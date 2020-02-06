package com.metacube.parkingSystem.model;

/**
 *Pass type class which is set the price of pass type.
 */
public class PassType {

	private float daily;
	private float monthly;
	private float yearly;

	public float getDaily() {
		return daily;
	}

	public void setDaily(float daily) {
		this.daily = daily;
	}

	public float getMonthly() {
		return monthly;
	}

	public void setMonthly(float monthly) {
		this.monthly = monthly;
	}

	public float getYearly() {
		return yearly;
	}

	public void setYearly(float yearly) {
		this.yearly = yearly;
	}
}
