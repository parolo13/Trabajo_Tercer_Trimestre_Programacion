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

public class Borrar_Liga extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public Borrar_Liga(String usuario) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblLiga = new JLabel("Liga");
		lblLiga.setBounds(122, 105, 46, 14);
		panel.add(lblLiga);

		/**
		 * Rellenamos el JComboBox con el array correspondiente
		 */
		JComboBox Liga = new JComboBox();
		Liga.setBounds(178, 101, 129, 22);
		String[] ligaBBDD = Crear.Liga();
		for (int i = 0; i < ligaBBDD.length; i++) {
			Liga.addItem(ligaBBDD[i]);
		}
		panel.add(Liga);

		JButton btnBorrarLiga = new JButton("Borrar liga");
		btnBorrarLiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String liga = (String) Liga.getSelectedItem();
				
				/**
				 * No puede estar vacío
				 */
				if (liga == null) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna liga", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {

					int eleccion = JOptionPane.showConfirmDialog(null,
							"¿Seguro que quieres borrar la liga " + liga
									+ "? , cuidado que se borrararan los jugadores y equipos dentro de esa liga",
							"Cuidado", JOptionPane.YES_NO_OPTION);
					
					/**
					 * Se borra la liga
					 */
					if (eleccion == JOptionPane.YES_OPTION) {
						Borrar_Jugador_BBDD.liga(liga);
						Borrar_Todo o = new Borrar_Todo(usuario);
						dispose();
						o.setVisible(true);
					}
				}
			}
		});
		btnBorrarLiga.setBounds(231, 192, 103, 23);
		panel.add(btnBorrarLiga);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Borrar_Todo o = new Borrar_Todo(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnVolver.setBounds(99, 192, 89, 23);
		panel.add(btnVolver);
	}

}
