/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.dgr.iu;

import sm.dgr.graficos.Linea2D;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.TexturePaint;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.awt.image.BufferedImage;
import static java.lang.Math.abs;
import static java.lang.Math.min;
import java.util.ArrayList;
import sm.dgr.graficos.DGRShape;
import sm.dgr.graficos.MiPoligonoEstrellado2D;
import sm.dgr.graficos.MiElipse2D;
import sm.dgr.graficos.MiLinea2D;
import sm.dgr.graficos.MiLineaCurva2D;
import sm.dgr.graficos.MiRectangulo2D;
import sm.dgr.graficos.MiRectanguloRedondeado2D;
import sm.dgr.graficos.MiLineaParalela2D;


/**
 *
 * @author Daniel Guerra Ruiz
 * @version 16/6/2015
 * Class Lienzo2D es el liezo donde se pintarán todas las figuras de la clase abstracta DGRShape
 * @see DGRShape
 */

public class Lienzo2D extends javax.swing.JPanel {
  
    private Point p1,p2;
    private int caso;
    private int altura;
    private int anchura;
    private Color color;
    private Color colorUno;

    public Color getColorUno() {
        return colorUno;
    }

    public void setColorUno(Color colorUno) {
        this.colorUno = colorUno;
    }

    public Color getColorDos() {
        return colorDos;
    }

    public void setColorDos(Color colorDos) {
        this.colorDos = colorDos;
    }
    private Color colorDos;
    private boolean relleno;
    private boolean transparencia;
    private BufferedImage img;
    private boolean gradiente;
    private boolean angulo;
    private float transparenciaGradual = 1;
    private int tipoTrazo;

    public int getTipoTrazo() {
        return tipoTrazo;
    }

    public void setTipoTrazo(int tipoTrazo) {
        this.tipoTrazo = tipoTrazo;
    }

    public float getTransparenciaGradual() {
        return transparenciaGradual;
    }

    public void setTransparenciaGradual(float t) {
        this.transparenciaGradual = t;
    }


    private boolean alisar;
    private boolean editar;
    private boolean borrar;    
    int formaActiva;
    Graphics2D g2d = null;

float patronDiscontinuidad[] = {15.0f, 15.0f};

int trazo= 1;
ArrayList<DGRShape> vShape = new ArrayList();
DGRShape s;


    public boolean isAngulo() {
        return angulo;
    }

    public void setAngulo(boolean angulo) {
        this.angulo = angulo;
    }

    /**
     * Constructor de la clase Lienzo2D
     */
    public Lienzo2D() {
        initComponents();
    }
    
    /**
     * Metodo setTrazo
     * Asgina el grosor en el lienzo
     * @param trazo Stroke
     */

    public void setTrazo(int trazo) {
        this.trazo = trazo;
    }

    /**
     * Metodo isGradient
     * Devuelve booleano de gradiente 
     * @return boolean
     */
   
    public boolean isGradiente() {
        return gradiente;
    }

    /**
     * Metodo setGradiente 
     * Asigna valor a si tiene gradiente
     * @param gradiente Boolean
     */
    public void setGradiente(boolean gradiente) {
        this.gradiente = gradiente;
    }
    
    /**
     * Metodo getImg
     * Devuelve el BufferedImage que usa el objeto a pintar como textura
     * @return BufferedImage
     */

    public BufferedImage getImg() {
        return img;
    }
    
    /**
     * Metodo setImg
     * Asigna un BufferedImage para asignar como textura al objeto a pintar
     * @param img BufferedImage
     */

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    /**
     * Metodo setBorrar
     * Limpia el vector de vShape y borra todas las figuras pintadas
     * @param b boolean
     */

    public void setBorrar(boolean b){
        if(b==true){
            vShape= new ArrayList();
            repaint();
        }
    }
    
    /**
     * Metodo setFormaActiva
     * Asigna la forma activa seleccionada para pintar la forma seleccionada
     * @param caso integer
     */
    
    public void setFormaActiva(int caso){
        this.formaActiva = caso;
    }
   
    /**
     * metodo setP1
     * Asigna valor al punto1
     * @param p Point
     */
    
    public void setP1(Point p){
        this.p1 = new Point(p);
    }
    
    /**
     * metodo setP2
     * Asigna valor al punto2
     * @param p Point
     */
    
    public void setP2(Point p){
        this.p2 = new Point(p);
    }

    public void setAlisar(boolean a){
        this.alisar=a;
    }
      
    /**
     * Metodo getAlisar
     * devuelve booleano de si esta activada para alisar
     * @return boolean
     */
    
    public boolean getAlisar(){  
        return this.alisar;
    }
    
    /**
     * Metodo setEditar
     * Asigna booleano si se va a a editar
     * @param a boolean
     */
    
    
    public void setEditar(boolean a){
        this.editar=a;
    }
    
    /**
     * Metodo getEditar
     * Devuelve booleano si esta activada la edicion
     * @return boolean
     */
    
    public boolean getEditar(){
        return this.editar;
    }
    
    /**
     * Metodo setColor
     * Asigna color a la figura a pintar
     * @param c Color
     */
    
    public void setColor(Color c){
        this.color = c;
    }
    
    /**
     * Metodo getColor
     * Devuelve el color
     * @return color
     */
    
    public Color getColor(){
        return this.color;
    }
    
    /**
     * Metodo setRelleno
     * Asigna valor booleano para relleno
     * @param r boolean
     */
    
    public void setRelleno(boolean r){
        this.relleno=r;
    }
    
    /**
     * Metodo getRelleno
     * Devuelve valor booleano si esta activado el relleno
     * @return boolean
     */
    
    public boolean getRelleno(){
        return this.relleno;
    }
    
    
    /**
     * Metodo setTransparencia
     * Asigna valor booleano si esta activa la transparencia
     * @param t boolean
     */
    
    public void setTransparencia(boolean t){
     this.transparencia=t; 
    }    
   
    /**
     * Metodo getTransparencia
     * Devuelve valor booleano si esta activada la transparencia
     * @return boolean
     */    
    
    public boolean getTransparencia(){
       return this.transparencia;
    }
    
    
    /**
     * Metodo paint
     * Se encarga de dibujar todas las figuras
     * @param g Graphics
     */

    public void paint(Graphics g){  
        super.paint(g);
        g2d = (Graphics2D)g;
        if(vShape !=null){
            for(DGRShape s: vShape){                    
                if(s instanceof MiLinea2D){
                    ((MiLinea2D)s).draw(g2d);
                }
                if(s instanceof MiRectangulo2D){    
                ((MiRectangulo2D)s).draw(g2d);
                }
                if(s instanceof MiElipse2D){
                ((MiElipse2D)s).draw(g2d);
                } 
                if(s instanceof MiRectanguloRedondeado2D){
                ((MiRectanguloRedondeado2D)s).draw(g2d);
                } 
                
                if(s instanceof MiLineaCurva2D){
                    ((MiLineaCurva2D)s).draw(g2d);
                }
                
                if(s instanceof MiPoligonoEstrellado2D){
                    ((MiPoligonoEstrellado2D)s).draw(g2d);
                }
                
                if(s instanceof MiLineaParalela2D){
                    ((MiLineaParalela2D)s).draw(g2d);
                }
            }
        }
    }
    
    /**
     * Metodo getSelectedShape
     * Se encarga de comprobar si el punto Point2D contiene alguna de las formas de la clase DGRShape
     * @param p Point2D
     * @return DGRShape
     */
    
    public DGRShape getSelectedShape(Point2D p){
        for(DGRShape s:vShape){
            if(((DGRShape)s).contains(p)){
                return s;  
            }    
        }
        return null;
    }
    
    /**
     * Metodo setLocation
     * Se encarga de posicionar en el nuevo lugar a las figuras
     * @param s DGRShape
     * @param posicion Point2D
     */

    public void setLocation(DGRShape s, Point2D posicion){

        Point2D.Double nuevaposicion;
        double x = posicion.getX();
        double y = posicion.getY();
        double ancho, alto;

        if ((s instanceof MiLinea2D)) {
             ((MiLinea2D)s).getLinea().setLocation(posicion);
        }
        if ((s instanceof MiLineaCurva2D)) {
             ((MiLineaCurva2D)s).getLinea().setLocation(posicion);
        }
         if(s instanceof MiRectanguloRedondeado2D){
                Shape aux = ((MiRectanguloRedondeado2D)s).getRectanguloRedondeado();
                RectangularShape rs = (RectangularShape)aux;
                ancho = rs.getWidth();
                alto = rs.getHeight();
                nuevaposicion = new Point2D.Double(posicion.getX()- (ancho/2), posicion.getY()-(alto/2));
                rs.setFrame(nuevaposicion,new Dimension((int)rs.getWidth(), (int)rs.getHeight()));     

         }

        if(s instanceof MiRectangulo2D){
                Shape aux = ((MiRectangulo2D)s).getRectangulo();
                RectangularShape rs = (RectangularShape)aux;
                ancho = rs.getWidth();
                alto = rs.getHeight();
                nuevaposicion = new Point2D.Double(posicion.getX()- (ancho/2), posicion.getY()-(alto/2));
                rs.setFrame(nuevaposicion,new Dimension((int)rs.getWidth(), (int)rs.getHeight()));
        }

        if(s instanceof MiElipse2D){
            Shape aux = ((MiElipse2D)s).getElipse();
            RectangularShape rs = (RectangularShape)aux;
            ancho = rs.getWidth();
            alto = rs.getHeight();
            nuevaposicion = new Point2D.Double(posicion.getX()- (ancho/2), posicion.getY()-(alto/2));
            rs.setFrame(nuevaposicion,new Dimension((int)rs.getWidth(), (int)rs.getHeight()));
        }
        
        if(s instanceof MiPoligonoEstrellado2D){
            nuevaposicion = new Point2D.Double(posicion.getX(), posicion.getY());
            ((MiPoligonoEstrellado2D)s).setPosicion(nuevaposicion);
    
        }
        
    


    }
 
    /**
     * Metodo createShape
     * Se encarga de crear los shapes correspondientes segun la forma activa seleccionada
     * @param p1 Point
     * @param p2 Point
     * @param c Color
     * @param relleno boolean
     * @param compo boolean
     * @param st Stroke
     * @param tipotrazo
     * @param r boolean
     * @param grad boolean
     * @param ang
     * @param imagen BufferedImage
     * @param c1
     * @param gradual
     * @param c2
     * @return DGRShape
     */
 
    public DGRShape createShape(Point p1, Point p2, Color c,boolean relleno, boolean compo, int st,int tipotrazo, boolean r,boolean grad,boolean ang,Color c1, Color c2,float gradual,BufferedImage imagen){

        int alto=0;
        int ancho=0;

        switch (formaActiva){
            case 0: //lapiz          
                s = new MiElipse2D(p1.x,p1.y,1.0D,1.0D,c,relleno, compo, st,tipotrazo ,r,grad,ang,c1,c2,gradual,imagen);
                
                break;

            case 1: //linea
                s = new MiLinea2D(p1,p2,c,relleno, compo, st,tipotrazo, r,grad,ang,c1,c2,gradual,imagen);
                
                break;

            case 2: //rectangulo
               if(this.p1!=null && this.p2!=null){ 
                alto = abs(p2.y-p1.y);
                ancho = abs(p2.y-p1.y);                  
                s = new MiRectangulo2D((double)p1.x,(double)p1.y,(double)ancho,(double)alto,c,relleno, compo, st,tipotrazo, r,grad,ang,c1,c2,gradual,imagen);
               }
               break;

            case 3: //ovalo
                if(this.p1!=null && this.p2!=null){
                alto = abs(p2.y-p1.y);
                ancho = abs(p2.y-p1.y);
                s = new MiElipse2D((double)p1.x,(double)p1.y,(double)ancho,(double)alto,c,relleno, compo, st,tipotrazo, r,grad,ang,c1,c2,gradual,imagen);
                }
                break; 

            case 4: //rectangulo redondeado
                s = new MiRectangulo2D();
                alto = abs(p2.y-p1.y);
                ancho = abs(p2.y-p1.y);   
                s = new MiRectanguloRedondeado2D((double)p1.x,(double)p1.y,(double)ancho,(double)alto,c,relleno, compo, st,tipotrazo, r,grad,ang,c1,c2,gradual,imagen);
                break;
                
            case 5: //Linea Curva
                s = new MiLineaCurva2D(p1,p2,c,relleno, compo, st,tipotrazo, r,grad,ang,c1,c2,gradual,imagen);
                break;   
                
            case 6:
                s = new MiPoligonoEstrellado2D((double)p1.x,(double)p1.y,(double)ancho,(double)alto,c,relleno, compo, st,tipotrazo, r,grad,ang,c1,c2,gradual,imagen);
                break;
            
            case 7:
                s = new MiLineaParalela2D(p1,p2,(double)ancho,(double)alto,c,relleno, compo, st,tipotrazo, r,grad,ang,c1,c2,gradual,imagen);
                break; 

        }
        return s;
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:      
        if(editar==false){        
                if(formaActiva==0){
                    p1=evt.getPoint();
                    p2=evt.getPoint();
                    s = createShape(p1,p2,color,relleno, transparencia, trazo,tipoTrazo, alisar,gradiente,angulo,colorUno,colorDos,transparenciaGradual,img);
                    vShape.add(s);
                    repaint();
                }
                if(formaActiva==6){
                    p1=evt.getPoint();
                    p2=evt.getPoint();                    
                    s = createShape(p1,p2,color,relleno, transparencia, trazo,tipoTrazo, alisar,gradiente,angulo,colorUno,colorDos,transparenciaGradual,img);
                    vShape.add(s);
                    repaint();
                }
                
                
                
        }
        else{
            Point p1= evt.getPoint();
            s= getSelectedShape(p1); 
            if(s instanceof MiLineaCurva2D){
                ((MiLineaCurva2D)s).setCurva(p1);
                    repaint();
//                ((MiLinea2D)s).setAtributos(color,transparencia,trazo, alisar, gradiente, img);
            }
                    
                
        }
       
    }//GEN-LAST:event_formMouseClicked

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        // TODO add your handling code here:
        p2= evt.getPoint(); 
        if(editar==false){
            if(p1!=null && p2!=null){
                s = createShape(p1,p2,color,relleno, transparencia, trazo,tipoTrazo, alisar,gradiente,angulo,colorUno,colorDos,transparenciaGradual,img);
                vShape.add(s);
                repaint();
                p2=null; 
            }
        }
        else{
            Point p1= evt.getPoint();
            s= getSelectedShape(p1); 
            if(s instanceof MiLineaCurva2D){
                ((MiLineaCurva2D)s).setCurva(p1);
                    repaint();
//                ((MiLinea2D)s).setAtributos(color,transparencia,trazo, alisar, gradiente, img);
            }
        }
       
    }//GEN-LAST:event_formMouseReleased

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed

        
        p1 = evt.getPoint();
        //p2 =evt.getPoint();
        if(editar){
            Point2D p= evt.getPoint();
            s= getSelectedShape(p); 
            if(s instanceof MiLinea2D){
//                ((MiLinea2D)s).setAtributos(color,transparencia,trazo, alisar, gradiente, img);
            }
 
            if(s instanceof MiLineaCurva2D){
                ((MiLineaCurva2D)s).setAtributos(color, relleno,transparencia,trazo,tipoTrazo ,alisar, gradiente,angulo,colorUno,colorDos,transparenciaGradual,img);
                ((MiLineaCurva2D)s).setCurva(p1);
                    repaint();
//                ((MiLinea2D)s).setAtributos(color,transparencia,trazo, alisar, gradiente, img);
            }
            
            if(s instanceof MiRectangulo2D){
                ((MiRectangulo2D)s).setAtributos(color, relleno,transparencia,trazo,tipoTrazo ,alisar, gradiente,angulo,colorUno,colorDos,transparenciaGradual,img);
            }
            if(s instanceof MiRectanguloRedondeado2D){
                ((MiRectanguloRedondeado2D)s).setAtributos(color, relleno,transparencia,trazo,tipoTrazo ,alisar, gradiente,angulo,colorUno,colorDos,transparenciaGradual,img);
            }                
            if(s instanceof MiElipse2D){
                ((MiElipse2D)s).setAtributos(color, relleno,transparencia,trazo,tipoTrazo ,alisar, gradiente,angulo,colorUno,colorDos,transparenciaGradual,img);
            }
            if(s instanceof MiPoligonoEstrellado2D){
                ((MiPoligonoEstrellado2D)s).setAtributos(color, relleno,transparencia,trazo,tipoTrazo ,alisar, gradiente,angulo,colorUno,colorDos,transparenciaGradual,img);
            }
        }else{
            if(p2!=null){
            s = createShape(p1,p2,color,relleno, transparencia, trazo,tipoTrazo, alisar,gradiente,angulo,colorUno,colorDos,transparenciaGradual,img);
            this.vShape.add(s);
           }
        }
        repaint();
    }//GEN-LAST:event_formMousePressed

    
    
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
    Point2D p3 = evt.getPoint();
    p2 = evt.getPoint();
    if(editar){
            if (s instanceof MiLinea2D){
                ((MiLinea2D)s).setLocation(p3);
            }
            if(s instanceof MiRectangulo2D){
                setLocation(s, p3);  
            }
            if(s instanceof MiRectanguloRedondeado2D){
                setLocation(s, p3);  
            }
            if(s instanceof MiElipse2D){
                setLocation(s, p3);  
            } 
            if(s instanceof MiPoligonoEstrellado2D){
                 ((MiPoligonoEstrellado2D)s).setPosicion(p3);
            }
            if(s instanceof MiLineaCurva2D){
                ((MiLineaCurva2D)s).setCurva(p2);
            }

            this.repaint();
        }
        this.repaint();
    }
   
    
    }//GEN-LAST:event_formMouseDragged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


