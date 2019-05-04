package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import programacion.Crear;
import programacion.Crear_Equipo_BBDD;
import programacion.Crear_Jugador_BBDD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;

public class Crear_Equipo extends JFrame {

	private JPanel contentPane;
	private JTextField Nombre;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public Crear_Equipo(String usuario) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(21, 25, 46, 14);
		panel.add(lblNombre);

		JLabel lblTitulos = new JLabel("Titulos");
		lblTitulos.setBounds(21, 114, 46, 14);
		panel.add(lblTitulos);

		JLabel lblEconomia = new JLabel("Economia");
		lblEconomia.setBounds(200, 68, 46, 14);
		panel.add(lblEconomia);

		JLabel lblLiga = new JLabel("Liga");
		lblLiga.setBounds(21, 68, 46, 14);
		panel.add(lblLiga);

		JLabel lblJugadores = new JLabel("Jugadores");
		lblJugadores.setBounds(200, 25, 54, 14);
		panel.add(lblJugadores);

		Nombre = new JTextField();
		Nombre.setBounds(77, 22, 105, 20);
		panel.add(Nombre);
		Nombre.setColumns(10);
		RestrictedTextField restricted = new RestrictedTextField(Nombre,"abcdefghijklmnñopqrstuvwxyz  123456789-");

		JComboBox Liga = new JComboBox();
		Liga.setBounds(77, 64, 105, 22);
		String[] ligaBBDD = Crear.Liga();
		for (int i = 0; i < ligaBBDD.length; i++) {
			Liga.addItem(ligaBBDD[i]);
		}
		panel.add(Liga);

		JComboBox Titulos = new JComboBox();
		Titulos.setBounds(77, 110, 105, 22);
		for (int i = 0; i < 101; i++) {
			Titulos.addItem(i + "");
		}
		panel.add(Titulos);

		JComboBox Economia = new JComboBox();
		Economia.setBounds(256, 64, 105, 22);
		Economia.addItem("Quiebra");
		Economia.addItem("Mala");
		Economia.addItem("Aceptable");
		Economia.addItem("Buena");
		Economia.addItem("Muy buena");

		panel.add(Economia);

		JComboBox Jugadores = new JComboBox();
		Jugadores.setBounds(256, 21, 105, 22);
		for (int i = 15; i < 31; i++) {
			Jugadores.addItem(i + "");
		}
		panel.add(Jugadores);

		JButton btnCrearEquipo = new JButton("Crear equipo");
		btnCrearEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String liga = (String) Liga.getSelectedItem();
				String titulos = (String) Titulos.getSelectedItem();
				String economia = (String) Economia.getSelectedItem();
				String jugadores = (String) Jugadores.getSelectedItem();
				if (liga==null) {
					JOptionPane.showMessageDialog(null, "La liga esta vacía, si no hay ligas,crea una", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (Nombre.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "El nombre del equipo no puede estar vacío", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					} else {
						try {
							Crear_Equipo_BBDD.equipo(Nombre.getText(), liga, titulos, economia, jugadores);
							Crear_Todo o = new Crear_Todo(usuario);
							dispose();
							o.setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnCrearEquipo.setBounds(234, 217, 105, 23);
		panel.add(btnCrearEquipo);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Crear_Todo o = new Crear_Todo(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnVolver.setBounds(99, 217, 105, 23);
		panel.add(btnVolver);

	}
}
