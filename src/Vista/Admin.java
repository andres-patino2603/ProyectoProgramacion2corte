package Vista;
import Controlador.Conexion;
import static Controlador.Conexion.con;
import Modelo.producto;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Admin extends javax.swing.JFrame {
    
            DefaultTableModel modeloAdmin = new DefaultTableModel();
            DefaultTableModel modeloAdmin2 = new DefaultTableModel();
    public Admin() {

            modeloAdmin.setRowCount(0);
            modeloAdmin2.setRowCount(0);
        initComponents();
        modeloAdmin.addColumn("IdPedido");
        modeloAdmin.addColumn("IdCliente");
        modeloAdmin.addColumn("ValorPedido");
        modeloAdmin.addColumn("Estado");
        modeloAdmin.addColumn("Tipo");
        modeloAdmin2.addColumn("IdProducto");
        modeloAdmin2.addColumn("Nombre");
        modeloAdmin2.addColumn("Precio");
        modeloAdmin2.addColumn("Stock");
        this.JTablePed.setModel(modeloAdmin);
        this.JTableProd.setModel(modeloAdmin2);
        LlenarTabla();
        LlenarTabla2();
        
    }
     public void LlenarTabla() {
        Statement consulta;
        ResultSet resultado;
        try {
            Conexion.abrirConexion();
            consulta = con.createStatement();
            resultado = consulta.executeQuery("SELECT idpedido, idcliente, total, estado, IdCom FROM pedido2");

            while (resultado.next()) {
              Object[] fila = new Object[5];
        fila[0] = resultado.getInt("idpedido");
        fila[1] = resultado.getInt("idcliente");
        fila[2] = resultado.getDouble("total");
        fila[3] = resultado.getString("estado");
        fila[4] = resultado.getString("IdCom");
        modeloAdmin.addRow(fila);
            }
        } catch (SQLException e) {
        }       catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
     
       public void LlenarTabla2() {
        Statement consulta;
        ResultSet resultado;
        try {
            Conexion.abrirConexion();
            consulta = con.createStatement();
            resultado = consulta.executeQuery("SELECT idProducto, nombre, precio, stock FROM productos");

            while (resultado.next()) {
              Object[] fila = new Object[4];
        fila[0] = resultado.getInt("idProducto");
        fila[1] = resultado.getString("nombre");
        fila[2] = resultado.getDouble("precio");
        fila[3] = resultado.getInt("stock");

        modeloAdmin2.addRow(fila);
            }
        } catch (SQLException e) {
        }       catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTablePed = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        JtIdProd = new javax.swing.JTextField();
        JtNombreProd = new javax.swing.JTextField();
        JtPrecioProd = new javax.swing.JTextField();
        JtStockProd = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        BtBuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableProd = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador");
        setBackground(new java.awt.Color(204, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        JTablePed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "IdPedido", "IdCliente", "ValorPedido", "Estado", "IdPedidoCom"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTablePed);
        if (JTablePed.getColumnModel().getColumnCount() > 0) {
            JTablePed.getColumnModel().getColumn(0).setResizable(false);
            JTablePed.getColumnModel().getColumn(1).setResizable(false);
            JTablePed.getColumnModel().getColumn(2).setResizable(false);
            JTablePed.getColumnModel().getColumn(3).setResizable(false);
            JTablePed.getColumnModel().getColumn(4).setResizable(false);
        }

        jButton2.setText("Recargar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton2)
                .addGap(0, 54, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pedidos", jPanel2);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("IdProducto:");

        jLabel2.setText("Nombre:");

        jLabel4.setText("Precio:");

        jLabel5.setText("Stock:");

        jButton3.setBackground(new java.awt.Color(171, 172, 200));
        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(171, 172, 200));
        jButton4.setText("Modificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Eliminar.setBackground(new java.awt.Color(171, 172, 200));
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        JtIdProd.setSelectionColor(new java.awt.Color(255, 255, 255));

        JtPrecioProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtPrecioProdActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(171, 177, 200));
        jButton1.setText("Atrás");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BtBuscar.setBackground(new java.awt.Color(171, 172, 200));
        BtBuscar.setText("Buscar");
        BtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JtIdProd)
                    .addComponent(JtPrecioProd, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtStockProd, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(JtIdProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(JtNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(JtPrecioProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(JtStockProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(BtBuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(Eliminar))
                        .addGap(34, 34, 34)
                        .addComponent(jButton1)))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Agregar Productos", jPanel1);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JTableProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "idProducto", "Nombre", "Precio", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableProd.setEnabled(false);
        jScrollPane2.setViewportView(JTableProd);
        if (JTableProd.getColumnModel().getColumnCount() > 0) {
            JTableProd.getColumnModel().getColumn(0).setResizable(false);
            JTableProd.getColumnModel().getColumn(1).setResizable(false);
            JTableProd.getColumnModel().getColumn(2).setResizable(false);
            JTableProd.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 49, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Productos", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Inicio ini = new Inicio();
            ini.setVisible(true);
            setVisible(false);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void JtPrecioProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtPrecioProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtPrecioProdActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Modelo.producto.reg_prod(JtNombreProd.getText().trim(), Double.parseDouble(JtPrecioProd.getText().trim()), Integer.parseInt(JtStockProd.getText().trim()));
        modeloAdmin2.setRowCount(0);
        LlenarTabla2();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void BtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarActionPerformed
      try {
        // Preparar la consulta SQL
        Conexion.abrirConexion();
        String sql = "SELECT * FROM productos WHERE IdProducto = ?";
        java.sql.PreparedStatement statement = con.prepareStatement(sql);
        
        // Establecer el valor del parámetro
        int idProducto = Integer.parseInt(JtIdProd.getText()); // Aquí debes proporcionar el valor de la ID que deseas buscar
        statement.setInt(1, idProducto);
        
        // Ejecutar la consulta
        ResultSet resultSet = statement.executeQuery();
        
        // Variable para verificar si se encontraron resultados
        boolean encontrado = false;
        
        // Recorrer los resultados
        while (resultSet.next()) {
            // Obtener los valores de cada columna en el registro actual
            int id = resultSet.getInt("IdProducto");
            String nombre = resultSet.getString("Nombre");
            double precio = resultSet.getDouble("Precio");
            int stock = resultSet.getInt("Stock");
            
            // Hacer algo con los datos obtenidos
            JtPrecioProd.setText(String.valueOf(precio));
            JtNombreProd.setText(nombre);
            JtStockProd.setText(String.valueOf(stock));
            System.out.println("ID: " + id);
            System.out.println("Nombre: " + nombre);
            System.out.println("Precio: " + precio);
            System.out.println("Stock: " + stock);
            System.out.println("-------------------");
            
            // Se encontraron resultados
            encontrado = true;
        }
        
        // Verificar si se encontraron resultados
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún producto con este ID");
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Ocurrió un error al buscar el producto");
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
    }

    }//GEN-LAST:event_BtBuscarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       modeloAdmin.setRowCount(0);
        LlenarTabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // Preparar la consulta SQL
            String sql = "UPDATE productos SET nombre = ?, precio = ?, stock = ? WHERE IdProducto = ?";
            java.sql.PreparedStatement statement = con.prepareStatement(sql);
            
            // Establecer los nuevos valores de los campos
            String nuevoNombre = JtNombreProd.getText();
            double nuevoPrecio = Double.parseDouble(JtPrecioProd.getText().trim());
            int nuevoStock = Integer.parseInt(JtStockProd.getText());
            int idProducto = Integer.parseInt(JtIdProd.getText()); // Aquí debes proporcionar el valor de la ID del producto a modificar
            
            statement.setString(1, nuevoNombre);
            statement.setDouble(2, nuevoPrecio);
            statement.setInt(3, nuevoStock);
            statement.setInt(4, idProducto);
            
            // Ejecutar la consulta
            int filasAfectadas = statement.executeUpdate();
            
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null,"Los campos se han actualizado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null,"No se encontró ningún registro con la ID especificada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        modeloAdmin2.setRowCount(0);
        LlenarTabla2();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
         try {
        // Establecer la conexión a la base de datos

        // Preparar la consulta SQL para eliminar el registro
        String deleteQuery = "DELETE FROM productos WHERE idProducto = ?";
        java.sql.PreparedStatement statement = con.prepareStatement(deleteQuery);
        int idProducto = Integer.parseInt(JtIdProd.getText());
        statement.setInt(1, idProducto);

        // Ejecutar la consulta
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null,"Registro eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún registro con el ID especificado.");
        }

        // Cerrar la conexión y liberar recursos
        statement.close();
        con.close();
    } catch (SQLException e) {
        System.out.println("Error al eliminar el registro: " + e.getMessage());
    }
         JtNombreProd.setText("");
         JtPrecioProd.setText("");
         JtStockProd.setText("");
        modeloAdmin2.setRowCount(0);
        LlenarTabla2();
    }//GEN-LAST:event_EliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtBuscar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JTable JTablePed;
    private javax.swing.JTable JTableProd;
    private javax.swing.JTextField JtIdProd;
    private javax.swing.JTextField JtNombreProd;
    private javax.swing.JTextField JtPrecioProd;
    private javax.swing.JTextField JtStockProd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
