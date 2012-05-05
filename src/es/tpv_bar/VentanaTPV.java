/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar;

import es.tpv_bar.gui.botones.BTCategoria;
import es.tpv_bar.gui.botones.BTLineas;
import es.tpv_bar.gui.botones.BTProducto;
import es.tpv_bar.gui.botones.BTTickets;
import es.tpv_bar.gui.ventanas.AnularTicket;
import es.tpv_bar.gui.ventanas.VentanaCamareros;
import es.tpv_bar.gui.ventanas.VentanaMesas;
import es.tpv_bar.persistencia.modelos.*;
import es.tpv_bar.persistencia.pojos.*;
import es.tpv_bar.prints.Print;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.*;

/**
 *
 * @author aperalta
 */
public class VentanaTPV extends javax.swing.JFrame {

    /**
     * Variables de los modelos de datos
     */
    VentanaTPV instanceOf;
    VentanaMesas mesa;
    CategoriaModel categorias = new CategoriaModel();
    ProductosModel productos = new ProductosModel();
    CajaModel caja = new CajaModel();
    CabezeraModel cabezeras = new CabezeraModel();
    ConfiguracionModel conf = new ConfiguracionModel();
    Print impresora = new Print();
    //CamareroModel camareros = new CamareroModel();
    Camarero camarero;
    public LineaModel lineas = new LineaModel();
    NumberFormat nf = new DecimalFormat("0.00");
    /**
     * Creates new form VentanaTPV
     */
    public VentanaTPV() {
        initComponents();
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setVisible(true);

        this.toFront();
        this.setAlwaysOnTop(true);
        cargarCategorias();
        instanceOf = this;
        this.jTabbedPane1.setIconAt(0,new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/addCafe.png")) );
        this.jTabbedPane1.setIconAt(1,new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/ticketCafe.png")) );  
        this.cargaTickets();
    }

    private void cargarCategorias() {
        ArrayList<Categoria> cat = categorias.getLista();
        for (int i = 0; i < cat.size(); i++) {
            final BTCategoria bt = new BTCategoria(cat.get(i));
            bt.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    cargarProductos(bt.getCategoria());
                }
            });
            this.pCategorias.add(bt);
        }
    }

    private void cargarProductos(Categoria cat) {
        this.pProductos.removeAll();
        ArrayList<Productos> prod = (ArrayList<Productos>) productos.busquedaDatos("categoria", cat);
        for (int i = 0; i < prod.size(); i++) {
            if(!prod.get(i).isActivo())
                continue;
            final BTProducto bt = new BTProducto(prod.get(i));
            
            bt.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (ubicacion != null) {
                        panelLineas.add(new BTLineas(bt.getProducto(), instanceOf));
                        total += bt.getProducto().getPrecio();
                    }
                    txTotal.setText(nf.format(total));
                    panelLineas.updateUI();
                }
            });
            this.pProductos.add(bt);
        }
        this.pProductos.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        pCategorias = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pProductos = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        txTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jToolBar7 = new javax.swing.JToolBar();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelLineas = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jToolBar5 = new javax.swing.JToolBar();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jToolBar6 = new javax.swing.JToolBar();
        jButton7 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jSeparator8 = new javax.swing.JSeparator();
        jToolBar3 = new javax.swing.JToolBar();
        jToolBar4 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        lbUbicacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pCategorias.setLayout(new java.awt.GridLayout(0, 3));
        jScrollPane2.setViewportView(pCategorias);

        pProductos.setLayout(new java.awt.GridLayout(0, 3, 3, 3));
        jScrollPane3.setViewportView(pProductos);

        jToolBar1.setFloatable(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/iconoComedor.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/iconoTerraza.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/iconoBarra.png"))); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jToolBar2.setFloatable(false);

        txTotal.setBackground(new java.awt.Color(1, 1, 1));
        txTotal.setEditable(false);
        txTotal.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txTotal.setForeground(new java.awt.Color(255, 51, 0));
        txTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txTotal.setText("0.0");
        txTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTotalActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(26, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/leo.png"))); // NOI18N
        jLabel1.setText("La Tasca de leo");
        jLabel1.setToolTipText("");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/1334848821_cashbox.png"))); // NOI18N
        jButton6.setText("Abrir Caja");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jToolBar7.setFloatable(false);

        jButton5.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/1335695322_java_src.png"))); // NOI18N
        jButton5.setText("Ticket");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar7.add(jButton5);

        panelLineas.setLayout(new javax.swing.BoxLayout(panelLineas, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(panelLineas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                    .addComponent(jToolBar7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 3, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("En Mesa", jPanel2);

        jPanel1.setAutoscrolls(true);

        jToolBar5.setFloatable(false);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/32money.png"))); // NOI18N
        jButton8.setText("Cobrar");
        jButton8.setFocusable(false);
        jButton8.setHideActionText(true);
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar5.add(jButton8);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/1335698153_select.png"))); // NOI18N
        jButton9.setText("Sel.Todo");
        jToolBar5.add(jButton9);

        jToolBar6.setFloatable(false);

        jButton7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/1335695344_cup_delete.png"))); // NOI18N
        jButton7.setText("Anular");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar6.add(jButton7);

        jPanel3.setAutoscrolls(true);
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane4.setViewportView(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(jToolBar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane4)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToolBar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tickets", jPanel1);

        jToolBar3.setFloatable(false);

        jToolBar4.setFloatable(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/1334673090_Log Out.png"))); // NOI18N
        jButton1.setText("Cerrar");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar4.add(jButton1);

        lbUbicacion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/iconoComedor24.png"))); // NOI18N
        lbUbicacion.setText("Ubicacion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lbUbicacion)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator8))
                                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 502, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbUbicacion)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        mesa = new VentanaMesas(this, true, 2);
        mesa.setVisible(true);
        lbUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/iconoComedor24.png")));

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new VentanaMesas(this, true, 1).setVisible(true);
        lbUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/iconoTerraza24.png")));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new VentanaMesas(this, true, 3).setVisible(true);
        lbUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/tpv_bar/gui/resources/iconoBarra24.png")));
    }//GEN-LAST:event_jButton4ActionPerformed
    double totalCab = 0.0;
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new VentanaCamareros(this, true).setVisible(true);
        totalCab = 0.0;
        Component[] c = this.panelLineas.getComponents();
        Cabezera cab = new Cabezera();
        cab.setCamarero(camarero);
        cab.setCod(conf.getCod());
        cab.setFecha(new Date());
        cab.setEstado(0);

        cabezeras.saveDato(cab);
        for (int i = 0; i < c.length; i++) {
            BTLineas bt = (BTLineas) c[i];
            if (bt.isSelect()) {
                totalCab += bt.getLinea().getTotal();
                bt.getLinea().setCabezera(cab);
                bt.getLinea().setCobrado(1);
                lineas.saveDato(bt.getLinea());
                panelLineas.remove(bt);
            }
        }
        cab.setTotal(totalCab);
        cabezeras.saveDato(cab);
     
        impresora.setImpresora(((Configuracion) conf.busquedaDato(1)).getValue());
        impresora.setEtiqueta("C:\\tpv\\jaspers\\ticket.jasper");
        impresora.setCabezera(cab);
        impresora.setUbi(ubicacion);
        impresora.startPrint();
        this.panelLineas.updateUI();
        cargaTickets();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            /*
             * Create an array of PrintServices
             */
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            int selectedService = 0;
            /*
             * Scan found services to see if anyone suits our needs
             */
            for (int i = 0; i < services.length; i++) {
                if (services[i].getName().equals(((Configuracion) conf.busquedaDato(2)).getValue())) {
                    /*
                     * If the service is named as what we are querying we select it
                     */
                    selectedService = i;
                    break;
                }
            }
            PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
            char[] a = {0x1b,0x70,0x00,0x19,0xff};
            
            String zplCommand ="";
            for (int i = 0; i<a.length;i++){
                zplCommand += a[i];
            }

    // convertimos el comando a bytes
            byte[] by = zplCommand.getBytes();
            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
            Doc doc = new SimpleDoc(by, flavor, null);

    // creamos el printjob
            DocPrintJob job = printService.createPrintJob();

    // imprimimos
            job.print(doc, null);
            /**
             * impresora.setImpresora(((Configuracion)conf.busquedaDato(2)).getValue());
             * impresora.setEtiqueta("C:\\tpv\\jaspers\\enBlanco.jasper");
             * //impresora.setCabezera(cab); //impresora.setUbi(ubicacion);
             * impresora.abrirCaja(); *
             */
        } catch (PrintException ex) {
            Logger.getLogger(VentanaTPV.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new AnularTicket(this, true).setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txTotalActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaTPV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaTPV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaTPV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaTPV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VentanaTPV().setVisible(true);
            }
        });
    }

    public void setUbicacion(Ubicacion ubicacion) {

        this.panelLineas.removeAll();
        this.ubicacion = ubicacion;
        this.lbUbicacion.setText(ubicacion.getNombre());
        this.lineasUbi = (ArrayList<Linea>) lineas.getLineasUbicacion(ubicacion);
        System.out.println("Ubicacion: " + this.lineasUbi.size());
        total = 0.0;
        for (int i = 0; i < lineasUbi.size(); i++) {
            Linea l = lineasUbi.get(i);
            panelLineas.add(new BTLineas(l, instanceOf));
            total += l.getTotal();
        }
        this.panelLineas.updateUI();
        this.txTotal.setText(nf.format(total));
    }

    public void cargaTickets(){
        this.jPanel3.removeAll();
        this.tickets = (ArrayList<Cabezera>) cabezeras.getTicketsSC();
        System.out.println("Tickets: " + this.tickets.size());
        total = 0.0;
        for (int i = 0; i < tickets.size(); i++) {
            Cabezera l = tickets.get(i);
            jPanel3.add(new BTTickets(instanceOf,l));
            
        }
        this.jPanel3.updateUI();
    
    }
    public void removeTicket(BTTickets btCab){
        this.jPanel3.remove(btCab);
        this.jPanel3.updateUI();
    }
    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void eliminarLinea(Linea l) {
        LineaModel lineas = new LineaModel();
        Linea li = (Linea) lineas.busquedaDato(l.getIdLinea());
        lineas.removeDato(li);
        this.setUbicacion(ubicacion);
    }

    public void actualizarLinea(Linea l) {
        System.out.println(l.isInvitacion());
        lineas.updateDato(l);
        l = (Linea) lineas.busquedaDato(l.getIdLinea());
        System.out.println(l.isInvitacion());
        this.setUbicacion(ubicacion);
    }
    ArrayList<Cabezera>tickets;
    ArrayList<Linea> lineasUbi;
    Ubicacion ubicacion = null;
    Double total = 0.0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JToolBar jToolBar7;
    private javax.swing.JLabel lbUbicacion;
    private javax.swing.JPanel pCategorias;
    private javax.swing.JPanel pProductos;
    private javax.swing.JPanel panelLineas;
    private javax.swing.JTextField txTotal;
    // End of variables declaration//GEN-END:variables

    public Camarero getCamarero() {
        return camarero;
    }

    public void setCamarero(Camarero camarero) {
        this.camarero = camarero;
    }
}
