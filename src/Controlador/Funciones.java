/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import static Controlador.Conexion.con;
import Modelo.Cuentas;
import Modelo.Pedido;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import Vista.Inicio;
import Vista.Pagar;
import static Vista.Pagar.CbCuenta;
import static Vista.Pagar.JLTotal;
import static Vista.Pagar.idComp;
import static Vista.Pagar.idPedido;
import static Vista.Pagar.iddetal;
import java.awt.HeadlessException;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Falabella
 */
public class Funciones {
    
/*
     public static String ConsultarCuenta(String NoCuenta) throws SQLException {       
         try {
             Inicio Inicio = new Inicio();
             Controlador.Conexion.abrirConexion();
             String Saldo,Cupo,Ide;
             String Identificacion;
             Statement consulta;
             ResultSet resultado;
             
             consulta = Controlador.Conexion.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
             resultado = consulta.executeQuery("select Cupo,Identificacion, Saldo from Cuenta where NoCuenta= ' "+NoCuenta+" '; ");
            
             resultado.first();
              System.out.println(NoCuenta);
             Saldo = resultado.getString("Saldo");
             Cupo = resultado.getString("Cupo");
             Ide = resultado.getString("Identificacion");
             System.out.println(Saldo);
             Inicio.JtCup.setText(Cupo);
             Inicio.JtIden.setText(Ide);
             Inicio.JtSaldoDis.setText(Saldo);
            Inicio.JtSaldoDis2.setText(Saldo);
   

             return Saldo;
         } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
             Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         Controlador.Conexion.cerrarConexion();
         return null;
    }
     */
  public static boolean verificarStock() {
    ArrayList<String> cadenas = new ArrayList<>();
    String reg = Inicio.registros;
    String reg2[] = reg.split("\n");
    for (int i = 0; i < reg2.length; i++) {
        cadenas.add(reg2[i]);
    }

    Map<Integer, Integer> stockProductos = obtenerStockProductos();

    ArrayList<Pedido> pedidos = new ArrayList<>();
    pedidos.clear();
    // Expresiones regulares para extraer los valores de id, cantidad y valor
    String idRegex = "(?<=Prod:\\s)(\\d+)";
    String cantidadRegex = "(?<=Cantidad:\\s)(\\d+)";
    String valorRegex = "(?<=Valor\\s)(\\d+)";

    for (String cadena : cadenas) {
        Pattern idPattern = Pattern.compile(idRegex);
        Pattern cantidadPattern = Pattern.compile(cantidadRegex);
        Pattern valorPattern = Pattern.compile(valorRegex);

        Matcher idMatcher = idPattern.matcher(cadena);
        Matcher cantidadMatcher = cantidadPattern.matcher(cadena);
        Matcher valorMatcher = valorPattern.matcher(cadena);

        if (idMatcher.find() && cantidadMatcher.find() && valorMatcher.find()) {
            int id = Integer.parseInt(idMatcher.group());
            String nombre = obtenerNombreProducto(id);
            int cantidad = Integer.parseInt(cantidadMatcher.group());
            double valor = Double.parseDouble(valorMatcher.group());

            if (cantidad <= stockProductos.getOrDefault(id, 0)) {
                Pedido pedido = new Pedido(id, valor, cantidad);
                pedidos.add(pedido);
            } else {
                JOptionPane.showMessageDialog(null,
                        "La cantidad ingresada para el producto ''" + nombre + "'' es mayor al stock disponible.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
    }
    return true;
}
    
    
   private static Map<Integer, Integer> obtenerStockProductos() {
    Map<Integer, Integer> stockProductos = new HashMap<>();
    try {
        Conexion.abrirConexion();
        java.sql.Statement consulta = Conexion.con.createStatement();
        java.sql.ResultSet resultado = consulta.executeQuery("SELECT idProducto, stock FROM productos");
        while (resultado.next()) {
            int idProducto = resultado.getInt("idProducto");
            int stock = resultado.getInt("stock");
            stockProductos.put(idProducto, stock);
        }
        consulta.close();
    } catch (SQLException e) {
    }   catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Pagar.class.getName()).log(Level.SEVERE, null, ex);
        }
    return stockProductos;
}

public static String obtenerNombreProducto(int id) {
    String nombre = null;

    try {
        Conexion.abrirConexion();
        String sql = "SELECT nombre FROM productos WHERE idProducto = ?";
        java.sql.PreparedStatement statement = Conexion.con.prepareStatement(sql);
        statement.setInt(1, id);
        java.sql.ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            nombre = resultSet.getString("nombre");

        }
        
        resultSet.close();
        statement.close();
    } catch (SQLException e) {
    }   catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Pagar.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return nombre;
}
 public static boolean verificarSaldo(int JLTotal) {
    boolean saldoSuficiente = false;  
    try {
        // Establecer la conexión a la base de datos
        Conexion.abrirConexion();

        // Obtener el saldo de la cuenta desde la tabla
        String query = "SELECT Saldo FROM cuenta where NoCuenta = ?";
        java.sql.PreparedStatement statement = Conexion.con.prepareStatement(query);
        statement.setInt(1, Integer.parseInt(String.valueOf(CbCuenta.getSelectedItem())));
        java.sql.ResultSet resultSet = statement.executeQuery();

        // Verificar el saldo
        if (resultSet.next()) {
            int saldo = resultSet.getInt("Saldo");
            if (JLTotal > saldo) {
                // Mostrar advertencia si JLTotal es mayor que el saldo
                JOptionPane.showMessageDialog(null, "El Total es mayor que el saldo disponible.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                
            } else {
                saldoSuficiente = true;
            }
        }

        // Cerrar conexiones
        resultSet.close();
        statement.close();
        Conexion.con.close();
    } catch (SQLException e) {
    }   catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Pagar.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return saldoSuficiente;
}
 
 
       public static void Pagar() {
    ArrayList<String> cadenas = new ArrayList<>();
    String reg = Inicio.registros;
    String reg2[] = reg.split("\n");
    for (int i = 0; i < reg2.length; i++) {
        cadenas.add(reg2[i]);
    }

    ArrayList<Pedido> pedidos = new ArrayList<>();
    pedidos.clear();
    // Expresiones regulares para extraer los valores de id, cantidad y valor
    String idRegex = "(?<=Prod:\\s)(\\d+)";
    String cantidadRegex = "(?<=Cantidad:\\s)(\\d+)";
    String valorRegex = "(?<=Valor\\s)(\\d+)";

    for (String cadena : cadenas) {
        Pattern idPattern = Pattern.compile(idRegex);
        Pattern cantidadPattern = Pattern.compile(cantidadRegex);
        Pattern valorPattern = Pattern.compile(valorRegex);

        Matcher idMatcher = idPattern.matcher(cadena);
        Matcher cantidadMatcher = cantidadPattern.matcher(cadena);
        Matcher valorMatcher = valorPattern.matcher(cadena);

        if (idMatcher.find() && cantidadMatcher.find() && valorMatcher.find()) {
            int id = Integer.parseInt(idMatcher.group());
            int cantidad = Integer.parseInt(cantidadMatcher.group());
            double valor = Double.parseDouble(valorMatcher.group());

            Pedido pedido = new Pedido(id, valor, cantidad);
            pedidos.add(pedido);
        }
    }

    try {
        Conexion.abrirConexion();
        Map<Integer, Integer> stockProductos = obtenerStockProductos();
        int idPedido = Inicio.obtenerIdPedido() + 1;

        String sql = "INSERT INTO prueba (id, cantidad, valor, IdPedido) VALUES (?, ?, ?, ?)";
        java.sql.PreparedStatement statement = Conexion.con.prepareStatement(sql);
        for (Pedido pedido : pedidos) {
            statement.setInt(1, pedido.getId());
            statement.setInt(2, pedido.getCantidad());
            statement.setDouble(3, pedido.getValor());
            statement.setInt(4, idPedido);
            statement.executeUpdate();
        }

        int iddetal = Inicio.obtenerIdCom();
        int idcom = Inicio.obtenerIdDetalle();
        double total = Double.parseDouble(JLTotal.getText().trim());
        int IdCliente = Integer.parseInt(Inicio.JtIde.getText().trim());

        sql = "INSERT INTO pedido2 (IdPedido, total, Estado, IdCliente, IdDetal, IdCom, fechaPedido) VALUES (?, ?, ?, ?, ?, ?, ?)";
        statement = Conexion.con.prepareStatement(sql);
        statement.setInt(1, idPedido);
        statement.setDouble(2, total);
        statement.setString(3, " PA");
        statement.setInt(4, IdCliente);
        statement.setInt(5, idPedido);
        statement.setInt(6, idcom);

// Obtener el valor de tiempo en milisegundos
LocalDateTime fechaActual = LocalDateTime.now();

// Crear el objeto Timestamp
Timestamp timestamp = Timestamp.valueOf(fechaActual);

// Agregar la fecha y hora actual al statement
statement.setTimestamp(7, timestamp);
        statement.executeUpdate();

        int NoCuenta = Integer.parseInt(String.valueOf(CbCuenta.getSelectedItem()));
        sql = "SELECT Saldo FROM cuenta WHERE NoCuenta = ?";
        statement = Conexion.con.prepareStatement(sql);
        statement.setInt(1, NoCuenta);
        ResultSet resultado = statement.executeQuery();

        if (resultado.next()) {
            int saldo = resultado.getInt("Saldo");
            int nuevoSaldo = saldo - Integer.parseInt(JLTotal.getText());
            sql = "UPDATE cuenta SET Saldo = ? WHERE NoCuenta = ?";
            statement = Conexion.con.prepareStatement(sql);
            statement.setInt(1, nuevoSaldo);
            statement.setInt(2, NoCuenta);
            statement.executeUpdate();
        }

        for (Pedido pedido : pedidos) {
            int idProducto = pedido.getId();
            int cantidadPedido = pedido.getCantidad();
            stockProductos = obtenerStockProductos();
            int stockActual = stockProductos.getOrDefault(idProducto, 0);
            if (stockActual >= cantidadPedido) {
                // Restar la cantidad del pedido al stock actual
                int nuevoStock = stockActual - cantidadPedido;
                // Actualizar el valor de stock en el Map
                stockProductos.put(idProducto, nuevoStock);
            }
        }

        for (Map.Entry<Integer, Integer> entry : stockProductos.entrySet()) {
            int idProducto = entry.getKey();
            int nuevoStock = entry.getValue();

            // Actualizar el valor de stock en la tabla "productos"
            sql = "UPDATE productos SET stock = ? WHERE idProducto = ?";
            statement = Conexion.con.prepareStatement(sql);
            statement.setInt(1, nuevoStock);
            statement.setInt(2, idProducto);
            statement.executeUpdate();
            statement.close();
        }
    } catch (HeadlessException | ClassNotFoundException | IllegalAccessException | InstantiationException | NumberFormatException | SQLException ex) {
        ex.printStackTrace();
        // Manejo del error, mostrar un mensaje o realizar alguna acción adicional
    }

    // Imprimir los objetos Pedido
    for (Pedido pedido : pedidos) {
        System.out.println(pedido);
    }

    System.out.println("Realizando pago...");
}
          public static boolean VeriAdmin(String IdCliente, String IdPass) throws SQLException {       
         try {
             Controlador.Conexion.abrirConexion();
             String Pass,Identificacion;
             boolean val=false;
             Statement consulta;
             ResultSet resultado;
             
             consulta = Controlador.Conexion.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
             resultado = consulta.executeQuery(" select IdCliente, Contraseña from clientes where IdCliente= ' "+IdCliente+" '; ");
             
             resultado.first();
             Pass = resultado.getString("Contraseña").trim();
             Identificacion = resultado.getString("IdCliente").trim();
             if(Identificacion.equals("11") && IdPass.equals("admin")){
                 val = true;
             }else {
                 throw new SQLException("El usuario o contraseña no existe, intente otra vez");
                }
             consulta.close();
             resultado.close();
             Controlador.Conexion.cerrarConexion();
             
             return val;
         } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println("Error: " + ex.getMessage());    
             
         }
         
        return false;
    }
          public static boolean VeriUser(String IdCliente, String IdPass) throws SQLException {       
       try {
        Controlador.Conexion.abrirConexion();
        String Pass, Identificacion;
        boolean val = false;
        Statement consulta;
        ResultSet resultado;

        consulta = Controlador.Conexion.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultado = consulta.executeQuery("SELECT IdCliente, Contraseña FROM clientes WHERE IdCliente='" + IdCliente + "';");

        if (resultado.first()) {
            Pass = resultado.getString("Contraseña").trim();
            Identificacion = resultado.getString("IdCliente").trim();
            if (Identificacion.equals(IdCliente.trim()) && IdPass.equals(Pass.trim())) {
                val = true;
            } else {
                throw new SQLException("El usuario o contraseña no existe, intente otra vez");
                
            }
        } else {
            throw new SQLException("El usuario o contraseña no existe, intente otra vez");

        }

        consulta.close();
        resultado.close();
        Controlador.Conexion.cerrarConexion();
        return val;
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
        System.out.println("Error: " + ex.getMessage());
    }

    return false;
    }
          
          public void AgregarPed(){
         try {
             int otrocont = 0;
             Inicio ini = new Inicio();
             if (otrocont >= 20) {
                 
                 ini.BtAgregar.setEnabled(false);
             } else {
                 String selectedItem = ini.CbProd.getSelectedItem().toString();
                 String[] prod = selectedItem.split("\\,");
                 String cant = String.valueOf(ini.jSpinner1.getValue());
                 int value = (Integer) ini.jSpinner1.getValue();
                 
                 String[] productos = new String[2];
                 productos[0] = prod[0];
                 productos[1] = cant;
                 ini.modelo.addRow(productos);
                 String dato = (String) ini.modelo.getValueAt(ini.contador, 1);
                 int dat = Integer.parseInt(dato);
                 ini.contador = ini.contador++;
                 otrocont = otrocont + dat;
                 System.out.println(ini.contador);
                 
             }} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
             Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
         }
          }
          
          public static void irpagar(){
  
         try {
    String pedido, ped = "";
    int suma=0;
             Inicio ini = new Inicio();
             if (ini.modelo.getRowCount() != 0) {
                 Map<String, Integer> Suma = new HashMap<>();
                 
                 for(int i=0; i<ini.modelo.getRowCount();i++){
                     String nombreProd = (String) ini.modelo.getValueAt(i,0);
                     String cantidadStr = (String) ini.modelo.getValueAt(i, 1);
                     int Cantidad = Integer.parseInt(cantidadStr);
                     if(Suma.containsKey(nombreProd)){
                         int stockac = Suma.get(nombreProd);
                         int nuevoStock = stockac + Cantidad;
                         Suma.put(nombreProd, nuevoStock);
                     }else{
                         Suma.put(nombreProd, Cantidad);
                     }
                 }
                 int sumaTotal = 0;
                 for (int cantidad : Suma.values()) {
                     sumaTotal += cantidad;
                 }
                 
                 
                 for(Map.Entry<String, Integer> entry : Suma.entrySet()){
                     String nombreProd = entry.getKey();
                     int stockTot = entry.getValue();
                     pedido = nombreProd + " x " + stockTot + "\n";
                     ped = pedido + ped;
                 }
                 ped = ped+"Total productos:                      "+sumaTotal + "\n";
             } else {
                 JOptionPane.showMessageDialog(null, "No ha hecho ningun pedido");
             }
             JOptionPane.showMessageDialog(null, ped);
             ped = "";
         } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
             Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
         }
          }
}         
         
   
        


