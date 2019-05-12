package programacion;

import java.sql.ResultSet;
import java.sql.SQLException;

import BBDD.Conexion;

public class Crear {
	public static String[] Liga() throws SQLException {
		int i = 0;
		int a = 0;
		ResultSet resultado;
		resultado = Conexion.EjecutarSetencia("Select nombre from liga");
		while (resultado.next()) {
			a++;
		}
		String[] solucion = new String[a];
		resultado.beforeFirst();
		while (resultado.next()) {

			solucion[i] = resultado.getString("nombre");
			i++;
		}
		return solucion;
	}

	public static String[] Pais() throws SQLException {
		int i = 0;
		int a = 0;
		ResultSet resultado;
		resultado = Conexion.EjecutarSetencia("Select nombre from paises");
		while (resultado.next()) {
			a++;
		}
		String[] solucion = new String[a];
		resultado.beforeFirst();
		while (resultado.next()) {

			solucion[i] = resultado.getString("nombre");
			i++;
		}
		return solucion;
	}

	public static String[] Equipo(String liga) throws SQLException {
		int i = 0;
		int a = 0;
		ResultSet resultado;
		resultado = Conexion.EjecutarSetencia("Select nombre from equipos where Liga='" + liga + "'");
		while (resultado.next()) {
			a++;
		}
		String[] solucion = new String[a];
		resultado.beforeFirst();
		while (resultado.next()) {

			solucion[i] = resultado.getString("nombre");
			i++;
		}
		return solucion;
	}

	public static String[] jugador() throws SQLException {
		int i = 0;
		int a = 0;
		ResultSet resultado;
		resultado = Conexion.EjecutarSetencia("Select Nombre_Completo from jugadores");
		while (resultado.next()) {
			a++;
		}
		String[] solucion = new String[a];
		resultado.beforeFirst();
		while (resultado.next()) {

			solucion[i] = resultado.getString("Nombre_Completo");
			i++;
		}
		return solucion;
	}

	public static String[] Equipo() throws SQLException {
		int i = 0;
		int a = 0;
		ResultSet resultado;
		resultado = Conexion.EjecutarSetencia("Select nombre from equipos");
		while (resultado.next()) {
			a++;
		}
		String[] solucion = new String[a];
		resultado.beforeFirst();
		while (resultado.next()) {

			solucion[i] = resultado.getString("nombre");
			i++;
		}
		return solucion;
	}
}
