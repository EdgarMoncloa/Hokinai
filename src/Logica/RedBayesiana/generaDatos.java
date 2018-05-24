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

    Nodo Pregunta;
    float aleatorio;

    public generaDatos(Nodo Pregunta) {
        this.Pregunta = Pregunta;
        aleatorio = (float) Math.random();
        if (Pregunta.AL_Padres.isEmpty()) {
            nodoSinPadres();
        } else {
            nodoConPadres();
        }

    }

    private void nodoSinPadres() {
        switch (Pregunta.numRespuestas) {
            case 1:
                if (aleatorio <= (float) Pregunta.AL_Probabilidad.get(0)) {
                    Pregunta.setRespuesta(0);
                } else {
                    Pregunta.setRespuesta(1);
                }
                break;
            case 2:
                if (aleatorio <= (float) Pregunta.AL_Probabilidad.get(0)) {
                    Pregunta.setRespuesta(0);
                }
                if (aleatorio >= (float) Pregunta.AL_Probabilidad.get(0) && aleatorio <= (float) Pregunta.AL_Probabilidad.get(2)) {
                    Pregunta.setRespuesta(1);
                }
                if (aleatorio >= (float) Pregunta.AL_Probabilidad.get(2)) {
                    Pregunta.setRespuesta(2);
                }
            default:
                break;
        }
    }

    private void nodoConPadres() {
        int udc,codigo=1;
        if(Pregunta.AL_Padres.size()-1==3){
             udc=100;
        }else{
             udc=10;
        }        
        for(int j=0;j<Pregunta.AL_Padres.size();j++){
            codigo*=((Nodo)Pregunta.AL_Padres.get(j)).Respuesta*udc;
            udc/=10;
        }
        Pregunta.AL_Probabilidad.add((float)Pregunta.AL_TablaProbabilidades.get(codigo));
        Pregunta.AL_Probabilidad.add(1-((float)Pregunta.AL_TablaProbabilidades.get(codigo)));
        Pregunta.numRespuestas=1;
         nodoSinPadres();
    }
    
}
