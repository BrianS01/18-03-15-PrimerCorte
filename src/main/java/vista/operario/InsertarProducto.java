package vista.operario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorProductoCasilla;
import modelo.vo.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InsertarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField nombreProducto;
	private JTextField precio;
	private MenuOperario menuOperario;
	private ControladorProductoCasilla controladorProductoCasilla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertarProducto frame = new InsertarProducto();
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
	public InsertarProducto() {
		controladorProductoCasilla = new ControladorProductoCasilla();
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombreDelProducto = new JLabel("Nombre del producto");
		lblNombreDelProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreDelProducto.setBounds(111, 32, 198, 29);
		contentPane.add(lblNombreDelProducto);

		nombreProducto = new JTextField();
		nombreProducto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limit = 23;
				if (nombreProducto.getText().length() == limit) {
					e.consume();
				}
			}
		});
		nombreProducto.setBounds(70, 81, 228, 37);
		contentPane.add(nombreProducto);
		nombreProducto.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(162, 155, 50, 29);
		contentPane.add(lblPrecio);

		precio = new JTextField();
		precio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limit1 = 8;
				if (precio.getText().length() == limit1) {
					e.consume();
				}

				// Falta validar que el precio sea solo numeros.
			}
		});
		precio.setBounds(70, 197, 228, 43);
		contentPane.add(precio);
		precio.setColumns(10);

		JButton AgregarProducto = new JButton("Agregar Producto");
		AgregarProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int idProducto = 0;
					controladorProductoCasilla.insertarProducto(idProducto, nombreProducto.getText(),
							Integer.parseInt(precio.getText()));

					Producto[] productos = controladorProductoCasilla.listarProductos();
					System.out.println("\tId\tNombre\tPrecio");
					if (productos.length > 0) {
						for (Producto pr : productos) {
							if (pr != null) {
								System.out.println("\t" + pr.getIdProducto() + "\t" + pr.getNombre() + "\t" + pr.getPrecio());
							}
						}
					}

				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "El precio debe ser un valor numerico");
				}
			}
		});
		AgregarProducto.setBounds(111, 281, 145, 37);
		contentPane.add(AgregarProducto);
	}

	public void validarProducto(String nombreProducto, String precio) {
		if (nombreProducto.equals("") || precio.equals("")) {
			JOptionPane.showMessageDialog(null, "No deje los espacios en blanco");
		}
		// else if()
	}

}
