package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import programacion.Crear;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class siguiente_siguiente_editar_jugador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public siguiente_siguiente_editar_jugador(String usuario,String jugador,String liga) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(22, 37, 46, 14);
		panel.add(lblEquipo);
		
		JLabel lblTecnica = new JLabel("Tecnica");
		lblTecnica.setBounds(22, 69, 46, 14);
		panel.add(lblTecnica);
		
		JLabel lblMental = new JLabel("Mental");
		lblMental.setBounds(215, 37, 46, 14);
		panel.add(lblMental);
		
		JLabel lblFisico = new JLabel("Fisico");
		lblFisico.setBounds(215, 73, 46, 14);
		panel.add(lblFisico);
		
		JComboBox Equipo = new JComboBox();
		Equipo.setBounds(78, 33, 98, 22);
		String[] EquipoBBDD = Crear.Equipo(liga);
		for (int i = 0; i < EquipoBBDD.length; i++) {
			Equipo.addItem(EquipoBBDD[i]);
		}
		panel.add(Equipo);
		
		JComboBox Tecnica = new JComboBox();
		Tecnica.setBounds(78, 65, 98, 22);
		for (int i = 0; i < 21; i++) {
			Tecnica.addItem(i);
		}
		panel.add(Tecnica);
		
		JComboBox Fisico = new JComboBox();
		Fisico.setBounds(291, 69, 98, 22);
		for (int i = 0; i < 21; i++) {
			Fisico.addItem(i);
		}
		panel.add(Fisico);
		
		JComboBox Mental = new JComboBox();
		Mental.setBounds(291, 33, 98, 22);
		for (int i = 0; i < 21; i++) {
			Mental.addItem(i);
		}
		panel.add(Mental);
		
		JButton btnEditarJugador = new JButton("Editar jugador");
		btnEditarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Editar_Jugador o=new Editar_Jugador(usuario);
					dispose();
					o.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnEditarJugador.setBounds(154, 205, 107, 23);
		panel.add(btnEditarJugador);
	}

}
