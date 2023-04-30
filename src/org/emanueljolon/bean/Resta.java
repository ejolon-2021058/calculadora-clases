package org.emanueljolon.bean;

/**
 * @author Emanuel Esaú Jolon Tzul
 * @date 01/03/2022
 * Codigo Tecnico: IN5BM
 * Carnet: 2021058
 */

public class Resta extends Operaciones {
    
 
    public float operar(){
        setResultado(getNumero1() - getNumero2());
        return getResultado();
    }
    
   
    public float operar(float numero1, float numero2){
        setNumero1(numero1);
        setNumero2(numero2);
        setResultado(getNumero1() - getNumero2());
        return getResultado();
    }
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
