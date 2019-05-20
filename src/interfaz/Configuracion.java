package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import programacion.CambioDeContraseña;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Configuracion extends JFrame {

	private JPanel contentPane;

	/**
	 * Este es el panel para cambiar usuario, contraseña o correo
	 */
	
	/**
	 * Create the frame.
	 */
	public Configuracion(String usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnCambiarNombreDe = new JButton("Cambiar nombre de usuario");
		btnCambiarNombreDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambiarUsuario o=new CambiarUsuario(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnCambiarNombreDe.setBounds(10, 11, 404, 23);
		panel.add(btnCambiarNombreDe);
		
		JButton btnCambiarContrasea = new JButton("Cambiar contrase\u00F1a");
		btnCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambiarContraseña o=new CambiarContraseña(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnCambiarContrasea.setBounds(10, 61, 404, 23);
		panel.add(btnCambiarContrasea);
		
		JButton btnCambiarDireccionDe = new JButton("Cambiar direccion de correo");
		btnCambiarDireccionDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambiarCorreo o=new CambiarCorreo(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnCambiarDireccionDe.setBounds(10, 116, 404, 23);
		panel.add(btnCambiarDireccionDe);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eleccion o=new Eleccion(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnVolver.setBounds(10, 176, 404, 23);
		panel.add(btnVolver);
	}

}
