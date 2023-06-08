package Controlador;


import Controlador.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Clientes {
    private int id_cl;
    private String Nombre;
    private String Direccion;
    private String Telefono;
    private String Email;
    Conexion con = new Conexion();
    public Clientes() {
    }
    public Clientes(int id_cl, String Nombre, String Direccion, String Telefono, String Email) {
        this.id_cl = id_cl;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Email = Email;
    }

    public int getId_cl() {
        return id_cl;
    }

    public void setId_cl(int id_cl) {
        this.id_cl = id_cl;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
       
    public static void reg_cliente(String nombre, String Direccion, String Telefono, String Email){
        
        try {
            Conexion.abrirConexion();
            String consulta = " insert into clientes "
                    + "values ("+0+", ' "+nombre+" ' "+" ' "+Direccion+" ' "+Telefono+" ' " + Email+" ');";
            
            Conexion.ingresar(consulta);
            Conexion.cerrarConexion();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    

    }
}

