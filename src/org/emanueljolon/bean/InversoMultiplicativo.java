package org.emanueljolon.bean;

/**
 * @author Emanuel Esaú Jolon Tzul
 * @date 01/03/2022
 * Codigo Tecnico: IN5BM
 * Carnet: 2021058
 */

public class InversoMultiplicativo extends Operaciones{
    
    public InversoMultiplicativo() {

    }    
    
    
    public float operar() {
        setResultado(getNumero1() / getNumero2());
        return  getResultado();
    }

    @Override
    public float operar(float numero1, float numero2){
            this.setNumero1(numero1);
            this.setNumero2(numero2);
            setResultado(getNumero1()/getNumero2());
            return getResultado();

    }
   
}
