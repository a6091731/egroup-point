package com.epoint.webapp.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class HtmlUtil {
	public String htmlToString (String FilePath) throws FileNotFoundException{
		String data="";
		String result="";
		FileInputStream ins = new FileInputStream(FilePath);
		try {
			if (ins == null) {} else {
				BufferedReader br = new BufferedReader(
					    new InputStreamReader(new FileInputStream(FilePath), "UTF-8"));
				while ((data = br.readLine()) != null) {
					result+=data;
					//System.out.println(data);
				}
			}
		} catch (IOException e) {
			System.out.println(e);
			//System.out.println(e.getMessage());
		}

		return result;
	}
}
