package com.api.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.api.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC002_GetSingleEmployeeData extends TestBase{
	
	
	@BeforeClass
	void getSingleEmployeeData()
	{
		System.out.println("Execution has been started...");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httprequest=RestAssured.given();
		
		//response=httprequest.request(Method.GET,"");
		
		/*JsonPath jsonpathevaluator=response.jsonPath();
		empid=jsonpathevaluator.get("[0].id");*/
		response=httprequest.request(Method.GET,"/employee/"+empid);
		
	}
	
	@Test
	void checkResponseBody()
	{
		String res=response.getBody().asString();
		Assert.assertEquals(res.contains(empid),true);
	}
	
	@Test
	void checkStatus()
	{
		int status=response.getStatusCode();
		Assert.assertEquals(status,200);
	}
	
	@Test
	void checkStatusLine()
	{
		String statusline=response.getStatusLine();
		System.out.println("Status Line: "+statusline);
		Assert.assertEquals(statusline,"HTTP/1.1 200 OK");
	}
	
	@Test
	void checkContentType()
	{
		String content=response.header("Content-Type");
		System.out.println("Content Type: "+content);
		Assert.assertEquals(content,"application/json");
		
	}
	
	@Test
	void checkServerType()
	{
		String server=response.header("Server");
		System.out.println("Server:"+server);
		Assert.assertEquals(server,"nginx/1.16.0");
	}
	
	@Test
	void checkContentEncoding()
	{
		String encoding=response.header("Content-Encoding");
		System.out.println("Status Encoding:"+encoding);
		Assert.assertEquals(encoding,null);
	}
	
	@Test
	void checkContentLength()
	{
		String length=response.header("Content-Length");
		System.out.println("Content Length"+length);
		if(Integer.parseInt(length)>800)
			System.out.println("Content Length is greater than 800");
		Assert.assertTrue(Integer.parseInt(length)<800);		
	}
	
	
	@AfterClass
	void tearDown()
	{
		System.out.println("Execution has been ended...");
	}

}
