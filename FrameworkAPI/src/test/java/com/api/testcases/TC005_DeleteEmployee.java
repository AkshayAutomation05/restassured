package com.api.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.api.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC005_DeleteEmployee extends TestBase{
	
	
	@BeforeClass
	public void deleteEmployeeData() throws InterruptedException
	{
		System.out.println("Execution has been started...");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httprequest=RestAssured.given();
		
		response=httprequest.request(Method.GET,"/employees");
		
		JsonPath path=response.jsonPath();
		String empID=path.get("[0].id");
		
		response=httprequest.request(Method.DELETE,"/delete/"+empID);
		Thread.sleep(3000);
			
	}
	
	@Test
	public void checkResponseBody()
	{
		String res=response.getBody().asString();
		Assert.assertEquals(res.contains("sucessfully! deleted Records"), true);
	}
	
	@AfterClass
	public void tearDown()
	{
		System.out.println("Execution has been completed...");
	}
}
