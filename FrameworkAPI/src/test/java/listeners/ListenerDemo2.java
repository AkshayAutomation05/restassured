package listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ListenerDemo2 {
	
	@Test
	public void test1()
	{
		System.out.println("You are in test case 1");
	}
	
	@Test
	public void test2()
	{
		System.out.println("You are in test case 2");
		Assert.assertTrue(false);
	}
	
	@Test
	public void test3()
	{
		System.out.println("You are in test case 3");
		throw new SkipException("This is skip exception...");
	}


}
