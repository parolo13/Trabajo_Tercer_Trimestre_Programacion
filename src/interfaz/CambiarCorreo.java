package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import programacion.CambioDeContraseña;
import programacion.CambioDeCorreo;

import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CambiarCorreo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public CambiarCorreo(String usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnNuevoCorreo = new JTextPane();
		txtpnNuevoCorreo.setText("Nuevo correo");
		txtpnNuevoCorreo.setEditable(false);
		txtpnNuevoCorreo.setBackground(SystemColor.menu);
		txtpnNuevoCorreo.setBounds(95, 64, 124, 20);
		contentPane.add(txtpnNuevoCorreo);
		
		JTextPane correo = new JTextPane();
		correo.setBounds(240, 64, 99, 20);
		contentPane.add(correo);
		
		/**
		 * Cambia el correo cogiendo el usuario
		 */
		JButton button = new JButton("Confirmar cambio");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambioDeCorreo.Correo(correo.getText(), usuario);
			}
		});
		button.setBounds(95, 114, 244, 23);
		contentPane.add(button);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Configuracion o=new Configuracion(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnVolver.setBounds(95, 173, 244, 23);
		contentPane.add(btnVolver);
	}

}
