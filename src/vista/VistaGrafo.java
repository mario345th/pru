package vista;

import controlador.*;



public class VistaGrafo extends javax.swing.JDialog {
  
    public VistaGrafo() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(this);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Guardar5 = new javax.swing.JLabel();
        Guardar6 = new javax.swing.JLabel();
        panelGrafo = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnMady = new javax.swing.JButton();
        btnPesos = new javax.swing.JButton();
        btnMCaminos = new javax.swing.JButton();
        btnAnchura = new javax.swing.JButton();
        btnProfundidad = new javax.swing.JButton();
        cbOrigen = new javax.swing.JComboBox<>();
        cbDestino = new javax.swing.JComboBox<>();
        btnCrearArco = new javax.swing.JButton();
        btnRestaurar = new javax.swing.JButton();

        Guardar5.setBackground(new java.awt.Color(91, 192, 222));
        Guardar5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Guardar5.setForeground(new java.awt.Color(255, 255, 255));
        Guardar5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Guardar5.setText("Guardar");
        Guardar5.setAutoscrolls(true);
        Guardar5.setOpaque(true);
        Guardar5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Guardar5MouseClicked(evt);
            }
        });

        Guardar6.setBackground(new java.awt.Color(91, 192, 222));
        Guardar6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Guardar6.setForeground(new java.awt.Color(255, 255, 255));
        Guardar6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Guardar6.setText("Guardar");
        Guardar6.setAutoscrolls(true);
        Guardar6.setOpaque(true);
        Guardar6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Guardar6MouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelGrafo.setBackground(new java.awt.Color(255, 255, 255));
        panelGrafo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelGrafoMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panelGrafoLayout = new javax.swing.GroupLayout(panelGrafo);
        panelGrafo.setLayout(panelGrafoLayout);
        panelGrafoLayout.setHorizontalGroup(
            panelGrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1322, Short.MAX_VALUE)
        );
        panelGrafoLayout.setVerticalGroup(
            panelGrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        textArea.setForeground(new java.awt.Color(0, 51, 204));
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        tabla.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabla);

        btnMady.setBackground(new java.awt.Color(255, 152, 0));
        btnMady.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnMady.setForeground(new java.awt.Color(255, 255, 255));
        btnMady.setText("M-Adyacencia");
        btnMady.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMadyActionPerformed(evt);
            }
        });

        btnPesos.setBackground(new java.awt.Color(139, 195, 74));
        btnPesos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPesos.setForeground(new java.awt.Color(255, 255, 255));
        btnPesos.setText("Pesos");
        btnPesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesosActionPerformed(evt);
            }
        });

        btnMCaminos.setBackground(new java.awt.Color(156, 39, 176));
        btnMCaminos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnMCaminos.setForeground(new java.awt.Color(255, 255, 255));
        btnMCaminos.setText("M-Caminos");
        btnMCaminos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMCaminosActionPerformed(evt);
            }
        });

        btnAnchura.setBackground(new java.awt.Color(255, 102, 102));
        btnAnchura.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAnchura.setForeground(new java.awt.Color(255, 255, 255));
        btnAnchura.setText("Anchura");
        btnAnchura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnchuraActionPerformed(evt);
            }
        });

        btnProfundidad.setBackground(new java.awt.Color(255, 102, 102));
        btnProfundidad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnProfundidad.setForeground(new java.awt.Color(255, 255, 255));
        btnProfundidad.setText("Profundidad");
        btnProfundidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfundidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMady, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMCaminos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnchura, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProfundidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnMady)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMCaminos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAnchura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnProfundidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        cbOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Origen" }));

        cbDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Destino" }));

        btnCrearArco.setBackground(new java.awt.Color(10, 200, 200));
        btnCrearArco.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCrearArco.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearArco.setText("Arco");
        btnCrearArco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearArcoActionPerformed(evt);
            }
        });

        btnRestaurar.setBackground(new java.awt.Color(156, 39, 176));
        btnRestaurar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRestaurar.setForeground(new java.awt.Color(255, 255, 255));
        btnRestaurar.setText("Restaurar");
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(cbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnCrearArco, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addComponent(cbOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCrearArco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
       

    
    private void Guardar5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Guardar5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Guardar5MouseClicked

    private void Guardar6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Guardar6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Guardar6MouseClicked

    private void panelGrafoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelGrafoMousePressed
       

    }//GEN-LAST:event_panelGrafoMousePressed

    private void btnCrearArcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearArcoActionPerformed

    }//GEN-LAST:event_btnCrearArcoActionPerformed

    private void btnMCaminosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMCaminosActionPerformed

    }//GEN-LAST:event_btnMCaminosActionPerformed

    private void btnMadyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMadyActionPerformed

    }//GEN-LAST:event_btnMadyActionPerformed

    private void btnPesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesosActionPerformed

    }//GEN-LAST:event_btnPesosActionPerformed

    private void btnAnchuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnchuraActionPerformed

    }//GEN-LAST:event_btnAnchuraActionPerformed

    private void btnProfundidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfundidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProfundidadActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRestaurarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Guardar5;
    private javax.swing.JLabel Guardar6;
    public javax.swing.JButton btnAnchura;
    public javax.swing.JButton btnCrearArco;
    public javax.swing.JButton btnMCaminos;
    public javax.swing.JButton btnMady;
    public javax.swing.JButton btnPesos;
    public javax.swing.JButton btnProfundidad;
    public javax.swing.JButton btnRestaurar;
    public javax.swing.JComboBox<String> cbDestino;
    public javax.swing.JComboBox<String> cbOrigen;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JPanel panelGrafo;
    public javax.swing.JTable tabla;
    public javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables



}
