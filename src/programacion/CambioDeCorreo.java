package programacion;

import javax.swing.JOptionPane;

import BBDD.Conexion;

/**
 * Aqui hacemos el update del nuevo correo
 */
public class CambioDeCorreo {
	public static void Correo(String correo,String usuario) {
		if(Registro.isValidEmailAddress(correo)) {
			Conexion.EjecutarUpdate("UPDATE usuarios SET Correo='"+correo+"'where Usuario='"+usuario+"'");
			JOptionPane.showMessageDialog(null, "correo cambiado", "Correcto", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Correo invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}
