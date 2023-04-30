package org.emanueljolon.bean;

/**
 * @author Emanuel Esaú Jolon Tzul
 * @date 01/03/2022
 * Codigo Tecnico: IN5BM
 * Carnet: 2021058
 */

public class RaizCuadrada extends Operaciones{

   

    @Override
    public float operar(float numero1, float numero2){
        setNumero1(numero1);
        setNumero2(numero2);
        setOperador('√');
        setResultado((float) Math.pow(numero1, numero2)); 
        return getResultado();
    }
    
    public float operar(float numero){
        setNumero1(numero);
        setOperador('√');
        setResultado((float) Math.sqrt(getNumero2())); 
        return getResultado();
    }
   

}



