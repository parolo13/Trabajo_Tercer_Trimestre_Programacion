package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import interfaz.Crear_Jugador;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Crear_Todo extends JFrame {

	private JPanel contentPane;

	/**
	 * Es el Jpanel que manda al resto de Jpanels
	 */


	/**
	 * Create the frame.
	 */
	public Crear_Todo(String usuario) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Crear Jugadores\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Crear_Jugador o;
				try {
					o = new Crear_Jugador(usuario);
					dispose();
					o.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(69, 24, 269, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Crear Liga");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Crear_Liga o=new Crear_Liga(usuario);
					dispose();
					o.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBounds(69, 158, 269, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Crear Equipos");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Crear_Equipo o=new Crear_Equipo(usuario);
					dispose();
					o.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_4.setBounds(69, 93, 269, 23);
		panel.add(btnNewButton_4);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eleccion o = new Eleccion(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnVolver.setBounds(112, 217, 197, 23);
		panel.add(btnVolver);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Crear_Todo.class.getResource("/interfaz/450_1000.jpg")));
		label.setBounds(0, 0, 424, 251);
		panel.add(label);
	}
}
