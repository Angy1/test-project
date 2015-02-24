package com.example.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected ApplicationManager app;
 
	
	@BeforeTest
	public void seUp() throws Exception {
		app = new ApplicationManager();
	    
	  }
	
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	    
	  }
	
	
	
}
