/**
 * 
 */
package uvg.edu.main;

import java.util.*;

import uvg.edu.common.Controlador;
import uvg.edu.common.Producto;
import uvg.edu.io.Reader;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        boolean salir = false;
        boolean salir2 = false;
        boolean error = false;
        int opc = 0;
        Reader reader = new Reader();
        Map inventario;
        String ruta;
        String typeMap = "";
        Controlador controlador = new Controlador();

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
            
            System.out.println("Ingrese la ruta en la que se encuentre el archivo.");
        	ruta = sc.nextLine();
        	inventario = reader.leerTxt(ruta, typeMap);
        	
        	 while(!salir2) {
        		 do{
                     //Verificacion de entrada de las opciones del menu
                     try{
                         //Solicitud de opcion de menu
                     	System.out.println("Que operacion desea realizar?");
                     	System.out.println("Ingrese el numero de la opcion");
         	            //Opciones del menú
         				System.out.println("1. Agregar  un  producto\n"
         									+ "2. Mostrar la categoría del producto\n"
         									+ "3. Mostrar  los  datos  del  producto,  categoría  y  la  cantidad  de  cada  artículo\n"
         									+ "4. Mostrar  los  datos  del  producto,  categoría  y  la  cantidad  de  cada  artículo ordenadas por tipo.\n"
         									+ "5. Mostrar el producto y la categoría de todo el inventario.\n"
         									+ "6. Mostrar el producto y la categoría existentes, ordenadas por tipo.\n"
         									+ "7. Salir\n");
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
                 	inventario = controlador.insert(inventario);
                 	break;
                 case 2:
                 	controlador.buscarCategoria(inventario);
                 	break;
                 case 3:

                 	Iterator it = inventario.entrySet().iterator();
                 	while(it.hasNext()) {
                 		Map.Entry pair = (Map.Entry) it.next();
                 		System.out.println(pair.getKey() + " = " + pair.getValue());
                 	}

                 	break;
                 case 4:

                  	Iterator it = inventario.entrySet().iterator();
                  	while(it.hasNext()) {
                  		Map.Entry pair = (Map.Entry) it.next();
                  		System.out.println(pair.getKey() + " = " + pair.getValue());
                  	}

                  	break;
                 case 5:

                  	Iterator it = inventario.entrySet().iterator();
                  	while(it.hasNext()) {
                  		Map.Entry pair = (Map.Entry) it.next();
                  		System.out.println(pair.getKey() + " = " + pair.getValue());
                  	}

                  	break;
                 case 6:

                  	Iterator it = inventario.entrySet().iterator();
                  	while(it.hasNext()) {
                  		Map.Entry pair = (Map.Entry) it.next();
                  		System.out.println(pair.getKey() + " = " + pair.getValue());
                  	}

                  	break;
                 case 7:

                	salir = true;
                	salir2 = true;
	                System.out.println("Ejecucion finalizada");

                  	break;
                 default:
             		System.out.println("Opcion incorrecta. Intentelo de nuevo.");
             		break;
            	 } 
        		 
        	 } 

        }
        sc.close();        

    }

}

