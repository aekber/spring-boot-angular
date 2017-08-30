//Angular controllers and config

var myModuleConfig = function($stateProvider, $urlRouterProvider){

    $urlRouterProvider.otherwise("/");

    $stateProvider.state("home", {
        url: "/",
        templateUrl: "/views/home.html"
    }).state("viewInsurances", {
        url: "/view-insurances/",
        templateUrl: "/views/view-insurances.html",
        controller: "viewInsurancesController"
    }).state("sellInsurances", {
        url: "/sell-insurances/",
        templateUrl: "/views/sell-insurances.html",
        controller: "sellInsurancesController"
    }).state("admin", {
        url: "/admin/",
        templateUrl: "/views/admin/index.html"
    }).state("admin.insurances", {
        url: "insurances/",
        templateUrl: "/views/admin/insurances/index.html",
        controller: "adminInsurancesListController"
    }).state("admin.insurances.add", {
        url: "add/",
        templateUrl: "/views/admin/insurances/add.html",
        controller: "adminInsurancesAddController"
    }).state("admin.insurances.edit", {
        url: "edit/:insuranceId",
        templateUrl: "/views/admin/insurances/edit.html",
        controller: "adminInsurancesEditController"
    });
};
myModuleConfig.$inject = ["$stateProvider", "$urlRouterProvider"];

// Services

var insurancesService = function($resource){
    return $resource("/api/insurances/:id", {
        id: "@insuranceId"
    }, {
        update: {
            method: "PUT"
        }
    });
};
insurancesService.$inject = ["$resource"];






// Controllers

var viewInsurancesController = function($scope, insurancesService){
    $scope.insurances = insurancesService.query();
    $scope.filterText = "";
};
viewInsurancesController.$inject = ["$scope", "insurancesService"];

var sellInsurancesController = function($scope, insurancesService){
	$scope.insurances = insurancesService.query();
	$scope.selectedInsuranceRisk = 0;
    $scope.enteredCoverage = 0;
    
    $scope.calculate = function(selectedInsuranceRisk, enteredCoverage){
    	alert("Payment Amount is " + enteredCoverage * (1 + selectedInsuranceRisk / 100));
    };
};
sellInsurancesController.$inject = ["$scope", "insurancesService"];

var adminInsurancesListController = function($scope, insurancesService, $state){
    $scope.insurances = insurancesService.query();

    $scope.delete = function(insurance){
      if(confirm("Are you sure to delete " + insurance.name + " insurance?")) {
          insurance.$delete(function(){
              $state.reload();
          });
      }
    };
};
adminInsurancesListController.$inject = ["$scope", "insurancesService", "$state"];


var adminInsurancesAddController = function($scope, insurancesService, $state){
    $scope.insurance = new insurancesService();

    $scope.save = function(){
        $scope.insurance.$save(function(){
            $state.go("admin.insurances", {}, {reload: true});
        });
    };
};
adminInsurancesAddController.$inject = ["$scope", "insurancesService", "$state"];

var adminInsurancesEditController = function($scope, insurancesService, $state, $stateParams){
    $scope.insurance = insurancesService.get({id: $stateParams.insuranceId});

    $scope.update = function(){
        $scope.insurance.$update(function(){
            $state.go("admin.insurances", {}, {reload: true});
        });
    };
};
adminInsurancesEditController.$inject = ["$scope", "insurancesService", "$state", "$stateParams"];



// Init module
angular.module("myAngularModule", ["ui.router", "ngResource"])
    .config(myModuleConfig)
    .factory("insurancesService", insurancesService)
    .controller("viewInsurancesController", viewInsurancesController)
    .controller("sellInsurancesController", sellInsurancesController)
    .controller("adminInsurancesListController", adminInsurancesListController)
    .controller("adminInsurancesAddController", adminInsurancesAddController)
    .controller("adminInsurancesEditController", adminInsurancesEditController);