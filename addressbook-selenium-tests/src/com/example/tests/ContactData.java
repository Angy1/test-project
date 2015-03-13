package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	private String firstname;
	private String lastname;
	private String address1;
	private String homephone1;
	private String mobile1;
	private String workphone1;
	private String email1;
	private String email2;
	private String birthdate;
	private String birthmonth;
	private String birthyear;
	private String group;
	private String address2;
	private String homephone2;

	public ContactData() {
		
	}
	
	public ContactData(String firstname, String lastname, String address1,
			String homephone1, String mobile1, String workphone1,
			String email1, String email2, String birthdate, String birthmonth,
			String birthyear, String group, String address2, String homephone2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address1 = address1;
		this.homephone1 = homephone1;
		this.mobile1 = mobile1;
		this.workphone1 = workphone1;
		this.email1 = email1;
		this.email2 = email2;
		this.birthdate = birthdate;
		this.birthmonth = birthmonth;
		this.birthyear = birthyear;
		this.group = group;
		this.address2 = address2;
		this.homephone2 = homephone2;
	}

	@Override
	public String toString() {
		return "ContactData [lastname=" + lastname + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result+ ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {	
		return this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
	}

//	public ContactData setfirstname(String firstname) {
//		this.firstname = firstname;
//		return this;
//	}
//
//	public ContactData setlastname(String lastname) {
//		this.lastname = lastname;
//		return this;
//	}

	public ContactData withFirstName(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public ContactData withLastName(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public ContactData withAddress1(String address1) {
		this.address1 = address1;
		return this;
	}

	public ContactData withHomephone1(String homephone1) {
		this.homephone1 = homephone1;
		return this;
	}

	public ContactData withMobile1(String mobile1) {
		this.mobile1 = mobile1;
		return this;
	}

	public ContactData withWorkphone1(String workphone1) {
		this.workphone1 = workphone1;
		return this;
	}

	public ContactData withEmail1(String email1) {
		this.email1 = email1;
		return this;
	}

	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}

	public ContactData withBirthdate(String birthdate) {
		this.birthdate = birthdate;
		return this;
	}

	public ContactData withBirthmonth(String birthmonth) {
		this.birthmonth = birthmonth;
		return this;
	}

	public ContactData withBirthyear(String birthyear) {
		this.birthyear = birthyear;
		return this;
	}

	public ContactData withGroup(String group) {
		this.group = group;
		return this;
	}

	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
		
	}

	public ContactData withHomephone2(String homephone2) {
		this.homephone2 = homephone2;
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAddress1() {
		return address1;
	}

	public String getHomephone1() {
		return homephone1;
	}

	public String getMobile1() {
		return mobile1;
	}

	public String getWorkphone1() {
		return workphone1;
	}

	public String getEmail1() {
		return email1;
	}

	public String getEmail2() {
		return email2;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public String getBirthmonth() {
		return birthmonth;
	}

	public String getBirthyear() {
		return birthyear;
	}

	public String getGroup() {
		return group;
	}

	public String getAddress2() {
		return address2;
	}

	public String getHomephone2() {
		return homephone2;
	}

}