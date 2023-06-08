
package Modelo;

import Controlador.Clientes;
import Controlador.Conexion;
import static Controlador.Conexion.con;

import com.mysql.jdbc.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class producto {
    public String idProd;
    public String nombre;
    public int Stock;
    public int precio;

    public producto() {
    }

    public producto(String idProd, int Stock, String nombre, int precio) {
        this.idProd = idProd;
        this.Stock = Stock;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getIdProd() {
        return idProd;
    }

    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
public static void reg_prod(String nombre, double precio, int stock) {
    try {
        Conexion.abrirConexion();
        
        // Verificar si el producto ya existe en la base de datos
        String consultaVerificacion = "SELECT * FROM productos WHERE Nombre = ?";
        java.sql.PreparedStatement statementVerificacion = con.prepareStatement(consultaVerificacion);
        statementVerificacion.setString(1, nombre);
        java.sql.ResultSet resultSet = statementVerificacion.executeQuery();
        
        // Si ya existe un producto con el mismo nombre, mostrar el JOptionPane de advertencia
        if (resultSet.next()) {
            JOptionPane.showMessageDialog(null, "El producto ya existe en la base de datos");
            return; // Salir del método
        }
        
        // Insertar el nuevo producto en la base de datos
        String consultaInsercion = "INSERT INTO productos (Nombre, Precio, Stock) VALUES (?, ?, ?)";
        java.sql.PreparedStatement statementInsercion = con.prepareStatement(consultaInsercion);
        statementInsercion.setString(1, nombre);
        statementInsercion.setInt(2, (int) precio);
        statementInsercion.setInt(3, stock);
        statementInsercion.executeUpdate();
        
        Conexion.cerrarConexion();
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
        Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
