package com.assignment.spring.boot.rest.controller;

import com.assignment.spring.boot.rest.model.Insurance;
import com.assignment.spring.boot.rest.repository.InsuranceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * This class is main controller class.All of its methods present a REST endpoint according to URL
 * 
 * @author ekber
 *
 */

@RestController
@RequestMapping("/api/insurances")
public class InsuranceController {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @RequestMapping
    public Iterable<Insurance> listAll() {
        return insuranceRepository.findAll();
    }

    @RequestMapping(value = "/{insuranceId}", method = RequestMethod.GET)
    public Insurance get(@PathVariable Integer insuranceId) {
        return insuranceRepository.findOne(insuranceId);
    }

    @RequestMapping(value = "/{insuranceId}", method = RequestMethod.POST)
    public Insurance save(@PathVariable Integer insuranceId, @RequestBody Insurance insurance) {
        return insuranceRepository.save(insurance);
    }

    @RequestMapping(value = "/{insuranceId}", method = RequestMethod.PUT)
    public Insurance update(@PathVariable Integer insuranceId, @RequestBody Insurance insurance) {
        Insurance ins = insuranceRepository.findOne(insuranceId);

        ins.setCoverageStart(insurance.getCoverageStart());
        ins.setCoverageEnd(insurance.getCoverageEnd());
        ins.setRisk(insurance.getRisk());

        return insuranceRepository.save(ins);
    }

    @RequestMapping(value = "/{insuranceId}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable Integer insuranceId) {
        insuranceRepository.delete(insuranceId);
        return true;
    }


}
