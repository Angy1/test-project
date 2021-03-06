package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends WebDriverHelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
			


	public ContactHelper createContact(ContactData contact, boolean CREATION) {
		initContactCreation();
		fillContactForm(contact, CREATION);
		submitContactCreation();
		returnToHomePage();
		// update model
		manager.getModel().addContact(contact);
		return this;	
	}
	
	public ContactHelper modifyContact(int index, ContactData contact) {
		manager.navigateTo().mainPage();
		initContactModification(index);
		updateContactForm(contact);
		submitContactModification();
		returnToHomePage();
		manager.getModel().removeContact(index).addContact(contact);
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		manager.navigateTo().mainPage();
		selectContactByIndex(index);
		submitContactDeletion();
		returnToHomePage();
		manager.getModel().removeContact(index);
		return this;
	}

	

	//--------------------------------------------------------------------------------------------
	
	public SortedListOf<ContactData> getUiContacts() {
		SortedListOf<ContactData> contacts = new SortedListOf<ContactData>();
		
		manager.navigateTo().mainPage();
		List<WebElement> rows = getContactRows();
		for (WebElement row : rows) {
			 String lastname = row.findElement(By.xpath(".//td[2]")).getText();
			 String firstname = row.findElement(By.xpath(".//td[3]")).getText();
			 contacts.add(new ContactData().withLastName(lastname).withFirstName(firstname));     
		}
		return contacts;
	}
	
	
	
	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
		type(By.name("address"), contact.getAddress1());
		type(By.name("home"), contact.getHomephone1());
		type(By.name("mobile"), contact.getMobile1());
		type(By.name("work"), contact.getWorkphone1());
		type(By.name("email"), contact.getEmail1());
		type(By.name("email2"), contact.getEmail2());
		selectByText(By.name("bday"), "12");
		selectByText(By.name("bmonth"),"March");
		type(By.name("byear"), contact.getBirthyear());
		if (formType == CREATION) { 
		// selectByText(By.name("new_group"), contact.group);
		}else{
			if (driver.findElements(By.name("new_group")).size() !=0) {
				throw new Error("Group selector exists in contact modification form");
			}
		}
		type(By.name("address2"), contact.getAddress2());
		type(By.name("phone2"), contact.getHomephone2());
		return this;	
	}

	public ContactHelper updateContactForm(ContactData contact) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
		return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	private void selectContactByIndex(int index) {
		click(By.xpath("//*[@id='maintable']/tbody/tr[" + (index+1) + "]/td[7]/a/img"));
	}

	public ContactHelper initContactModification(int index) {
		selectContactByIndex(index);
		return this;
	}

	public ContactHelper submitContactModification() {
		click(By.name("update"));
		return this;
	}

	public void submitContactDeletion() {
		click(By.xpath("//*[@id='content']/form[2]/input[2]"));
	}
	
	private List<WebElement> getContactRows() {
		return driver.findElements(By.name("entry"));
	}
}

