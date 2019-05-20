package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import programacion.Crear;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Editar_Liga extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Editar_Liga(String usuario) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblLigaAEditar = new JLabel("Liga a editar");
		lblLigaAEditar.setBounds(47, 97, 85, 14);
		panel.add(lblLigaAEditar);
		
		
		/**
		 * Se rellena el combobox para escoger la liga que vamos a editar
		 */
		JComboBox Liga = new JComboBox();
		Liga.setBounds(142, 93, 130, 22);
		String[] ligaBBDD = Crear.Liga();
		for (int i = 0; i < ligaBBDD.length; i++) {
			Liga.addItem(ligaBBDD[i]);
		}
		panel.add(Liga);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editar_Todo o=new Editar_Todo (usuario);
				dispose();
				o.setVisible(true);
			}
		});
		btnVolver.setBounds(84, 195, 89, 23);
		panel.add(btnVolver);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String liga=(String)Liga.getSelectedItem();
				siguiente_Editar_Liga o;
				try {
					o = new siguiente_Editar_Liga(usuario,liga);
					dispose();
					o.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnEditar.setBounds(223, 195, 89, 23);
		panel.add(btnEditar);
		
	}

}
