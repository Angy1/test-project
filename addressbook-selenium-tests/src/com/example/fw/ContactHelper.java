package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;
import com.example.tests.TestBase;

public class ContactHelper {

	public void initContactCreation() {
	    ApplicationManager.driver.findElement(By.linkText("add new")).click();
	  }

	public void fillContactForm(ApplicationManager applicationManager, TestBase testBase, ContactData contact) {
	    ApplicationManager.driver.findElement(By.name("firstname")).clear();
	    ApplicationManager.driver.findElement(By.name("firstname")).sendKeys(contact.firstname);
	    ApplicationManager.driver.findElement(By.name("lastname")).clear();
	    ApplicationManager.driver.findElement(By.name("lastname")).sendKeys(contact.lastname);
	    ApplicationManager.driver.findElement(By.name("address")).clear();
	    ApplicationManager.driver.findElement(By.name("address")).sendKeys(contact.address1);
	    ApplicationManager.driver.findElement(By.name("home")).clear();
	    ApplicationManager.driver.findElement(By.name("home")).sendKeys(contact.homephone1);
	    ApplicationManager.driver.findElement(By.name("mobile")).clear();
	    ApplicationManager.driver.findElement(By.name("mobile")).sendKeys(contact.mobile1);
	    ApplicationManager.driver.findElement(By.name("work")).clear();
	    ApplicationManager.driver.findElement(By.name("work")).sendKeys(contact.workphone1);
	    ApplicationManager.driver.findElement(By.name("email")).clear();
	    ApplicationManager.driver.findElement(By.name("email")).sendKeys(contact.email1);
	    ApplicationManager.driver.findElement(By.name("email2")).clear();
	    ApplicationManager.driver.findElement(By.name("email2")).sendKeys(contact.email2);
	    new Select(ApplicationManager.driver.findElement(By.name("bday"))).selectByVisibleText(contact.birthdate);
	    new Select(ApplicationManager.driver.findElement(By.name("bmonth"))).selectByVisibleText(contact.birthmonth);
	    ApplicationManager.driver.findElement(By.name("byear")).clear();
	    ApplicationManager.driver.findElement(By.name("byear")).sendKeys(contact.birthyear);
	    new Select(ApplicationManager.driver.findElement(By.name("new_group"))).selectByVisibleText(contact.group);
	    ApplicationManager.driver.findElement(By.name("address2")).clear();
	    ApplicationManager.driver.findElement(By.name("address2")).sendKeys(contact.address2);
	    ApplicationManager.driver.findElement(By.name("phone2")).clear();
	    ApplicationManager.driver.findElement(By.name("phone2")).sendKeys(contact.homephone2);
	  }

	

	public void submitContactCreation() {
	    ApplicationManager.driver.findElement(By.name("submit")).click();
	  }

	public void returnToHomePage() {
	    ApplicationManager.driver.findElement(By.linkText("home page")).click();
	  }

}
