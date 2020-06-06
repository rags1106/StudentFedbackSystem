package com.studentfeedback.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studentfeedback.pojo.UserPojo;
import com.studentfeedback.pojo.UserRolePojo;
import com.studentfeedback.util.MyConnection;

public class UserRoleImpl implements UserRoleIntf{

	public boolean addUserRole(UserRolePojo uj) {
		// TODO Auto-generated method stub
		Connection  conn=null;
		PreparedStatement ps=null;
		
		try {
			conn=MyConnection.getConnectionObj();
			ps=conn.prepareStatement("insert into userrole(Urole) values(?)");
			
			ps.setString(1, uj.getUserRole());
			
			int i=ps.executeUpdate();
			
			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUserRole(UserRolePojo uj) {
		// TODO Auto-generated method stub
		Connection  conn=null;
		PreparedStatement ps=null;
		
		try {
			conn=MyConnection.getConnectionObj();
			ps=conn.prepareStatement("update userrole set Urole=? where Urid=?");
			
			ps.setString(1, uj.getUserRole());
			ps.setInt(2, uj.getUsreRid());
			
			int i=ps.executeUpdate();
			
			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteUserRole(int id) {
		// TODO Auto-generated method stub
		Connection  conn=null;
		PreparedStatement ps=null;
		
		try {
			conn=MyConnection.getConnectionObj();
			ps=conn.prepareStatement("delete from userrole where Urid=?");
			
			ps.setInt(1, id);
			
			int i=ps.executeUpdate();
			
			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public List<UserPojo> getAllRecords() {
		// TODO Auto-generated method stub
		Connection  conn=null;
		PreparedStatement ps=null;
		
		try {
			List<UserPojo> userlist=new ArrayList<UserPojo>();
			conn=MyConnection.getConnectionObj();
			ps=conn.prepareStatement("select * from usertable where role=?");
			ps.setString(1,"staff");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				UserPojo userPojo=new UserPojo();
				userPojo.setId(rs.getInt("id"));
				System.out.println(rs.getInt("id"));
				userPojo.setFaculty_name(rs.getString("faculty_name"));
				System.out.println(rs.getString("faculty_name"));
				userPojo.setFaculty_department(rs.getString("faculty_department"));
				System.out.println(rs.getString("faculty_department"));
				userlist.add(userPojo);
				
			}
			
			return userlist;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

	public List<UserPojo> getAllRecords(long id) {
		// TODO Auto-generated method stub
		
		Connection  conn=null;
		PreparedStatement ps=null;
		
		try {
			List<UserPojo> userlist=new ArrayList<UserPojo>();
			conn=MyConnection.getConnectionObj();
			ps=conn.prepareStatement("select * from usertable where id=?");
			ps.setLong(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				UserPojo userPojo=new UserPojo();
				userPojo.setId(rs.getInt("id"));
				System.out.println(rs.getInt("id"));
				userPojo.setFaculty_name(rs.getString("faculty_name"));
				System.out.println(rs.getString("name"));
				userPojo.setFaculty_department(rs.getString("faculty_department"));
				System.out.println(rs.getString("department"));
				userPojo.setMobile(rs.getString("mobile"));
				userPojo.setAddress(rs.getString("address"));
				userPojo.setEmail(rs.getString("email"));
				userlist.add(userPojo);
				
			}
			
			return userlist;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

	public boolean deleteStaff(long id) {
		// TODO Auto-generated method stub
		
		Connection  conn=null;
		
		try 
		{
			conn=MyConnection.getConnectionObj();
			PreparedStatement ps=conn.prepareStatement("delete from usertable where id=?");
			ps.setLong(1,id);
			
			int z=ps.executeUpdate();
			if(z==1)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}

	
	
	
	

	/*public boolean login(String email, String password) {
		// TODO Auto-generated method stub3w3q
		Connection conn=null;
		PreparedStatement ps=null;
		
		try {
			conn=MyConnection.getConnectionObj();
			ps=conn.prepareStatement("select * from usertable where Uemail=? and Upassword=?");
			
			ps.setString(1, email);
			ps.setString(2, Password);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}*/

	
}
