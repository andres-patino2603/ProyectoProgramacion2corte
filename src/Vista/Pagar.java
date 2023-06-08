
package Vista;

import Controlador.Conexion;
import Controlador.Funciones;
import Modelo.Cuentas;
import Modelo.Pedido;
import static Vista.Inicio.BtAgregar;
import static Vista.Inicio.JtIde;
import static Vista.Inicio.obtenerIdCom;
import static Vista.Inicio.obtenerIdPedido;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import java.awt.List;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Pagar extends javax.swing.JFrame {
    private Timer temporizador;
    public Pagar() {
        initComponents();
        
        try {
            System.out.println("ID:"+Inicio.JtIde.getText());
            String id;
            llenarCBCuentas(Inicio.JtIde.getText());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Pagar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public static void llenarCBCuentas(String N) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        N = JtIde.getText().trim();
        try {
            if (!Conexion.abrirConexion()) {
                JOptionPane.showMessageDialog(null, "Error en conexión a base de datos");
            } else {
                CbCuenta.removeAllItems();
                ArrayList mListaCuentas = Conexion.getListaCuentas(N);
                Iterator iterador = mListaCuentas.iterator();
                while (iterador.hasNext()) {
                    Cuentas mCuenta = (Cuentas) iterador.next();
                    CbCuenta.addItem(String.valueOf(mCuenta));

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        Jped = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        CbCuenta = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        BtPagar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        JLTotal = new javax.swing.JLabel();
        BtSeguir = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Jped.setToolTipText("");
        Jped.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Jped.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        CbCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbCuentaActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccionar Cuenta");

        BtPagar.setText("Pagar");
        BtPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPagarActionPerformed(evt);
            }
        });

        jLabel3.setText("Total:");

        JLTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BtSeguir.setText("Seguir comprando");
        BtSeguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSeguirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(30, 30, 30)
                        .addComponent(JLTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Jped, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BtSeguir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel1)))
                        .addContainerGap(144, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(CbCuenta, 0, 285, Short.MAX_VALUE)
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtSeguir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtPagar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(Jped, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel3)
                    .addComponent(JLTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CbCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbCuentaActionPerformed
public static int idPedido=0;
public static int idComp=0;
public static int iddetal=0;
    private void BtPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPagarActionPerformed
      int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea realizar el pago? Una vez pague no podra volver a realizar un pedido hasta el dia siguiente");
                if (confirmacion == JOptionPane.YES_OPTION && Funciones.verificarStock() && Funciones.verificarSaldo(Integer.parseInt(JLTotal.getText()))) {
                    idPedido++;
                    idComp=obtenerIdCom()+1;
                    iddetal++;
                    boolean pedidoHoy = verificarPedidoRealizadoHoy(Integer.parseInt(JtIde.getText()));
                    if(pedidoHoy){
                        JOptionPane.showMessageDialog(null, "Ya ha realizado un pedido hoy. No se puede hacer otro pedido hasta el día siguiente.");
                    }else{
                  Funciones.Pagar();
                    System.out.println("IDPEDIDOOOO" + obtenerIdPedido());
                  ingresarDatosDetalles(obtenerIdCom(), obtenerIdPedido());
                   
                    //verificarStock();
                   // System.out.println("Verificar funcion" + verificarSaldo(Integer.parseInt(JLTotal.getText())));
                    }
                   }
    }//GEN-LAST:event_BtPagarActionPerformed
   
     public static boolean verificarPedidoRealizadoHoy(int idCliente) {
        boolean pedidoRealizadoHoy = false;

        try {
            // Obtener la fecha actual
            LocalDate fechaActual = LocalDate.now();

            // Crear la consulta SQL para verificar si hay un pedido para el cliente en la fecha actual
            String sql = "SELECT COUNT(*) AS count FROM pedido2 WHERE IdCliente = ? AND fechaPedido >= ?";

            // Preparar la consulta
            java.sql.PreparedStatement statement = Conexion.con.prepareStatement(sql);
            statement.setInt(1, idCliente);
            statement.setDate(2, java.sql.Date.valueOf(fechaActual));

            // Ejecutar la consulta
            java.sql.ResultSet resultSet = statement.executeQuery();

            // Obtener el resultado de la consulta
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                pedidoRealizadoHoy = count > 0;
            }

            // Cerrar los recursos
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
        }

        return pedidoRealizadoHoy;
    }
    
   public static void ingresarDatosDetalles(int idDetal, int idPedido) {
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
    String sql = "INSERT INTO detalles (IdDetal, IdPedido, Cantidad, IdProducto) VALUES (?, ?, ?, ?)";
    try (java.sql.PreparedStatement statement = Conexion.con.prepareStatement(sql)) {
        for (Pedido pedido : pedidos) {
            statement.setInt(1, idDetal);
            statement.setInt(2, idPedido);
            statement.setInt(3, pedido.getCantidad());
            statement.setInt(4, pedido.getId());
            statement.executeUpdate();
        }
    }
} catch (SQLException e) {
    // Manejo de excepciones
} catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
    Logger.getLogger(Pagar.class.getName()).log(Level.SEVERE, null, ex);
}
    }
    
   
    private void BtSeguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSeguirActionPerformed
        Inicio.maximo=Inicio.maximo+20;
        BtAgregar.setEnabled(true);
        setVisible(false);
    }//GEN-LAST:event_BtSeguirActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pagar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtPagar;
    private javax.swing.JButton BtSeguir;
    public static javax.swing.JComboBox<String> CbCuenta;
    public static javax.swing.JLabel JLTotal;
    public javax.swing.JLabel Jped;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
