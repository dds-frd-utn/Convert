/*
 * 	@name	Converter
 * 	@type	Publico
 * 	@desc	Convierte una lista de objetos en un archivo CSV
 * 	@params	Ninguno
 * 	@return	Converter Instance
 */

package lib;

import java.io.FileWriter;		//	Maneja la creacion y edicion de archivos.
import java.io.IOException;		//	Maneja el control de errores.
import java.lang.reflect.*;		//	Maneja los atributos, sus valores y los metodos de los objetos.
import java.util.ArrayList;		//	Maneja la creacion y control de ArrayList.

public class Converter {
	
	/*
	 * 	@name	createHeaders
	 * 	@type	Privado
	 * 	@desc	Crea la cabecera del archivo CSV.
	 *	@params
	 *			Field[] fields	::	Array de objetos del tipo Field.
	 * 	@return
	 *			String header	::	Cadena que representa la cabecera del archivo CSV.
	 */
	
	private String createHeaders(Field[] fields) {
		
		//	Creo una variable del tipo string que representa la cabecera
		String header = "";
		
		//	Recorro cada campo
        for (int j=0; j < fields.length; j++)
        {
        	//	Agrego a la cabecera el nombre del campo encerrado entre comillas dobles
        	header += "\""+fields[j].getName()+"\"";
        	
        	//	Agrego a la cabecera una coma si no es el ultimo campo
        	if (j < fields.length-1) header += ",";
        }
		
        //	Devuelvo la cabecera
        return	header;
	}
	
	/*
	 * 	@name	createRow
	 * 	@type	Privatado
	 * 	@desc	Crea la fila del archivo CSV.
	 *	@params
	 *			Field[] fields	::	Array de objetos del tipo Field.
	 *			Object object	::	Objeto a ser representado en una fila.
	 * 	@return
	 *			String row		::	Cadena que representa la fila del archivo CSV.
	 */
	
	private String createRow(Field[] fields, Object object) {
		
		//	Creo una variable del tipo string que representa la fila del CSV
		String row = "";
		
		// 	Recorro cada campo
        for (int j=0; j < fields.length; j++)
        {
        	//	Intento obtener el valor del campo y escribirlo
        	try {
        		
        		System.out.println(fields[j].get(object).toString());
        		
        		//	Obtengo el valor del campo y lo escribo agrego a la fila encerrandolo entre comillas       		
        		if	(fields[j].get(object) == null)
        			throw new IllegalArgumentException();
        		else
        			row += "\""+fields[j].get(object)+"\"";
        		
			}	catch (IllegalArgumentException | IllegalAccessException e)	{
			
				//	Si no pude leer el valor agrego una cadena vacia
				row += "";
			
			}
        	
        	//	Si no es el ultimo campo escribo una coma en el archivo CSV
        	if (j < fields.length-1) row += ",";
        }
        
        //	Devuelvo la fila
        return row;
		
	}
	
	/*
	 * 	@name	createFileAndConvert
	 * 	@type	Privado
	 * 	@desc	Crea apartir una lista de objetos el archivo CSV en un directorio dado.
	 *	@params
	 * 			ArrayList<?> listToConvert	::	Lista de objetos a convertir
	 * 			String csvPath				::	Lugar donde se guardara el archivo CSV
	 * 	@return	Nada
	 */
	
	private void createFileAndConvert(ArrayList<?> listToConvert, String csvPATH) {
		
		//	Creo una variable del tipo Field que representa los campos de la clase
		Field fields[];
		
		try
		{
			//	Creo una instancia de mi escritor de archivos
		    FileWriter writer = new FileWriter(csvPATH);
		    
		    //	Obtengo la lista de campos apartir del primer objeto
	        fields = listToConvert.get(0).getClass().getFields();
	        
	        //	Inserto la cabecera dentro del archivo CSV
	        writer.append(createHeaders(fields));
	        
	        //	Escribo un salto de linea en el CSV
	        writer.append(System.getProperty("line.separator"));
		    
	        //	Recorro cada objeto de mi lista
		    for (int i=0; i < listToConvert.size(); i++)
			{
		    	
		    	//	Escribo la fila en el CSV
		    	writer.append(createRow(fields, listToConvert.get(i)));
		    	
		    	//	Escribo un salto de linea en el CSV
		        writer.append(System.getProperty("line.separator"));
		    	
		    }
		    	 
		    //	Escribo y cierro el archivo
		    writer.flush();
		    writer.close();
		    
		}	catch(IOException e)	{
			
		     e.printStackTrace();
		     
		}
		
	}
	
	/*
	 * 	@name	convert
	 * 	@type	Publico
	 * 	@desc	Crea apartir una lista de objetos el archivo CSV en el directorio C:\\DDS\\test.csv.
	 *	@params
	 * 			ArrayList<?> listToConvert	::	Lista de objetos a convertir
	 * 	@return	Nada
	 */
	
	public void convert(ArrayList<?> listToConvert) {
		
		//	Llamo al metodo encargado de crear el archivo CSV
		createFileAndConvert(listToConvert, "C:\\DDS\\test.csv");
		
	}
	
	/*
	 * 	@name	convert
	 * 	@type	Publico
	 * 	@desc	Crea apartir una lista de objetos el archivo CSV en un directorio dado.
	 *	@params
	 * 			ArrayList<?> listToConvert	::	Lista de objetos a convertir
	 * 			String csvPath				::	Lugar donde se guardara el archivo CSV
	 * 	@return	Nada
	 */
	
	public void convert(ArrayList<?> listToConvert, String csvPath) {
		
//		Llamo al metodo encargado de crear el archivo CSV
		createFileAndConvert(listToConvert, csvPath);
		
	}
}
