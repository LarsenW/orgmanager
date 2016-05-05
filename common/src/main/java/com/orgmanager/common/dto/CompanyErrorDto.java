package com.orgmanager.common.dto;

public class CompanyErrorDto {

	private Boolean invalidName = false;

	private Boolean invalidIncome = false;

	private Boolean invalidParentId = false;

	public Boolean getInvalidName() {
		return invalidName;
	}

	public void setInvalidName(Boolean invalidName) {
		this.invalidName = invalidName;
	}

	public Boolean getInvalidIncome() {
		return invalidIncome;
	}

	public void setInvalidIncome(Boolean invalidIncome) {
		this.invalidIncome = invalidIncome;
	}

	public Boolean getInvalidParentId() {
		return invalidParentId;
	}

	public void setInvalidParentId(Boolean invalidParentId) {
		this.invalidParentId = invalidParentId;
	}

}
