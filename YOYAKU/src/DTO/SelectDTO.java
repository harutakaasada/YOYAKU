package DTO;

import java.io.Serializable;

public class SelectDTO implements Serializable{
	private String selectDetails;
	private String selectPlace;


	public String getSelectDetails() {
		return selectDetails;
	}
	public String getSelectPlace() {
		return selectPlace;
	}
	public void setSelectDetails(String selectDetails) {
		this.selectDetails = selectDetails;
	}
	public void setSelectPlace(String selectPlace) {
		this.selectPlace = selectPlace;
	}




}
