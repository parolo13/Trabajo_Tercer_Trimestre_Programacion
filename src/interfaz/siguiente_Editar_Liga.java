package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import programacion.Crear;
import programacion.Crear_Liga_BBDD;
import programacion.Editar_Liga_BBDD;

public class siguiente_Editar_Liga extends JFrame {
	private JTextField Nombre;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public siguiente_Editar_Liga(String usuario,String liga) throws SQLException {
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
		
		JButton btnNewButton = new JButton("Editar liga");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pais = (String) Pais.getSelectedItem();
				String division = (String) Division.getSelectedItem();
				if(Nombre.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "El nombre de la liga no puede estar vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else {
					Editar_Liga_BBDD.Editar_Liga(Nombre.getText(), pais, division, liga);
					Editar_Todo o=new Editar_Todo(usuario);
					dispose();
					o.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(219, 194, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editar_Liga o;
				try {
					o = new Editar_Liga(usuario);
					dispose();
					o.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnVolver.setBounds(100, 194, 89, 23);
		panel.add(btnVolver);
	}

}
