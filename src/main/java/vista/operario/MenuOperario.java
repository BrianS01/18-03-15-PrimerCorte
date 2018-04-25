package vista.operario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuOperario extends JFrame {

	private JPanel contentPane;
    private InicioOperario inicioOperario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuOperario frame = new MenuOperario();
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
	public MenuOperario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenidoAdministrador = new JLabel("Bienvenido Administrador");
		lblBienvenidoAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBienvenidoAdministrador.setBounds(161, 31, 175, 25);
		contentPane.add(lblBienvenidoAdministrador);
		
		JButton insertarProducto = new JButton("InsertarProducto");
		insertarProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			cambiarInterfaz();	
				
			}
		});
		insertarProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		insertarProducto.setBounds(40, 78, 147, 35);
		contentPane.add(insertarProducto);
		
		JButton eliminarProducto = new JButton("EliminarProducto");
		eliminarProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eliminarProducto.setBounds(38, 138, 149, 35);
		contentPane.add(eliminarProducto);
		
		JButton verListaProductos = new JButton("Ver Lista Productos");
		verListaProductos.setBounds(39, 198, 148, 35);
		contentPane.add(verListaProductos);
		
		JButton Salir = new JButton("Salir");
		Salir.setBounds(287, 488, 89, 23);
		contentPane.add(Salir);
	}
     public void cambiarInterfaz(){
    	 InsertarProducto insertarProducto= new InsertarProducto();
		 insertarProducto.setVisible(true);
		 this.dispose();
     }


	public void adicionarProducto(int idProducto, String text, int text2) {
		inicioOperario.envioCredenciales(idProducto,text,text2);
		
	}

	
}
