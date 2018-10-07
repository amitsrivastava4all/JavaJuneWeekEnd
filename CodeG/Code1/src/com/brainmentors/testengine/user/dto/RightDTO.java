package com.brainmentors.testengine.user.dto;

public class RightDTO {
	private String rightName;
	private String screenName;
	public RightDTO(String rightName, String screenName) {
		this.rightName = rightName;
		this.screenName = screenName;
	}
	public String getRightName() {
		return rightName;
	}
	public void setRightName(String rightName) {
		this.rightName = rightName;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
}
