package com.assignment.spring.boot.rest.repository;

import com.assignment.spring.boot.rest.model.Insurance;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * This class manages basic crud operations
 * @author ekber
 *
 */
public interface InsuranceRepository extends CrudRepository<Insurance, Integer> {

    List<Insurance> findByName(String name);

}
