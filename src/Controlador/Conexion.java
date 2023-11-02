
package Controlador;


import Modelo.Cuentas;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.producto;


public class Conexion {

      public static Connection con = null;
    
    // Las diversas instrucciones que se envían a la BD
    private static Statement st = null;
    
    // El driver de MySQL
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    // El url de la BD, se especifica el nombre del host y el de la base de datos
    private static final String URL = "jdbc:mysql://localhost/proyect_program";
    
    // Abrir la conexión con la BD
   public static boolean abrirConexion() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
      // Se realiza la conexión
try {
        // Se realiza la conexión
        System.out.println("Intentando abrir la conexión...");
        Class.forName(DRIVER);
        con = DriverManager.getConnection(URL, "usuario", "root");
        st = con.createStatement();
        System.out.println("Conexión abierta correctamente");
        return true;
    } catch (ClassNotFoundException | SQLException e) {
        System.out.println("Error al abrir la conexión: " + e.getMessage());
        return false;
    }
}
   
    
    // Cerrar la conexiòn con la BD
    public static void cerrarConexion() throws SQLException {
        con.close();
        st.close();
        con = null;
        st = null;
    }
    public static void ingresar(String consulta){
          try {
              
              st.executeUpdate(consulta);
              
          } catch (SQLException ex) {
              Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
  
   
     public static ArrayList getListaProductos() {
        ArrayList mListaProductos = new ArrayList();
        producto mProducto = null;
        Statement consulta;
        ResultSet resultado;
        try {
            consulta = con.createStatement();
            resultado = consulta.executeQuery("select * from productos");

            while (resultado.next()) {
                mProducto = new producto();
                mProducto.setIdProd(resultado.getString("idProducto"));
                mProducto.setStock(resultado.getInt("Stock"));
                mProducto.setNombre(resultado.getString("nombre"));
                mProducto.setPrecio(resultado.getInt("precio"));
                mListaProductos.add(mProducto);
            }
        } catch (SQLException e) {
        }
        return mListaProductos;
    }
public static ArrayList getListaCuentas(String NoCuenta) {
        ArrayList mListaCuentas = new ArrayList();
        Cuentas mCuenta = null;
        Statement consulta;
        ResultSet resultado;
        try {
            consulta = con.createStatement();
            resultado = consulta.executeQuery("select NoCuenta from Cuenta where Identificacion= ' "+NoCuenta+" '; ");

            while (resultado.next()) {
                mCuenta = new Cuentas();
                mCuenta.setNoCuenta(resultado.getLong("NoCuenta"));
                mListaCuentas.add(mCuenta);
            }
        } catch (SQLException e) {
        }
        return mListaCuentas;
    }
      public static void registrar(int Identificacion, String Nombre, String Direccion, String Telefono, String Email, String Contraseña) throws SQLException {
        String consulta;
       
        // Se arma la consulta
        consulta = "insert into clientes "
                + "values ("+Identificacion+", ' "+Nombre+" ', ' "+Direccion+" ', ' "+Telefono+" ', ' "+Email+" ', ' " + Contraseña +" ' );";
        System.out.println(consulta);
        
        // Se envia la consulta a la BD
        st.executeUpdate(consulta);
    }
}


