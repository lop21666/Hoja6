package uvg.edu.io;
import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;

import uvg.edu.common.MapInstanceCreator;
import uvg.edu.common.Producto;

public class Reader {

	public Reader(){}

    public Map<String, String> leerTxt(String ruta, String typeMap){

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
        	//Nombre del archivo que se lee para obtener todas las expresiones proporcionadas
            archivo = new File (ruta);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            MapInstanceCreator mapFactory = new MapInstanceCreator();
            Map map = mapFactory.getInstance(typeMap);
            Random random = new Random();
            
            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null){
            	
            	String x[] = linea.split("\\|\t");
            	
            	Producto producto = new Producto(random.nextInt(10 + 1) + 1, x[0], x[1]);
                map.put(hashFunction(x[0],x[1]), producto);
                
            }
            return map;
            
        }catch(Exception e){
        	System.out.println("La ruta del archivo proporcionada no existe, por favor cambiarla dentro de la clase 'Archivo.java'");
        }finally{
            try{                    
                if( null != fr ){   
                    fr.close();     
                }                  
            }catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
        return null;
    }
    
    private String hashFunction(String name, String producto) {	
    	String key = name + " - " + producto;
    	return key;
    }
	
}
