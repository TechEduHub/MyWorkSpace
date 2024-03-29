package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
	public static final String currentDir  = System.getProperty("user.dir"); 
	public static String filePath = currentDir + "/src/main/resources/";
	

	public Properties getProperty(String fileName) throws IOException {
	      FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream(filePath+fileName);
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         fis.close();
	      }
	      System.out.println("url is : "+ prop.getProperty("url"));
	      System.out.println("username is : "+ prop.getProperty("username"));
	      System.out.println("password is : "+ prop.getProperty("password"));
	      System.out.println("Reviewer is : "+ prop.getProperty("Reviewer"));
	      System.out.println("Approver is : "+ prop.getProperty("Approver"));
	      System.out.println("Author  is : "+ prop.getProperty("Approver"));
	      return prop;
	   }

}
