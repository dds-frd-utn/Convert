# Convert
Libreria Java la cual permite convertir una lista de objetos en un archivo CSV.

### ¿Como la utilizo?
Primero es necesario importar la libreria

```
import librerias.Converter;
```

Luego solo basta con generar una istancia de la clase Converter para poder hacer uso de sus metodos.

```
Converter myConverter = new Converter();
```

Una vez creada una instancia de la clase <b>Converter</b>, disponemos del metodo <b>convert</b> un metodo el cual recibe como argumentos el listado de objetos a convertir y la direccion en donde queremos guardar el objeto una vez terminada la conversion.

```
myConverter.convert(myArray,elPATH);
```

Por ejemplo, creamos una clase llamada User como sigue:

```
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
```

Luego importamos la librería, creamos una lista de usuarios y convertimos la lista a CSV como sigue:

```
//  Importamos la librería
import lib.Converter;

//  Creamos un ArrayList que contendrá  instancias de la clase User
ArrayList<User> myArray = new ArrayList<User>();

//  Agregamos dentro del ArrayList las instancias de la clase User
myArray.add(new User("Juan","Perez"));
myArray.add(new User("Roberto","Carlos",53));
myArray.add(new User("Jose","Gomez",25,"San Martin 123"));

//  Instanciamos el Converter
Converter myConverter = new Converter();

//  Convertimos la lista de Users y guardamos el CSV en la carpeta DDS del disco C.
myConverter.convert(myArray,"C:\\DDS\\test.csv");
```

### ¿A quién agradecemos?
Esta librería fue desarrollada por:
- Emiliano Casas
- Agustin Rosas
- Neri Güidi
