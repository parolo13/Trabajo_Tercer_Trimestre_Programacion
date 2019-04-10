package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Eleccion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Eleccion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextPane txtpnquQuieresHacer = new JTextPane();
		txtpnquQuieresHacer.setEditable(false);
		txtpnquQuieresHacer.setBackground(UIManager.getColor("Button.background"));
		txtpnquQuieresHacer.setText("\u00BFQu\u00E9 quieres hacer?");
		txtpnquQuieresHacer.setBounds(142, 11, 230, 20);
		panel.add(txtpnquQuieresHacer);
		
		JButton btnNewButton = new JButton("Ver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(152, 42, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Editar\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(152, 87, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton button = new JButton("Añadir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(152, 133, 89, 23);
		panel.add(button);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBorrar.setBounds(152, 182, 89, 23);
		panel.add(btnBorrar);
	}

}
