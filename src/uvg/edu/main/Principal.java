/**
 * 
 */
package uvg.edu.main;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import uvg.edu.io.Reader;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        boolean salir = false;
        boolean error = false;
        int opc = 0;
        Reader reader = new Reader();
        Map filasLeidas;
        String ruta;
        String typeMap = "";

        while(!salir){
        	
        	do{
                //Verificacion de entrada de las opciones del menu
                try{
                    //Solicitud de opcion de menu
                	System.out.println("Que implementación de Map desea utilizar?");
                	System.out.println("Ingrese el numero de la opcion");
    	            //Opciones del menú
    				System.out.println("1. HashMap\n"
    									+ "2. TreeMap\n"
    									+ "3. LinkedHashMap\n");
    	            opc = sc.nextInt();
                    error = false;

                //En caso de error
                }catch(Exception e){
                    System.out.println("Ha ocurrido un error, intente de nuevo.\n");
                    error = true;
                //Finalmente
                }finally{
                	sc.nextLine();
                }
            }while(error);

            switch (opc) {
                case 1:
                	typeMap = "HashMap";
                	break;
                case 2:
                	typeMap = "TreeMap";
                	break;
                case 3:
                	typeMap = "LinkedHashMap";
                	break;
                default:
            		System.out.println("Opcion incorrecta. Intentelo de nuevo.");
            		break;
            }
            
            System.out.println("Ingrese la ruta en la que se encunetre el archivo.");
        	ruta = sc.nextLine();
        	filasLeidas = reader.leerTxt(ruta, typeMap);

        }
        sc.close();        

    }

}

