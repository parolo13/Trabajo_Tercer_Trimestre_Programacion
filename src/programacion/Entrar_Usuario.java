package programacion;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;



import BBDD.Conexion;
import BBDD.EntrarBBDD;

public class Entrar_Usuario {
public  boolean Usuario(String usuario, String clave ,String correo) throws SQLException {
	String[] solucion=EntrarBBDD.Usuario();
	int contador=0;
	int contador2=0;
	while(contador<solucion.length) {
	for (int i = 0; i < solucion.length; i++) {
		contador++;
		if(solucion[i]==usuario) {
			
				return false;
				
		}else {
			contador2++;
		}
	}
	}
if(contador2==solucion.length-1) {
	
	Conexion.EjecutarUpdate("INSERT INTO usuarios(ID_Usuarios,Clave,Usuario,Correo) VALUES (null,'"+clave+"','"+usuario+"','"+correo+"')");
	return true;
	}
JOptionPane.showMessageDialog(null, "Usuario ya existente", "ERROR", JOptionPane.ERROR_MESSAGE);
return false;
}
}
