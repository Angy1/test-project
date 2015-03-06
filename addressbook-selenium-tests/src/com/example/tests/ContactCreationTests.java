package com.example.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
	
    @DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();

		for (int i = 0; i < 5; i++) {
			ContactData contact = new ContactData();
			contact.firstname = generateRandomString();
			contact.lastname = generateRandomString();
			contact.address1 = generateRandomString();
			contact.homephone1 = generateRandomString();
			contact.mobile1 = generateRandomString();
			contact.workphone1 = generateRandomString();
			contact.email1 = generateRandomString();
			contact.email2 = generateRandomString();
			contact.birthdate = "12";
			contact.birthmonth = "March";
			contact.birthyear = generateRandomString();
			contact.group = generateRandomString();
			contact.address2 = generateRandomString();
			contact.homephone2 = generateRandomString();
			list.add(new Object[] { contact });
		}
		return list.iterator();
	}

	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}

	}

	@Test(dataProvider = "randomValidGroupGenerator")
	public void testContactCreationWithValidData(ContactData contact)
			throws Exception {
		app.getNavigationHelper().openMainPage();

		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();

		// actions
		app.getContactHelper().initContactCreation();
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToHomePage();

		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();

		// compare states
		oldList.add(contact);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}

}
