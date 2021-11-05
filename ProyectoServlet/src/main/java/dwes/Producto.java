package dwes;

public class Producto {

	private String producto;
	private String cantidad;
	private int precio;



	public Producto(String producto2, String cantidad2, int precio2) {
		this.producto=producto2;
		this.cantidad=cantidad2;
		this.precio = precio2;
		
	}

	public String getProducto() {
		return producto;
		
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

}
