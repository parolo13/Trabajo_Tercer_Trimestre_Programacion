package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;
import programacion.RecuperarContraseña;

import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ContraseñaOlvidada extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public ContraseñaOlvidada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JTextPane txtpnCorreo = new JTextPane();
		txtpnCorreo.setEditable(false);
		txtpnCorreo.setBackground(UIManager.getColor("Button.background"));
		txtpnCorreo.setText("Correo");
		txtpnCorreo.setBounds(20, 118, 53, 20);
		panel.add(txtpnCorreo);

		JTextPane Correo = new JTextPane();
		Correo.setBounds(83, 118, 217, 20);
		panel.add(Correo);

		JTextPane txtpnRecuperarContrasea = new JTextPane();
		txtpnRecuperarContrasea.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtpnRecuperarContrasea.setEditable(false);
		txtpnRecuperarContrasea.setForeground(SystemColor.desktop);
		txtpnRecuperarContrasea.setBackground(UIManager.getColor("Button.background"));
		txtpnRecuperarContrasea.setText("Recuperar contrase\u00F1a");
		txtpnRecuperarContrasea.setBounds(83, 28, 217, 46);
		panel.add(txtpnRecuperarContrasea);

		JButton btnRecuperarContrasea = new JButton("Recuperar contrase\u00F1a");
		btnRecuperarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nuevaCon = null;
				try {
					nuevaCon = RecuperarContraseña.RecuperarCon(Correo.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				/**
				 * Si devuelve 0 es que no esta bien el correo, y si no , le da la nueva
				 * contraseña y la muestra por pantalla
				 */
				if (nuevaCon.equals("0")) {
					JOptionPane.showMessageDialog(null, "Correo incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					System.out.println(nuevaCon);
					JOptionPane.showMessageDialog(null, "tu nueva contraseña es " + nuevaCon, "Contraseña",
							JOptionPane.INFORMATION_MESSAGE);
					Conexion.EjecutarUpdate(
							"UPDATE usuarios SET Clave='" + nuevaCon + "' where Correo='" + Correo.getText() + "'");
				}
			}
		});
		btnRecuperarContrasea.setBounds(127, 169, 139, 23);
		panel.add(btnRecuperarContrasea);

		JButton btnAtrs = new JButton("Volver");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login o = new login();
				dispose();
				o.setVisible(true);
			}
		});
		btnAtrs.setBounds(148, 203, 89, 23);
		panel.add(btnAtrs);
	}
}
