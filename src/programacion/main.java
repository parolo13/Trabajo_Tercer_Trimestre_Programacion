package programacion;

import BBDD.Conexion;
import interfaz.login;

public class main {

	public static void main(String[] args) {
		Conexion.recibirConexion();
		login o=new login();
		o.setVisible(true);
		
	}

}
