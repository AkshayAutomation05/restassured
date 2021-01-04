package com.api.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

import com.api.base.TestBase;
import com.api.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC004_UpdateEmployeeData extends TestBase{
	
	String empname=RestUtils.empName();
	String sal=RestUtils.empSal();
	String age=RestUtils.empAge();
	
	@BeforeClass
	public void updateEmployeeData() throws InterruptedException
	{
		System.out.println("Execution has been started...");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/";
		httprequest=RestAssured.given();
				
		JSONObject obj=new JSONObject();
		obj.put("name",empname);
		obj.put("salary",sal);
		obj.put("age",age);
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(obj.toJSONString());
		response=httprequest.request(Method.PUT,"update/"+empid);
				
		Thread.sleep(5000);
	}
	
	@Test
	public void getStatus()
	{
		int status=response.getStatusCode();
		System.out.println("Status Code:"+status);
		Assert.assertEquals(status,200);
	}
	
	@AfterClass
	public void tearDown()
	{
		System.out.println("Execution has been completed...");
	}
	
	

}
