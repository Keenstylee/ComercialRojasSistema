package controlador;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;
import modelo.Categoria;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author intel
 */
public class ProductoControlador {
    static public List<Producto> obtenerProductos(){
        List<Producto> productos = new ArrayList(); // Crea una lista para almacenar los productos recuperados
        String sql = "SELECT *, (SELECT Categoria.nombre FROM Categoria WHERE Categoria.id = Producto.idCategoria) as categoriaNombre FROM Producto"; // Consulta SQL para seleccionar todas los productos
        
        try {
            Statement st = Conexion.db.createStatement(); // Crea una declaración SQL para ejecutar la consulta
            ResultSet rs = st.executeQuery(sql); // Ejecuta la consulta y obtiene el conjunto de resultados
            
            // Itera a través de los resultados y crea objetos Producto, luego los agrega a la lista de los productos
            while(rs.next()){
                int id = rs.getInt("id");
                int stock = rs.getInt("stock");
                double precio = rs.getDouble("stock");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("idCategoria"));
                categoria.setNombre(rs.getString("categoriaNombre"));
                
                productos.add(new Producto(id, nombre, descripcion, stock, precio, categoria));
            }
            
        } catch (SQLException e) {
            // Captura cualquier excepción SQL que pueda ocurrir durante la recuperación y muestra un mensaje de error
            System.out.println("Error: " + e.getMessage());
        }
        
        // Devuelve la lista de los productos recuperados desde la base de datos
        return productos;
    }
}
