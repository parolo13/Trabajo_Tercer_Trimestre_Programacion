package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BBDD.Conexion;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

public class Ver_Ligas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnVolver;
	private JComboBox filtrar;
	private JTextPane nombre;
	private JButton button;
	private JButton button_1;
	private String sentencia;
	private JButton btnImprimirTablaEn;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Ver_Ligas(String usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 584);
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

		Object[][] datos = new Object[0][0];
		String[] titulo = { "Nombre", "Pais", "Division" };
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

		filtrar = new JComboBox();
		filtrar.setBounds(140, 0, 163, 22);
		filtrar.addItem("nombre");
		filtrar.addItem("Pais");
		filtrar.addItem("Division");
		panel.add(filtrar);

		nombre = new JTextPane();
		nombre.setBounds(313, 2, 177, 20);
		panel.add(nombre);

		button = new JButton("Filtrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filtro = (String) filtrar.getSelectedItem();
				sentencia = "Select nombre,Pais,Division FROM liga WHERE " + filtro + " ='" + nombre.getText() + "'";
				
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
							Object[] fila = new Object[3];
							for (int i = 0; i < 3; i++)
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
		button.setBounds(500, 0, 89, 23);
		panel.add(button);

		button_1 = new JButton("Restaurar Tabla");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filas = modelo.getRowCount();
				for (int i = 0; i < filas; i++) {
					modelo.removeRow(0);
				}
				try {
					ResultSet rs = Conexion.EjecutarSetencia("Select nombre,Pais,Division FROM liga");
					while (rs.next()) {
						Object[] fila = new Object[3];
						for (int i = 0; i < 3; i++)
							fila[i] = rs.getObject(i + 1);
						modelo.addRow(fila);
					}
					rs.beforeFirst();
				} catch (Exception e11) {
					System.out.println(e11);
				}
			}
		});
		button_1.setBounds(140, 46, 144, 23);
		panel.add(button_1);

		btnImprimirTablaEn = new JButton("Imprimir tabla en csv");
		btnImprimirTablaEn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = Conexion.EjecutarSetencia("Select * FROM liga");
				try {
					String ext = ".csv";
					String ruta = "src/Fichero/Ligas" + ext;
					FileWriter writer = new FileWriter(ruta);
					writer.write("ID_Liga;Nombre;Pais;Division\n");

					while (rs.next()) {
						writer.write(rs.getString("ID_Liga") + ";" + rs.getString("nombre") + ";" + rs.getString("Pais")
								+ ";" + rs.getString("Division") + "\n");

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
		btnImprimirTablaEn.setBounds(313, 46, 177, 23);
		panel.add(btnImprimirTablaEn);
		
		
		scroll.setEnabled(false);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		getContentPane().add(scroll, BorderLayout.NORTH);

		try {
			ResultSet rs = Conexion.EjecutarSetencia("Select nombre,Pais,Division FROM liga");
			while (rs.next()) {
				Object[] fila = new Object[3];
				for (int i = 0; i < 3; i++)
					fila[i] = rs.getObject(i + 1);
				modelo.addRow(fila);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
