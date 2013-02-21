package models;

import java.util.List;

import play.data.validation.Required;
import siena.*;

public class UserCategory extends Model {
	@Id(Generator.AUTO_INCREMENT)
	public Long id;

	@Index("usercategory_index")
	public User user;

	@Index("category_index")
	@Required
	public Category cat;

	public UserCategory(User u, Category c) {
		user = u;
		cat = c;
	}

	public static Query<UserCategory> all() {
		return Model.all(UserCategory.class);
	}

	public static UserCategory findByUserAndCategory(String c,
			User u) {
		return all().filter("user", u).filter("cat.name", c).get();
	}

	public static UserCategory findById(Long id) {
		return all().filter("id", id).get();
	}

	public static List<UserCategory> findByUser(User u) {
		return all().filter("user", u).fetch();
	}

	public static List<UserCategory> findByCategory(String c) {
		return all().filter("cat.name", c).fetch();
	}

	public String toString() {
		return "Category: " + cat + "UserID: " + user.id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((cat == null) ? 0 : cat.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		UserCategory other = (UserCategory) obj;

		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;

		if (cat == null) {
			if (other.cat != null)
				return false;
		} else if (!cat.equals(other.cat))
			return false;
		return true;
	}
}
