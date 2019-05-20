package programacion;

import java.sql.ResultSet;
import java.sql.SQLException;

import BBDD.Conexion;
/**
 * Aqui hacemos el insert para el jugador
 */
public class Crear_Jugador_BBDD {
	public static void Jugador(String Nombre, String Valoracion, String Pais, String Liga, String Equipo, String Edad,
			String Valor, String Posicion, String Dorsal, String Calificacion) throws SQLException {
		int idpais = IDpais(Pais);
		int idliga = IDliga(Liga);
		Conexion.EjecutarUpdate(
				"INSERT INTO `jugadores`(`ID_Jugador`, `Nombre_Completo`, `Valoracion_Media`, `ID_Pais`, `Pais`, "
						+ "`ID_Liga`, `Liga`, `ID_Equipo`, `Equipo`, `Edad`, `Valor`, `Posicion`, `Dorsal`, `Calificacion_Media`)"
						+ " VALUES (null,'" + Nombre + "','" + Valoracion + "'," + idpais + ",'" + Pais + "'," + idliga
						+ ",'" + Liga + "',10" + ",'" + Equipo + "','" + Edad + "','" + Valor + "','" + Posicion + "','"
						+ Dorsal + "','" + Calificacion + "')");

	}

	public static int IDpais(String Pais) throws SQLException {
		int a = 0;
		int i = 0;
		ResultSet IDpais = Conexion.EjecutarSetencia("Select id from paises where nombre='" + Pais + "'");
		while (IDpais.next()) {
			a++;
		}
		int[] idpais = new int[a];
		IDpais.beforeFirst();
		while (IDpais.next()) {

			idpais[i] = IDpais.getInt("id");
			i++;

		}
		return idpais[0];
	}

	public static int IDliga(String liga) throws SQLException {
		int a = 0;
		int i = 0;
		ResultSet IDliga = Conexion.EjecutarSetencia("Select ID_Liga from liga where nombre='" + liga + "'");
		while (IDliga.next()) {
			a++;
		}
		int[] idliga = new int[a];
		IDliga.beforeFirst();
		while (IDliga.next()) {

			idliga[i] = IDliga.getInt("ID_liga");
			i++;

		}
		return idliga[0];
	}

	public static int IDequipo(String equipo) throws SQLException {
		int a = 0;
		int i = 0;
		ResultSet IDequipo = Conexion.EjecutarSetencia("Select ID_Equipo from equipos where nombre='" + equipo + "'");
		while (IDequipo.next()) {
			a++;
		}
		int[] idequipo = new int[a];
		IDequipo.beforeFirst();
		while (IDequipo.next()) {

			idequipo[i] = IDequipo.getInt("ID_Equipo");
			i++;

		}
		return idequipo[0];
	}

	public static int IDjugador(String nombre) throws SQLException {
		int a = 0;
		int i = 0;
		ResultSet IDjugador = Conexion
				.EjecutarSetencia("Select ID_Jugador from jugadores where Nombre_Completo ='" + nombre + "'");
		while (IDjugador.next()) {
			a++;
		}
		int[] idjugador = new int[a];
		IDjugador.beforeFirst();
		while (IDjugador.next()) {

			idjugador[i] = IDjugador.getInt("ID_Jugador");
			i++;

		}
		return idjugador[0];
	}

	public static void jugador2(String equipo, String nombre, int tecnica, int mental, int fisico) throws SQLException {
		// TODO Auto-generated method stub
		int idequipo = IDequipo(equipo);
		int idjugador = IDjugador(nombre);
		Conexion.EjecutarUpdate("Update jugadores Set ID_Equipo=" + idequipo + ",Equipo='" + equipo
				+ "'where Nombre_Completo='" + nombre + "'");
		Conexion.EjecutarUpdate(
				"INSERT INTO `valoracion_jugador`(`ID_jugador`, `Valoracion_Tecnica`, `Valoracion_Mental`, `Valoracion_Fisica`) VALUES ("
						+ idjugador + "," + tecnica + "," + mental + "," + fisico + ")");

	}
}
