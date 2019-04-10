package interfaz;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BBDD.EntrarBBDD;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import interfaz.Crear_Todo;
import programacion.Entrar_Usuario;

import javax.swing.JSeparator;
import java.awt.SystemColor;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setBounds(100, 100, 570, 421);
		  int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	       int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	        this.setBounds((ancho / 2) - (this.getWidth() / 2), (alto / 2) - (this.getHeight() / 2), 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnUsuario = new JTextPane();
		txtpnUsuario.setEditable(false);
		txtpnUsuario.setBackground(UIManager.getColor("Button.background"));
		txtpnUsuario.setText("Usuario");
		txtpnUsuario.setBounds(59, 47, 50, 20);
		contentPane.add(txtpnUsuario);
		
		JTextPane txtpnContrasea = new JTextPane();
		txtpnContrasea.setEditable(false);
		txtpnContrasea.setBackground(UIManager.getColor("Button.background"));
		txtpnContrasea.setText("Contrase\u00F1a");
		txtpnContrasea.setBounds(158, 47, 86, 20);
		contentPane.add(txtpnContrasea);
		
		textField = new JTextField();
		textField.setBounds(59, 78, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 78, 86, 20);
		contentPane.add(passwordField);
		JButton btnIniciarSesion = new JButton("Entrar");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("q") && passwordField.getText().equals("q")) {
					System.out.println("Entraste");
					Crear_Todo o=new Crear_Todo();
					dispose();
					o.setVisible(true);
					
				}else {
					
					JTextPane txtpnError = new JTextPane();
					txtpnError.setEditable(false);
					txtpnError.setForeground(Color.RED);
					txtpnError.setBackground(UIManager.getColor("Button.background"));
					txtpnError.setText("ERROR");
					txtpnError.setBounds(377, 78, 62, 20);
					contentPane.add(txtpnError);	
				}
			}
		});
		btnIniciarSesion.setBounds(254, 77, 122, 23);
		contentPane.add(btnIniciarSesion);
		
		JTextPane txtpnInicioDeSesion = new JTextPane();
		txtpnInicioDeSesion.setText("Inicio de sesion");
		txtpnInicioDeSesion.setEditable(false);
		txtpnInicioDeSesion.setBackground(SystemColor.menu);
		txtpnInicioDeSesion.setBounds(10, 11, 122, 20);
		contentPane.add(txtpnInicioDeSesion);
		
		JTextPane txtpnSiNoEsta = new JTextPane();
		txtpnSiNoEsta.setEditable(false);
		txtpnSiNoEsta.setBackground(UIManager.getColor("Button.background"));
		txtpnSiNoEsta.setText("Si no esta registrado,registrese.");
		txtpnSiNoEsta.setBounds(57, 164, 220, 20);
		contentPane.add(txtpnSiNoEsta);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrarse o=new Registrarse();
				dispose();
				o.setVisible(true);
				
			}
		});
		btnRegistrarse.setBounds(254, 164, 122, 23);
		contentPane.add(btnRegistrarse);
		
		JButton btnNewButton = new JButton("Si se le ha olvidado la contrase\u00F1a, pulse aqu\u00ED");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setBounds(59, 109, 317, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
