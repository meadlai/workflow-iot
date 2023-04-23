package com.meadlai.iot;


/**
 * 
 * @author meadlai
 *
 */
public enum WEATHER {
	//
	RAIN("RAIN"), SUNNY("SUNNY");

	//
	private final String status;

	//
	WEATHER(String input) {
		this.status = input;
	}

	@Override
	public String toString() {
		return status;
	}
}
