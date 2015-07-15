package example;

import lib.Converter;
import example.User;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<User> myArray = new ArrayList<User>();
				
		myArray.add(new User("Juan","Perez"));
		myArray.add(new User("Roberto","Carlos",53));
		myArray.add(new User("Jose","Gomez",25,"San Martin 123"));
		
		Converter myConverter = new Converter();
						
		myConverter.convert(myArray,"/home/alumno/test.csv");
		
		
	}

}
