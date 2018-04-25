package modelo;

import modelo.vo.Producto;

public class ServicioProductoCasilla {

	private AdministradorProducto adminproducto;
	
	public ServicioProductoCasilla() {
		adminproducto = AdministradorProducto.getInstance();
	}

	public void insertarProducto(int idProducto, String nombreProducto, int precio) {
		adminproducto.insertarProducto(idProducto, nombreProducto, precio);
	}
	
	public Producto[] listarProductos() {
		return adminproducto.listarProducto();
	}
}
	
	

