package com.epoint.webapp.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyConstants {
	  public static Properties props;
	  public  void loadProperties(InputStream stream) {
	         props = new Properties();
	         try {
	              props.load(stream);
	         } catch (FileNotFoundException e) {
	              e.printStackTrace();
	         } catch (IOException e) {
	              e.printStackTrace();
	         }
	     	
	     
	    }
	    public  void loadProperties(String Config_path) {
	         props = new Properties();
	         try {
	              props.load(new FileInputStream(Config_path));
	         } catch (FileNotFoundException e) {
	              e.printStackTrace();
	         } catch (IOException e) {
	              e.printStackTrace();
	         }
	     	
	     
	    }

	    public  String getConfig(String key) {
	    
	    
	        return props.getProperty(key);
	    }

	    String str;
	    
		public void setStr(String str){
			this.str=str;
		}
		public String getStr(){
			return str;
		}
	
	
  public static void main(String[] args) {
	  PropertyConstants PC = new PropertyConstants();
	  PC.loadProperties("D:/Config.txt"); 
 	   System.out.println(PC.getConfig("BLOG_LINK"));

  }

}
