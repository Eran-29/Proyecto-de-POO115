
package proyecto.de.poo115.ui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto.de.poo115.dao.VehiculoDAO;
import proyecto.de.poo115.logica.VehiculoFunciones;
import proyecto.de.poo115.modelos.Vehiculo;

public class FormGestionVehiculos extends javax.swing.JFrame {

// 1. DECLARAMOS LOS "CEREBROS"
    private final VehiculoDAO dao;
    private final VehiculoFunciones logica;

    // 2. DECLARAMOS UNA VARIABLE PARA GUARDAR EL ID
    
    private String idSeleccionado;

    /**
     * creamos un nuevo form FormGestionVehiculos
     */
    public FormGestionVehiculos() {
        
        
        initComponents(); // Esto lo pone NetBeans
        this.setLocationRelativeTo(null); // Centrar la ventana

        // 3. INICIALIZAMOS LOS "CEREBROS"
        this.dao = new VehiculoDAO();
        this.logica = new VehiculoFunciones(this.dao); // Le pasamos el DAO

        // 4. Llama a este método para llenar la tabla al abrir
        cargarTabla();
        
        
    }
    private void cargarTabla() {
        // 1. Obtenemos el "modelo" de la tabla (la estructura)
       
        DefaultTableModel modeloTabla = (DefaultTableModel) jTable1.getModel();
        
        // 2. Limpiamos la tabla de datos anteriores
        modeloTabla.setRowCount(0);

        // 3. Pedimos los datos a la Lógica
        List<Vehiculo> vehiculos = logica.obtenerTodos();

        // 4. Recorremos la lista y añadimos cada vehículo como una fila
        for (Vehiculo v : vehiculos) {
            Object[] fila = {
                v.getId(), // Ponemos el ID de Mongo en la Col 0
                v.getMarca(),
                v.getModelo(),
                v.getAnio(),
                v.getTipo(),
                v.getPrecioDia(),
                v.isDisponible() ? "Disponible" : "Alquilado" // Ternario para el boolean
            };
            modeloTabla.addRow(fila);
        }
        
        // 5. Ocultamos la columna del ID (es feo para el usuario)
        
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tblVehiculos = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtCodi = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtMar = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        txtMod = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        txtAn = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        txtTip = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        txtPrecioDi = new javax.swing.JLabel();
        txtPrecioDia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVehiculosMouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MongoID", "Codigo", "Marca", "Modelo", "Año", "Precio/Dia", "Estado"
            }
        ));
        tblVehiculos.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Vehiculo"));

        txtCodi.setText("Código:");

        txtMar.setText("Marca:");

        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });

        txtMod.setText("Modelo:");

        txtAn.setText("Año:");

        txtAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnioActionPerformed(evt);
            }
        });

        txtTip.setText("Tipo:");

        txtPrecioDi.setText("Precio/Día");

        jLabel8.setText("Estado:");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMod, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodi, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTip, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioDi, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecioDia, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar)
                        .addGap(12, 12, 12)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiar)))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodi, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMod, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAn)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTip)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioDi, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(tblVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tblVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
                                          
    try {
        // 1. Recoger datos de los JTextFields
        Vehiculo v = new Vehiculo();
v.setCodigo(txtCodigo.getText()); // Asumiendo que Codigo es String (ej. Placa)
v.setMarca(txtMarca.getText());
v.setModelo(txtModelo.getText());

// --- APLICAR CONVERSIÓN DE TIPO ---
v.setAnio(Integer.parseInt(txtAnio.getText()));
v.setPrecioDia(Double.parseDouble(txtPrecioDia.getText()));
// ---------------------------------

v.setTipo(txtTipo.getText()); // Asumiendo que es String
v.setEstado(cmbEstado.getSelectedItem().toString());

        // 2. Llamar a la Lógica para registrar
        logica.registrarVehiculo(v);

        // 3. Aviso de Éxito
        JOptionPane.showMessageDialog(this, "Vehículo guardado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        // 4. Actualizar la tabla y limpiar campos
        cargarTabla();
        limpiarCampos();

    }catch (IllegalArgumentException ex) {
        // Captura el error de validación de tu clase Funciones
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de Validación", JOptionPane.WARNING_MESSAGE);
    }
        // Captura si el usuario pone "hola" en el año
        
    }//GEN-LAST:event_btnGuardarActionPerformed
private void limpiarCampos() {
        
        txtCodigo.setText(""); // Código (Aunque el modelo no lo tiene, lo limpiamos)
        txtMarca.setText(""); // Marca
        txtModelo.setText(""); // Modelo
        txtAnio.setText(""); // Año
        txtTipo.setText(""); // Tipo
        txtPrecioDia.setText(""); // PrecioDia
        cmbEstado.setSelectedItem("Disponible"); // Estado
        
        this.idSeleccionado = null; // Quita la selección
    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
                                                   
    if (this.idSeleccionado == null) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un vehículo de la tabla.", "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // 1. Pedir confirmación
    int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este vehículo?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        // 2. Llamar a la lógica
        logica.eliminarVehiculo(this.idSeleccionado);

        // 3. Avisar y refrescar
        JOptionPane.showMessageDialog(this, "Vehículo eliminado.");
        cargarTabla();
        limpiarCampos();
    }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioActionPerformed

    private void tblVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVehiculosMouseClicked
                                      
    // Usando jTable1 para obtener los valores
int fila = jTable1.getSelectedRow();
if (fila == -1) return;

this.idSeleccionado = jTable1.getValueAt(fila, 0).toString(); // MongoID

// Usando los JTextFields corregidos y sin conversión para MOSTRAR
txtCodigo.setText(jTable1.getValueAt(fila, 1).toString());
txtMarca.setText(jTable1.getValueAt(fila, 2).toString());
txtModelo.setText(jTable1.getValueAt(fila, 3).toString());
txtAnio.setText(jTable1.getValueAt(fila, 4).toString());
txtTipo.setText(jTable1.getValueAt(fila, 5).toString());
txtPrecioDia.setText(jTable1.getValueAt(fila, 6).toString());
cmbEstado.setSelectedItem(jTable1.getValueAt(fila, 7).toString());

    }//GEN-LAST:event_tblVehiculosMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
                                                  
    if (this.idSeleccionado == null) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un vehículo de la tabla.", "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        // 1. Recoger datos de los JTextFields
        Vehiculo v = new Vehiculo();
v.setCodigo(txtCodigo.getText()); // Asumiendo que Codigo es String (ej. Placa)
v.setMarca(txtMarca.getText());
v.setModelo(txtModelo.getText());

// --- APLICAR CONVERSIÓN DE TIPO ---
v.setAnio(Integer.parseInt(txtAnio.getText()));
v.setPrecioDia(Double.parseDouble(txtPrecioDia.getText()));
// ---------------------------------

v.setTipo(txtTipo.getText()); // Asumiendo que es String
v.setEstado(cmbEstado.getSelectedItem().toString());
        // 2. Llamar a la Lógica para actualizar
        logica.actualizarVehiculo(v);

        // 3. Aviso de Éxito
        JOptionPane.showMessageDialog(this, "Vehículo actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        // 4. Actualizar la tabla y limpiar campos
        cargarTabla();
        limpiarCampos();

    } catch (IllegalArgumentException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de Validación", JOptionPane.WARNING_MESSAGE);
    }

    }//GEN-LAST:event_btnEditarActionPerformed

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
            java.util.logging.Logger.getLogger(FormGestionVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormGestionVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormGestionVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormGestionVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormGestionVehiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable jTable1;
    private javax.swing.JScrollPane tblVehiculos;
    private javax.swing.JLabel txtAn;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JLabel txtCodi;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JLabel txtMar;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JLabel txtMod;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JLabel txtPrecioDi;
    private javax.swing.JTextField txtPrecioDia;
    private javax.swing.JLabel txtTip;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
