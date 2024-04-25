package Hospital;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Book")
public class AppointmentServlet extends HttpServlet{
	@SuppressWarnings("resource")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
            String name=req.getParameter("name");
            int age=Integer.parseInt(req.getParameter("age"));
            String gender=req.getParameter("gender");
            String condition=req.getParameter("selected");
            String date=req.getParameter("date");
    		Connection con=null;
    		PreparedStatement pstmt=null;
    		ResultSet rs=null;
    		String sql="insert into Hospital.Appointment (Name,Age,Gender,Medical_Condition,Date,Booking_Date) "
    				+ "values('"+name+"',"+age+",'"+gender+"','"+condition+"','"+date+"','2024-01-29');";
    		String sql2="select * from Hospital.Doctors where Department='"+condition+"';";
    		String sql3="select * from Hospital.Appointment where Name='"+name+"';";
    		try {
    			Class.forName("com.mysql.jdbc.Driver");
    			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Asad@007");
    			pstmt=con.prepareStatement(sql);
    			pstmt.executeUpdate();
    			pstmt=con.prepareStatement(sql2);
    			rs=pstmt.executeQuery();
    			String doctor=null;
    			if(rs.next()) {
    			doctor=rs.getString("Name");}
    			pstmt=con.prepareStatement(sql3);
    			rs=pstmt.executeQuery();
    			Time tim=null;
    			String time=null;
    			if(rs.next()) {
    			tim=rs.getTime("Ap_Time");
    			SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
    			time=sdf.format(tim);
    			}
                req.setAttribute("name", name);
                req.setAttribute("age", age);
                req.setAttribute("medicalCondition", condition);
                req.setAttribute("doctor", doctor);
                req.setAttribute("date", date);
                req.setAttribute("time", time);
                req.getRequestDispatcher("Confirmation.jsp").forward(req, resp);    			
    		} catch (ClassNotFoundException | SQLException e) {
    			e.printStackTrace();
    		}
    		finally {
    			if(pstmt!=null) {
    				try {
    					pstmt.close();
    				} catch (SQLException e) {
    					e.printStackTrace();
    				}
    			}
    			if(con!=null) {
    				try {
    					con.close();
    				} catch (SQLException e) {
    					e.printStackTrace();
    				}
    			}
    		}       
	   }
  }
