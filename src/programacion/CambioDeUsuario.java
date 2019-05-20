package programacion;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import BBDD.Conexion;
import BBDD.ContraseñaBBDD;
import BBDD.UsuarioBBDD;
/**
 * Primero comprobamos si existe o no en la base de datos el usuario
 */
public class CambioDeUsuario {
	public static String Usuario(String usuarioNuevo,String usuarioAntiguo) throws SQLException {
		String[] solucion = UsuarioBBDD.Usuario();
		int contador = 0;
		while (contador < solucion.length) {
			for (int i = 0; i < solucion.length; i++) {
				contador++;
				if (solucion[i].equals(usuarioNuevo)) {
					JOptionPane.showMessageDialog(null, "Usuario ya existente", "ERROR", JOptionPane.ERROR_MESSAGE);
					return usuarioAntiguo;

				}

			}
		}
		/**
		 * Aqui hacemos el update del nuevo usuario
		 */
		try {
				Conexion.EjecutarUpdate("UPDATE usuarios SET Usuario='"+usuarioNuevo+"'where Usuario='"+usuarioAntiguo+"'");
				JOptionPane.showMessageDialog(null, "Usuario cambiado", "Correcto", JOptionPane.INFORMATION_MESSAGE);
				return usuarioNuevo;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Usuario ya existente", "ERROR", JOptionPane.ERROR_MESSAGE);
			return usuarioAntiguo;
		}
}
}
