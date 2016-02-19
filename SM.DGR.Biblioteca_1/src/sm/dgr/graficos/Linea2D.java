/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.dgr.graficos;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Line2D;

/**
 * @author Daniel Guerra Ruiz
 * @version 16/6/2015
 * Clase Linea2D que extiende de Line2D.Float e implementa la interfaz Shape
 * @param stroke Stroke
 * @param color Color 
 * @param CTE_NEAR Double
 * @see Shape
 */
import java.awt.Stroke;
import java.awt.geom.Line2D.Float;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class Linea2D extends Line2D.Float implements Shape{
  protected Stroke stroke;
  Color color;
  static final double CTE_NEAR = 2.0D;
  
  
  /**
   * Constructor sin parametros
   * 
   */
  
  public Linea2D() {}
  
  /**
   * Constructor con parámetros
   * @param p1 Point2D
   * @param p2 Point2D
   */
  
  public Linea2D(Point2D p1, Point2D p2){  
    super(p1, p2);
  }
  
  /**
   * Metodo isNear, devueve si el punto está cerca de la linea
   * @param p Point2D
   * @return  Boolean
   */
  
  public boolean isNear(Point2D p){
    if (getP1().equals(getP2())) {    
        return getP1().distance(p) <= 2.0D;  
    } 
    return ptLineDist(p) <= 2.0D;
  }
  
  
  /**
   * Metodo contains se usa para generalizar con todas las figuras shape y devuelve si esta cerca del metodo isNear
   * @param p Point2D
   * @return boolean
   */
  
  @Override
  public boolean contains(Point2D p){     
    return isNear(p);
  }
  
  /**
   * Metodo setLocation 
   * Asigna nueva posición a la linea
   * @param posicion Point2D
   */
  
  public void setLocation(Point2D posicion){
    double nuevoX = posicion.getX() - getX1();
    double nuevoY = posicion.getY() - getY1();
    Point2D nuevaPos = new Point2D.Double(getX2() + nuevoX, getY2() + nuevoY);
    setLine(posicion, nuevaPos);  
  }
  
  /**
   * Metodo getStroke
   * Devuelve el grosor de la linea
   * @return stroke Stroke
   */
  
  public Stroke getStroke(){  
    return this.stroke;
  }
  
  /**
   * Metodo getColor
   * Devuelve el color de la linea
   * @return color Color
   */
  
  public Color getColor(){
      return this.color;
  }
  
  /**
   * Metodo setColor
   * Asigna un color a la linea
   * @param c Color
   */
  
  public void setColor(Color c){
      this.color = c;
  }
  
  /**
   * Metodo setStroke
   * Asigna grosor a la linea
   * @param trazo Stroke
   */
  
  public void setStroke(Stroke trazo){     
    this.stroke = trazo; 
  }
  
  
}

