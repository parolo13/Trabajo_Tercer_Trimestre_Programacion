package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import programacion.Crear;
import programacion.Editar_Jugador_BBDD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class siguiente_editar_jugador extends JFrame {

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
	public siguiente_editar_jugador(String usuario, String jugador) throws SQLException {
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
		lblNombre.setBounds(26, 16, 75, 14);
		panel.add(lblNombre);

		JLabel lblValoracion = new JLabel("Valoracion");
		lblValoracion.setBounds(209, 51, 62, 14);
		panel.add(lblValoracion);

		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(209, 84, 53, 14);
		panel.add(lblPais);

		JLabel lblLiga = new JLabel("Liga");
		lblLiga.setBounds(26, 51, 75, 14);
		panel.add(lblLiga);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(26, 84, 75, 14);
		panel.add(lblEdad);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(26, 119, 62, 14);
		panel.add(lblValor);

		JLabel lblPosicion = new JLabel("Posicion");
		lblPosicion.setBounds(20, 148, 81, 14);
		panel.add(lblPosicion);

		JLabel lblNewLabel = new JLabel("Calificacion");
		lblNewLabel.setBounds(209, 155, 81, 14);
		panel.add(lblNewLabel);

		JLabel lblDorsal = new JLabel("Dorsal");
		lblDorsal.setBounds(209, 16, 62, 14);
		panel.add(lblDorsal);

		
		/**
		 * Se rellena el combobox
		 */
		JComboBox Dorsal = new JComboBox();
		Dorsal.setBounds(275, 12, 94, 22);
		for (int i = 1; i < 100; i++) {
			Dorsal.addItem(i + "");
		}
		panel.add(Dorsal);

		JComboBox Liga = new JComboBox();
		Liga.setBounds(98, 47, 101, 22);
		String[] ligaBBDD = Crear.Liga();
		for (int i = 0; i < ligaBBDD.length; i++) {
			Liga.addItem(ligaBBDD[i]);
		}
		panel.add(Liga);

		JComboBox Valor = new JComboBox();
		Valor.setBounds(98, 115, 101, 22);
		for (int i = 1; i < 300; i++) {
			Valor.addItem(i + ",00 Millones");
		}
		panel.add(Valor);

		JComboBox Edad = new JComboBox();
		Edad.setBounds(98, 80, 101, 22);
		for (int i = 15; i < 51; i++) {
			Edad.addItem(i + " a�os");
		}
		panel.add(Edad);

		JComboBox Posicion = new JComboBox();
		Posicion.setBounds(98, 144, 101, 22);
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

		JComboBox Valoracion = new JComboBox();
		Valoracion.setBounds(275, 47, 94, 22);
		Valoracion.addItem("1");
		Valoracion.addItem("2");
		Valoracion.addItem("3");
		Valoracion.addItem("4");
		Valoracion.addItem("5");
		panel.add(Valoracion);

		JComboBox Pais = new JComboBox();
		Pais.setBounds(275, 80, 94, 22);
		String[] paisBBDD = Crear.Pais();
		for (int i = 0; i < paisBBDD.length; i++) {
			Pais.addItem(paisBBDD[i]);
		}
		panel.add(Pais);

		JComboBox Calificacion = new JComboBox();
		Calificacion.setBounds(300, 144, 94, 22);
		Calificacion.setBounds(309, 151, 53, 22);
		Calificacion.addItem("1");
		Calificacion.addItem("2");
		Calificacion.addItem("3");
		Calificacion.addItem("4");
		Calificacion.addItem("5");
		Calificacion.addItem("6");
		Calificacion.addItem("7");
		Calificacion.addItem("8");
		Calificacion.addItem("9");
		Calificacion.addItem("10");
		panel.add(Calificacion);

		Nombre = new JTextField();
		Nombre.setBounds(98, 13, 101, 20);
		panel.add(Nombre);
		Nombre.setColumns(10);
		RestrictedTextField restricted = new RestrictedTextField(Nombre,"abcdefghijklmn�opqrstuvwxyz -�����");

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Editar_Jugador o = new Editar_Jugador(usuario);
					dispose();
					o.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnVolver.setBounds(85, 206, 108, 23);
		panel.add(btnVolver);

		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String liga = (String) Liga.getSelectedItem();
				String posicion = (String) Posicion.getSelectedItem();
				String calificacion = (String) Calificacion.getSelectedItem();
				String valoracion = (String) Valoracion.getSelectedItem();
				String pais = (String) Pais.getSelectedItem();
				String edad = (String) Edad.getSelectedItem();
				String valor = (String) Valor.getSelectedItem();
				String dorsal = (String) Dorsal.getSelectedItem();
				
				/**
				 * El nombre no puede estar vac�o
				 */

				if (Nombre.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "El nombre del jugador no puede estar vac�o", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {

					siguiente_siguiente_editar_jugador o;
					try {
						Editar_Jugador_BBDD.Jugador(Nombre.getText(), valoracion, pais, liga, null, edad, valor,
								posicion, dorsal, calificacion, jugador);
						o = new siguiente_siguiente_editar_jugador(usuario, Nombre.getText(), liga);
						dispose();
						o.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnSiguiente.setBounds(209, 206, 108, 23);
		panel.add(btnSiguiente);
	}
}
