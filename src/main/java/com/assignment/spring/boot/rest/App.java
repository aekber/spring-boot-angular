package com.assignment.spring.boot.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.assignment.spring.boot.rest.model.Insurance;
import com.assignment.spring.boot.rest.repository.InsuranceRepository;


/**
 * Main class
 * 
 * @author ekber
 *
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner demo(final InsuranceRepository insuranceRepository) {
        return s -> {

            List<Insurance> insurances = new ArrayList<>();

            Insurance insurance = new Insurance();
            insurance.setName("Bike");
            insurance.setCoverageStart(0d);
            insurance.setCoverageEnd(3000d);
            insurance.setRisk(30d);
            insurances.add(insurance);

            insurance = new Insurance();
            insurance.setName("Jevelry");
            insurance.setCoverageStart(500d);
            insurance.setCoverageEnd(10000d);
            insurance.setRisk(5d);
            insurances.add(insurance);

            insurance = new Insurance();
            insurance.setName("Electronics");
            insurance.setCoverageStart(500d);
            insurance.setCoverageEnd(6000d);
            insurance.setRisk(35d);
            insurances.add(insurance);
            
            insurance = new Insurance();
            insurance.setName("Sports Equipment");
            insurance.setCoverageStart(0d);
            insurance.setCoverageEnd(20000d);
            insurance.setRisk(30d);
            insurances.add(insurance);

            insuranceRepository.save(insurances);
        };
    }

}
