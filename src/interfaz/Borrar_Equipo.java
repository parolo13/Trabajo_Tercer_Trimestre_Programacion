package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import programacion.Borrar_Jugador_BBDD;
import programacion.Crear;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Borrar_Equipo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public Borrar_Equipo(String usuario) throws SQLException {
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
		lblEquipo.setBounds(79, 98, 46, 14);
		panel.add(lblEquipo);

		JComboBox Equipo = new JComboBox();
		Equipo.setBounds(135, 94, 126, 22);
		String[] EquipoBBDD = Crear.Equipo();
		for (int i = 0; i < EquipoBBDD.length; i++) {
			Equipo.addItem(EquipoBBDD[i]);
		}
		panel.add(Equipo);

		JButton button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Borrar_Todo o = new Borrar_Todo(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		button.setBounds(81, 185, 89, 23);
		panel.add(button);

		JButton btnBorrarEquipo = new JButton("Borrar equipo");
		btnBorrarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String equipo = (String) Equipo.getSelectedItem();
				if (equipo == null) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun equipo", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int eleccion = JOptionPane.showConfirmDialog(null,
							"¿Seguro que quieres borrar el equipo " + equipo
									+ "? , cuidado que se borrararan los jugadores dentro de esa equipo",
							"Cuidado", JOptionPane.YES_NO_OPTION);
					if (eleccion == JOptionPane.YES_OPTION) {
						Borrar_Jugador_BBDD.equipo(equipo);
						Borrar_Todo o = new Borrar_Todo(usuario);
						dispose();
						o.setVisible(true);
					}
				}
			}
		});
		btnBorrarEquipo.setBounds(193, 185, 126, 23);
		panel.add(btnBorrarEquipo);
	}

}
