package com.studentfeedback.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.studentfeedback.dao.UserImpl;
import com.studentfeedback.dao.UserIntf;
import com.studentfeedback.pojo.FeedbackPojo;
import com.studentfeedback.pojo.StudentPojo;
import com.studentfeedback.pojo.SubjectPojo;
import com.studentfeedback.pojo.UserPojo;
import com.studentfeedback.util.EmailUtility;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
		/*String action=request.getParameter("action");
		HttpSession session=request.getSession();
		
		UserIntf intf=new UserImpl();
		
		List<String> qlist=intf.getAllQuestion();
		
		session.setAttribute("qlist", qlist);
		
		response.sendRedirect("question.jsp");*/
		HttpSession session=request.getSession();
		UserIntf intf=new UserImpl();
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		
		if(action!=null && action.equals("RegisterStaff"))
		{
			UserIntf intf=new UserImpl();
			String role=request.getParameter("role");
			System.out.println("role"+role);
			//int id=intf.getDaoUserId(role);
			
			String department =request.getParameter("department");
			System.out.println("department"+department);
			session.setAttribute("department", department);
			String year =request.getParameter("year");
			String sem=request.getParameter("sem");
			String yearsem=year.concat(sem);
			session.setAttribute("year", year);
			//String year=(String) session.getAttribute("year");
			
			System.out.println("department servlet"+department);
			System.out.println("year servlet"+year);
			
			
			System.out.println("yearsem servlet"+yearsem);
			
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			String mob=request.getParameter("mobile");
			
			String add=request.getParameter("address");
			String email=request.getParameter("email");
			String pass;
			
			
			UserPojo userPojo=new UserPojo();
			
			//userPojo.setId(id);
			userPojo.setFaculty_name(name);
			userPojo.setFaculty_department(department);
			userPojo.setYear(yearsem);
			userPojo.setMobile(mob);
			userPojo.setAddress(add);
			userPojo.setEmail(email);
			userPojo.setRole(role);
			userPojo.setPassword(password);
			
			boolean x=intf.addUser(userPojo);
			if(x){
				if(x)
				{
					EmailUtility emailUtility=new EmailUtility();
					boolean b=emailUtility.sendEmailUtil(email, password);
					System.out.println("UserNameIDDDDD :"+name +    " passwordddd :"  +password);
					if(b==true)
					{
					if(role.equalsIgnoreCase("Staff"))
					{
						request.setAttribute("error", "Record Added Successfully!!!!! You can Added New Record");
						RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
						rd.include(request, response);
						//response.sendRedirect("registerstudent.jsp");
					}
					else
					{
						request.setAttribute("staffexist", "Staff Record already exist!!");
						RequestDispatcher rd1=request.getRequestDispatcher("register.jsp");
						rd1.include(request, response);
					}
					}
					else{
						request.setAttribute("error", "Sorry!!!!!Please Enter Valid Email ID");
						RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
						rd.include(request, response);
						
					}
				}
				//response.sendRedirect("home.jsp");
			}
			
			
		}
		else if(action!=null && action.equals("Register"))
		{
			UserIntf intf=new UserImpl();
			String role=request.getParameter("role");
			System.out.println("role"+role);
			
			String department =request.getParameter("department");
			System.out.println("department"+department);
			session.setAttribute("department", department);
			
			String enrollment_no =request.getParameter("enrollment");
			System.out.println("enrollment_no"+enrollment_no);
			
			String year =request.getParameter("year");
			session.setAttribute("year", year);
			System.out.println("year servlet"+year);
			
			String name=request.getParameter("name");
			String mob=request.getParameter("mobile");
			
			String add=request.getParameter("address");
			String email=request.getParameter("email");
			String pass;
			
			StudentPojo studentPojo=new StudentPojo();
			
			//userPojo.setId(id);
			studentPojo.setStudent_name(name);
			studentPojo.setStudent_department(department);
			studentPojo.setYear(year);
			studentPojo.setMobile(mob);
			studentPojo.setAddress(add);
			studentPojo.setEmail(email);
			studentPojo.setRole(role);
			studentPojo.setEnrollment(enrollment_no);
			pass=name+'@';
			
			studentPojo.setPassword(pass);
			
			
			
			boolean x=intf.addStudent(studentPojo);
			
			if(x)
			{
				EmailUtility emailUtility=new EmailUtility();
				emailUtility.sendEmailUtil(email, pass);
				System.out.println("UserNameIDDDDD :"+name +    " passwordddd :"  +pass);
				
				
				
					request.setAttribute("error", "Record Added Successfully!!!!! You can Added New Record");
					RequestDispatcher rd=request.getRequestDispatcher("registerstudent.jsp");
					rd.include(request, response);
					//response.sendRedirect("registerstudent.jsp");
					
				}
				else
				{
					request.setAttribute("staffexist", "Student Record already exist!!");
					RequestDispatcher rd1=request.getRequestDispatcher("registerstudent.jsp");
					rd1.include(request, response);
				}
			
			
		}
		else if(action!=null && action.equals("alluserlist"))
		{
			UserIntf intf=new UserImpl();
			List<UserPojo> userlist=intf.getAllStaff();
			session.setAttribute("userlist", userlist);
			response.sendRedirect("allstafflist.jsp");
		}
		
		else if(action!=null && action.equals("allStudentlist"))
		{
			UserIntf intf=new UserImpl();
			List<StudentPojo> studentlist=intf.getAllStudent();
			session.setAttribute("studentlist", studentlist);
			response.sendRedirect("allstudentlist.jsp");
		}
		
		else if(action!=null && action.equals("deleteStudent"))
		{
			
			int student_id=Integer.parseInt(request.getParameter("student_id"));
			System.out.println("student_id"+student_id);
			UserIntf intf=new UserImpl();
			boolean b=intf.deleteStudent(student_id);
			if(b){
			response.sendRedirect("UserServlet?action=allStudentlist");
			}
		}
		else if(action!=null && action.equals("studentDetailsONID"))
		{
			long student_id=Long.parseLong(request.getParameter("student_id"));
			System.out.println("student_id"+student_id);
			
			UserIntf intf=new UserImpl();
			StudentPojo studentPojo=intf.getStudent_Details(student_id);
			PrintWriter out = response.getWriter();
			String json = new Gson().toJson(studentPojo);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(json);
		}
		
		else if(action!=null && action.equals("updateStudentDetails"))
		{
			int student_id=Integer.parseInt(request.getParameter("student_id"));
			System.out.println("student_id"+student_id);
			
			
			String department =request.getParameter("student_department");
			System.out.println("department"+department);
			
			String year =request.getParameter("year");
			System.out.println("year servlet"+year);
			
			String name=request.getParameter("student_name");
			String mob=request.getParameter("mobile");
			
			String add=request.getParameter("address");
			String email=request.getParameter("email");
			StudentPojo studentPojo=new StudentPojo();
			studentPojo.setStudent_id(student_id);
			studentPojo.setStudent_name(name);
			studentPojo.setStudent_department(department);
			studentPojo.setYear(year);
			studentPojo.setMobile(mob);
			studentPojo.setAddress(add);
			studentPojo.setEmail(email);
			
			UserIntf intf=new UserImpl();
			boolean x=intf.updatestudentDetails(studentPojo);
			PrintWriter out = response.getWriter();
			String json = new Gson().toJson(x);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(json);
		}
		
		else if(action!=null && action.equals("adminLogin"))
		{
			
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			if(email.equals("admin@123" )&&password.equals("admin"))
			{
			   response.sendRedirect("adminAction.jsp");	
			
			}
			else{
			
				request.setAttribute("error", "Sorry!!Please Enter Valid EmailId And Password");
				RequestDispatcher rd1=request.getRequestDispatcher("adminlogin.jsp");
				rd1.include(request, response);
			}
			
			
		}
		
		else if(action!=null && action.equals("Login"))
		{
			
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			session.setAttribute("email", email);
			session.setAttribute("password", password);
			UserPojo u=new UserPojo();
			
			u.setEmail(email);
			u.setPassword(password);
			
			UserIntf intf=new UserImpl();
			
			
			
			boolean x=intf.login(email, password);
			
			if(x)
			{
				UserPojo userPojo=intf.getFaulty_id(email);
				int faculty_id=userPojo.getFaculty_id();
				session.setAttribute("faculty_id", faculty_id);
				String department=userPojo.getFaculty_department();
				session.setAttribute("department", department);
				response.sendRedirect("stafftoStudent.jsp");
						
			}
			else
			{
				request.setAttribute("error", "Sorry!!Please Enter Valid EmailId And Password");
				RequestDispatcher rd1=request.getRequestDispatcher("login.jsp");
				rd1.include(request, response);
			}
			
			
		}
		
		else if(action!=null && action.equals("StudentLogin"))
		{
			
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			
			session.setAttribute("email", email);
			session.setAttribute("password", password);
			StudentPojo studentPojo=new StudentPojo();
			
			studentPojo.setEmail(email);
			studentPojo.setPassword(password);
			
			session.setAttribute("user",studentPojo);
			UserIntf intf=new UserImpl();
			
			boolean x=intf.loginStudent(email, password);
			System.out.println(x);
			if(x)
			{
				studentPojo=intf.getFaulty_idFromStudent(email);
				String facultydept=studentPojo.getStudent_department();
				List<UserPojo> userlist=intf.getStaff(facultydept);
				session.setAttribute("userlist", userlist);
				response.sendRedirect("stafflist.jsp");
						
			}
			else
			{
				request.setAttribute("error", "Sorry!!Please Enter Valid EmailId And Password");
				RequestDispatcher rd1=request.getRequestDispatcher("login.jsp");
				rd1.include(request, response);
			}
		}
		
		else if(action!=null && action.equals("addSubject"))
		{
			
			String sub_name=request.getParameter("subject_name");
			
			String sub_code=request.getParameter("subject_code");
			
			String department=request.getParameter("department");
			
			String year=request.getParameter("year");
			 
			SubjectPojo subjectPojo=new SubjectPojo();
			subjectPojo.setDepartment(department);
			subjectPojo.setSubject_code(sub_code);
			subjectPojo.setSubject_name(sub_name);
			subjectPojo.setYear(year);
			UserIntf intf=new UserImpl();
			boolean a=intf.addSubject(subjectPojo);
			if(a)
			{
				request.setAttribute("error", "Subject Added Successfully!!!!");
				RequestDispatcher rd1=request.getRequestDispatcher("addsubject.jsp");
				rd1.include(request, response);
			}
			else{
				request.setAttribute("error", "Sorry!!Subject Record is already exist!!!");
				RequestDispatcher rd1=request.getRequestDispatcher("addsubject.jsp");
				rd1.include(request, response);
			}
			
		}
		
		else if(action!=null && action.equals("addFeedbackDetails"))
		{
			String suggestion=null;
			int faculty_id=Integer.parseInt(request.getParameter("faculty_id"));
			String feedback_status=request.getParameter("feedback_status");
			suggestion=request.getParameter("suggestion");
			String email=(String) session.getAttribute("email");
			UserIntf intf=new UserImpl();
			StudentPojo studentPojo=intf.getFaulty_idFromStudent(email);
			String student_name=studentPojo.getStudent_name();
			int student_id=studentPojo.getStudent_id();
			UserPojo userPojo=intf.getFaulty_name(faculty_id);
			String faculty_name=userPojo.getFaculty_name();
			
			System.out.println("sss name"+student_name);
			FeedbackPojo feedbackPojo=new FeedbackPojo();
			feedbackPojo.setFaculty_name(faculty_name);
			feedbackPojo.setFeedback_status(feedback_status);
			feedbackPojo.setStudent_name(student_name);
			feedbackPojo.setSuggestion(suggestion);
			feedbackPojo.setFaculty_id(faculty_id);
		    feedbackPojo.setStudent_id(student_id);
			
			boolean f=intf.addFeedback(feedbackPojo);
			if(f){
				response.sendRedirect("stafflist.jsp");
			}
			
		}
		
		else if(action!=null && action.equals("seefeedback"))
		{
			
			System.out.println("innnnnnnnnnn");
		    int faculty_id=Integer.parseInt(request.getParameter("faculty_id"));
			System.out.println("seefeedback"+faculty_id);
			UserIntf intf=new UserImpl();
			List<FeedbackPojo> getList=intf.getFeedbackesult(faculty_id);
			session.setAttribute("getList", getList);
			response.sendRedirect("allstafflistFeedback.jsp");
			
		}
		else if(action!=null && action.equals("seeSpecificfeedback"))
		{
			int faculty_id=(int) session.getAttribute("faculty_id");
			System.out.println("seefeedback"+faculty_id);
			UserIntf intf=new UserImpl();
			List<FeedbackPojo> getList1=intf.getFeedbackesult(faculty_id);
			session.setAttribute("getList1", getList1);
			response.sendRedirect("specificStafflFeedback.jsp");
		}

	}

}
