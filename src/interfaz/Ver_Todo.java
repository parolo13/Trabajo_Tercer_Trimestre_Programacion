package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ver_Todo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Ver_Todo(String usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Ver Jugadores");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ver_Jugadores o=new Ver_Jugadores(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnNewButton.setBounds(127, 35, 157, 23);
		panel.add(btnNewButton);
		
		JButton button = new JButton("Ver Equipos");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ver_Equipos o=new Ver_Equipos(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		button.setBounds(127, 88, 157, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Ver Ligas");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ver_Ligas o=new Ver_Ligas(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		button_1.setBounds(127, 145, 157, 23);
		panel.add(button_1);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eleccion o=new Eleccion(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnVolver.setBounds(127, 196, 157, 23);
		panel.add(btnVolver);
	}

}
