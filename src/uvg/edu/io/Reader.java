package uvg.edu.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import uvg.edu.common.MapInstanceCreator;

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
            
            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null){
            	
            	String x[] = linea.split("\\|\t");
                map.put(x[0], x[1]);
                
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
	
}
