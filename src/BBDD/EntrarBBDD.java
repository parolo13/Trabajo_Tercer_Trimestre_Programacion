package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EntrarBBDD {
	public static String[] Usuario() throws SQLException {
		int i=0;
		Conexion.recibirConexion();
		ResultSet resultado;
             resultado=Conexion.EjecutarSetencia("Select Usuario from usuarios", "Usuario"); 
             String[] solucion = new String[10];
             while(resultado.next()) {
            	 
             solucion[i]=resultado.getString("Usuario");
             i++;
             }
            return solucion;
          
	}
}