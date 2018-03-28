package test;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.sun.deploy.nativesandbox.comm.Response;


public class loginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginServlet1() {
        super();
    }
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String driverName = "com.mysql.jdbc.Driver";         
    String userName = "root";
    String userPwd = "123456";
    String dbName = "game";

    String url1 = "jdbc:mysql://localhost:3306/" + dbName;
    String url2 = "?user=" + userName + "&password=" + userPwd;
    String url3 = "&useUnicode=true&characterEncoding=UTF-8";
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 request.setCharacterEncoding("UTF-8");
		 try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			conn = DriverManager.getConnection(url1,url2,url3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		 String sql = "select * from login where username=? and password=?";  
		 try {
			 pstmt = conn.prepareStatement("select * from login where username=? and password=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 String user = request.getParameter("username");
	     String password = request.getParameter("password");
	     try {
			pstmt.setString(1, user);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	     try {
			pstmt.setString(2, password);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     try {
			rs = pstmt.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     try {
			if(rs.next()) {
			    response.getWriter().println("»¶Ó­¡¾ "+ user + "¡¿ÓÃ»§µÇÂ¼³É¹¦£¡£¡£¡");
			 }
			 else {
				 response.getWriter().println("µÇÂ¼Ê§°Ü£¡£¡£¡");
			 }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	        if(rs != null) {
	            try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        if(pstmt != null) {
	            try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        if(conn != null) {
	            try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
