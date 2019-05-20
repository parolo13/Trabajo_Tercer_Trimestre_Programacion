package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import programacion.Crear;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class editar_equipo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public editar_equipo(String usuario) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblEdiarEquipo = new JLabel("Equipo a editar");
		lblEdiarEquipo.setBounds(33, 98, 96, 14);
		panel.add(lblEdiarEquipo);
		/**
		 * Se rellena el combobox para la eleccion de equipo que queremos editar
		 */
		JComboBox Equipo = new JComboBox();
		Equipo.setBounds(135, 94, 132, 22);
		String[] EquipoBBDD = Crear.Equipo();
		for (int i = 0; i < EquipoBBDD.length; i++) {
			Equipo.addItem(EquipoBBDD[i]);
		}
		panel.add(Equipo);

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

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String equipo = (String) Equipo.getSelectedItem();
				/**
				 * Si está vacio no te deja entrar
				 */
				if (equipo == null) {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun equipo", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						siguiente_editar_equipo o = new siguiente_editar_equipo(usuario, equipo);
						dispose();
						o.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnEditar.setBounds(222, 203, 89, 23);
		panel.add(btnEditar);
	}

}
