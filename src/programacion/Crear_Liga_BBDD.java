package programacion;

import BBDD.Conexion;

public class Crear_Liga_BBDD {
	public static void liga(String pais, String division, String nombre) {
	Conexion.EjecutarUpdate("INSERT INTO `liga`(`ID_Liga`, `nombre`, `Pais`, `Division`) VALUES (null,'"+nombre+"','"+pais+"','"+division+"')");
	}
}
