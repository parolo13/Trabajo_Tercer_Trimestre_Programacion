package programacion;

import java.sql.SQLException;

import BBDD.Conexion;

public class Editar_Equipo_BBDD {
	public static void equipo(String nombre, String liga, String titulos, String economia, String jugadores,
			String equipo) throws SQLException {
		Conexion.EjecutarUpdate("UPDATE `equipos` SET `nombre`='" + nombre + "',`Liga`='" + liga + "',`Titulos`='"
				+ titulos + "',`Num_Jugadores`='" + jugadores + "',`Economia`='" + economia + "' WHERE nombre='"
				+ equipo + "' ");
		Conexion.EjecutarUpdate(
				"UPDATE `jugadores` SET Equipo='"+nombre+"' WHERE Equipo='"+equipo+"'");
	}
}
