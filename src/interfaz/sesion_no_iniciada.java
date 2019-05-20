package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sesion_no_iniciada extends JFrame {

	private JPanel contentPane;

	/**
	 * JPanel para los que no tienen un usuario creado
	 */
	/**
	 * Create the frame.
	 */
	public sesion_no_iniciada(String usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnVerJugadores = new JButton("Ver jugadores");
		btnVerJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ver_Jugadores o=new Ver_Jugadores(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnVerJugadores.setBounds(30, 36, 118, 42);
		panel.add(btnVerJugadores);
		
		JButton btnVerLigas = new JButton("Ver ligas");
		btnVerLigas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ver_Ligas o=new Ver_Ligas(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnVerLigas.setBounds(252, 36, 118, 42);
		panel.add(btnVerLigas);
		
		JButton btnVerEquipos = new JButton("Ver equipos");
		btnVerEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ver_Equipos o=new Ver_Equipos(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnVerEquipos.setBounds(30, 163, 118, 42);
		panel.add(btnVerEquipos);
		
		JButton btnIniciarSesin = new JButton("Iniciar sesi\u00F3n");
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login o =new login();
				dispose();
				o.setVisible(true);
			}
		});
		btnIniciarSesin.setBounds(252, 163, 118, 42);
		panel.add(btnIniciarSesin);
	}
}
