
package com.example.tests;


import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {
	
  @Test
  public void testNonEmptyAddNewContactCreation() throws Exception {
	openMainPage();
    goToAddNewPage();
    ContactData contact = new ContactData();
    contact.firstname = "firstname 1";
    contact.lastname = "lastname 1";
    contact.address1 = "address 1";
    contact.homephone1 = "homephone 1";
    contact.mobile1 = "mobile 1";
    contact.workphone1 = "workphone 1";
    contact.email1 = "email 1";
    contact.email2 = "email 2";
    contact.birthdate = "18";
    contact.birthmonth = "February";
    contact.birthyear = "year";
    contact.group = "group 1";
    contact.address2 = "address 2";
    contact.homephone2 = "homephone 2";
	fillContactForm(contact);
    submitNewContactCreation();
    returnToMainPage();
  }
  
  @Test
  public void testEmptyAddNewContactCreation() throws Exception {
	openMainPage();
    goToAddNewPage();
    fillContactForm(new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "", "", ""));
    submitNewContactCreation();
    returnToMainPage();
  }

}


 