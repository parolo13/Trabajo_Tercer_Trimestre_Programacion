package programacion;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import BBDD.Conexion;
import BBDD.UsuarioBBDD;
/**
 * Aqui comprobamos si existe un usuario y se compueba la veracidad del correo, finalmente se hace el insert
 */
public class Registro {
	public static boolean Usuario(String usuario, String clave, String correo) throws SQLException {
		String[] solucion = UsuarioBBDD.Usuario();
		int contador = 0;
		while (contador < solucion.length) {
			for (int i = 0; i < solucion.length; i++) {
				contador++;
				if (solucion[i].equals(usuario)) {
					JOptionPane.showMessageDialog(null, "Usuario ya existente", "ERROR", JOptionPane.ERROR_MESSAGE);
					return false;

				}

			}
		}
		try {
			if (isValidEmailAddress(correo)) {
				Conexion.EjecutarUpdate("INSERT INTO usuarios(ID_Usuarios,Clave,Usuario,Correo) VALUES (null,'" + clave
						+ "','" + usuario + "','" + correo + "')");
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Correo invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Usuario ya existente", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public static boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}
}
