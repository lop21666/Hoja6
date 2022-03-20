package uvg.edu.common;

public class Producto {
	
	int Cantidad;
	String Categoria;
	String Descripcion;
	
	public Producto(int cantidad, String categoria, String descripcion) {
		Cantidad = cantidad;
		Categoria = categoria;
		Descripcion = descripcion;
	}
	
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Producto [Cantidad=" + Cantidad + ", Categoria=" + Categoria + ", Descripcion=" + Descripcion + "]";
	}

}
