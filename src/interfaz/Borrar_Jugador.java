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
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Borrar_Jugador extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public Borrar_Jugador(String usuario) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblJugador = new JLabel("Jugador");
		lblJugador.setBounds(73, 106, 68, 14);
		panel.add(lblJugador);

		/**
		 * Rellenamos el JComboBox con el array correspondiente
		 */

		JComboBox Jugador = new JComboBox();
		Jugador.setBounds(142, 102, 123, 22);
		String[] jugadorBBDD = Crear.jugador();
		for (int i = 0; i < jugadorBBDD.length; i++) {
			Jugador.addItem(jugadorBBDD[i]);
		}
		panel.add(Jugador);

		JButton btnBorrarJugador = new JButton("Borrar jugador");
		btnBorrarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jugador = (String) Jugador.getSelectedItem();

				/**
				 * No puede estar vacío
				 */
				if (jugador == null) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun jugador", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {

					int eleccion = JOptionPane.showConfirmDialog(null,
							"¿Seguro que quieres borrar al jugador " + jugador + "?", "Cuidado",
							JOptionPane.YES_NO_OPTION);
					
					/**
					 * Se borra el jugador
					 */
					if (eleccion == JOptionPane.YES_OPTION) {
						Borrar_Jugador_BBDD.jugador(jugador);
						Borrar_Todo o = new Borrar_Todo(usuario);
						dispose();
						o.setVisible(true);
					}
				}

			}
		});
		btnBorrarJugador.setBounds(203, 193, 123, 23);
		panel.add(btnBorrarJugador);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Borrar_Todo o = new Borrar_Todo(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnVolver.setBounds(88, 193, 89, 23);
		panel.add(btnVolver);

	}
}
