package programacion;

import BBDD.Conexion;
import interfaz.login;

public class main {

	public static void main(String[] args) {
		/**
		 * Aqui inicamos la conexion a la base de datos y nos lleva al login
		 */
		Conexion.recibirConexion();
		login o=new login();
		o.setVisible(true);
		
	}

}
