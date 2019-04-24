package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class siguiente_Crear_Jugador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public siguiente_Crear_Jugador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextPane Temporadaxxxx = new JTextPane();
		Temporadaxxxx.setText("Temporada(20XX-20XX)");
		Temporadaxxxx.setBounds(34, 28, 121, 20);
		panel.add(Temporadaxxxx);
		
		JTextPane Goles = new JTextPane();
		Goles.setText("Goles");
		Goles.setBounds(239, 28, 121, 20);
		panel.add(Goles);
		
		JTextPane Partidos = new JTextPane();
		Partidos.setText("Partidos");
		Partidos.setBounds(239, 81, 121, 20);
		panel.add(Partidos);
		
		JTextPane Asistencias = new JTextPane();
		Asistencias.setText("Asistencias");
		Asistencias.setBounds(34, 81, 121, 20);
		panel.add(Asistencias);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("hola");
		comboBox.setBounds(34, 141, 121, 22);
		panel.add(comboBox);
	}
}
