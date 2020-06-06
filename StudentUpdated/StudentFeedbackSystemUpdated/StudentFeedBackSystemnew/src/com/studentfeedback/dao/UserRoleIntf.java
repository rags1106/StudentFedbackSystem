package com.studentfeedback.dao;

import java.util.List;

import com.studentfeedback.pojo.UserPojo;
import com.studentfeedback.pojo.UserRolePojo;



public interface UserRoleIntf {

	public boolean addUserRole(UserRolePojo uj);
	public boolean updateUserRole(UserRolePojo uj);
	public boolean deleteUserRole(int id);
	public List<UserPojo> getAllRecords();
	public List<UserPojo> getAllRecords(long id);
	public boolean deleteStaff(long id);
}
