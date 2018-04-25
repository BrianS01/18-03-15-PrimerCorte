package modelo;

import modelo.vo.Producto;

public class AdministradorProducto {

	private static AdministradorProducto administradorProducto;
	public Producto producto;
    private Producto[] miProducto;
	
	public AdministradorProducto() {
		miProducto = new Producto[30];
	}
	
	public void insertarProducto(int idProducto, String nombre, int precio) {
		producto=new Producto(idProducto, nombre, precio);

	    for(int i=0; i< miProducto.length;i++) {
	    	if(miProducto[i]==null) {
	    		miProducto[i] = producto;
	    		break;
	    	}
	    }
	 
	}
	
	public static AdministradorProducto getInstance() {
		if(administradorProducto==null) {
			return new AdministradorProducto();
		}
		return administradorProducto;
	}
		
	public void eliminarProducto(int idProducto) {
		
	}
	
	public Producto[] listarProducto() {			   
		return miProducto;
	}
	
}
