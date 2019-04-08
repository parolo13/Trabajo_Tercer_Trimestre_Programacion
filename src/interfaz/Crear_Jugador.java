package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Crear_Jugador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crear_Jugador frame = new Crear_Jugador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Crear_Jugador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextPane txtpnNombre = new JTextPane();
		txtpnNombre.setText("Nombre");
		txtpnNombre.setBounds(10, 25, 115, 20);
		panel.add(txtpnNombre);
		
		JTextPane txtpnEdad = new JTextPane();
		txtpnEdad.setText("Edad");
		txtpnEdad.setBounds(299, 25, 115, 20);
		panel.add(txtpnEdad);
		
		JTextPane txtpnPais = new JTextPane();
		txtpnPais.setText("Pais");
		txtpnPais.setBounds(10, 56, 115, 20);
		panel.add(txtpnPais);
		
		JTextPane txtpnLiga = new JTextPane();
		txtpnLiga.setText("Liga");
		txtpnLiga.setBounds(299, 56, 115, 20);
		panel.add(txtpnLiga);
		
		JTextPane txtpnDorsal = new JTextPane();
		txtpnDorsal.setText("Dorsal");
		txtpnDorsal.setBounds(299, 118, 115, 20);
		panel.add(txtpnDorsal);
		
		JTextPane txtpnPosicion = new JTextPane();
		txtpnPosicion.setText("Posicion");
		txtpnPosicion.setBounds(299, 87, 115, 20);
		panel.add(txtpnPosicion);
		
		JTextPane txtpnEquipo = new JTextPane();
		txtpnEquipo.setText("Equipo");
		txtpnEquipo.setBounds(10, 87, 115, 20);
		panel.add(txtpnEquipo);
		
		JTextPane txtpnValor = new JTextPane();
		txtpnValor.setText("Valor(En Millones)");
		txtpnValor.setBounds(10, 118, 115, 20);
		panel.add(txtpnValor);
		
		JTextPane txtpnValoracionMedia = new JTextPane();
		txtpnValoracionMedia.setText("Valoracion Media(0-5)");
		txtpnValoracionMedia.setBounds(10, 149, 115, 20);
		panel.add(txtpnValoracionMedia);
		
		JTextPane txtpnCalificacionMedia = new JTextPane();
		txtpnCalificacionMedia.setText("Calificacion Media");
		txtpnCalificacionMedia.setBounds(299, 149, 115, 20);
		panel.add(txtpnCalificacionMedia);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSiguiente.setBounds(176, 217, 89, 23);
		panel.add(btnSiguiente);
	}
}
