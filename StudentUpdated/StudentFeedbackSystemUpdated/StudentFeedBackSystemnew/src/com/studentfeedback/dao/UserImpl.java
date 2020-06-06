package com.studentfeedback.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studentfeedback.pojo.FeedbackPojo;
import com.studentfeedback.pojo.StudentPojo;
import com.studentfeedback.pojo.SubjectPojo;
import com.studentfeedback.pojo.UserPojo;
import com.studentfeedback.util.MyConnection;

public class UserImpl implements UserIntf{

	public boolean addUser(UserPojo uj) {
		// TODO Auto-generated method stub
		Connection  conn=null;
		PreparedStatement ps=null;
		
		try {
			
			conn=MyConnection.getConnectionObj();
			PreparedStatement ps1=conn.prepareStatement("select * from usertable where email=?");
			ps1.setString(1, uj.getEmail());
			ResultSet rs1 =ps1.executeQuery();
		   if(rs1.next())
		   {
			   return false;
		   }
		   else
		   {
			
			conn=MyConnection.getConnectionObj();
			ps=conn.prepareStatement("insert into usertable(faculty_name, faculty_department, year, mobile, address, email, password, role) values(?,?,?,?,?,?,?,?)");
			
			//ps.setInt(1, uj.getFaculty_id());
			ps.setString(1, uj.getFaculty_name());
			ps.setString(2, uj.getFaculty_department());
			ps.setString(3, uj.getYear());
			ps.setString(4, uj.getMobile());
			ps.setString(5, uj.getAddress());
			ps.setString(6, uj.getEmail());
			ps.setString(7, uj.getPassword());
			ps.setString(8, uj.getRole());
			
			
			int i=ps.executeUpdate();
			
			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		   }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean login(String email, String Password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		
		System.out.println("email USER IMPL"+email);
		System.out.println("Password USER IMPL"+Password);
		try {
			conn=MyConnection.getConnectionObj();
			ps=conn.prepareStatement("select * from usertable where email=? and password=?");
			
			
			
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
	}
	@Override
	public boolean addStudent(StudentPojo studentPojo) {
		// TODO Auto-generated method stub
		
		Connection  conn=null;
		PreparedStatement ps=null;
		
		try {
			
			conn=MyConnection.getConnectionObj();
		    ps=conn.prepareStatement("select * from student_table where email=? and enrollment_no=?");
			ps.setString(1, studentPojo.getEmail());
			ps.setString(2, studentPojo.getEnrollment());
			ResultSet rs1 =ps.executeQuery();
		   if(rs1.next())
		   {
			   System.out.println("in if");
			   return false;
		   }
		   else
		   {
			System.out.println("in else");
			//conn=MyConnection.getConnectionObj();
			ps=conn.prepareStatement("insert into student_table(student_name, student_department, year, mobile, address, email, password, role,enrollment_no) values(?,?,?,?,?,?,?,?,?)");
			
			//ps.setInt(1, uj.getFaculty_id());
			ps.setString(1, studentPojo.getStudent_name());
			ps.setString(2, studentPojo.getStudent_department());
			ps.setString(3, studentPojo.getYear());
			ps.setString(4, studentPojo.getMobile());
			ps.setString(5, studentPojo.getAddress());
			ps.setString(6, studentPojo.getEmail());
			ps.setString(7, studentPojo.getPassword());
			ps.setString(8, studentPojo.getRole());
			ps.setString(9, studentPojo.getEnrollment());
			
			int i=ps.executeUpdate();
			
			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		   }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		return false;
	}
	@Override
	public UserPojo getFaulty_id(String emailID) {
		// TODO Auto-generated method stub
		Connection  conn=null;
		PreparedStatement ps=null;
		UserPojo userPojo=new UserPojo();
		try {
			
			conn=MyConnection.getConnectionObj();
			PreparedStatement ps1=conn.prepareStatement("select * from usertable where email=?");
			ps1.setString(1,emailID);
			ResultSet rs1 =ps1.executeQuery();
		   while(rs1.next())
		   {
			   userPojo.setAddress(rs1.getString("address"));
			   userPojo.setFaculty_department(rs1.getString("faculty_department"));
			   userPojo.setFaculty_id(rs1.getInt("faculty_id"));
		   }
		   return userPojo;
		} catch(Exception e)
			{
			e.printStackTrace();	
			}
		return null;
	
	}
	@Override
	public boolean loginStudent(String email, String password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		
		System.out.println("email USER IMPL"+email);
		System.out.println("Password USER IMPL"+password);
		try {
			conn=MyConnection.getConnectionObj();
			ps=conn.prepareStatement("select * from student_table where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
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
	}
	@Override
	public StudentPojo getFaulty_idFromStudent(String emailID) {
		// TODO Auto-generated method stub
		Connection  conn=null;
		PreparedStatement ps=null;
		StudentPojo studentPojo=new StudentPojo();
		try {
			
			conn=MyConnection.getConnectionObj();
			PreparedStatement ps1=conn.prepareStatement("select * from student_table where email=?");
			ps1.setString(1,emailID);
			ResultSet rs1 =ps1.executeQuery();
		   while(rs1.next())
		   {
			   studentPojo.setAddress(rs1.getString("address"));
			   studentPojo.setStudent_department(rs1.getString("student_department"));
			 //  studentPojo.setFaculty_id(rs1.getInt("faculty_id"));
			   studentPojo.setStudent_id(rs1.getInt("student_id"));
			   studentPojo.setStudent_name(rs1.getString("student_name"));
		   }
		   return studentPojo;
		} catch(Exception e)
			{
			e.printStackTrace();	
			}
		return null;
	}
	@Override
	public List<UserPojo> getStaff(String facultydept) {
		// TODO Auto-generated method stub
		Connection  conn=null;
		PreparedStatement ps=null;
		
		List<UserPojo> userlist=new ArrayList<UserPojo>();
		try {
			
			conn=MyConnection.getConnectionObj();
			PreparedStatement ps1=conn.prepareStatement("select * from usertable where faculty_department=?");
			ps1.setString(1,facultydept);
			ResultSet rs1 =ps1.executeQuery();
		   while(rs1.next())
		   {
			   UserPojo userPojo=new UserPojo();
			   userPojo.setEmail(rs1.getString("email"));
			   userPojo.setFaculty_name(rs1.getString("faculty_name"));
			   userPojo.setYear(rs1.getString("year"));
			   userPojo.setAddress(rs1.getString("address"));
			   userPojo.setFaculty_department(rs1.getString("faculty_department"));
			   userPojo.setFaculty_id(rs1.getInt("faculty_id"));
			   userPojo.setMobile(rs1.getString("mobile"));
			   userlist.add(userPojo);
			   
		   }
		  
		   return userlist;
		} catch(Exception e)
			{
			e.printStackTrace();	
			}
		return null;
	}
	@Override
	public List<String> getAllQuestion() {
		// TODO Auto-generated method stub
		Connection  conn=null;
		PreparedStatement ps=null;
		
		List<String> list=new ArrayList<String>();
		try {
			
			conn=MyConnection.getConnectionObj();
			PreparedStatement ps1=conn.prepareStatement("select * from question_table");
			
			ResultSet rs1 =ps1.executeQuery();
		   while(rs1.next())
		   {
			   String question=rs1.getString("question");
			   list.add(question);
			   
		   }
		  
		   return list;
		} catch(Exception e)
			{
			e.printStackTrace();	
			}
		return null;
	}
	@Override
	public boolean addSubject(SubjectPojo subjectPojo) {
		// TODO Auto-generated method stub
		Connection  conn=null;
		PreparedStatement ps=null;
		
		try {
			
			conn=MyConnection.getConnectionObj();
			PreparedStatement ps1=conn.prepareStatement("select * from subject_table where sub_name=? AND department=?");
			ps1.setString(1, subjectPojo.getSubject_name());
			ps1.setString(2, subjectPojo.getDepartment());
			ResultSet rs1 =ps1.executeQuery();
		   if(rs1.next())
		   {
			   return false;
		   }
		   else
		   {
			
			conn=MyConnection.getConnectionObj();
			ps=conn.prepareStatement("insert into subject_table(sub_name, sub_code, year, department) values(?,?,?,?)");
			
			//ps.setInt(1, uj.getFaculty_id());
			ps.setString(1, subjectPojo.getSubject_name());
			ps.setString(2, subjectPojo.getSubject_code());
			ps.setString(3, subjectPojo.getYear());
			ps.setString(4, subjectPojo.getDepartment());
			
			
			
			int i=ps.executeUpdate();
			
			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		   }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public boolean addFeedback(FeedbackPojo feedbackPojo) {
		// TODO Auto-generated method stub
		Connection  conn=null;
		PreparedStatement ps=null;
		
		try {
			
		/*	conn=MyConnection.getConnectionObj();
			PreparedStatement ps1=conn.prepareStatement("select * from feedback_table where faculty_name=? AND student_name=?");
			ps1.setString(1, feedbackPojo.getFaculty_name());
			ps1.setString(2, feedbackPojo.getStudent_name());
			ResultSet rs1 =ps1.executeQuery();
		   if(rs1.next())
		   {
			   return false;
		   }
		   else
		   {*/
			
			conn=MyConnection.getConnectionObj();
			ps=conn.prepareStatement("insert into feedback_table(faculty_name, feedback_status, suggestions, student_name,student_id,faculty_id) values(?,?,?,?,?,?)");
			
			//ps.setInt(1, uj.getFaculty_id());
			ps.setString(1, feedbackPojo.getFaculty_name());
			ps.setString(2, feedbackPojo.getFeedback_status());
			ps.setString(3, feedbackPojo.getSuggestion());
			ps.setString(4, feedbackPojo.getStudent_name());
			ps.setInt(5, feedbackPojo.getStudent_id());
			ps.setInt(6, feedbackPojo.getFaculty_id());
			
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
	@Override
	public List<UserPojo> getAllStaff() {
		// TODO Auto-generated method stub
		
		Connection  conn=null;
		PreparedStatement ps=null;
		
		List<UserPojo> userlist=new ArrayList<UserPojo>();
		try {
			
			conn=MyConnection.getConnectionObj();
			PreparedStatement ps1=conn.prepareStatement("select * from usertable");
			
			ResultSet rs1 =ps1.executeQuery();
		   while(rs1.next())
		   {
			   UserPojo userPojo=new UserPojo();
			   userPojo.setEmail(rs1.getString("email"));
			   userPojo.setFaculty_name(rs1.getString("faculty_name"));
			   userPojo.setYear(rs1.getString("year"));
			   userPojo.setAddress(rs1.getString("address"));
			   userPojo.setFaculty_department(rs1.getString("faculty_department"));
			   userPojo.setFaculty_id(rs1.getInt("faculty_id"));
			   userPojo.setMobile(rs1.getString("mobile"));
			   userlist.add(userPojo);
			   
		   }
		  
		   return userlist;
		} catch(Exception e)
			{
			e.printStackTrace();	
			}
	
		return null;
	}
	@Override
	public List<FeedbackPojo> getFeedbackesult(int faculty_id) {
		// TODO Auto-generated method stub
		Connection  conn=null;
		PreparedStatement ps=null;
		try
		{
			conn=MyConnection.getConnectionObj();
		    ps = conn.prepareStatement("select feedback_status,COUNT(feedback_status) as feedback_total from feedback_table  where faculty_id=? group by feedback_status ");
		    ps.setInt(1, faculty_id);
		    ResultSet rs = ps.executeQuery();
		    List<FeedbackPojo> list = new ArrayList<FeedbackPojo>();
			while(rs.next())
			{
				FeedbackPojo feedbackPojo = new FeedbackPojo();
				feedbackPojo.setFeedback_status(rs.getString("feedback_status"));;
				feedbackPojo.setFeedback_total(rs.getInt("feedback_total"));
				list.add(feedbackPojo);
			}
			return list;
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			
		return null;
	}
	@Override
	public UserPojo getFaulty_name(int faculty_id) {
		// TODO Auto-generated method stub
		Connection  conn=null;
		PreparedStatement ps=null;
		UserPojo userPojo=new UserPojo();
		try {
			
			conn=MyConnection.getConnectionObj();
			PreparedStatement ps1=conn.prepareStatement("select * from usertable where faculty_id=?");
			ps1.setInt(1,faculty_id);
			ResultSet rs1 =ps1.executeQuery();
		   while(rs1.next())
		   {
			   userPojo.setAddress(rs1.getString("address"));
			   userPojo.setFaculty_department(rs1.getString("faculty_department"));
			   userPojo.setFaculty_id(rs1.getInt("faculty_id"));
			   userPojo.setFaculty_name(rs1.getString("faculty_name"));
		   }
		   return userPojo;
		} catch(Exception e)
			{
			e.printStackTrace();	
			}
		return null;
	}
	@Override
	public List<StudentPojo> getAllStudent() {
		// TODO Auto-generated method stub
		
		Connection  conn=null;
		PreparedStatement ps=null;
		
		List<StudentPojo> studentlist=new ArrayList<StudentPojo>();
		try {
			
			conn=MyConnection.getConnectionObj();
			PreparedStatement ps1=conn.prepareStatement("select * from student_table ");
		
			ResultSet rs1 =ps1.executeQuery();
		   while(rs1.next())
		   {
			   StudentPojo studentPojo=new StudentPojo();
			   studentPojo.setStudent_id(rs1.getInt("student_id"));
			   studentPojo.setStudent_name(rs1.getString("student_name"));
			   studentlist.add(studentPojo);
			   
		   }
		  
		   return studentlist;
		} catch(Exception e)
			{
			e.printStackTrace();	
			}
	
		return null;
	}
	@Override
	public boolean deleteStudent(int student_id) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		
		
		try {
			conn=MyConnection.getConnectionObj();
			ps=conn.prepareStatement("delete from student_table where student_id=? ");
			ps.setInt(1, student_id);
			
			
			int rs=ps.executeUpdate();
			
			if(rs>0)
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
	@Override
	public StudentPojo getStudent_Details(long student_id) {
		// TODO Auto-generated method stub
		Connection  conn=null;
		PreparedStatement ps=null;
		StudentPojo studentPojo=new StudentPojo();
		System.out.println("in impl"+student_id);
		try {
			
			conn=MyConnection.getConnectionObj();
			PreparedStatement ps1=conn.prepareStatement("select * from student_table where student_id=?");
			ps1.setLong(1, student_id);
			ResultSet rs1 =ps1.executeQuery();
		   while(rs1.next())
		   {
			   studentPojo.setAddress(rs1.getString("address"));
			   studentPojo.setEmail(rs1.getString("email"));
			   studentPojo.setMobile(rs1.getString("mobile"));
			   studentPojo.setPassword(rs1.getString("password"));
			   studentPojo.setStudent_department(rs1.getString("student_department"));
			   studentPojo.setStudent_id(rs1.getInt("student_id"));
			   studentPojo.setStudent_name(rs1.getString("student_name"));
			   studentPojo.setYear(rs1.getString("year"));
			   
		   }
		   return studentPojo;
		} catch(Exception e)
			{
			e.printStackTrace();	
			}
		return null;
	}
	@Override
	public boolean updatestudentDetails(StudentPojo studentPojo) {
		// TODO Auto-generated method stub
		Connection  conn=null;
		PreparedStatement ps=null;
		try{
			conn=MyConnection.getConnectionObj();
			ps=conn.prepareStatement("update student_table set student_name=?, student_department=?, year=?, mobile=?, address=?, email=? where student_id=?");
			
			
			ps.setString(1, studentPojo.getStudent_name());
			ps.setString(2, studentPojo.getStudent_department());
			ps.setString(3, studentPojo.getYear());
			ps.setString(4, studentPojo.getMobile());
			ps.setString(5, studentPojo.getAddress());
			ps.setString(6, studentPojo.getEmail());
			ps.setInt(7, studentPojo.getStudent_id());
			
			int i=ps.executeUpdate();
			
			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch(Exception e)
		{
		e.printStackTrace();	
		}
		return false;
	}
	
	/*public int getDaoUserId(String userrole) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		System.out.println("userroleImpl::::"+userrole);
		try
		{
			conn=MyConnection.getConnectionObj();
			
			ps=conn.prepareStatement("select Urid from userrole where Urole = ?");
			ps.setString(1, userrole);
			ResultSet rs=ps.executeQuery();
		
			while(rs.next())
			{
				 int id=rs.getInt("Urid");
				 return id;	
			}
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		return 0;
	}*/
	/*public boolean updateUser(UserPojo uj) {
		// TODO Auto-generated method stub
		Connection  conn=null;
		PreparedStatement ps=null;
		
		try {
			conn=MyConnection.getConnectionObj();
			ps=conn.prepareStatement("update usertable set Urid=?,name=?,department=?,year=?,mobile=?,address=?,email=?,password=?,Role=? where id=?");
			
			ps.setInt(1, uj.getUrid());
			ps.setString(2, uj.getName());
			ps.setString(3, uj.getDepartment());
			ps.setString(4, uj.getYear());
			ps.setString(5, uj.getMobile());
			ps.setString(6, uj.getAddress());
			ps.setString(7, uj.getEmail());
			ps.setString(8, uj.getPassword());
			ps.setString(9, uj.getRole());
			ps.setInt(10, uj.getId());
			
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

	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		Connection  conn=null;
		PreparedStatement ps=null;
		
		try {
			conn=MyConnection.getConnectionObj();
			ps=conn.prepareStatement("delete from usertable where id=?");
			
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
		
		return null;
	}

	public boolean login(String email, String Password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		
		System.out.println("email USER IMPL"+email);
		System.out.println("Password USER IMPL"+Password);
		try {
			conn=MyConnection.getConnectionObj();
			ps=conn.prepareStatement("select * from usertable where email=? and password=?");
			
			
			
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
	}

	public String forgotPassword(String email) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		
		try {
			conn=MyConnection.getConnectionObj();
			
			ps=conn.prepareStatement("select password from usertable where email=?");
		
			ps.setString(1, email);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				return rs.getString("Upassword");
			}
			else
			{
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int resetPass(UserPojo uj) {
		// TODO Auto-generated method stub
		int i=0;
		
		Connection conn=null;
		PreparedStatement ps=null;
		
		try {
			conn=MyConnection.getConnectionObj();
			ps=conn.prepareStatement("update usertable set password=? where email=?");
			
			ps.setString(1,uj.getUpass());
			ps.setString(2, uj.getUemail());
			ps.setString(3,uj.getUserOldpass());
				 
				System.out.println(uj.getUpass());
				System.out.println(uj.getUserOldpass());
				i=ps.executeUpdate();
				 return i;
	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	public List<UserPojo> getRecordById(int roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getDaoUserId(String userrole) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement ps=null;
		System.out.println("userroleImpl::::"+userrole);
		try
		{
			conn=MyConnection.getConnectionObj();
			
			ps=conn.prepareStatement("select Urid from userrole where Urole = ?");
			ps.setString(1, userrole);
			ResultSet rs=ps.executeQuery();
		
			while(rs.next())
			{
				 int id=rs.getInt("Urid");
				 return id;	
			}
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		return 0;
	}

	public int getRoleIdByEmail(String email, String password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		//System.out.println("userroleImpl::::"+userrole);
		try
		{
			conn=MyConnection.getConnectionObj();
			
			ps=conn.prepareStatement("select id from usertable where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
		
			while(rs.next())
			{
				 int id=rs.getInt("id");
				 return id;	
			}
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		
		return 0;
	}

	public UserPojo getUrIDByEmail(String email, String password) {
		Connection conn=null;
		PreparedStatement ps=null;
		//System.out.println("userroleImpl::::"+userrole);
		try
		{
			conn=MyConnection.getConnectionObj();
			
			ps=conn.prepareStatement("select * from usertable where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
		
			while(rs.next())
			{
				UserPojo userPojo = new UserPojo();
				userPojo.setUrid( rs.getInt("Urid"));
				userPojo.setDepartment(rs.getString("department"));
				return  userPojo;
			}
			
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		
		return null;
	}
	
	
	public UserPojo getDepartmentYear(String email, String password) {
		Connection conn=null;
		PreparedStatement ps=null;
		//System.out.println("userroleImpl::::"+userrole);
		try
		{
			conn=MyConnection.getConnectionObj();
			
			ps=conn.prepareStatement("select department , year from usertable where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
		
			while(rs.next())
			{
				 UserPojo userPojo = new UserPojo();
				 userPojo.setDepartment(rs.getString("department"));
				 userPojo.setYear(rs.getString("year"));
					return userPojo;
			}
	
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		return null;
		
		
	}

	public UserPojo getDepartmentYearByStudentid(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		
		System.out.println("Student id IMPL"+id);
		try {
			
			conn=MyConnection.getConnectionObj();
			ps=conn.prepareStatement("select department,year from usertable where id=?");
					
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				UserPojo userPojo=new UserPojo(); 
				
				userPojo.setDepartment(rs.getString("department"));
				userPojo.setYear(rs.getString("year"));
				
				return userPojo;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public int getDaoSubjectId(String department,String year) {
		Connection conn=null;
		PreparedStatement ps=null;
		System.out.println("userroleImpl::::"+department);
		System.out.println("userroleImpl::::"+year);
		try
		{
			conn=MyConnection.getConnectionObj();
			
			ps=conn.prepareStatement("select subjectid from subjecttable where department= ? and year=?");
			//ps.setInt(1, subjectid);
			ps.setString(1, department);
			ps.setString(2, year);
			ResultSet rs=ps.executeQuery();
		
			while(rs.next())
			{
				 int id=rs.getInt("subjectid");
				 return id;	
			}
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		
		return 0;
	}*/
}
