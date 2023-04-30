package org.emanueljolon.controller;
import org.emanueljolon.bean.Suma;
import org.emanueljolon.bean.Resta;
import org.emanueljolon.bean.Division;
import org.emanueljolon.bean.Multiplicacion;
import org.emanueljolon.bean.RaizCuadrada;
import org.emanueljolon.bean.Porcentaje;
import org.emanueljolon.bean.Potenciacion;
import org.emanueljolon.bean.Operaciones;
import org.emanueljolon.bean.InversoAditivo;
import org.emanueljolon.bean.InversoMultiplicativo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * @author Emanuel Esaú Jolon Tzul
 * @date 01/03/2022
 * Codigo Tecnico: IN5BM
 * Carnet: 2021058
 */

public class FXMLCalculadoraController implements Initializable {
    //DECLARAR TOODAS LOS ATRIBUTOS DE LOS BOTONES CON SU NOMBRE
    
    private float resultado;
    private float numero;
    private int contador;
    private String operadorAnterior;
    private boolean ingresoNuevo;
    
    
    
   @FXML
    private Button btnDividir;

    @FXML
    private Button btnSiete;

    @FXML
    private Button btnOcho;

    @FXML
    private Button btnNueve;

    @FXML
    private Button btnMultiplicacion;

    @FXML
    private Button btnCuatro;

    @FXML
    private Button btnCinco;

    @FXML
    private Button btnSeis;

    @FXML
    private Button btnResta;

    @FXML
    private Button btnUno;

    @FXML
    private Button btnDos;

    @FXML
    private Button btnTres;

    @FXML
    private Button btnSuma;

    @FXML
    private Button btnCambiarSigno;

    @FXML
    private Button btnCero;

    @FXML
    private Button btnPunto;

    @FXML
    private Button btnIgual;

    @FXML
    private Button btnPorcentaje;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Button btnInversoM;

    @FXML
    private Button btnPotencia;

    @FXML
    private Button btnRaiz;

    @FXML
    private Button btnSDel;

    @FXML
    private Label lblPantalla;

    
    
    
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
    }    
    
    @FXML
    private void actualizarPantalla(String digito){
        if (ingresoNuevo){
            lblPantalla.setText("");
        }
        lblPantalla.setText(lblPantalla.getText().concat(digito));
        ingresoNuevo=false;
    }
    
    
    @FXML
    private void clickIgual(ActionEvent event){
       calcular(this.operadorAnterior);
       lblPantalla.setText(String.valueOf(this.resultado));
       operadorAnterior = "";
    }

    @FXML
    private void clickRaiz(ActionEvent event){
        contador++;
        resultado = 1;
        operadorAnterior = "√";
        calcular("");
        ingresoNuevo = false;
        lblPantalla.setText(String.valueOf(resultado));
    }
    
    @FXML
    private void clickPotencia(ActionEvent event){
       contador++;
       resultado = 1;
       operadorAnterior = "^";
       calcular("");
       ingresoNuevo = false;
       lblPantalla.setText(String.valueOf(resultado));
    }
             
    @FXML
    private void clickLimpiar(ActionEvent event){
        limpiarPantalla();
        this.resultado= 0;
        this.numero = 0;
        this.contador = 0;
        this.operadorAnterior = " ";
    }
    
   
    @FXML
    private void calcular(String operador){
        Operaciones calc = null;
        if(!(lblPantalla.getText().equals(""))){
            String Pantalla = lblPantalla.getText();

            if(ingresoNuevo == false){
               this.numero = Float.parseFloat(Pantalla);
               contador++;
             if (contador == 1){
                this.resultado=numero;
             }else if(contador >= 2){
        
             switch (this.operadorAnterior){
                case "+":
                    calc = new Suma();
                    this.resultado = calc.operar(resultado,numero);
                    break;
                case "-":
                    calc = new Resta();
                    this.resultado = calc.operar(resultado, numero);
                    break;
                case "x":
                    calc = new Multiplicacion();
                    this.resultado = calc.operar(resultado, numero);
                    break;           
                case "÷":
                    calc = new Division();
                    this.resultado = calc.operar(resultado, numero);
                    break;
               case "%":
                    calc  = new Porcentaje();
                    this.resultado = calc.operar(resultado,numero);
                    break;
               case "1/x":
                   calc = new InversoMultiplicativo();
                   this.resultado = calc.operar(1,numero);
                   lblPantalla.setText(String.valueOf(resultado));
                   break;
               case "√":
                   calc = new RaizCuadrada();
                   resultado = calc.operar(numero, 0.5f);
                   break;
               case "±":
                   calc = new InversoAditivo();
                   resultado = calc.operar(numero,-1);
                   break;
               case "^":
                   calc = new RaizCuadrada();
                   resultado = calc.operar(numero, 2);
                   break;
                }
            }
            
           }
        }
       lblPantalla.setText(String.valueOf(resultado));
       this.operadorAnterior = operador;
       limpiarPantalla();
       //System.out.println(resultado);
       //System.out.println(numero);
       
    }
    
    
    
    @FXML
    private void clickDel(ActionEvent event){
        String cadena;
        cadena=lblPantalla.getText();
        
        if(cadena.length()>0){
            cadena=cadena.substring(0, cadena.length()-1);
            lblPantalla.setText(cadena);
        }
		
   }

    public void agregarPunto(){
        String cadena = lblPantalla.getText();
        
        if (cadena.length() <= 0){
            lblPantalla.setText("0.");
        } else if(!(lblPantalla.getText().contains("."))){
           actualizarPantalla(".");
        }
    }
   
    @FXML
    private void clickCambiarSigno(ActionEvent event){
        contador++;
        resultado = 1;
        operadorAnterior = "±";
        calcular("");
        ingresoNuevo= false;
        lblPantalla.setText(String.valueOf(resultado));
    }
    
    @FXML
    private void clickInversoM(ActionEvent event){
        contador++;
        resultado = 1;
        operadorAnterior = "1/x";
        calcular("");
        ingresoNuevo= false;
        lblPantalla.setText(String.valueOf(resultado));
    }
   
    @FXML
    private void clickPunto(ActionEvent event){
        agregarPunto(); 
    }
    
    @FXML
    private void clickSuma(ActionEvent event){
        calcular("+");
    }
    
    @FXML
    private void clickResta(ActionEvent event){
        calcular("-");
    }
    
    @FXML
    private void clickMultiplicacion(ActionEvent event){
        calcular("x");
    }
    
    @FXML
    private void clickDividir(ActionEvent event){
        calcular("÷");   
    }
    
    @FXML
    private void clickPorcentaje(ActionEvent event){
         calcular("%");
    }
    
    @FXML
    private void clickUno(ActionEvent event){
        actualizarPantalla("1"); 
    }
    
    @FXML
    private void clickDos(ActionEvent event){
        actualizarPantalla("2"); 
    }
    
    @FXML
    private void clickTres(ActionEvent event){
        actualizarPantalla("3"); 
    }
    
    @FXML
    private void clickCuatro(ActionEvent event){
        actualizarPantalla("4");    
    }
    
    @FXML
    private void clickCinco(ActionEvent event){
        actualizarPantalla("5");    
    }
    
    @FXML
    private void clickSeis(ActionEvent event){
        actualizarPantalla("6");    
    }
    
    @FXML
    private void clickSiete(ActionEvent event){
        actualizarPantalla("7"); 
    }
    
    @FXML
    private void clickOcho(ActionEvent event){
        actualizarPantalla("8");   
    }
    
    @FXML
    private void clickNueve(ActionEvent event){
        actualizarPantalla("9");  
    }
    
    @FXML
    private void clickCero(ActionEvent event){
     try{
         cero();
     }catch(NumberFormatException e){
         lblPantalla.setText("0");
     }
        

    }
    
   public void cero(){
   float num=Float.parseFloat(lblPantalla.getText());
        if(ingresoNuevo){
            lblPantalla.setText("");
        }
        
        String cadena=lblPantalla.getText();
        
        if(cadena.length()<=0){
            lblPantalla.setText("0");
            ingresoNuevo=false;
        }else if(!lblPantalla.getText().contains("0")){
            actualizarPantalla("0");
        }else if(num!=0){
            actualizarPantalla("0");
            ingresoNuevo=false;
        }else if(lblPantalla.getText().equals("0.")){
            actualizarPantalla("0");
        }  
    }
    
    @FXML
    private void limpiarPantalla(){
        lblPantalla.setText("");
        
    }
}
    
    
