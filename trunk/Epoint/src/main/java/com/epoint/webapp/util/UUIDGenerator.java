package com.epoint.webapp.util;

import java.util.UUID;

public class UUIDGenerator {
	public UUIDGenerator() {
		
    } 
    /** 
     * 獲得一個UUID 
     * @return String UUID 
     */ 
    public static String getUUID(){ 
        String s = UUID.randomUUID().toString(); 
        //去掉“-”符號 
        return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
    } 
    /** 
     * 獲得指定數目的UUID 
     * @param number int 需要獲得的UUID數量 
     * @return String[] UUID數組 
     */ 
    public static String[] getUUID(int number){ 
        if(number < 1){ 
            return null; 
        } 
        String[] ss = new String[number]; 
        for(int i=0;i<number;i++){ 
            ss[i] = getUUID(); 
        } 
        return ss; 
    } 
}
