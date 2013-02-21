package models;

import java.util.*;

import play.data.validation.Email;
import play.data.validation.Password;
import play.data.validation.Phone;
import play.data.validation.Required;

import siena.*;
import siena.embed.Embedded;
import siena.embed.Embedded.Mode;

public class User extends Model {
	@Id(Generator.AUTO_INCREMENT)
	public Long id;

	// token from 3rd party authenticator (i.e. google, facebook, yahoo...etc)
	public String authToken;

	// mobile Token to send notifications to GCM or Apple Notification System
	public String mobileToken;

	// Date created
	@DateTime
	public Date creationDate;

	// First Name
	@Required
	@Max(20)
	public String firstName;

	// Last Name
	@Required
	@Max(30)
	public String lastName;

	// The role of this account
	@Required
	@Column("role")
	@Index("role_index")
	public int role;

	// Contact email
	@Required
	@Email
	public String email;

	// Contact mobile phone number
	@Required
	@Phone
	public String mobilePhoneNumber;

	@Required
	public String userName;

	@Required
	@Password
	public String passwd;

	@Filter("favList")
	public static Query<Event> eventList;

	// Category Tags
	@Filter("usercategory_index")
	public static Query<UserCategory> category;

	public User() {
		super();
		creationDate = new Date();
	}

	public static List<UserCategory> getUserCategorys() {
		return category.fetch();
	}

	public static Query<User> all() {
		return Model.all(User.class);
	}

	public static User findByEmail(String email) {
		return all().filter("email", email).get();
	}


	public String toString() {
		return "User: " + userName + " Role: " + role + " authToken: "
				+ authToken + " mobileToken: " + mobileToken;
	}

	public static User findByUserName(String u) {
		return all().filter("userName", u).get();
	}

	public static User findByPhoneNumber(String u) {
		return all().filter("mobilePhoneNumber", u).get();
	}

	public static List<User> findByRole(int role) {
		return all().filter("role", role).fetch();
	}

	public static User findById(Long id) {
		return all().filter("id", id).get();
	}

	public static User findByAuthToken(String token) {
		return all().filter("authToken", token).get();
	}

	public static User findByPasswd(String u, String p) {
		return all().filter("userName", u).filter("passwd", p).get();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime
				* result
				+ ((mobilePhoneNumber == null) ? 0 : mobilePhoneNumber
						.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((passwd == null) ? 0 : passwd.hashCode());
		result = prime * result
				+ ((authToken == null) ? 0 : authToken.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + (int) role;
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
		User other = (User) obj;

		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;

		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;

		if (mobilePhoneNumber == null) {
			if (other.mobilePhoneNumber != null)
				return false;
		} else if (!mobilePhoneNumber.equals(other.mobilePhoneNumber))
			return false;

		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;

		if (passwd == null) {
			if (other.passwd != null)
				return false;
		} else if (!passwd.equals(other.passwd))
			return false;

		if (authToken == null) {
			if (other.authToken != null)
				return false;
		} else if (!authToken.equals(other.authToken))
			return false;

		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;

		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;

		if (role != other.role)
			return false;

		return true;
	}
}
