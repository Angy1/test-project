package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

	
	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();

		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size())+1;

		// actions
		app.getContactHelper().initContactModification(index);
		ContactData contact = new ContactData();
		contact.lastname = "new lastname";
		app.getContactHelper().updateContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
		
		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();

		// compare states
		oldList.remove(index-1);
		oldList.add(contact);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}

}
