package com.api.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String empName()
	{
		String empname=RandomStringUtils.randomAlphabetic(1);
		return ("Max"+empname);
		
	}
	
	public static String empSal()
	{
		String sal=RandomStringUtils.randomNumeric(5);
		return sal;
	}
	
	public static String empAge()
	{
		String age=RandomStringUtils.randomNumeric(2);
		return age;
	}

}
