package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	public String firstname;
	public String lastname;
	public String address1;
	public String homephone1;
	public String mobile1;
	public String workphone1;
	public String email1;
	public String email2;
	public String birthdate;
	public String birthmonth;
	public String birthyear;
	public String group;
	public String address2;
	public String homephone2;

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

	public ContactData setfirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public ContactData setlastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

}