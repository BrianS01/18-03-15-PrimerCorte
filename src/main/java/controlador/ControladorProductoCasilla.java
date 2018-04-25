package controlador;

import modelo.ServicioProductoCasilla;
import modelo.vo.Producto;

public class ControladorProductoCasilla {
    
	private ServicioProductoCasilla servicioProductoCasilla;
	
	public ControladorProductoCasilla() {
		servicioProductoCasilla = new ServicioProductoCasilla();
	}
	
	public void insertarProducto(int idProducto, String nombreProducto, int precio) {
		servicioProductoCasilla.insertarProducto(idProducto, nombreProducto, precio);
	}
   
	
	public Producto[] listarProductos() {
		return servicioProductoCasilla.listarProductos();
	}
	
}
