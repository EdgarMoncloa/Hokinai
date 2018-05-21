/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.RedBayesiana;

/**
 *
 * @author EdgarMoncloa
 */
public class generaDatos {
  public generaDatos(Nodo Pregunta) {
        float aleatorio=(float)Math.random();
        switch(Pregunta.numRespuestas){
            case 1:
                if(aleatorio<=(float)Pregunta.Probabilidad.get(0)){
                    Pregunta.setRespuesta(0);                    
                }else{
                    Pregunta.setRespuesta(1);                    
                }                
                break;
            case 2:
                if(aleatorio<=(float)Pregunta.Probabilidad.get(0)){
                    Pregunta.setRespuesta(0);
                }
                if(aleatorio>=(float)Pregunta.Probabilidad.get(0) && aleatorio<=(float)Pregunta.Probabilidad.get(2)){
                    Pregunta.setRespuesta(1);
                }
                if(aleatorio>=(float)Pregunta.Probabilidad.get(2)){
                    Pregunta.setRespuesta(2);
                }
            default:               
            break;
        }
    }

   
   

}
