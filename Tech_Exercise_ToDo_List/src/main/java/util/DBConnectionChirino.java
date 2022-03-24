package util;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;

public class DBConnectionChirino {
   public static Connection connection = null;
   static ServletContext servletContext;

   protected static void getDBConnection() {
     
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
      } catch (ClassNotFoundException e) {
         
         e.printStackTrace();
         return;
      }
      

      connection = null;
      try {
         UtilPropChirino.loadProperty(servletContext);
         connection = DriverManager.getConnection(getURL(), getUserName(), getPassword());
      } catch (Exception e) {
         
         e.printStackTrace();
         return;
      }

    
   }

   static String getURL() {
      String url = UtilPropChirino.getProp("url");
      
      return url;
   }

   static String getUserName() {
      String usr = UtilPropChirino.getProp("user");
      
      return usr;
   }

   static String getPassword() {
      String pwd = UtilPropChirino.getProp("password");
      
      return pwd;
   }

   public static void getDBConnection(ServletContext context) {
      servletContext = context;
      getDBConnection();
   }
}