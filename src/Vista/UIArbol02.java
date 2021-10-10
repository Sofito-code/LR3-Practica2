/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ArbolControlador;
import Modelo.ArbolBinario;
import Modelo.NodoDoble;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Sofito-Chan
 */
public class UIArbol02 extends javax.swing.JFrame {

    /**
     * Creates new form Vista
     */
    public UIArbol02() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("codeIcon.png")));
    }

    public void dibujarArbol() {
        control.iniciar();
        panelArbol.removeAll();
        internalFrame();
        arbol = control.getArbol();
        detallesArbol();
    }

    private void internalFrame() {
        Rectangle tamaño = InternalFrameArbol.getBounds();
        this.InternalFrameArbol = null;
        this.InternalFrameArbol = new JInternalFrame("Arbol Binario", false);
        this.panelArbol.add(InternalFrameArbol, JLayeredPane.DEFAULT_LAYER);
        this.InternalFrameArbol.setToolTipText("Mueveme desde el titulo Arbol Binario");
        this.InternalFrameArbol.setVisible(true);
        this.InternalFrameArbol.setBounds(tamaño);
        this.InternalFrameArbol.setEnabled(false);
        this.InternalFrameArbol.add(control.getLienzo(), BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelArbol = new javax.swing.JPanel();
        InternalFrameArbol = new javax.swing.JInternalFrame();
        panel = new javax.swing.JPanel();
        buttonDetallesArbol = new javax.swing.JButton();
        buttonNuevoArbol = new javax.swing.JButton();
        buttonDetallesNodo = new javax.swing.JButton();
        buttonRecorridos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Consola = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Segunda Práctica - Lógica 3");
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(204, 255, 204));
        setResizable(false);

        panelArbol.setBackground(new java.awt.Color(204, 255, 204));
        panelArbol.setForeground(new java.awt.Color(255, 255, 255));
        panelArbol.setEnabled(false);
        panelArbol.setPreferredSize(new java.awt.Dimension(700, 400));

        InternalFrameArbol.setBackground(new java.awt.Color(255, 255, 255));
        InternalFrameArbol.setBorder(null);
        InternalFrameArbol.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        InternalFrameArbol.setForeground(new java.awt.Color(255, 255, 255));
        InternalFrameArbol.setTitle("Arbol Binario");
        InternalFrameArbol.setToolTipText("");
        InternalFrameArbol.setAutoscrolls(true);
        InternalFrameArbol.setPreferredSize(new java.awt.Dimension(800, 400));
        InternalFrameArbol.setVisible(true);

        javax.swing.GroupLayout InternalFrameArbolLayout = new javax.swing.GroupLayout(InternalFrameArbol.getContentPane());
        InternalFrameArbol.getContentPane().setLayout(InternalFrameArbolLayout);
        InternalFrameArbolLayout.setHorizontalGroup(
            InternalFrameArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 822, Short.MAX_VALUE)
        );
        InternalFrameArbolLayout.setVerticalGroup(
            InternalFrameArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelArbolLayout = new javax.swing.GroupLayout(panelArbol);
        panelArbol.setLayout(panelArbolLayout);
        panelArbolLayout.setHorizontalGroup(
            panelArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArbolLayout.createSequentialGroup()
                .addComponent(InternalFrameArbol, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelArbolLayout.setVerticalGroup(
            panelArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InternalFrameArbol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
        );

        panel.setBackground(new java.awt.Color(204, 255, 204));
        panel.setForeground(new java.awt.Color(255, 255, 255));
        panel.setEnabled(false);

        buttonDetallesArbol.setBackground(new java.awt.Color(102, 255, 102));
        buttonDetallesArbol.setForeground(new java.awt.Color(0, 0, 0));
        buttonDetallesArbol.setText("Detalles del arbol");
        buttonDetallesArbol.setToolTipText("Altura, grado, hijos");
        buttonDetallesArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDetallesArbolActionPerformed(evt);
            }
        });

        buttonNuevoArbol.setBackground(new java.awt.Color(102, 255, 102));
        buttonNuevoArbol.setForeground(new java.awt.Color(0, 0, 0));
        buttonNuevoArbol.setText("Nuevo Arbol");
        buttonNuevoArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNuevoArbolActionPerformed(evt);
            }
        });

        buttonDetallesNodo.setBackground(new java.awt.Color(102, 255, 102));
        buttonDetallesNodo.setForeground(new java.awt.Color(0, 0, 0));
        buttonDetallesNodo.setText("Detalles de un nodo");
        buttonDetallesNodo.setToolTipText("Hijos, hermanos, padre, ancestros, tio , abuelo");
        buttonDetallesNodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDetallesNodoActionPerformed(evt);
            }
        });

        buttonRecorridos.setBackground(new java.awt.Color(102, 255, 102));
        buttonRecorridos.setForeground(new java.awt.Color(0, 0, 0));
        buttonRecorridos.setText("Recorridos");
        buttonRecorridos.setToolTipText("Recorridos (in, pre y pos)");
        buttonRecorridos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRecorridosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("OPCIONES");

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        Consola.setEditable(false);
        Consola.setBackground(new java.awt.Color(255, 255, 255));
        Consola.setColumns(20);
        Consola.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Consola.setForeground(new java.awt.Color(0, 0, 0));
        Consola.setRows(5);
        Consola.setAutoscrolls(false);
        Consola.setFocusable(false);
        jScrollPane1.setViewportView(Consola);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonDetallesArbol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonDetallesNodo, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(buttonNuevoArbol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonRecorridos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(buttonNuevoArbol)
                .addGap(18, 18, 18)
                .addComponent(buttonDetallesArbol)
                .addGap(18, 18, 18)
                .addComponent(buttonRecorridos)
                .addGap(18, 18, 18)
                .addComponent(buttonDetallesNodo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelArbol, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelArbol, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelArbol.getAccessibleContext().setAccessibleName("Arboles Binarios");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDetallesArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDetallesArbolActionPerformed
        detallesArbol();
    }//GEN-LAST:event_buttonDetallesArbolActionPerformed
    private void detallesArbol() {
        detallesArbol = "Detalles del arbol\n\nAltura: " + arbol.altura() + "\nGrado: "
                + arbol.grado() + "\nNúmero de hojas: " + arbol.hojas() + "\nHojas: " 
                + arbol.listaNodoToString(arbol.nodosHoja());
        Consola.setText("");
        Consola.setText(detallesArbol);
    }
    private void buttonNuevoArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNuevoArbolActionPerformed
        UIArbol01 menu = new UIArbol01();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonNuevoArbolActionPerformed

    private void buttonDetallesNodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDetallesNodoActionPerformed
        String nombreNodo = "";
        try{
            nombreNodo = JOptionPane.showInputDialog("Elige el nodo:");
        } catch(NullPointerException e){
            return;
        }
        arbol.limpiarRecorridos();
        String detalles = "";
        String hijos = "";
        String hermano = "";
        String padre = "";
        String ancestros = "";
        String tio = "";
        String abuelo = "";
        NodoDoble nodo = arbol.buscarNodo(nombreNodo);        
        if (nodo == null) {
            JOptionPane.showMessageDialog(rootPane, "No se encontró el nodo.");
        } else {            
            //Hijos
            hijos = "Hijos: ";
            if(arbol.hijos(nodo).equals("[]")){
                hijos += "No tiene hijos";
            } else {
                hijos += arbol.hijos(nodo);
            }
            
            //Padre
            NodoDoble padreNodo = arbol.padre(nodo);
            padre += "\nPadre: ";
            if(padreNodo == null || padreNodo.equals(nodo)){
                padre += "No tiene padre";
            }
            else{
                padre += padreNodo;
            }
            
            //Hermano
            hermano += "\nHermano: ";
            if (arbol.hermano(nodo) == null) {
                hermano += "No tiene hermano";
            } else {                
                hermano += arbol.hermano(nodo);
                int opcion = arbol.esIzorDe(arbol.hermano(nodo));
                switch(opcion){
                    case -1:
                        hermano += "No tiene hermano";
                        break;
                    case 0:
                        hermano += " es el hermano izquierdo";
                        break;
                    case 1:
                        hermano += " es el hermano derecho";
                        break;
                }             
            }
            
            //ancestros            
            ancestros += "\nAncestros: ";
            List<NodoDoble> ancest = arbol.ancestros(nodo);
            
            if (ancest.contains(nodo)){
                ancest.remove(nodo);
            }
            if(ancest.toString().equals("[]")){
                ancestros += "No tiene ancestros";
            } else {
                ancestros += ancest.toString();
            }
            
            //tio
            tio = "\nTio: ";
            if(arbol.tio(nodo) == null){
                tio += "No tiene tio";
            } else {
                tio += arbol.tio(nodo);
            }
            
            //abuelo
            abuelo += "\nAbuelo: ";
            if(arbol.abuelo(nodo) == null || arbol.abuelo(nodo).equals(nodo) || arbol.abuelo(nodo).equals(padreNodo)){
                abuelo += "No tiene abuelo";
            } else {
                abuelo += arbol.abuelo(nodo);
            }

            //impresion
            Consola.setText("");
            detalles = hijos + hermano + padre + ancestros + tio + abuelo;
            Consola.setText(detalles);
        }
    }//GEN-LAST:event_buttonDetallesNodoActionPerformed

    private void buttonRecorridosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRecorridosActionPerformed
        String nombreNodo = "";
        try{
            nombreNodo = JOptionPane.showInputDialog("Elige el nodo desde el cual se mostrarán los recorridos:");
        } catch(NullPointerException e){
            return;
        }
        String in = "InOrden: \n";
        String pre = "PreOrden: \n";
        String pos = "PosOrden: \n";
        String recorridos = "";
        NodoDoble nodo = arbol.buscarNodo(nombreNodo);
        if (nodo == null) {
            JOptionPane.showMessageDialog(rootPane, "No se encontró el nodo.");
        } else {
            arbol.limpiarRecorridos();
            recorridos = in + arbol.recorridoIn(nodo) + "\n\n" + pre + arbol.recorridoPre(nodo) + "\n\n" + pos + arbol.recorridoPos(nodo);
            Consola.setText("");
            Consola.setText(recorridos);
        }
    }//GEN-LAST:event_buttonRecorridosActionPerformed

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
            java.util.logging.Logger.getLogger(UIArbol02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIArbol02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIArbol02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIArbol02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIArbol02().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Consola;
    private javax.swing.JInternalFrame InternalFrameArbol;
    private javax.swing.JButton buttonDetallesArbol;
    private javax.swing.JButton buttonDetallesNodo;
    private javax.swing.JButton buttonNuevoArbol;
    private javax.swing.JButton buttonRecorridos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelArbol;
    // End of variables declaration//GEN-END:variables

    private ArbolControlador control; //CONTROL
    private ArbolBinario arbol;
    private String detallesArbol = "";
    private String resorridos = "";

    public void setControl(ArbolControlador control) {
        this.control = control;
    }
}
