package com.learn;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class JDBCDemo3
 */
public class JDBCDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JDBCDemo3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Load the driver class
			Class.forName("com.mysql.jdbc.Driver");
			
			// Get the connection from DriverManager
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo2024" , "root" , "Bawa@4415");
			
			// create the statement using connection object
			Statement statement = connection.createStatement();
			
			ResultSet executeQuery = statement.executeQuery("select * from person ");	
			
			//Iterate through resultSet
			while(executeQuery.next()) {
				
				int personID = executeQuery.getInt(1);
				String lastname = executeQuery.getString(2);
				String firstname = executeQuery.getString(3);
				String city = executeQuery.getString(4);
		
				response.getWriter().append("PersonID : "+ personID + " lastname : " + lastname);
			}
			
			connection.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
