/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.dgr.graficos;



import com.sun.javafx.geom.PathIterator;
import com.sun.javafx.geom.RectangularShape;
import com.sun.javafx.geom.transform.BaseTransform;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import static java.awt.Color.red;
import java.awt.Composite;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.TexturePaint;
import java.awt.geom.GeneralPath;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import static java.lang.Math.abs;

/**
*@author Daniel Guerra Ruiz
*@version 16/6/1015
*Clase MiPoligonoEstrellado2D que extiende de DGRShape, lo cual tiene los atributos de la clase DGRShape
*@see  DGRShape
 */
public class MiPoligonoEstrellado2D extends DGRShape{


    
    
    GeneralPath estrella = new GeneralPath();boolean relleno;
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
    *Constructor MiPoligonoEstrellado2D
    *@param x Double
    *@param y Double
    *@param ancho Double
    *@param alto Double
    *@param color Color
    *@param relleno Boolean
    *@param c Boolean, contiene el valor booleano de composite/transparencia para el objeto
    *@param st Stroke
    *@param r Boolean del alisado de la imagen (RenderingHints)
    *@param grad Boolean del gradiente del objeto
    *@param bff BufferedImage que se usara como alisado para este objeto
    */
    
    public MiPoligonoEstrellado2D(double x, double y, double ancho, double alto, Color color,boolean relleno, boolean c, int st,int tipotrazo ,boolean r,boolean grad,boolean ang,Color c1, Color c2,float gradual, BufferedImage bff){
        this.setColor(color);
        this.setCompositeBoolean(c);
        this.setGradiente(grad);
        this.setAngulo(ang);
        this.setColorUno(c1);
        this.setColorDos(c2);
        this.setRelleno(relleno);
        this.gradual = gradual;
        this.tipotrazo = tipotrazo;
        this.setRenderinghints(r);
        this.trazo = st;
        //this.setStroke(st);
        
        this.setBufferedImage(bff);
        estrella.moveTo(x, y);
        int posX = (int)x; 
        int posY = (int)y;
        
        double points[][] = { { x, y }, { x+75, y+35 }, { x+100, y+5 }, { x+125, y+35 }, { x+200, y+45 }, { x+150, y+65 }, { x+160, y+95 }, { x+100, y+75 }, { x+40, y+95 }, { x+50, y+65 }, { x+0, y+45 } };
        
        for (int i = 0 ; i < points.length; i ++){
            estrella.lineTo(points[i][0], points[i][1]);
        }
        estrella.closePath();
    }
     
    
    /**
    *Constructor sin parámetros
    */
    
    public MiPoligonoEstrellado2D(){

    }
    
    /**
    *Metodo setAtributos
    *Asigna las propiedades para modificar el objeto  
    *@param color Color
    *@param relleno Boolean
    *@param c Boolean, contiene el valor booleano de composite/transparencia para el objeto
    *@param st Stroke
    *@param r Boolean del alisado de la imagen (RenderingHints)
    *@param grad Boolean del gradiente del objeto
    *@param img BufferedImage que se usara como alisado para este objeto
    */
    
    
    public void setAtributos(Color color,boolean relleno, boolean c, int st,int tipotrazo, boolean r,boolean grad,boolean ang,Color c1, Color c2,float gradual,BufferedImage img){
        this.setColor(color);
        this.setCompositeBoolean(c);
        this.setRelleno(relleno);
        this.setAngulo(ang);
        this.setRenderinghints(r);
        //this.setStroke(st);
        this.setGradiente(grad);
        this.gradual = gradual;
        this.trazo = st;
        this.tipotrazo = tipotrazo;
        this.setColorUno(c1);
        this.setColorDos(c2);
        this.setBufferedImage(img);    
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
    *@return boolean
    */
    
    public boolean isGradiente() {
        return gradiente;
    }
 
    /**
    *Metodo setGradiente
    *Asigna el gradiente al objeto y se pintará el gradiente
    *@param gradiente Boolean
    */    
    
    public void setGradiente(boolean gradiente) {
        this.gradiente = gradiente;
        if(this.gradiente && colorUno==null && colorDos==null){
            //gradient es un objeto GradientPaint
            gradient = new GradientPaint(0,0,Color.YELLOW,0, 400,Color.GREEN);
            this.setGradient(gradient);

        }
    }

    /**
    *Metodo isRenderinghints
    *Devuelve booleano de si tiene alisado
    *@return boolean
    */    
    
    public boolean isRenderinghints() {
        return renderinghints;
    }    
    
    /**
    *Metodo setRenderingHints
    *Asigna valor al booleano renderinghints, y se pintará con alisado
    *@param renderinghints Boolean
    */      

    public void setRenderinghints(boolean renderinghints) {
        this.renderinghints = renderinghints;
        if(renderinghints){
            this.setRender(render);
        }
    }

    /**
    *Metodo isCompositeBoolean
    *Devuelve el valor del booleano composite_bool
    *@return boolean
    */    

    public boolean isCompositeBoolean(){
        return composite_bool;
    }

    /**
    *Metodo isRelleno
    *Devuelve valor booleano de relleno
    *@return boolean
    */    
    
    public boolean isRelleno() {
        return relleno;
    }

    /**
    *Metodo setRelleno
    *Asigna valor booleano a relleno, si es asi se rellena la figura
    *@param relleno Boolean
    */    
    
    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
        
    }
    
    /**
    *Metodo getTransparencia
    *Devuelve AlphaComposite/ transparencia del objeto
    *@return AlphaComposite
    */    
    
    public AlphaComposite getTransparencia(){
        return composite;
    }

    /**
    *Metodo setCompositeBoolean
    *Asigna la transparencia al objeto, y se añade mediante el objeto composite
    *@param c boolean
    */    
    
    public void setCompositeBoolean(boolean c) {
        this.composite_bool = c;
        if(composite_bool){
            this.setComposite(composite);
        }
    }
    
    /**
    *Metodo getRectangulo
    *Devuelve el objeto Rectangle2D.Double
    *@return Rectangle2D.Double
    */  

    public GeneralPath getEstrella() {
        return estrella;
    }
   
  
    /**
    *Metodo draw
    *Se encarga de pintar el objeto con todas sus propiedades: color, relleno, 
    *alisado, transparencia, grosor, gradiente y textura
    *@param g2d Graphics2D
    */    
   
    public void draw(Graphics2D g2d){
        
        //Establece el trazo
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
        
        //Establece renderinghints / alisado
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
        if(relleno){
        g2d.fill(estrella);
        }
        //Establece transparencia        
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,gradual));
        //Pinta la figura
        g2d.draw(estrella);
        }
    
    /**
    *Metodo contains
    *Devuelve si el Point2D p contiene al objeto
    *@return Boolean
    */

    @Override
    public boolean contains(Point2D p) {
        return estrella.contains(p);
    }
    
    /**Metodo setPosicion
    *@param p
    *Mueve de posicion la figura
    */
    
    public void setPosicion(Point2D p){
        estrella.moveTo(p.getX(), p.getY());
    }
     
    /*
    *@deprecated
    */

    @Override
    public com.sun.javafx.geom.Shape impl_configShape() {
       return null; //To change body of generated methods, choose Tools | Templates.
    }


}






    
    


   

    

