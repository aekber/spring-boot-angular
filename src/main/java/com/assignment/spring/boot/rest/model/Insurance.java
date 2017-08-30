package com.assignment.spring.boot.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Model class
 * 
 * @author ekber
 *
 */

@Entity
public class Insurance {

    @Id
    @GeneratedValue
    private Integer insuranceId;
    
    private String name;
    
    private double coverageStart;
    
    private double coverageEnd;
    
    private double risk;

	public Integer getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(Integer insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCoverageStart() {
		return coverageStart;
	}

	public void setCoverageStart(double coverageStart) {
		this.coverageStart = coverageStart;
	}

	public double getCoverageEnd() {
		return coverageEnd;
	}

	public void setCoverageEnd(double coverageEnd) {
		this.coverageEnd = coverageEnd;
	}

	public double getRisk() {
		return risk;
	}

	public void setRisk(double risk) {
		this.risk = risk;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((insuranceId == null) ? 0 : insuranceId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Insurance other = (Insurance) obj;
		if (insuranceId == null) {
			if (other.insuranceId != null)
				return false;
		} else if (!insuranceId.equals(other.insuranceId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Insurance[" + this.insuranceId + ", " + this.name + "]";
	}
}
