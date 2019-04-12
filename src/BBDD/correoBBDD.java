package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class correoBBDD {
	public static String[] Correo() throws SQLException {
		int i=0;
		int a=0;
		ResultSet resultado;
             resultado=Conexion.EjecutarSetencia("Select Correo from usuarios", "Usuario");
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
