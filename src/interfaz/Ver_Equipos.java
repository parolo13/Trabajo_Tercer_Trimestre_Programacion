package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BBDD.Conexion;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

public class Ver_Equipos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnVolver;
	private String sentencia;
	private JButton btnImprimirTablaEn;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Ver_Equipos(String usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		table = new JTable();
		table.setEnabled(false);
		table.setBounds(10, 11, 404, 229);
		panel.add(table);
		/**
		 * Creamos la tabla 
		 */
		Object[][] datos = new Object[0][0];
		String[] titulo = { "Nombre", "Liga", "Titulos", "Numero de jugadores", "Economia" };
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
		/**
		 * Se rellena el combobox
		 */
		JComboBox Filtrar = new JComboBox();
		Filtrar.setBounds(120, 0, 163, 22);
		Filtrar.addItem("nombre");
		Filtrar.addItem("Liga");
		Filtrar.addItem("Titulos");
		Filtrar.addItem("Num_Jugadores");
		Filtrar.addItem("Economia");
		panel.add(Filtrar);

		JTextPane nombre = new JTextPane();
		nombre.setBounds(293, 2, 177, 20);
		panel.add(nombre);
		/**
		 * Esta es la setencia para filtrar
		 */
		JButton button = new JButton("Filtrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filtro = (String) Filtrar.getSelectedItem();
				sentencia = "Select nombre,Liga,Titulos,Num_Jugadores ,Economia FROM equipos where " + filtro + " ='"
						+ nombre.getText() + "'";
				if (nombre.getText().equals("")) {
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
							Object[] fila = new Object[5];
							for (int i = 0; i < 5; i++)
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
		button.setBounds(480, 0, 89, 23);
		panel.add(button);

		JButton button_1 = new JButton("Restaurar Tabla");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int filas = modelo.getRowCount();
				for (int i = 0; i < filas; i++) {
					modelo.removeRow(0);
				}					
				try {
					ResultSet rs = Conexion.EjecutarSetencia("Select nombre,Liga,Titulos,Num_Jugadores ,Economia FROM equipos");
					while (rs.next()) {
						Object[] fila = new Object[5];
						for (int i = 0; i < 5; i++)
							fila[i] = rs.getObject(i + 1);
						modelo.addRow(fila);
					}
					rs.beforeFirst();
				} catch (Exception e11) {
					System.out.println(e11);
				}
			}
		});
		button_1.setBounds(222, 48, 144, 23);
		panel.add(button_1);
		scroll.setEnabled(false);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		getContentPane().add(scroll, BorderLayout.NORTH);
		/**
		 * Rellenamos la tabla
		 */
		try {
			ResultSet rs = Conexion.EjecutarSetencia("Select nombre,Liga,Titulos,Num_Jugadores ,Economia FROM equipos");
			while (rs.next()) {
				Object[] fila = new Object[5];
				for (int i = 0; i < 5; i++)
					fila[i] = rs.getObject(i + 1);
				modelo.addRow(fila);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		/**
		 * Imprimimos la tabla en formato .csv
		 */
		btnImprimirTablaEn = new JButton("Imprimir tabla en csv");
		btnImprimirTablaEn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ResultSet rs = Conexion.EjecutarSetencia("Select * FROM equipos");
			try {
				String ext = ".csv";
				String ruta = "src/Fichero/Equipos" + ext;
				FileWriter writer = new FileWriter(ruta);
				writer.write("ID_Equipo;Nombre;Liga;Tiulos;Num_Jugadores;Economia\n");

				while (rs.next()) {
					writer.write(rs.getString("ID_Equipo") + ";" + rs.getString("nombre") + ";" + rs.getString("Liga")
							+ ";" + rs.getString("Titulos") + ";" + rs.getString("Num_Jugadores") + ";" + rs.getString("Economia") +"\n");

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
