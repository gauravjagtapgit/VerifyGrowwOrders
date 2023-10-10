package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UtilityClassForProperties {
	
	public static  Properties prop;
	
	 public static String getproperties(String key) throws IOException {

			 
		 prop = new Properties();
		 
		 FileInputStream file = new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\gauav\\GrowwOrder\\configuration\\properties");
		 
		 prop.load(file);
		 
		 return prop.getProperty(key);
		 
	 }

}
