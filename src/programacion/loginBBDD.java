package programacion;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import BBDD.Contrase�aBBDD;
import BBDD.UsuarioBBDD;

/**
 * Aqui comprobamos si existe la contrase�a y el usuario
 */
public class loginBBDD {
	public static boolean Login(String usuario, String contrase�a) throws SQLException {
		String[] usuarioBBDD = UsuarioBBDD.Usuario();
		String[] contrase�aBBDD = Contrase�aBBDD.Contrase�a();
		int contador = 0;
		while (contador < usuarioBBDD.length) {
			for (int i = 0; i < usuarioBBDD.length; i++) {
				contador++;
				if (usuarioBBDD[i].equals(usuario)) {
					if (contrase�aBBDD[i].equals(contrase�a)) {
						return true;
					}else {
						JOptionPane.showMessageDialog(null, "Contrase�a equivocada", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		}
		return false;
	}
}
