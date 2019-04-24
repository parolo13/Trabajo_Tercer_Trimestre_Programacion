package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import programacion.CambioDeContraseña;

import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CambiarContraseña extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public CambiarContraseña(String usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextPane txtpnNuevaContrasea = new JTextPane();
		txtpnNuevaContrasea.setText("Nueva contrase\u00F1a");
		txtpnNuevaContrasea.setEditable(false);
		txtpnNuevaContrasea.setBackground(SystemColor.menu);
		txtpnNuevaContrasea.setBounds(95, 78, 124, 20);
		panel.add(txtpnNuevaContrasea);
		
		JTextPane contraseña = new JTextPane();
		contraseña.setBounds(240, 78, 99, 20);
		panel.add(contraseña);
		
		JButton button = new JButton("Confirmar cambio");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambioDeContraseña.Contraseña(contraseña.getText(), usuario);
			}
		});
		button.setBounds(95, 126, 244, 23);
		panel.add(button);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Configuracion o=new Configuracion(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnVolver.setBounds(95, 173, 244, 23);
		panel.add(btnVolver);
	}
}
