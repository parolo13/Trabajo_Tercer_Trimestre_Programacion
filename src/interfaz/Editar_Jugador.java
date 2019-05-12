package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import programacion.Crear;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Editar_Jugador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public Editar_Jugador(String usuario) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Jugador a editar");
		lblNewLabel.setBounds(44, 82, 112, 14);
		panel.add(lblNewLabel);

		JComboBox Jugador = new JComboBox();
		Jugador.setBounds(166, 78, 120, 22);
		String[] jugadorBBDD = Crear.jugador();
		for (int i = 0; i < jugadorBBDD.length; i++) {
			Jugador.addItem(jugadorBBDD[i]);
		}
		panel.add(Jugador);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jugador = (String) Jugador.getSelectedItem();
				if (jugador == null) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun jugador", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {

					siguiente_editar_jugador o;
					try {

						o = new siguiente_editar_jugador(usuario, jugador);
						dispose();
						o.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnEditar.setBounds(231, 202, 89, 23);
		panel.add(btnEditar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editar_Todo o = new Editar_Todo(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnVolver.setBounds(102, 202, 89, 23);
		panel.add(btnVolver);
	}
}
