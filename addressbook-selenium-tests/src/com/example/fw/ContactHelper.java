package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

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
		// selectByText(By.name("new_group"), contact.group);
		type(By.name("address2"), contact.address2);
		type(By.name("phone2"), contact.homephone2);
	}

	public void updateContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstname);
		type(By.name("lastname"), contact.lastname);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	public void deleteContact(int index) {
		selectContactByIndex(index);
		click(By.xpath("//*[@id='content']/form[2]/input[2]"));
	}

	private void selectContactByIndex(int index) {
		click(By.xpath("//*[@id='maintable']/tbody/tr[" + (index+1) + "]/td[7]/a/img"));
	}

	public void initContactModification(int index) {
		selectContactByIndex(index);
	}

	public void submitContactModification() {
		click(By.name("update"));
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> rows = getContactRows();
		for (WebElement row : rows) {
			ContactData contact = new ContactData().setfirstname(
					row.findElement(By.xpath(".//td[3]")).getText())
					.setlastname(
							row.findElement(By.xpath(".//td[2]")).getText());
			contacts.add(contact);     
		}

		return contacts;

	}

	private List<WebElement> getContactRows() {
		return driver.findElements(By.name("entry"));
	}
}
