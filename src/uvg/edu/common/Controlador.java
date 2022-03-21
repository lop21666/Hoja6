package uvg.edu.common;

import java.util.*;

public class Controlador {
	
	Scanner sc = new Scanner(System.in);
	
	public Controlador() {
		
	}
	
	public Map insert(Map inventario) {
		
		int opc = 0;
		ArrayList<String> categorias = new ArrayList<String>();
    	for (Object i : inventario.keySet()) {
    		String split[] = ((String) i).split(" - ");
     		categorias.add(split[0]);
     	}
    	Set<String> hashSet = new HashSet<String>(categorias);
    	categorias.clear();
    	categorias.addAll(hashSet);
    	int contador = 1;
    	System.out.println("Ingrese el numero de la categoria del producto que desea agregar\n");
    	for (String categoria : categorias) {
    		System.out.println(contador + ". " + categoria);
    		contador ++;
    	}
    	opc = sc.nextInt();
    	sc.nextLine();
    	if(opc > categorias.size()) {
    		System.out.println("El numero de opción ingresado no existe\n");
    	}else {
    		System.out.println("Ingrese el producto que desea agregar\n");
    		String prod = sc.nextLine();
    		sc.nextLine();
    		System.out.println("Ingrese la cantidad de unidades\n");
    		int cantidad = sc.nextInt();
    		sc.nextLine();
    		
    		Producto producto = new Producto(cantidad, categorias.get(opc-1), prod);
    		System.out.println("Producto ingresado con exito!\n");
    		
    		inventario.put(categorias.get(opc-1) + " - " + producto.getDescripcion() , producto);
    	}
		return inventario;
	}
	
	
	public void buscarCategoria(Map inventario) {
		
		System.out.println("Ingrese producto del que desea ver su categoria.\n");
    	String articulo = sc.nextLine();
    	sc.nextLine();
    	
    	ArrayList<String> productos = new ArrayList<String>();
    	for (Object i : inventario.keySet()) {
    		productos.add((String) i);
     	}
    	
    	int validacion = 0;
    	String categoriaEncontrada = "";
    	for (String i : productos) {
    		System.out.println(i);
    		String split[] = i.split(" - ");
    		if(split[1] == articulo) {
    			validacion = 1;
    			categoriaEncontrada = split[0];
    		}
     	}
    	
    	if(validacion == 1) {
    		System.out.println("La categoria del producto ingresado es:\n");
    		System.out.println(categoriaEncontrada);
    	}else {
    		System.out.println("El producto ingresado no se ha encontrado.\n");
    	}
		
	}
	
	public void listar(Map inventario) {
		Iterator it = inventario.entrySet().iterator();
     	while(it.hasNext()) {
     		Map.Entry pair = (Map.Entry) it.next();
     		System.out.println(pair.getKey() + " = " + pair.getValue());
     	}
	}
	

}
