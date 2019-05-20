package programacion;

import java.sql.SQLException;

import BBDD.Conexion;

/**
 * Aqui hacemos el supdate para editar el jugador
 */
public class Editar_Jugador_BBDD {
	public static void Jugador(String Nombre, String Valoracion, String Pais, String Liga, String Equipo, String Edad,
			String Valor, String Posicion, String Dorsal, String Calificacion, String jugador) throws SQLException {
		int idpais = Crear_Jugador_BBDD.IDpais(Pais);
		int idliga = Crear_Jugador_BBDD.IDliga(Liga);
		Conexion.EjecutarUpdate("UPDATE `jugadores` SET Nombre_Completo='" + Nombre + "',`Valoracion_Media`='"
				+ Valoracion + "',`ID_Pais`=" + idpais + ",`Pais`='" + Pais + "',`ID_Liga`=" + idliga + ",`Liga`='"
				+ Liga + "',`Edad`='" + Edad + "',`Valor`='" + Valor + "',`Posicion`='" + Posicion + "',`Dorsal`='"
				+ Dorsal + "',`Calificacion_Media`='" + Calificacion + "' WHERE Nombre_Completo='" + jugador + "'");
	}

	public static void jugador2(String equipo, String nombre, int tecnica, int mental, int fisico) throws SQLException {
		// TODO Auto-generated method stub
		int idequipo = Crear_Jugador_BBDD.IDequipo(equipo);
		int idjugador = Crear_Jugador_BBDD.IDjugador(nombre);
		Conexion.EjecutarUpdate("Update jugadores Set ID_Equipo=" + idequipo + ",Equipo='" + equipo
				+ "'where Nombre_Completo='" + nombre + "'");
		Conexion.EjecutarUpdate("UPDATE `valoracion_jugador` SET `Valoracion_Tecnica`="
				+ tecnica + ",`Valoracion_Mental`=" + mental + ",`Valoracion_Fisica`="+fisico+" WHERE ID_jugador="+idjugador+"");

	}
}
