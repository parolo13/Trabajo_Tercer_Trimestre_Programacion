package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import programacion.Crear;
import programacion.Crear_Jugador_BBDD;

import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Atxy2k.CustomTextField.RestrictedTextField;

public class siguiente_Crear_Jugador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @param liga
	 * @param usuario
	 * @param nombre
	 * @throws SQLException
	 */
	public siguiente_Crear_Jugador(String liga, String usuario, String nombre) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(29, 21, 59, 14);
		panel.add(lblEquipo);

		JComboBox Equipo = new JComboBox();
		Equipo.setBounds(111, 17, 122, 22);
		String[] EquipoBBDD = Crear.Equipo(liga);
		for (int i = 0; i < EquipoBBDD.length; i++) {
			Equipo.addItem(EquipoBBDD[i]);
		}
		panel.add(Equipo);

		JLabel IblTecnica = new JLabel("Tecnica");
		IblTecnica.setBounds(29, 59, 59, 14);
		panel.add(IblTecnica);

		JLabel lblFisica = new JLabel("Fisica");
		lblFisica.setBounds(29, 126, 59, 14);
		panel.add(lblFisica);

		JLabel IblMental = new JLabel("Mental");
		IblMental.setBounds(29, 92, 59, 14);
		panel.add(IblMental);

		JComboBox Tecnica = new JComboBox();
		Tecnica.setBounds(111, 55, 122, 22);
		for (int i = 0; i < 21; i++) {
			Tecnica.addItem(i);
		}
		panel.add(Tecnica);

		JComboBox Mental = new JComboBox();
		Mental.setBounds(111, 88, 122, 22);
		for (int i = 0; i < 21; i++) {
			Mental.addItem(i);
		}
		panel.add(Mental);

		JComboBox Fisico = new JComboBox();
		Fisico.setBounds(111, 122, 122, 22);
		for (int i = 0; i < 21; i++) {
			Fisico.addItem(i);
		}
		panel.add(Fisico);

		JButton btnCrearJugador = new JButton("Crear jugador");
		btnCrearJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tecnica = (int) Tecnica.getSelectedItem();
				int mental = (int) Mental.getSelectedItem();
				int fisico = (int) Fisico.getSelectedItem();
				String equipo = (String) Equipo.getSelectedItem();
				if (equipo==null) {
					JOptionPane.showMessageDialog(null, "El equipo esta vacío, si no hay equipos,crea uno", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						Crear_Jugador_BBDD.jugador2(equipo, nombre, tecnica, mental, fisico);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					Crear_Todo o = new Crear_Todo(usuario);
					dispose();
					o.setVisible(true);
				}
			}
		});
		btnCrearJugador.setBounds(153, 203, 122, 23);
		panel.add(btnCrearJugador);

	}
}
