package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioBBDD {
	public static String[] Usuario() throws SQLException {
		int i=0;
		int a=0;
		ResultSet resultado;
             resultado=Conexion.EjecutarSetencia("Select Usuario from usuarios", "Usuario");
             while (resultado.next()) {
				a++;	
			}
             String[] solucion = new String[a];
             resultado.beforeFirst();
             while(resultado.next()) {
            	 
             solucion[i]=resultado.getString("Usuario");
             i++;
             }
            return solucion;
          
	}
}