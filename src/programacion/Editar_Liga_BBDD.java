package programacion;

import BBDD.Conexion;
/**
 * Aqui hacemos el update de las ligas
 */
public class Editar_Liga_BBDD {
	public static void Editar_Liga(String nombre,String pais,String division,String liga) {
		Conexion.EjecutarUpdate("UPDATE `liga` SET `nombre`='"+nombre+"',`Pais`='"+pais+"',`Division`='"+division+"' WHERE nombre='"+liga+"'");
		Conexion.EjecutarUpdate("UPDATE `equipos` SET `Liga`='"+nombre+"' WHERE Liga='"+liga+"'");
		Conexion.EjecutarUpdate("UPDATE `jugadores` SET `Liga`='"+nombre+"' WHERE Liga='"+liga+"'");
	}
}
