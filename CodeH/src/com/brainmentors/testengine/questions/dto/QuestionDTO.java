package com.brainmentors.testengine.questions.dto;

import java.util.Arrays;

public class QuestionDTO {
	private int id;
	private String name;
	private String options[] = new String[4];
	private String rightAnswer;
	private int score;
	private String yourAnswer;
	
	public String getYourAnswer() {
	    return yourAnswer;
	}
	public void setYourAnswer(String yourAnswer) {
	    this.yourAnswer = yourAnswer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getOptions() {
		return options;
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
	public String getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "QuestionDTO [id=" + id + ", name=" + name + ", options=" + Arrays.toString(options) + ", rightAnswer="
				+ rightAnswer + ", score=" + score + "]";
	}
	
	
	
	
	
}
