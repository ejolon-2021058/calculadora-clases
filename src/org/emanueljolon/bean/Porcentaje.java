package org.emanueljolon.bean;

/**
 * @author Emanuel Esaú Jolon Tzul
 * @date 01/03/2022
 * Codigo Tecnico: IN5BM
 * Carnet: 2021058
 */

public class Porcentaje extends Operaciones {
     
    public Porcentaje(){
        
    }
    
    public Porcentaje(float numero1, float numero2){
        operar();
    }
    
    private float operar(){
        this.setResultado((this.getNumero1() * this.getNumero2())/100);
        return this.getResultado();
    }
    
    @Override
    public float operar(float numero1, float numero2){
        this.setNumero1(numero1);
        this.setNumero2(numero2);
        
        return this.operar();
    }
     
    }