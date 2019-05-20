package programacion;

import javax.swing.JOptionPane;

import BBDD.Conexion;
/**
 * Aqui hacemos el update para la nueva contrasela
 */
public class CambioDeContraseña {
public static void Contraseña(String contraseña,String usuario) {
	Conexion.EjecutarUpdate("UPDATE usuarios SET Clave='"+contraseña+"'where Usuario='"+usuario+"'");
	JOptionPane.showMessageDialog(null, "Contraseña cambiada", "Correcto", JOptionPane.INFORMATION_MESSAGE);
	}
}
