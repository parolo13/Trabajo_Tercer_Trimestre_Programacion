package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import programacion.Crear;
import programacion.Crear_Liga_BBDD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Atxy2k.CustomTextField.RestrictedTextField;

public class Crear_Liga extends JFrame {

	private JPanel contentPane;
	private JTextField Nombre;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Crear_Liga(String usuario) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(47, 25, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(47, 62, 46, 14);
		panel.add(lblPais);
		
		JLabel lblNewLabel_1 = new JLabel("Division");
		lblNewLabel_1.setBounds(47, 109, 46, 14);
		panel.add(lblNewLabel_1);
		
		Nombre = new JTextField();
		Nombre.setBounds(103, 22, 86, 20);
		panel.add(Nombre);
		Nombre.setColumns(10);
		RestrictedTextField restricted = new RestrictedTextField(Nombre,"abcdefghijklmnñopqrstuvwxyz  123456789áéíóú");
		
		
		/**
		 * Se rellenan los comboboxs
		 */
		JComboBox Pais = new JComboBox();
		Pais.setBounds(103, 58, 86, 22);
		String[] paisBBDD=Crear.Pais();
		for (int i = 0; i < paisBBDD.length; i++) {
		Pais.addItem(paisBBDD[i]);
		}
		panel.add(Pais);
		
		JComboBox Division = new JComboBox();
		Division.setBounds(103, 105, 86, 22);
		Division.addItem("1");
		Division.addItem("2");
		Division.addItem("3");
		Division.addItem("4");
		panel.add(Division);
		
		JButton btnNewButton = new JButton("Crear liga");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pais = (String) Pais.getSelectedItem();
				String division = (String) Division.getSelectedItem();
				
				/**
				 * El nombre no puede estar vacio
				 */
				if(Nombre.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "El nombre de la liga no puede estar vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else {
					Crear_Liga_BBDD.liga(pais,division,Nombre.getText());
					Crear_Todo o=new Crear_Todo(usuario);
					dispose();
					o.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(219, 194, 103, 23);
		panel.add(btnNewButton);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Crear_Todo o=new Crear_Todo(usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnVolver.setBounds(100, 194, 89, 23);
		panel.add(btnVolver);
	}

}
