package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Aqui hacemos el select para el correo y la metemos en un array
 */
public class correoBBDD {
	public static String[] Correo() throws SQLException {
		int i=0;
		int a=0;
		ResultSet resultado;
             resultado=Conexion.EjecutarSetencia("Select Correo from usuarios");
             while (resultado.next()) {
				a++;	
			}
             String[] solucion = new String[a];
             resultado.beforeFirst();
             while(resultado.next()) {
            	 
             solucion[i]=resultado.getString("Correo");
             i++;
             }
            return solucion;
          
	}
}
