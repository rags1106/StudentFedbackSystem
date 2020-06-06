package com.studentfeedback.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import javax.servlet.http.HttpSession;

import com.studentfeedback.dao.UserRoleImpl;
import com.studentfeedback.dao.UserRoleIntf;
import com.studentfeedback.pojo.UserPojo;
import com.studentfeedback.pojo.UserRolePojo;


/**
 * Servlet implementation class UserRoleServlet
 */
public class UserRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action=request.getParameter("action");
		UserRoleIntf intf=new UserRoleImpl();
		HttpSession session = request.getSession();
		if(action!=null && action.equals("AllStaff"))
		{
			System.out.println("**********");
			List<UserPojo> userlist=intf.getAllRecords();
			System.out.println("userlist" + userlist);
			session.setAttribute("userlist", userlist);
			response.sendRedirect("staffdetail.jsp");
			
			
		}
		
		else if(action!=null && action.equals("staffDetails"))
		{
			System.out.println("**********");
			long id=Long.parseLong(request.getParameter("id1"));
			System.out.println("staff id"+id);
			List<UserPojo> Staffinfo=intf.getAllRecords(id);
			System.out.println("Staffinfo" + Staffinfo);
			session.setAttribute("Staffinfo", Staffinfo);
			
			response.sendRedirect("viewStaffDetails.jsp");
			
			
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		String action=request.getParameter("action");
		if(action!=null && action.equals("Register"))
		{
			String name=request.getParameter("Urole");
			
			UserRolePojo uj=new UserRolePojo();
			
			uj.setUserRole(name);
			
			UserRoleIntf intf=new UserRoleImpl();
			
			boolean x=intf.addUserRole(uj);
			
			if(x)
			{
				response.sendRedirect("success.jsp");
			}
			else
			{
				response.sendRedirect("error.jsp");
			}
		}
		else if(action!=null && action.equals("Update"))
		{
			String name=request.getParameter("Urole");
			int id=Integer.parseInt(request.getParameter("Uid"));
			
			UserRolePojo uj=new UserRolePojo();
			
			uj.setUserRole(name);
			uj.setUsreRid(id);
			
			UserRoleIntf intf=new UserRoleImpl();
			
			boolean x=intf.updateUserRole(uj);
			
			if(x)
			{
				response.sendRedirect("success.jsp");
			}
			else
			{
				response.sendRedirect("error.jsp");
			}
		}
		else if(action!=null && action.equals("Delete"))
		{
			int id=Integer.parseInt(request.getParameter("Urid"));
			
			UserRolePojo uj=new UserRolePojo();
			
			uj.setUsreRid(id);
			
			UserRoleIntf intf=new UserRoleImpl();
			
			boolean x=intf.deleteUserRole(id);
			
			if(x)
			{
				response.sendRedirect("success.jsp");
			}
			else
			{
				response.sendRedirect("error.jsp");
			}
		}
		
		else if(action!=null && action.equals("deleteStaff"))
		{
			long id=Long.parseLong(request.getParameter("rowID"));
			System.out.println("staff id"+id);
			UserRoleIntf intf=new UserRoleImpl();
            boolean x=intf.deleteStaff(id);
			
			if(x)
			{
				response.sendRedirect("UserRoleServlet?action=AllStaff");
			}
			else
			{
				response.sendRedirect("error.jsp");
			}
			
			
		}
		
	}

}
