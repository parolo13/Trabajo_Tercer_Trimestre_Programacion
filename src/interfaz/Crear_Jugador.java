package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;
import programacion.Crear;
import programacion.Crear_Jugador_BBDD;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

import Atxy2k.CustomTextField.RestrictedTextField;

public class Crear_Jugador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public Crear_Jugador(String usuario) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JTextField Nombre = new JTextField();
		Nombre.setBounds(66, 25, 115, 20);
		panel.add(Nombre);
		RestrictedTextField restricted = new RestrictedTextField(Nombre,"abcdefghijklmnñopqrstuvwxyz -áéíóú");
		

		JComboBox Liga = new JComboBox();
		Liga.setBounds(274, 56, 140, 22);
		String[] ligaBBDD = Crear.Liga();
		for (int i = 0; i < ligaBBDD.length; i++) {
			Liga.addItem(ligaBBDD[i]);
		}
		panel.add(Liga);

		JComboBox Posicion = new JComboBox();
		Posicion.setBounds(274, 85, 140, 22);
		Posicion.addItem("Portero");
		Posicion.addItem("Lateral derecho");
		Posicion.addItem("Lateral izquierdo");
		Posicion.addItem("Defensa central");
		Posicion.addItem("Mediocentro Defensivo");
		Posicion.addItem("Mediocentro");
		Posicion.addItem("Mediocentro ofensivo");
		Posicion.addItem("Interior izquierdo");
		Posicion.addItem("Interior derecho");
		Posicion.addItem("Mediapunta");
		Posicion.addItem("Delantero centro");
		Posicion.addItem("Extremo izquierdo");
		Posicion.addItem("Extremo derecho");
		panel.add(Posicion);

		JComboBox CalificacionMedia = new JComboBox();
		CalificacionMedia.setBounds(361, 151, 53, 22);
		CalificacionMedia.addItem("1");
		CalificacionMedia.addItem("2");
		CalificacionMedia.addItem("3");
		CalificacionMedia.addItem("4");
		CalificacionMedia.addItem("5");
		CalificacionMedia.addItem("6");
		CalificacionMedia.addItem("7");
		CalificacionMedia.addItem("8");
		CalificacionMedia.addItem("9");
		CalificacionMedia.addItem("10");
		panel.add(CalificacionMedia);

		JComboBox ValoracionMedia = new JComboBox();
		ValoracionMedia.setBounds(128, 120, 53, 22);
		ValoracionMedia.addItem("1");
		ValoracionMedia.addItem("2");
		ValoracionMedia.addItem("3");
		ValoracionMedia.addItem("4");
		ValoracionMedia.addItem("5");
		panel.add(ValoracionMedia);

		JComboBox Pais = new JComboBox();
		Pais.setBounds(51, 58, 140, 22);
		String[] paisBBDD = Crear.Pais();
		for (int i = 0; i < paisBBDD.length; i++) {
			Pais.addItem(paisBBDD[i]);
		}
		panel.add(Pais);

		JComboBox Edad = new JComboBox();
		Edad.setBounds(274, 25, 140, 22);
		for (int i = 15; i < 51; i++) {
			Edad.addItem(i + " años");
		}
		panel.add(Edad);

		JComboBox Dorsal = new JComboBox();
		Dorsal.setBounds(274, 118, 140, 22);
		for (int i = 1; i < 100; i++) {
			Dorsal.addItem(i);
		}
		panel.add(Dorsal);

		JComboBox Valor = new JComboBox();
		Valor.setBounds(51, 91, 140, 22);
		for (int i = 1; i < 300; i++) {
			Valor.addItem(i + ",00 Millones");
		}
		panel.add(Valor);

		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String liga = (String) Liga.getSelectedItem();
				String posicion = (String) Posicion.getSelectedItem();
				String calificacionMedia = (String) CalificacionMedia.getSelectedItem();
				String valoracionMedia = (String) ValoracionMedia.getSelectedItem();
				String pais = (String) Pais.getSelectedItem();
				String edad = (String) Edad.getSelectedItem();
				String valor = (String) Valor.getSelectedItem();
				int dorsal = (int) Dorsal.getSelectedItem();

				siguiente_Crear_Jugador o;
				if (liga==null) {
					JOptionPane.showMessageDialog(null, "La liga esta vacía, si no hay ligas,crea una", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (Nombre.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "El nombre del jugador no puede estar vacío", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					} else {
						try {
							Crear_Jugador_BBDD.Jugador(Nombre.getText(), valoracionMedia, pais, liga, null, edad, valor,
									posicion, Integer.toString(dorsal), calificacionMedia);
							o = new siguiente_Crear_Jugador(liga, usuario, Nombre.getText());
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
		btnSiguiente.setBounds(227, 217, 89, 23);
		panel.add(btnSiguiente);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Crear_Todo o = new Crear_Todo(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnVolver.setBounds(116, 217, 89, 23);
		panel.add(btnVolver);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 31, 46, 14);
		panel.add(lblNombre);

		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(10, 62, 46, 14);
		panel.add(lblPais);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(10, 93, 46, 14);
		panel.add(lblValor);

		JLabel lblValoracion = new JLabel("Valoracion");
		lblValoracion.setBounds(10, 124, 62, 14);
		panel.add(lblValoracion);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(208, 25, 46, 14);
		panel.add(lblEdad);

		JLabel lblLiga = new JLabel("Liga");
		lblLiga.setBounds(208, 56, 46, 14);
		panel.add(lblLiga);

		JLabel lblPosicion = new JLabel("Posicion");
		lblPosicion.setBounds(208, 87, 56, 14);
		panel.add(lblPosicion);

		JLabel lblDorsal = new JLabel("Dorsal");
		lblDorsal.setBounds(208, 118, 56, 14);
		panel.add(lblDorsal);

		JLabel lblCalificacionMedia = new JLabel("Calificacion Media");
		lblCalificacionMedia.setBounds(208, 155, 143, 14);
		panel.add(lblCalificacionMedia);

	}
}
