package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import programacion.CambioDeUsuario;

import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CambiarUsuario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public CambiarUsuario(String usuario) {
		String usuarionuevo=usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextPane txtpnNuevoUsuario = new JTextPane();
		txtpnNuevoUsuario.setEditable(false);
		txtpnNuevoUsuario.setBackground(UIManager.getColor("Button.background"));
		txtpnNuevoUsuario.setText("Nuevo usuario");
		txtpnNuevoUsuario.setBounds(63, 67, 99, 20);
		panel.add(txtpnNuevoUsuario);
		
		JTextPane Usuario = new JTextPane();
		Usuario.setBounds(208, 67, 99, 20);
		panel.add(Usuario);
		
		JButton btnConfirmarCambio = new JButton("Confirmar cambio");
		btnConfirmarCambio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuarionuevo=usuario;
				try {
					usuarionuevo=CambioDeUsuario.Usuario(Usuario.getText(),usuario);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConfirmarCambio.setBounds(63, 115, 244, 23);
		panel.add(btnConfirmarCambio);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Configuracion o=new Configuracion(usuarionuevo);
				dispose();
				o.setVisible(true);
			}
		});
		btnVolver.setBounds(63, 174, 244, 23);
		panel.add(btnVolver);
	}
}
