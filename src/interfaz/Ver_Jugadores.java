package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BBDD.Conexion;

import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JComboBox;

public class Ver_Jugadores extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnVolver;
	private JButton btnFiltrar;
	private String sentencia;
	private JButton btnImprimirTablaEn;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Ver_Jugadores(String usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		sentencia = "Select Nombre_Completo,Valoracion_Media,Pais,Liga,Equipo,Edad,Valor,Posicion,Dorsal,Calificacion_Media FROM jugadores";
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		table = new JTable();
		table.setEnabled(false);
		table.setBounds(10, 11, 404, 229);
		panel.add(table);

		JComboBox FILTRAR = new JComboBox();
		FILTRAR.setBounds(109, 0, 163, 22);
		FILTRAR.addItem("Nombre_Completo");
		FILTRAR.addItem("Valoracion_Media");
		FILTRAR.addItem("Pais");
		FILTRAR.addItem("Liga");
		FILTRAR.addItem("Equipo");
		FILTRAR.addItem("Edad");
		FILTRAR.addItem("Valor");
		FILTRAR.addItem("Posicion");
		FILTRAR.addItem("Dorsal");
		FILTRAR.addItem("Calificacion_Media");
		panel.add(FILTRAR);

		Object[][] datos = new Object[0][0];
		String[] titulo = { "Nombre", "Valoracion", "Pais", "Liga", "Equipo", "Edad", "Valor", "Posicion", "Dorsal",
				"Calificacion" };
		DefaultTableModel modelo = new DefaultTableModel(datos, titulo);
		table.setModel(modelo);
		JScrollPane scroll = new JScrollPane(table);

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuario == null) {
					sesion_no_iniciada o = new sesion_no_iniciada(usuario);
					dispose();
					o.setVisible(true);
				} else {
					Ver_Todo o = new Ver_Todo(usuario);
					dispose();
					o.setVisible(true);
				}
			}
		});
		btnVolver.setBounds(0, 0, 89, 23);
		panel.add(btnVolver);

		JTextPane Nombre = new JTextPane();
		Nombre.setBounds(282, 2, 177, 20);
		panel.add(Nombre);

		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filtro = (String) FILTRAR.getSelectedItem();
				sentencia = "Select Nombre_Completo,Valoracion_Media,Pais,Liga,Equipo,Edad,Valor,Posicion,Dorsal,Calificacion_Media FROM jugadores where "
						+ filtro + " ='" + Nombre.getText() + "'";
				if (Nombre.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "No puedes filtrar un nombre vacío", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {

					int filas = modelo.getRowCount();
					for (int i = 0; i < filas; i++) {
						modelo.removeRow(0);
					}
					try {
						ResultSet rs = Conexion.EjecutarSetencia(sentencia);
						while (rs.next()) {
							Object[] fila = new Object[10];
							for (int i = 0; i < 10; i++)
								fila[i] = rs.getObject(i + 1);
							modelo.addRow(fila);
						}
						rs.beforeFirst();
					} catch (Exception e1) {
						System.out.println(e1);
					}
				}
			}
		});
		btnFiltrar.setBounds(469, 0, 89, 23);
		panel.add(btnFiltrar);

		JButton btnRestaurarTabla = new JButton("Restaurar Tabla");
		btnRestaurarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int filas = modelo.getRowCount();
				for (int i = 0; i < filas; i++) {
					modelo.removeRow(0);
				}
				try {
					ResultSet rs = Conexion.EjecutarSetencia(
							"Select Nombre_Completo,Valoracion_Media,Pais,Liga,Equipo,Edad,Valor,Posicion,Dorsal,Calificacion_Media FROM jugadores");
					while (rs.next()) {
						Object[] fila = new Object[10];
						for (int i = 0; i < 10; i++)
							fila[i] = rs.getObject(i + 1);
						modelo.addRow(fila);
					}
					rs.beforeFirst();
				} catch (Exception e11) {
					System.out.println(e);
				}
			}
		});
		btnRestaurarTabla.setBounds(109, 49, 144, 23);
		panel.add(btnRestaurarTabla);

		scroll.setEnabled(false);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		getContentPane().add(scroll, BorderLayout.NORTH);

		try {
			ResultSet rs = Conexion.EjecutarSetencia(sentencia);
			while (rs.next()) {
				Object[] fila = new Object[10];
				for (int i = 0; i < 10; i++)
					fila[i] = rs.getObject(i + 1);
				modelo.addRow(fila);
			}
			rs.beforeFirst();
		} catch (Exception e) {
			System.out.println(e);
		}

		btnImprimirTablaEn = new JButton("Imprimir tabla en csv");
		btnImprimirTablaEn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = Conexion.EjecutarSetencia("Select * FROM jugadores");
				try {
					String ext = ".csv";
					String ruta = "src/Fichero/jugadores" + ext;
					FileWriter writer = new FileWriter(ruta);
					writer.write(
							"ID_Jugador;Nombre_Completo;Valoracion_Media;ID_Pais;Pais;ID_Liga;Liga;ID_Equipo;Equipo;Edad;Valor;Posicion;Dorsal;Calificacion_Media\n");

					while (rs.next()) {
						writer.write(rs.getString("ID_Jugador") + ";" + rs.getString("Nombre_Completo") + ";"
								+ rs.getString("Valoracion_Media") + ";" + rs.getString("ID_Pais") + ";"
								+ rs.getString("Pais") + ";" + rs.getString("ID_Liga") + ";" + rs.getString("Liga")
								+ ";" + rs.getString("ID_Equipo") + ";" + rs.getString("Equipo") + ";"
								+ rs.getString("Edad") + ";" + rs.getString("Valor") + ";" + rs.getString("Posicion")
								+ ";" + rs.getString("Dorsal") + ";" + rs.getString("Calificacion_Media") + "\n");

					}
					writer.close();
					JOptionPane.showMessageDialog(null, "Archivo creado", "Correcto", JOptionPane.DEFAULT_OPTION);
				} catch (Exception e1) {
					System.out.println(e1);
					JOptionPane.showMessageDialog(null, "No se ha creado correctamente", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnImprimirTablaEn.setBounds(392, 48, 177, 23);
		panel.add(btnImprimirTablaEn);
	}
}
