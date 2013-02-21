package models;

import play.data.validation.Required;
import siena.Generator;
import siena.Id;
import siena.Index;
import siena.Model;
import siena.Query;

public class Category extends Model{
	@Id(Generator.AUTO_INCREMENT)
	public Long id;
	
	@Index("category_index")
	@Required
	public String name;
	
	public Category(String n) {
		name = n;
	}
	
	public static Query<Category> all() {
		return Model.all(Category.class);
	}
	
	public static Category findById(Long id) {
		return all().filter("id", id).get();
	}
	
	public String toString() {
		return name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());

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
		Category other = (Category) obj;

		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
