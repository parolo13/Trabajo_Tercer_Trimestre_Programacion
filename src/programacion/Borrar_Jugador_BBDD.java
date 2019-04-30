package programacion;

import BBDD.Conexion;

public class Borrar_Jugador_BBDD {
	public static void jugador(String jugador) {
		Conexion.EjecutarUpdate("DELETE FROM `jugadores` WHERE Nombre_Completo='"+jugador+"'");
	}
	public static void liga(String liga) {
		Conexion.EjecutarUpdate("DELETE FROM `liga` WHERE nombre='"+liga+"'");
		Conexion.EjecutarUpdate("DELETE FROM `equipos` WHERE Liga='"+liga+"'");
		Conexion.EjecutarUpdate("DELETE FROM `jugadores` WHERE Liga='"+liga+"'");
	}
	public static void equipo(String equipo) {
		Conexion.EjecutarUpdate("DELETE FROM `equipos` WHERE nombre='"+equipo+"'");
		Conexion.EjecutarUpdate("DELETE FROM `jugadores` WHERE Equipo='"+equipo+"'");
		
	}
}
