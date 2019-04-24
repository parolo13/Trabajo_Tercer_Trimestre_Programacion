package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import programacion.Crear_Jugador_BBDD;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Crear_Jugador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Crear_Jugador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JTextPane Nombre = new JTextPane();
		Nombre.setText("Nombre");
		Nombre.setBounds(10, 25, 115, 20);
		panel.add(Nombre);

		JTextPane Edad = new JTextPane();
		Edad.setText("Edad");
		Edad.setBounds(299, 25, 115, 20);
		panel.add(Edad);

		JTextPane Pais = new JTextPane();
		Pais.setText("Pais");
		Pais.setBounds(10, 56, 115, 20);
		panel.add(Pais);

		JTextPane Liga = new JTextPane();
		Liga.setText("Liga");
		Liga.setBounds(299, 56, 115, 20);
		panel.add(Liga);

		JTextPane Dorsal = new JTextPane();
		Dorsal.setText("Dorsal");
		Dorsal.setBounds(299, 118, 115, 20);
		panel.add(Dorsal);

		JTextPane Posicion = new JTextPane();
		Posicion.setText("Posicion");
		Posicion.setBounds(299, 87, 115, 20);
		panel.add(Posicion);

		JTextPane Equipo = new JTextPane();
		Equipo.setText("Equipo");
		Equipo.setBounds(10, 87, 115, 20);
		panel.add(Equipo);

		JTextPane Valor = new JTextPane();
		Valor.setText("Valor(En Millones)");
		Valor.setBounds(10, 118, 115, 20);
		panel.add(Valor);

		JTextPane ValoracionMedia = new JTextPane();
		ValoracionMedia.setText("Valoracion Media(0-5)");
		ValoracionMedia.setBounds(10, 149, 115, 20);
		panel.add(ValoracionMedia);

		JTextPane CalificacionMedia = new JTextPane();
		CalificacionMedia.setText("Calificacion Media");
		CalificacionMedia.setBounds(299, 149, 115, 20);
		panel.add(CalificacionMedia);

		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siguiente_Crear_Jugador o = new siguiente_Crear_Jugador();
				dispose();
				o.setVisible(true);
				Crear_Jugador_BBDD.Jugador(Nombre.getText(), ValoracionMedia.getText(), Pais.getText(), Liga.getText(),
						Equipo.getText(), Edad.getText(), Valor.getText(), Posicion.getText(), Dorsal.getText(),
						CalificacionMedia.getText());

			}
		});
		btnSiguiente.setBounds(227, 217, 89, 23);
		panel.add(btnSiguiente);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login o = new login();
				dispose();
				o.setVisible(true);
			}
		});
		btnVolver.setBounds(116, 217, 89, 23);
		panel.add(btnVolver);
	}
}
