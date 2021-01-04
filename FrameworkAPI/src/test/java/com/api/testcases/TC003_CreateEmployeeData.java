package com.api.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

import com.api.base.TestBase;
import com.api.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC003_CreateEmployeeData extends TestBase{
	
	String empname=RestUtils.empName();
	String empsal=RestUtils.empSal();
	String empage=RestUtils.empAge();
	
	@BeforeClass
	public void createEmployeeData() throws InterruptedException
	{
		System.out.println("Execution has been started...");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httprequest=RestAssured.given();
		
		JSONObject obj=new JSONObject();
		obj.put("name",empname);
		obj.put("salary",empsal);
		obj.put("age",empage);
		
		httprequest.header("Content-Type", "application/json");
		httprequest.body(obj.toJSONString());
		
		response=httprequest.request(Method.POST,"/create");
		Thread.sleep(5000);
		
	}
	
	@Test
	public void getStatusCode()
	{
		int status=response.getStatusCode();
		Assert.assertEquals(status, 200);
	}
	
	@AfterClass
	public void tearDown()
	{
		System.out.println("Execution has been completed sucessfully...");
	}

}
