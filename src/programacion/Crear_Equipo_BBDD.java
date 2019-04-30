package programacion;

import java.sql.SQLException;

import BBDD.Conexion;

public class Crear_Equipo_BBDD {
	public static void equipo(String nombre, String liga, String titulos, String economia, String jugadores) throws SQLException {
		Conexion.EjecutarUpdate(
				"INSERT INTO `equipos`(`ID_Equipo`, `nombre`, `Liga`, `Titulos`, `Num_Jugadores`, `Economia`) VALUES (null,'"
						+ nombre + "','" + liga + "','" + titulos + "','" + jugadores + "','" + economia + "') ");
	}
}
