package programacion;

import javax.swing.JOptionPane;

import BBDD.Conexion;
/**
 * Aqui hacemos el update para la nueva contrasela
 */
public class CambioDeContraseņa {
public static void Contraseņa(String contraseņa,String usuario) {
	Conexion.EjecutarUpdate("UPDATE usuarios SET Clave='"+contraseņa+"'where Usuario='"+usuario+"'");
	JOptionPane.showMessageDialog(null, "Contraseņa cambiada", "Correcto", JOptionPane.INFORMATION_MESSAGE);
	}
}
