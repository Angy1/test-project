package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	  }

	public void initContactCreation() {
	    click(By.linkText("add new"));
	  }

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstname);
	    type(By.name("lastname"), contact.lastname);
	    type(By.name("address"), contact.address1);
	    type(By.name("home"), contact.homephone1);
	    type(By.name("mobile"), contact.mobile1);
	    type(By.name("work"), contact.workphone1);
	    type(By.name("email"), contact.email1);
	    type(By.name("email2"), contact.email2);
	    selectByText(By.name("bday"), contact.birthdate);
	    selectByText(By.name("bmonth"), contact.birthmonth);
	    type(By.name("byear"), contact.birthyear);
	    //selectByText(By.name("new_group"), contact.group);
	    type(By.name("address2"), contact.address2);
	    type(By.name("phone2"), contact.homephone2); 
	  }

	public void submitContactCreation() {
	   click(By.name("submit"));
	  }

	public void returnToHomePage() {
	   click(By.linkText("home page"));
	  }

}
