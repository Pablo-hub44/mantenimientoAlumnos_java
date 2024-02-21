/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pFormularios;

import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import pClases.ArregloEstudiantes;
import pClases.Estudiante;

/**
 *
 * @author Pablo Jose
 */
public class frmMantenimiento extends javax.swing.JFrame {

    //objeto de la clase ArregloEstudiantes
    ArregloEstudiantes a = new ArregloEstudiantes();

    /**
     * Creates new form frmMantenimiento
     */
    public frmMantenimiento() {
        initComponents();
        //define el ancho de las coumnas de la tabla
        defineAnchoTabla();

        //llenar el control cboCiclo
        llenaCombo();

        //permite mostrar los registros contenidos en el archivo 
        //Estudiante.txt
        listar();
        btngrabar.setVisible(false);
        btngrabarM.setVisible(false);
        habitaCajas(false);
    }

    //metodo que define los anchos de la tabla talumnos
    void defineAnchoTabla() {
        TableColumn columna;
        columna = tAlumnos.getColumnModel().getColumn(0);
        columna.setPreferredWidth(50);
        columna = tAlumnos.getColumnModel().getColumn(1);
        columna.setPreferredWidth(150);
        columna = tAlumnos.getColumnModel().getColumn(2);
        columna.setPreferredWidth(30);
        columna = tAlumnos.getColumnModel().getColumn(3);
        columna.setPreferredWidth(40);
        tAlumnos.getTableHeader().setReorderingAllowed(false);
        tAlumnos.getTableHeader().setResizingAllowed(false);
        
    }

    //metodo que llena los ciclos en el control cbociclo
    void llenaCombo() {
        cbociclo.addItem("1");
        cbociclo.addItem("2");
        cbociclo.addItem("3");
        cbociclo.addItem("4");
        cbociclo.addItem("5");
        cbociclo.addItem("6");
    }

    //metodo que permite habilitar a inhabilitar el acceso
    //a los controles Jtexfild
    void habitaCajas(boolean opcion) {
        txtcodigo.setEditable(opcion);
        txtnombres.setEditable(opcion);
        txtpension.setEditable(opcion);
        cbociclo.setEnabled(opcion);
    }

    //metodo que permite limpiar los controles Jtexfield
    void limpiaCajas() {
        txtcodigo.setText("");
        txtnombres.setText("");
        txtpension.setText("");
        cbociclo.setSelectedIndex(0);
        
    }

    //metodo que permite limpiar la tabla tAlumno
    void limpiaMatriz() {
        for (int i = 0; i < 10; i++) {
            tAlumnos.setValueAt("", i, 0);
            tAlumnos.setValueAt("", i, 1);
            tAlumnos.setValueAt("", i, 2);
            tAlumnos.setValueAt("", i, 3);
        }
    }

    //metodo ue permite autogenerar un codigo del estudiante
    //con un maximo de 4 cifras por numero autogenerado
    public int autogenerarCodigo() {
        int cod = (int) ((9999 - 1000 + 1) * Math.random() + 1000);
        return cod;
    }

    //metodo que permite listar los registros de los estudiantes
    //al control talumnos
    void listar() {
        if (a.getTamaño() > 0) {
            for (int i = 0; i < a.getTamaño(); i++) {
                Estudiante e = a.obtener(i);
                tAlumnos.setValueAt(e.getCodigo(), i, 0);
                tAlumnos.setValueAt(e.getNombre(), i, 1);
                tAlumnos.setValueAt(e.getCiclo(), i, 2);
                tAlumnos.setValueAt(e.getPension(), i, 3);
                
            }
        }
    }

    //metodos gets
    public int getCodigo() {
        return Integer.parseInt(txtcodigo.getText());//parsearlo de texto a int
    }
    
    public String getNombre() {
        return txtnombres.getText();
    }
    
    public double getPension() {
        return Double.parseDouble(txtpension.getText());
    }
    
    public int getCiclo() {
        return cbociclo.getSelectedIndex() + 1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtnombres = new javax.swing.JTextField();
        txtpension = new javax.swing.JTextField();
        cbociclo = new javax.swing.JComboBox<>();
        txtcodigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tAlumnos = new javax.swing.JTable();
        btningresar = new javax.swing.JButton();
        btnconsultar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btnlistar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btngrabar = new javax.swing.JButton();
        btngrabarM = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("MANTENIMINETO DE ALUMNOS");

        txtnombres.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre y apellidos"));

        txtpension.setBorder(javax.swing.BorderFactory.createTitledBorder("Pension"));
        txtpension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpensionActionPerformed(evt);
            }
        });

        cbociclo.setBorder(javax.swing.BorderFactory.createTitledBorder("Ciclo"));

        txtcodigo.setBorder(javax.swing.BorderFactory.createTitledBorder("Codigo"));

        tAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombres y apellidos", "Ciclo", "Pension"
            }
        ));
        jScrollPane1.setViewportView(tAlumnos);

        btningresar.setText("Ingresar");
        btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarActionPerformed(evt);
            }
        });

        btnconsultar.setText("Consultar");
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });

        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        btnlistar.setText("Listar");
        btnlistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlistarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btngrabar.setText("Grabar");
        btngrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngrabarActionPerformed(evt);
            }
        });

        btngrabarM.setText("GrabarM");
        btngrabarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngrabarMActionPerformed(evt);
            }
        });

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbociclo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtpension, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btningresar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnlistar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btngrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btngrabarM, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(txtnombres))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbociclo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpension, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btningresar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnlistar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btngrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btngrabarM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(84, 84, 84))
        );

        setBounds(0, 0, 748, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void txtpensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpensionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpensionActionPerformed

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        try {
            limpiaCajas();
            limpiaMatriz();
            
            int codigo = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese codigo a buscar: "));
            Estudiante e = a.buscar(codigo);
            if (e != null) {
                tAlumnos.setValueAt(e.getCodigo(), 0, 0);
                tAlumnos.setValueAt(e.getNombre(), 0, 1);
                tAlumnos.setValueAt(e.getCiclo(), 0, 2);
                tAlumnos.setValueAt(e.getPension(), 0, 3);
            } else {
                JOptionPane.showMessageDialog(this, "Codigo de estudiante No Existe");
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error de datos");
            
        }

    }//GEN-LAST:event_btnconsultarActionPerformed

    private void btningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresarActionPerformed
        
        int codigo = autogenerarCodigo();
        txtcodigo.setText("" + codigo);
        habitaCajas(true);
        txtcodigo.setEditable(false);
        txtnombres.requestFocus();
        btngrabar.setVisible(true);
        btngrabarM.setVisible(true);

    }//GEN-LAST:event_btningresarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        
        int codigo = Integer.parseInt(JOptionPane.showInputDialog(this, "ingrese el codigo de estudiante a modificar:"));
        habitaCajas(true);
        limpiaMatriz();
        txtcodigo.setEditable(false);
        
        Estudiante e = a.buscar(codigo);
        if (e != null) {
            txtcodigo.setText("" + e.getCodigo());
            txtnombres.setText(e.getNombre());
            cbociclo.setSelectedIndex(e.getCiclo() - 1);
            txtpension.setText("" + getPension());
            
            txtnombres.requestFocus();
            btngrabarM.setVisible(true);
            btnmodificar.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Codigo de estudiante no existe");
        }

    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        try {
            limpiaCajas();
            limpiaMatriz();
            
            int codigo = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese codigo a eliminar: "));
            Estudiante e = a.buscar(codigo);
            if (e != null) {
                a.eliminar(e);
                a.grabar();
                listar();
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Codigo de estudiante no exite");
        }
        

    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnlistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlistarActionPerformed
        
        listar();

    }//GEN-LAST:event_btnlistarActionPerformed

    private void btngrabarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngrabarMActionPerformed
        
        Estudiante e = a.buscar(getCodigo());
        if (e != null) {
            e.setNombre(getNombre());
            e.setCiclo(getCiclo());
            e.setPension(getPension());
            
            a.grabar();
            listar();
        }
        limpiaCajas();
        habitaCajas(false);
        
        btnmodificar.setVisible(true);
        btngrabarM.setVisible(false);
       // btngrabarM.setVisible(true);
    }//GEN-LAST:event_btngrabarMActionPerformed

//    este es el metodo que guarda los datos
    private void btngrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngrabarActionPerformed
        
        Estudiante e = a.buscar(getCodigo());
        if (e != null) {
            e = new Estudiante(getCodigo(), getNombre(), getCiclo(), getPension());
            
            a.adicionar(e);
            a.grabar();
            listar();
        }
        limpiaCajas();
        habitaCajas(false);
        
       // btngrabarM.setVisible(true);
        btningresar.setVisible(true);
        btngrabar.setVisible(false);
    }//GEN-LAST:event_btngrabarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int s = JOptionPane.showOptionDialog(this, "esta seguro?..", "Matenimiento de alumnos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        
        if (s == 0) {
            System.exit(0);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMantenimiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btngrabar;
    private javax.swing.JButton btngrabarM;
    private javax.swing.JButton btningresar;
    private javax.swing.JButton btnlistar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JComboBox<String> cbociclo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tAlumnos;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtnombres;
    private javax.swing.JTextField txtpension;
    // End of variables declaration//GEN-END:variables
}
