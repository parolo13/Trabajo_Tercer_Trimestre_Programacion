package programacion;

import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import BBDD.Conexion;
import BBDD.EntrarBBDD;

public class Entrar_Usuario {
public static boolean Usuario(String usuario, String contrase�a ) throws SQLException {
	String[] solucion=EntrarBBDD.Usuario();
	int contador=0;
	while(contador<solucion.length) {
	for (int i = 0; i < solucion.length; i++) {
		if(solucion[i]==usuario) {
		return false;	
		}
	}
	}
	Conexion.recibirConexion();
	Conexion.EjecutarUpdate("INSERT INTO usuarios (contrase�a,Usuario) VALUES ("+contrase�a +", "+usuario+")");
	return true;
}
}
