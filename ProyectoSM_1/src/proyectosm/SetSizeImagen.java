/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosm;

/**
 *
 * @author dani
 */
public class SetSizeImagen extends javax.swing.JDialog {

    /**
     * Creates new form SetSizeImagen
     */
    public int ancho =0;
    public int alto =0;
    public SetSizeImagen(java.awt.Frame parent, int imgWidthIni, int imgHeightInit){
    super(parent, true);
    initComponents();
    
    }
  public void showDialog()
    {
    setVisible(true);
    
    }
    public int getAncho(){
    return ancho;
    }
    public int getAlto(){
        return alto;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Establece el tamaño de la imagen");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jLabel2.setText("Alto:");
        jPanel1.add(jLabel2);

        jTextField1.setMaximumSize(new java.awt.Dimension(20, 20));
        jTextField1.setMinimumSize(new java.awt.Dimension(20, 20));
        jTextField1.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanel1.add(jTextField1);

        jLabel4.setText("px");
        jPanel1.add(jLabel4);

        jSeparator3.setMinimumSize(new java.awt.Dimension(100, 10));
        jSeparator3.setPreferredSize(new java.awt.Dimension(100, 10));
        jPanel1.add(jSeparator3);

        jLabel3.setText("Ancho:");
        jPanel1.add(jLabel3);

        jTextField2.setMaximumSize(new java.awt.Dimension(20, 20));
        jTextField2.setMinimumSize(new java.awt.Dimension(20, 20));
        jTextField2.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanel1.add(jTextField2);

        jLabel5.setText("px");
        jPanel1.add(jLabel5);

        jButton1.setText("Enviar");
        jPanel1.add(jButton1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SetSizeImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SetSizeImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SetSizeImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SetSizeImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SetSizeImagen dialog = new SetSizeImagen(new javax.swing.JFrame(), 0,0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
