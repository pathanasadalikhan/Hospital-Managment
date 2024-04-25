package Hospital;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Sign")
public class SignupServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
	     String name=req.getParameter("name");
	     int age=Integer.parseInt(req.getParameter("age"));
	     long contact=Long.parseLong(req.getParameter("contact"));
	     String Gender=req.getParameter("gender");
	     String Gmail=req.getParameter("email");
	     int password=Integer.parseInt(req.getParameter("repassword"));
	     Connection con=null;
	     PreparedStatement pstmt=null;
	     String sql="insert into Hospital.Details (Name,Age,Contact,Gender,Email,Password) values(?,?,?,?,?,?)";
	     try {
	    	 Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Asad@007");
				pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2,age);
			pstmt.setLong(3,contact);
			pstmt.setString(4,Gender);
			pstmt.setString(5, Gmail);
			pstmt.setInt(6, password);
			pstmt.executeUpdate();
			resp.sendRedirect("/HospitalProject/Login.html");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	     finally {
	    	 try {
	    		 if(pstmt!=null) {
	    			 pstmt.close();
	    		 }
	    		 if(con!=null) {
	    			 con.close(); 
	    		 }
			} catch (SQLException e) {
				e.printStackTrace();
			}
	     }
	}

}
