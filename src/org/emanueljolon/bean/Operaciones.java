package org.emanueljolon.bean;

/**
 * @author Emanuel Esaú Jolon Tzul
 * @date 01/03/2022
 * Codigo Tecnico: IN5BM
 * Carnet: 2021058
 */

public class Operaciones {
    
    private float numero1;
    private float numero2;
    private float resultado;
    private char operador;
    
    
    //constructores 
    
    //constructor sin parametros
    public Operaciones(){
        
    }
    
    /*
    Constructor con parametros
    */
    
    public Operaciones(float numero1, float numero2){
    this.numero1=numero1;
    this.numero2=numero2;
    }
    
    public float getNumero1(){
        return numero1;
    }
    
    public float getNumero2(){
        return numero2;
    }
    
    public float getResultado(){
        return resultado;
    }
    
    public char getOperador(){
        return operador;
    }
    
    public void setNumero1(float numero1){
        this.numero1=numero1;
    }
    
    public void setNumero2(float numero2){
        this.numero2=numero2;
    }
    
    public void setResultado(float resultado){
        this.resultado=resultado;
    }
    
    public void setOperador(char operador){
        this.operador=operador;
    }

    public float operar(float resultado, float numero) {
       return resultado;
    }
    
    
    
    

  
    
    
}