package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	
		static String timeZone="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		static String dbname="fm19";
		static String url="jdbc:mysql://localhost:3307/"+dbname+timeZone;
		static String user="root";
		static String pass ="manolo";
		static String driver="com.mysql.cj.jdbc.Driver";
		
		static Connection conexion;
		static Statement consulta;
		static ResultSet resultado;
		
		public static Connection recibirConexion() {
			try {
				conexion=DriverManager.getConnection(url,user,pass);
				consulta=conexion.createStatement();
				Connection dani =conexion;
				return dani;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conexion;
		}
		public static ResultSet EjecutarSetencia(String sentencia,String tabla) {
			try {
				resultado = consulta.executeQuery(sentencia);
				while(resultado.next()) {
					System.out.println(resultado.getString(tabla));
				}
			} catch (SQLException e) {
				System.out.println("error");
				e.printStackTrace();
			}
			return resultado;
		}
		public static void EjecutarUpdate(String sentencia) {
				try {
					consulta.executeUpdate(sentencia);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}
}
