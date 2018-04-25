package vista.operario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorProductoCasilla;
import modelo.vo.Producto;

import javax.swing.JComboBox;
import javax.swing.JTable;

public class VerListaDeProducto extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ControladorProductoCasilla controladorProductoCasilla;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerListaDeProducto frame = new VerListaDeProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VerListaDeProducto() {
		controladorProductoCasilla = new ControladorProductoCasilla();
		Producto[] productos = controladorProductoCasilla.listarProductos();
		System.out.println("\tId\tNombre\tPrecio");
		if(productos.length>0) {
			for(Producto pr:productos) {
				System.out.println("\t"+pr.getIdProducto()+"\t"+pr.getNombre()+"\t"+pr.getPrecio());
			}
		}
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String[] columnas = { "Id", "Nombre", "Precio" };
		String[][] data = { { "1", "Papas", "10000" }, { "2", "Yougourt", "5999" } };
		DefaultTableModel dtm = new DefaultTableModel(data, columnas);
		table = new JTable(dtm);
		table.setBounds(86, 85, 23, -27);
		contentPane.add(table);
	}
}
