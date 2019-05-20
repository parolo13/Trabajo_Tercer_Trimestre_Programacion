package programacion;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import BBDD.ContraseñaBBDD;
import BBDD.UsuarioBBDD;

/**
 * Aqui comprobamos si existe la contraseña y el usuario
 */
public class loginBBDD {
	public static boolean Login(String usuario, String contraseña) throws SQLException {
		String[] usuarioBBDD = UsuarioBBDD.Usuario();
		String[] contraseñaBBDD = ContraseñaBBDD.Contraseña();
		int contador = 0;
		while (contador < usuarioBBDD.length) {
			for (int i = 0; i < usuarioBBDD.length; i++) {
				contador++;
				if (usuarioBBDD[i].equals(usuario)) {
					if (contraseñaBBDD[i].equals(contraseña)) {
						return true;
					}else {
						JOptionPane.showMessageDialog(null, "Contraseña equivocada", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		}
		return false;
	}
}
