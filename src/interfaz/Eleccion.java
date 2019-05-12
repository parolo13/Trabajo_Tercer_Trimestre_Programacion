package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;


public class Eleccion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Eleccion(String usuario) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextPane txtpnquQuieresHacer = new JTextPane();
		txtpnquQuieresHacer.setEditable(false);
		txtpnquQuieresHacer.setBackground(UIManager.getColor("Button.background"));
		txtpnquQuieresHacer.setText("\u00BFQu\u00E9 quieres hacer?");
		txtpnquQuieresHacer.setBounds(142, 11, 230, 20);
		panel.add(txtpnquQuieresHacer);
		
		JButton btnNewButton = new JButton("Ver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ver_Todo o =new Ver_Todo(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnNewButton.setBounds(41, 42, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Editar\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editar_Todo o=new Editar_Todo(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(283, 42, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Crear_Todo o=new Crear_Todo(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnCrear.setBounds(41, 106, 89, 23);
		panel.add(btnCrear);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Borrar_Todo o=new Borrar_Todo(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnBorrar.setBounds(283, 106, 89, 23);
		panel.add(btnBorrar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login o=new login();
				dispose();
				o.setVisible(true);
			}
		});
		btnVolver.setBounds(41, 176, 138, 23);
		panel.add(btnVolver);
		
		JButton btnConfiguracion = new JButton("Configuracion");
		btnConfiguracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Configuracion o=new Configuracion(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnConfiguracion.setBounds(214, 176, 158, 23);
		panel.add(btnConfiguracion);
	}

}
