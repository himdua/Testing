package test.java;


import main.java.MainClass;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClass {

	public MainClass sa = new MainClass();
	
	
	//String testEnv = System.getProperty("exeEnvironment");
	//String testGroup = "a";
			//System.getProperty("testGroup");
	
	@Test	
	public void seleniumTest(){
		sa.openApplication();
	}
	
	
	/*@Test(groups={"a"},priority=2)
	public void testMethod(){
		sa.a();
	}
	
	@Test(groups ={"a"},priority=1)
	public void testMethodb(){
		sa.b();
	}
	
	@Test(groups ={"b"})
	public void testMethodC(){
		sa.c();
	}
	
	@Test(groups ={"b"})
	public void testMethodD(){
		sa.d();
	}
	*/

	}
