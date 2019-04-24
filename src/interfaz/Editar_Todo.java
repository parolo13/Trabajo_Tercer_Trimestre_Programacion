package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Editar_Todo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Editar_Todo(String usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnEditarJugador = new JButton("Editar Jugador");
		btnEditarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditarJugador.setBounds(10, 11, 404, 23);
		panel.add(btnEditarJugador);
		
		JButton btnEditarLiga = new JButton("Editar Equipo");
		btnEditarLiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditarLiga.setBounds(10, 63, 404, 23);
		panel.add(btnEditarLiga);
		
		JButton button = new JButton("Editar Liga");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(10, 116, 404, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Volver");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eleccion o=new Eleccion(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		button_1.setBounds(10, 174, 404, 23);
		panel.add(button_1);
	}

}
