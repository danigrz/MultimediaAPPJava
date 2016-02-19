/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.dgr.image;

import java.awt.image.ByteLookupTable;
import java.awt.image.LookupTable;
import sm.image.LookupTableProducer;

/**
 *
 * @author Daniel Guerra Ruiz
 * @version 16/6/1015
 * Clase SenoLookupTableProducer
 * Clase para aplicar funcion seno a la imagen
 */
public class SenoLookupTableProducer extends sm.image.LookupTableProducer{
    
    public static final int TYPE_SENO = -1;
    public static double w = 180.0/255.0D;
    public static LookupTable createLookupTable(int type){
        switch (type){
            case -1: 
            return senoFunction(w);
        }
        return LookupTableProducer.createLookupTable(type);
    }
  
    /**
     * Metodo senoFunction
     * Aplica funcion seno
     * @param w double
     * @return ByteLookupTable
     */
    
  public static LookupTable senoFunction(double w){
    double K = 255.0D / Math.sin(Math.toRadians(Math.PI/2.0D)); //Constante de normalización
    
    byte[] lt = new byte[256];
    for (int l = 0; l <= 255; l++) {
      lt[l] = ((byte)(int)(K * Math.abs(Math.sin(Math.toRadians(l * w)))));
    }

    ByteLookupTable slt = new ByteLookupTable(0, lt);
    
    return slt;
  }

}
