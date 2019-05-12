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
import java.awt.event.ActionEvent;

public class Ver_Jugadores extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnVolver;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Ver_Jugadores(String usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 594);
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
		scroll.setEnabled(false);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		getContentPane().add(scroll, BorderLayout.NORTH);

		try {
			ResultSet rs = Conexion.EjecutarSetencia(
					"Select Nombre_Completo,Valoracion_Media,Pais,Liga,Equipo,Edad,Valor,Posicion,Dorsal,Calificacion_Media FROM jugadores");
			while (rs.next()) {
				Object[] fila = new Object[10];
				for (int i = 0; i < 10; i++)
					fila[i] = rs.getObject(i + 1);
				modelo.addRow(fila);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
