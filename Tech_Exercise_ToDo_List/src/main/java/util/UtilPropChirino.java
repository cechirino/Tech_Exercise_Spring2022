package util;
import java.util.Properties;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.InputStream;

public class UtilPropChirino {

   static Properties prop = new Properties();

   public static void loadProperty(ServletContext servletContext) throws Exception {
      String filePath = "/WEB-INF/config.properties";
      InputStream is = servletContext.getResourceAsStream(filePath);

      
      prop.load(is);
   }

   public static String getProp(String key) {
      return prop.getProperty(key).trim();
   }
}
