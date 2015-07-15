package example;

/**
 * @class	User
 * @desc	Clase de ejemplo que repretara a objetos del tipo Usuario
 * @attr
 * 		name	::String
 * 		color	::List<Post>
 */

public class User {

	public String name;

	public String lastName;
	
	public Integer age;
	
	public String address;
	
	public User(String nameToSet, String lastName) {
		
		this.name = nameToSet;
		
		this.lastName = lastName;
		
	}
	
	public User(String nameToSet, String lastName, Integer age) {
		
		this.name = nameToSet;
		
		this.lastName = lastName;
		
		this.age = age;
		
	}
	
public User(String nameToSet, String lastName, Integer age, String address) {
		
		this.name = nameToSet;
		
		this.lastName = lastName;
		
		this.age = age;
		
		this.lastName = address;
	}


}