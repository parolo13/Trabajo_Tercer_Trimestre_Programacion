package programacion;

import BBDD.Conexion;

public class Crear_Jugador_BBDD {
	public static void Jugador(String Nombre, String Valoracion, String Pais, String Liga, String Equipo, String Edad,
			String Valor, String Posicion, String Dorsal, String Calificacion) {
		
		Conexion.EjecutarUpdate(
				"INSERT INTO `jugadores`(`ID_Jugador`, `Nombre_Completo`, `Valoracion_Media`, `ID_Pais`, `Pais`, "
				+ "`ID_Liga`, `Liga`, `ID_Equipo`, `Equipo`, `Edad`, `Valor`, `Posicion`, `Dorsal`, `Calificacion_Media`)"
				+ " VALUES (null,'"+Nombre+"','"+Valoracion+"',1,'"+Pais+"',1,'"+Liga+"',1"
				+ ",'"+Equipo+"','"+Edad+"','"+Valor+"','"+Posicion+"','"+Dorsal+"','"+Calificacion+"')");

	}
}
