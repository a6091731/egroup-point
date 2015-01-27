package com.epoint.webapp.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConversion {
	public String ConversionYMDHMS (Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String DateString = formatter.format(date);
		return DateString ;
	}
	
	public String ConversionYMDHMS2 (Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmssss");
		String DateString = formatter.format(date);
		return DateString ;
	}
	
	public String ConversionYMDHM (Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String DateString = formatter.format(date);
		return DateString ;
	}
		
	public String ConversionY(Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		String DateString = formatter.format(date);
		return DateString ;
	}

	public String ConversionYDM(Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String DateString = formatter.format(date);
		return DateString ;
	}

}
