package programacion;

import java.sql.SQLException;
import java.util.Random;

import javax.swing.JOptionPane;

import BBDD.UsuarioBBDD;
import BBDD.correoBBDD;

public class RecuperarContrase�a {
	public static String RecuperarCon(String Correo) throws SQLException {
		String[] solucion = correoBBDD.Correo();
		int contador = 0;
		String nuevaContrase�a="";
		while (contador < solucion.length) {
			for (int i = 0; i < solucion.length; i++) {
				contador++;
				if (solucion[i].equals(Correo)) {
					Random r = new Random();
					int n;
					int num;
					int numero;
					char caracter;
					for (int o = 0; o < 8; o++) {

						n = r.nextInt(3) + 1;
						switch (n) {
						case 1:
							num = r.nextInt(10) + 48;
							break;
						case 2:
							num = r.nextInt(25) + 65;
							break;
						default:
							num = r.nextInt(25) + 97;
							break;
						}
						caracter = (char) num;
						nuevaContrase�a += Character.toString(caracter);

					}
					return nuevaContrase�a;

				}

			}
		}
		return "0";

	}
}