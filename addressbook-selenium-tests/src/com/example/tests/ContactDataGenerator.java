package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out
					.println("Please spesify parameters: <amount of test data> <file> <format>");
			return;
		}
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()){
		System.out.println("File exists, please remove it manually: " + file);
	    return;
		}

		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format" + format);
			return;
		}
	}


	private static void saveContactsToXmlFile(List<ContactData> contacts,File file) throws IOException {
     XStream xstream = new XStream();
     xstream.alias("contact", ContactData.class);
     String xml = xstream.toXML(contacts);
     FileWriter writer = new FileWriter(file);
     writer.write(xml);
     writer.close();	
	}

	public static List<ContactData> loadContactsFromXmlFile(File file) {
		 XStream xstream = new XStream();
	     xstream.alias("contact", ContactData.class);
	     return (List<ContactData>) xstream.fromXML(file); 
	}
	
	private static void saveContactsToCsvFile(List<ContactData> contacts,File file) throws IOException {
	FileWriter writer = new FileWriter(file);
	for (ContactData contact : contacts) {
		writer.write(contact.getFirstname() + "," + contact.getLastname() + "," + contact.getAddress1() + "," + contact.getHomephone1() + "," + contact.getMobile1() +"," + contact.getWorkphone1() + "," + contact.getEmail1() + "," + contact.getEmail2() + "," + contact.getBirthdate() + "," + contact.getBirthmonth() + "," + contact.getBirthyear() + "," + contact.getGroup() + "," + contact.getAddress2() + "," + contact.getHomephone2() + ",!" + "\n");
	}
	writer.close();	
	}

	
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null){
			String[] part = line.split(",");
			ContactData contact = new ContactData()
			.withFirstName(part[0])
			.withLastName(part[1])
			.withAddress1(part[2])
			.withHomephone1(part[3])
			.withMobile1(part[4])
			.withWorkphone1(part[5])
			.withEmail1(part[6])
			.withEmail2(part[7])
			.withBirthdate(part[8])
			.withBirthmonth(part[9])
			.withBirthyear(part[10])
			.withGroup(part[11])
			.withAddress2(part[12])
			.withHomephone2(part[13]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++) {
			ContactData contact = new ContactData()
					.withFirstName(generateRandomString())
					.withLastName(generateRandomString())
					.withAddress1(generateRandomString())
					.withHomephone1(generateRandomString())
					.withMobile1(generateRandomString())
					.withWorkphone1(generateRandomString())
					.withEmail1(generateRandomString())
					.withEmail2(generateRandomString())
					.withBirthdate(generateRandomString())
					.withBirthmonth(generateRandomString())
					.withBirthyear(generateRandomString())
					.withGroup(generateRandomString())
					.withAddress2(generateRandomString())
					.withHomephone2(generateRandomString());
			list.add(contact);
		}
		return list;
	}

	public static String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}
}