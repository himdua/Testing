package test.java;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import main.java.MainClass;

public class NewClass {
public MainClass sa = new MainClass();
	
	//String testEnv = System.getProperty("exeEnvironment");
	//String testGroup = "a";
			//System.getProperty("testGroup");
	@Test(groups={"a"}, parameters="IE")
	public void seleniumTest(){
	sa.openApplication();
		sa.search();
	}
}
