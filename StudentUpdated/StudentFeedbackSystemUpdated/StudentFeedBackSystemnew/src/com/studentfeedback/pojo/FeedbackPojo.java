package com.studentfeedback.pojo;

public class FeedbackPojo {

	private String faculty_name;
	private String feedback_status;
	private String suggestion;
	private String student_name;
	private int student_id;
	private int  faculty_id;
	private int feedback_total;
	
	
	public int getFeedback_total() {
		return feedback_total;
	}
	public void setFeedback_total(int feedback_total) {
		this.feedback_total = feedback_total;
	}
	public String getFeedback_status() {
		return feedback_status;
	}
	public void setFeedback_status(String feedback_status) {
		this.feedback_status = feedback_status;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	public String getFaculty_name() {
		return faculty_name;
	}
	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getFaculty_id() {
		return faculty_id;
	}
	public void setFaculty_id(int faculty_id) {
		this.faculty_id = faculty_id;
	}
	
	
	
}
