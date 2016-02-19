/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.dgr.graficos;




import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.TexturePaint;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;
import java.awt.image.BufferedImage;
import static java.lang.Math.abs;
import javafx.scene.Cursor;

    /**
    *@author Daniel Guerra Ruiz
    *@version 16/6/1015
    *Clase MiLineaCurva2D que extiende de DGRShape, lo cual tiene los atributos de la clase DGRShape
    *@see DGRShape
    *@see LineaCurva2D
    */

public class MiLineaCurva2D extends DGRShape{
    LineaCurva2D Linea = new LineaCurva2D();
    Point p3;
    boolean composite_bool;
    boolean renderinghints;
    boolean gradiente;
    boolean angulo;
    float gradual = 1;
    int trazo;
    int tipotrazo;
    Color colorUno;
    Color colorDos;
    RenderingHints render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    RenderingHints norender = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
    AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5F);
    AlphaComposite nocomposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1F);
    GradientPaint verticalGradient;
    GradientPaint gradient;
    BufferedImage bf;

   
    
    /**
    *Constructor MiLineaCurva2D
    *@param p1 Point, contiene el inicio de la linea
    *@param p2 Point, contiene el final de la linea
    *@param c Color
    *@param gradual Float
    *@param st Stroke
    *@param r Boolean del alisado de la imagen (RenderingHints)
    *@param grad Float del gradiente del objeto
    *@param bff BufferedImage que se usara como alisado para este objeto
    */    
    
    
    public MiLineaCurva2D(Point p1,Point p2,Color color,boolean relleno, boolean c, int st,int tipotrazo ,boolean r,boolean grad,boolean ang,Color c1, Color c2,float gradual, BufferedImage bff){
        Linea = new LineaCurva2D();
        
        //Pinta Linea recta para luego asignar el punto de control de la curva:    
        int cntrlx = (p2.x+p1.x)/3;
        int cntrly = (p2.y+p1.y)/3; 
        p3 = new Point(cntrlx,cntrly);

        Linea.setCurve(p1, p3, p2);

        this.setRenderinghints(r);
        this.setBufferedImage(bff);
        //Linea.setStroke(st);
        Linea.setColor(color);
        

        this.setGradiente(grad);
        this.setAngulo(ang);
        this.setColorUno(c1);
        this.setColorDos(c2);
        this.gradual = gradual;
        this.tipotrazo = tipotrazo;
        this.setRenderinghints(r);
        this.trazo = st;
        
        
    }
    /**
     * Asigna el punto de control de la curva
     * @param p3 
     */
    public void setCurva(Point p3){
        Linea.setCurve(Linea.getP1(), p3,Linea.getP2());
    }
    /**
    * Metodo setAtributos
    * Asigna las propiedades para modificar el objeto  
    * @param color Color
    * @param gradual Float, contiene el nivel de transparencia para el objeto
    * @param st Stroke
    * @param r Boolean del alisado de la imagen (RenderingHints)
    * @param grad Boolean del gradiente del objeto
    * @param img BufferedImage que se usara como alisado para este objeto
    */    
    
     public void setAtributos(Color color,boolean relleno, boolean c, int st,int tipotrazo, boolean r,boolean grad,boolean ang,Color c1, Color c2,float gradual,BufferedImage img){
        this.setAngulo(ang);
        //this.setStroke(st);
        this.gradual = gradual;
        this.trazo = st;
        this.tipotrazo = tipotrazo;
        this.setColorUno(c1);
        this.setColorDos(c2);
        this.setBufferedImage(img);  
        Linea.setColor(color);
        this.setRenderinghints(r);
        this.setGradiente(grad);
        this.setBufferedImage(img);  
    }
    /* /** Devuelve el color 1 del gradiente
     * @return colorUno
     */
    public Color getColorUno() {
        return colorUno;
    }

     /**
     * Asigna el color 1 al gradiente
     * @param colorUno
     */
    
    public void setColorUno(Color colorUno) {
        this.colorUno = colorUno;
    }
    /**
     * Devuelve el color 2 del gradiente
     * @return 
     */
    public Color getColorDos() {
        return colorDos;
    }

     /**
     * Asigna el color 2 al gradiente
     * @param colorDos
     */    
    
    public void setColorDos(Color colorDos) {
        this.colorDos = colorDos;
    }
    /**
     * Devuelve el angulo del gradiente
     * @return 
     */
    public boolean isAngulo() {
        return angulo;
    }

    /**
     * Asigna angulo al gradiente
     * @param angulo Boolean
     */
    public void setAngulo(boolean angulo) {
        this.angulo = angulo;
       

     }
    
     
     
     
    /**
    * Metodo draw
    * Se encarga de pintar el objeto con todas sus propiedades: color, alisado,
    * transparencia, grosor, gradiente y textura
    *@param g2d Graphics2D
    */        
    
    public void draw(Graphics2D g2d){
            switch(tipotrazo){
            case 1:
                BasicStroke basico = new BasicStroke(trazo);
                g2d.setStroke(basico);
                
                break;
            case 2:
                float dash1[] = {2.0f};
                BasicStroke dashed = new BasicStroke(trazo,BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
                g2d.setStroke(dashed);
                
                break;
            case 3:
                float dash2[] = {10.0f};
                BasicStroke dashed2 = new BasicStroke(trazo,BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash2, 0.0f);
                g2d.setStroke(dashed2);
                
                
                break;
            default:
                BasicStroke defecto = new BasicStroke(trazo);
                g2d.setStroke(defecto);
                
                break;
        }        
        //Establece alisado
        if(renderinghints){
            g2d.setRenderingHints(this.getRender());
        }else{
            g2d.setRenderingHints(norender);
        }
        //Establece gradiente/textura/color
        if(gradiente){
            
            if(angulo){
                 if(colorUno!=null && colorDos!=null)
                    gradient = new GradientPaint(0,0,colorUno,400, 0,colorDos);
                 else
                     gradient = new GradientPaint(0,0,Color.RED,400, 0,Color.CYAN);
                 this.setGradient(gradient);
            }else{
                if(colorUno!=null && colorDos!=null)
                    gradient = new GradientPaint(0,0,colorUno,0, 400,colorDos);
                 else
                     gradient = new GradientPaint(0,0,Color.RED,0,400,Color.CYAN);
                 this.setGradient(gradient);
            }
            g2d.setPaint(this.getGradient());
        }else if(bf!=null){
            Rectangle r = new Rectangle(0, 0, 20, 20);
            g2d.setPaint(new TexturePaint(this.getBuffImg(), r));
            
        }else{
            g2d.setColor(this.getColor());  
        }
        //Establece transparencia        
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,gradual));
            

        //Pinta la linea
        
        g2d.draw(Linea); 
        
        
}

    /**
    * Metodo getBufferedImage
    * Devuelve el obeto BufferedImage
    * @return BufferedImage
    */    
    
    public BufferedImage getBufferedImage() {
        return bf;
    }

    /**
    *Metodo setBufferedImage
    *Asigna un BufferedImage que se usará como textura del objeto
    *@param buf BufferedImage
    */    
 
    public void setBufferedImage(BufferedImage buf) {
        this.bf = buf;
        if(bf!=null){
            this.setBuffImg(bf);
        }
    }
    
    /**
    *Metodo isGradiente
    *Devuelve valor del booleano gradiente
    *@return GradientPaint
    */    
    
    public boolean isGradiente() {
        return gradiente;
    }

    /**
    * Metodo setGradiente
    * Asigna el gradiente al objeto y se pintará el gradiente
    * @param gradiente boolean
    */     
    
    public void setGradiente(boolean gradiente) {
        this.gradiente = gradiente;
        if(gradiente){
            this.setGradient(gradient);
        }
    }
 
    /**
    * Metodo isRenderinghints
    * Devuelve booleano de si tiene alisado
    * @return boolean
    */        
    
    public boolean isRenderinghints() {
        return renderinghints;
    }

    /**
    * Metodo setRenderingHints
    * Asigna valor al booleano renderinghints, y se pintará con alisado
    * @param r Boolean
    */ 
    
    public void setRenderinghints(boolean r) {
        this.renderinghints = r;
        if(renderinghints){
            this.setRender(render);
        }
    }
    
    /**
    * Metodo isComposite_bool
    * Devuelve el valor del booleano composite_bool
    * @return boolean
    */   
    
    
    public boolean isComposite_bool() {
        return composite_bool;
    }

    /**
    * Metodo setComposite_bool
    * Asigna la transparencia al objeto, y se añade mediante el objeto composite
    * @param c boolean
    */       
    
    public void setComposite_bool(boolean c) {
        this.composite_bool = c;
        if(composite_bool){
            this.setComposite(composite);
        }
    }  
    
    /**
    * Metodo getLinea
    * Devuelve el objeto Linea2D
    * @return Linea2D
    */
        
    public LineaCurva2D getLinea() {
        return Linea;
    }
    
    /**
    * Metodo getColor
    * Devuelve el color del objeto
    * @return color
    */
    
    @Override
    public Color getColor(){
        return Linea.getColor();
    }
    
    /**
    * Metodo setColor
    * Asigna color a la linea
    * @param c Color
    */
    
    @Override
    public void setColor(Color c){
        Linea.setColor(c);
    }
    
    /**
    * Metodo getMiStroke
    * Devuelve el grosor de la linea
    * @return Stroke
    */
    
    public Stroke getMiStroke() {
        return Linea.getStroke();
    }

    /**
    * Metodo setTrazo
    * Establece grosor al objeto
    * @param trazo Stroke
    */
    
    public void setTrazo(Stroke trazo) {
        Linea.setStroke(trazo);
        
                
    }
    
    /**
    * Metodo setLocation
    * Asigna la nueva posicion de la linea
    * @param pos Point2D
    */
     
    public void setLocation(Point2D pos){
        Linea.setLocation(pos);
    }
    
    /**
    * Metodo isNear
    * Devuelve si hay linea cerca del punto pasado por parametro
    * @param p Point2D
    * @return boolean
    */
    /**
    public boolean isNear(Point2D p){
        
        return Linea.isNear(p);
    }
    */
    /**
    * Metodo contains
    * Devuelve si el punto pasado por parámetro contiene al objeto
    *@param p Point2D
    */

    public boolean contains(Point2D p){
        return Linea.contains(p);
    }
    
    
    /*
    *@deprecated
    */


    @Override
    public com.sun.javafx.geom.Shape impl_configShape() {
        return null;//To change body of generated methods, choose Tools | Templates.
    }


}

