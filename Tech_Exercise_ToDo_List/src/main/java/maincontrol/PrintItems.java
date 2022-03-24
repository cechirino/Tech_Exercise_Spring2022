package maincontrol;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBConnectionChirino;

/**
 * Servlet implementation class PrintItems
 */
@WebServlet("/PrintItems")
public class PrintItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServletContext contextR;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintItems(ServletContext contextIn) {
        super();
        // TODO Auto-generated constructor stub
        this.contextR = contextIn;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	/**
	 * Prints the updated list of Item from the database;
	 */
	public void printlist(HttpServletResponse response) throws IOException 
	{
		Connection connection = null;
		
		DBConnectionChirino.getDBConnection(this.contextR);
        connection = DBConnectionChirino.connection;
        PrintWriter out = response.getWriter();
        
        
		
		try 
		{
			String selectSQL = "SELECT * FROM toDoListitems";
			PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) 
			{
	            
	           String item = rs.getString("item").trim();

	           out.println("<div class=\"todo\">" +
	        		   "<li class=\"todo-item\">" + item + "</li>" +
	        		   "<button class=\"delete-btn\"> <i class=\"fas fa-trash\"></i></button>"+
	        		   
	        		   "</div>");
	               
	         }
			
			
			connection.close();
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
