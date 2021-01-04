package com.api.base;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import com.api.testcases.TC001_GetEmployeeData;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	public static RequestSpecification httprequest;
	public static Response response;
	public String empid="24";
	
	public Logger logger;
	
	/*@BeforeClass
	public void setup(){
		
		logger=Logger.getLogger(TestBase.class);//added Logger
		
		//PropertyConfigurator.configure("log4j.properties"); //added logger
			
		
		logger.setLevel(Level.DEBUG);
		
	}*/
	
}
