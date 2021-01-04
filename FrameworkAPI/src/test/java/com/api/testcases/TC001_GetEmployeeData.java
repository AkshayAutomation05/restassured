package com.api.testcases;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;


import com.api.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_GetEmployeeData extends TestBase{
	
	Logger logger=LogManager.getLogger(TC001_GetEmployeeData.class);
	
	
	
	@BeforeClass
	void getEmployeeData()
	{
		logger.info("*********Started TC001_Get_Employee_Data **********");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httprequest=RestAssured.given();
		response=httprequest.request(Method.GET,"/employees");
		System.out.println("Test case starts executing....");
	}
	
	@Test
	void checkResponseBody()
	{
		logger.info("***********  Checking Respose Body **********");
		
		String res=response.getBody().asString();
		logger.info("Response Body==>"+res);
		Assert.assertTrue(res!=null);
	}
	
	@Test
	void checkresponseStatus()
	{
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode,200);
		logger.debug("This is debug info...");
	}
	
	@Test
	void checkresponseTime()
	{
		long responsetime=response.getTime();
		//System.out.println("Response Time:"+responsetime);
		if(responsetime>2000)
			System.out.println("Response time is greater than 2000");
			Assert.assertTrue(responsetime<2000);
			logger.warn("This is waring message..");
	}
	
	@Test
	void checkStatusLine()
	{
		String statusLine=response.getStatusLine();
		System.out.println("Status Line:"+statusLine);
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
		//logger.error("This is an error message...");
	}
	
	@Test
	void checkContentType()
	{
		String contentType=response.header("Content-Type");
		Assert.assertEquals(contentType, "application/json;charset=utf-8");
		//logger.fatal("This is fatal message...");
	}
	
	
	@Test
	void checkServerType()
	{
		String server=response.header("Server");
		System.out.println("Server:"+server);
		Assert.assertEquals(server, "nginx/1.16.0");
	}
	
	@Test
	void checkContentEncoding()
	{
		String encoding=response.header("Content-Encoding");
		System.out.println("Content Encoding"+encoding);
		Assert.assertEquals(encoding, "gzip");
	}
	
	@Test
	void checkContentLength()
	{
		String contentLength=response.header("Content-Length");
		if(Integer.parseInt(contentLength)>100)
			System.out.println("Length of content is greater than 100");
		Assert.assertTrue(Integer.parseInt(contentLength)>100);
		
	}
	

	
	@AfterClass
	void tearDown()
	{
		System.out.println("Test case has been executed....");
	}

}
