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
 * Servlet implementation class AddItem
 */
@WebServlet("/AddItem")
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServletContext contextR;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItem(ServletContext contextIn) {
        super();
        // TODO Auto-generated constructor stub
        this.contextR = contextIn;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}
	
	
	
	/**
	 * Add a new item to the todo list
	 */
	public void addItem(String item) 
	{
		Connection connection = null;
		
		DBConnectionChirino.getDBConnection(this.contextR);
        connection = DBConnectionChirino.connection;
        
        String insertSql = " INSERT INTO toDoListitems (id, item) values (default, ?)";
		
		try 
		{
			if(item != null) 
			{
				PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
				String itemPass = item + "%";
				preparedStatement.setString(1, itemPass);
				preparedStatement.execute();
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
