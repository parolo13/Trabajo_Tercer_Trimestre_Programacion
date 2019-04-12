package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import programacion.Registro;

import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Registrarse extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private boolean entra=true;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Registrarse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(124, 46, 103, 20);
		panel.add(textPane_1);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(124, 77, 187, 20);
		panel.add(textPane_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(124, 108, 103, 20);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(124, 141, 103, 20);
		panel.add(passwordField_1);
		
		JTextPane txtpnUsuario = new JTextPane();
		txtpnUsuario.setText("Usuario");
		txtpnUsuario.setEditable(false);
		txtpnUsuario.setBackground(SystemColor.menu);
		txtpnUsuario.setBounds(36, 46, 78, 20);
		panel.add(txtpnUsuario);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setText("Email");
		txtpnEmail.setEditable(false);
		txtpnEmail.setBackground(SystemColor.menu);
		txtpnEmail.setBounds(36, 77, 78, 20);
		panel.add(txtpnEmail);
		
		JTextPane txtpnContrasea = new JTextPane();
		txtpnContrasea.setText("Contrase\u00F1a");
		txtpnContrasea.setEditable(false);
		txtpnContrasea.setBackground(SystemColor.menu);
		txtpnContrasea.setBounds(36, 108, 78, 20);
		panel.add(txtpnContrasea);
		
		JTextPane txtpnRecontrasea = new JTextPane();
		txtpnRecontrasea.setText("ReContrase\u00F1a");
		txtpnRecontrasea.setEditable(false);
		txtpnRecontrasea.setBackground(SystemColor.menu);
		txtpnRecontrasea.setBounds(36, 141, 78, 20);
		panel.add(txtpnRecontrasea);
		
		
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(! passwordField.getText().equals(passwordField_1.getText())) {
					JTextPane textPane = new JTextPane();
					textPane.setText("Error, las contrase\u00F1as no coinciden");
					textPane.setForeground(Color.RED);
					textPane.setEditable(false);
					textPane.setBackground(SystemColor.menu);
					textPane.setBounds(256, 108, 158, 48);
					panel.add(textPane);
				}else {
					try {
						Registro usuario=new Registro();
						entra=usuario.Usuario(textPane_1.getText(),passwordField.getText(),textPane_4.getText());
						} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(entra) {
						JTextPane textPane = new JTextPane();
						textPane.setText("Exito");
						textPane.setForeground(Color.GREEN);
						textPane.setEditable(false);
						textPane.setBackground(SystemColor.menu);
						textPane.setBounds(256, 108, 158, 48);
						panel.add(textPane);
					}else {
						JTextPane textPane = new JTextPane();
						textPane.setText("ERROR");
						textPane.setForeground(Color.RED);
						textPane.setEditable(false);
						textPane.setBackground(SystemColor.menu);
						textPane.setBounds(256, 108, 158, 48);
						panel.add(textPane);

					}
					
				}
			}
		});
		btnRegistrarse.setBounds(113, 174, 198, 23);
		panel.add(btnRegistrarse);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login o = new login();
				o.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(113, 206, 198, 23);
		panel.add(btnVolver);
		
	}
}
