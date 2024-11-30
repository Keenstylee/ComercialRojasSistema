/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;

/**
 *
 * @author intel
 */
public class UsuarioControlador {
    
    // Método estático para verificar las credenciales de un usuario en la base de datos
    static public boolean login(Usuario usuario) {
        boolean respuesta = false; // Inicializa la variable de respuesta como falso
        String sql = "SELECT id FROM Usuario WHERE id='"+ usuario.getId() +"' AND PASSWORD = '"+ usuario.getPassword() +"'"; // Consulta SQL para verificar las credenciales
        
        try {
            // Ejecuta la consulta SQL y obtiene el conjunto de resultados
            ResultSet rs = Conexion.db.createStatement().executeQuery(sql);
            // Itera a través de los resultados
            while (rs.next()) {
                respuesta = true; // Si hay al menos una fila en el resultado, establece la respuesta como verdadero (credenciales válidas)
            }
            
        } catch (SQLException error) {
            // Captura cualquier excepción SQL que pueda ocurrir durante la autenticación y muestra un mensaje de error
            System.out.println("Error: " + error.getMessage());
        }
        
        // Devuelve true si las credenciales son válidas, de lo contrario, devuelve false
        return respuesta;
    }
}
