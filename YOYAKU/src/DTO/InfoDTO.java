package DTO;

import java.io.Serializable;

public class InfoDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String ryokan;
	private String place;



	public String getRyokan() {
		return ryokan;
	}
	public void setRyokan(String ryokan) {
		this.ryokan = ryokan;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}


}
