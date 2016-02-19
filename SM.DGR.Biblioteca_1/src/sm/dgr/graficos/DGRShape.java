
package sm.dgr.graficos;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.TexturePaint;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import javafx.scene.shape.Shape;

/**
* @author Daniel Guerra Ruiz
* @version 16/6/1015
* Clase DGRShape: Contiene variables generales para las clases que extienden de esta clase abstracta y métodos
* @see Shape
 */

public abstract class DGRShape extends Shape{
    
    private Color color;
    private AlphaComposite composite;
    private Stroke stroke;
    private RenderingHints render;
    private GradientPaint gradient;
    private BufferedImage buffImg;
    double x,y,width,height;

    /**
    *Metodo setMiFrame 
    *Asigna valores de x, y, ancho y alto al objeto
    *@param x Double 
    *@param y Double
    *@param w Double
    *@param h Double
    */

    public void setMiFrame(double x, double y, double w, double h) {
            this.x = x;
            this.y = y;
            this.width = w;
            this.height = h;
    }
    
    /**
    * Metodo getBuffImg
    * Devuelve el objeto BufferedImage
    * @return BufferedImage
    */
    public BufferedImage getBuffImg() {
        return buffImg;
    }
    
    /**
    * Metodo setBuffImg
    * Asigna al objeto buffImg un BufferedImage
    * @param buffImg BufferedImage
    */
    public void setBuffImg(BufferedImage buffImg) {
        this.buffImg = buffImg;
    }
    
    /**
    *Metodo getGradient
    *Devuelve el gradiente del objeto
    *@return GradientPaint
    */
    
    public GradientPaint getGradient() {
        return gradient;
    }
    
    /**
    * Metodo setGradient 
    * Asigna gradiente a la variable gradient
    * @param gradient GradientPaint
    */
       
    public void setGradient(GradientPaint gradient) {
        this.gradient = gradient;
    }
    
    /**
    * Metodo setColor
    * Asigna Color al objeto 
    * @param color Color
    */
    
    public void setColor(Color color) {
        this.color = color;
    }

    /**
    * Metodo setComposite
    * Asigna transparencia al objeto
    * @param composite AlphaComposite
    */    
    
    public void setComposite(AlphaComposite composite) {
        this.composite = composite;
    }

    /**
    * Metodo getColor
    * Devuelve el color del objeto
    * @return color 
    */
    
    public Color getColor() {
        return color;
    }

    /**
    * Metodo getMiStroke
    * Devuelve el grosor del objeto
    * @return Stroke
    */    
    
    public Stroke getMiStroke() {
        return stroke;
    } 

    /**
    * Metodo getComposite
    * Devuelve la transparencia del objeto
    * @return AlphaComposite 
    */
    
    public AlphaComposite getComposite() {
        return composite;
    }

    
    /**
    * Metodo getRender
    * Devuelve el alisado del objeto
    * @return RenderingHints
    */    

    public RenderingHints getRender() {
        return render;
    }
    
    /**
    * Metodo setStroke
    * Asigna grosor al objeto
    * @param stroke Stroke
    */      
    
    
    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    /**
    * Metodo setRender
    * Asigna alisado al objeto
    * @param render RenderingHints
    */       
    
    
    public void setRender(RenderingHints render) {
        this.render = render;
    }

    /**
    * Metodo contains
    * Devuelve true o false si el punto pasado por parámetro está dentro del objeto
    * @param p Point2D
    * @return Boolean
    */       
    
    public boolean contains(Point2D p) {
        return super.contains(p.getX(), p.getY());
    }

    /**
    * Metodo getWidth
    * Devuelve anchura del objeto
    * @return Double
    */   
    
    private double getWidth() {
        return this.width;
    }

    /**
    * Metodo getHeight
    * Devuelve altura del objeto
    * @return Double
    */      
    
    private double getHeight() {
        return this.height;
    }

    /**
    * Metodo getX
    * Devuelve coordenada X del objeto
    * @return Double
    */      
    
    private double getX() {
        return this.x;
    }

    /**
    * Metodo getY
    * Devuelve coordenada Y del objeto
    * @return Double
    */        
    
    private double getY() {
        return this.y;
    }
    
    
}
