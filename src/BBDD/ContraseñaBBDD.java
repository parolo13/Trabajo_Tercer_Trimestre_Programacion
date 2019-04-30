package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContraseñaBBDD {
	public static String[] Contraseña() throws SQLException {
		int i=0;
		int a=0;
		ResultSet resultado;
             resultado=Conexion.EjecutarSetencia("Select Clave from usuarios"); 
             while (resultado.next()) {
 				a++;	
 			}
              String[] solucion = new String[a];
              resultado.beforeFirst();
             while(resultado.next()) {
            	 
             solucion[i]=resultado.getString("Clave");
             i++;
             }
            return solucion;
          
	}
}
