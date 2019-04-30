package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Borrar_Todo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Borrar_Todo(String usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Borrar Jugadores");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Borrar_Jugador o=new Borrar_Jugador(usuario);
					dispose();
					o.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(85, 27, 241, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Borrar Equipos");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Borrar_Equipo o=new Borrar_Equipo(usuario);
					dispose();
					o.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button_1.setBounds(85, 94, 241, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Borrar Ligas");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Borrar_Liga o;
				try {
					o = new Borrar_Liga(usuario);
					dispose();
					o.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_2.setBounds(85, 158, 241, 23);
		contentPane.add(button_2);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eleccion o=new Eleccion(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnVolver.setBounds(125, 213, 151, 23);
		contentPane.add(btnVolver);
	}
}
