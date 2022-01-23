package com.example.HumanClock.Model;

public class ClockModel {
	
	private String numericTime; 
	private String textualTime;
	
	public ClockModel(String numericTime, String textualTime) {
		super();
		this.numericTime = numericTime;
		this.textualTime = textualTime;
	}
	public String getNumericTime() {
		return numericTime;
	}
	public void setNumericTime(String numericTime) {
		this.numericTime = numericTime;
	}
	public String getTextualTime() {
		return textualTime;
	}
	public void setTextualTime(String textualTime) {
		this.textualTime = textualTime;
	}

}
