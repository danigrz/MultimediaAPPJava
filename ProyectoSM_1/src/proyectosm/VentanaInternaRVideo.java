/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosm;


import java.awt.Component;
import java.io.File;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;

/**
 *
 * @author Daniel Guerra Ruiz
 * @version 16/6/2015
 * Clase VentanaInternaRVideo
 * Reproductor de video.
 * 
 */
public class VentanaInternaRVideo extends javax.swing.JInternalFrame {

    /**
     * Constructor sin parámetros
     */
    public VentanaInternaRVideo() {
       initComponents();
       super.closable=true;
       super.resizable=true;
       super.maximizable=true;
       super.iconable=true;
    }
    
    private Player player = null;

    public static VentanaInternaRVideo getInstance(File f){
        VentanaInternaRVideo v = new VentanaInternaRVideo(f);
        if(v.player!=null) return v;
        else return null;
    }
    
    public Player getPlayer(){
        if(player!=null)
            return player;
        else
        return null;
 
    }    
    

    
    private VentanaInternaRVideo(File f) {
    initComponents();
    String sfichero = "file:" + f.getAbsolutePath();
    MediaLocator ml = new MediaLocator(sfichero);
    try {
    player = Manager.createRealizedPlayer(ml);
    Component vc = player.getVisualComponent();
    if(vc!=null)add(vc, java.awt.BorderLayout.CENTER);
    Component cpc = player.getControlPanelComponent();
    if(cpc!=null)add(cpc, java.awt.BorderLayout.SOUTH);
    this.pack();
    }catch(Exception e) {
    System.err.println("VentanaInternaJMFPlayer: "+e);
    player = null;
    }
    }
    
    public void play() {
        if (player != null) {
            try {
            player.start();
            } catch (Exception e) {
            System.err.println("VentanaInternaJMFPlayer: "+e);
            }
        } 
    } 
    
     public void stop() {
        if (player != null) {
            try {
            player.close();
            } catch (Exception e) {
            System.err.println("VentanaInternaJMFPlayer: "+e);
            }
        } 
    }    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        stop();
        
        
    }//GEN-LAST:event_formInternalFrameClosed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        stop();
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
