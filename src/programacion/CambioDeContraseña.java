package programacion;

import javax.swing.JOptionPane;

import BBDD.Conexion;
/**
 * Aqui hacemos el update para la nueva contrasela
 */
public class CambioDeContrase�a {
public static void Contrase�a(String contrase�a,String usuario) {
	Conexion.EjecutarUpdate("UPDATE usuarios SET Clave='"+contrase�a+"'where Usuario='"+usuario+"'");
	JOptionPane.showMessageDialog(null, "Contrase�a cambiada", "Correcto", JOptionPane.INFORMATION_MESSAGE);
	}
}
