package com.studentfeedback.dao;

import java.util.List;

import com.studentfeedback.pojo.FeedbackPojo;
import com.studentfeedback.pojo.StudentPojo;
import com.studentfeedback.pojo.SubjectPojo;
import com.studentfeedback.pojo.UserPojo;
import com.studentfeedback.pojo.UserRolePojo;

public interface UserIntf {

	public boolean addUser(UserPojo uj);
	public boolean login(String email, String Password);
	public boolean addStudent(StudentPojo studentPojo);
	public UserPojo getFaulty_id(String emailID);
	public boolean loginStudent(String email, String password);
	public StudentPojo getFaulty_idFromStudent(String emailID);
	public List<UserPojo> getStaff(String facultydept);
	public List<String> getAllQuestion();
	public boolean addSubject( SubjectPojo subjectPojo);
	public boolean addFeedback(FeedbackPojo feedbackPojo);
	public List<UserPojo> getAllStaff();
	public List<FeedbackPojo>getFeedbackesult(int faculty_id);
	public UserPojo getFaulty_name(int faculty_id);
	public List<StudentPojo> getAllStudent();
	public boolean deleteStudent(int student_id);
	public StudentPojo getStudent_Details(long student_id);
	public boolean updatestudentDetails(StudentPojo studentPojo);
}
