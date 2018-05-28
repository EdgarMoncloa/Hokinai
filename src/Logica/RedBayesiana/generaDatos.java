/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.RedBayesiana;

import java.util.ArrayList;

/**
 *
 * @author EdgarMoncloa
 */
public class generaDatos {

    Nodo NodoActual;
    float aleatorio;

    public generaDatos(Nodo Pregunta, ArrayList redBayesiana) {
        this.NodoActual = Pregunta;
        aleatorio = (float) Math.random();
        if (Pregunta.AL_Padres.isEmpty()) {
            nodoSinPadres();
        } else {

            if (Pregunta.nodoFinal) {
                nodoFinal(redBayesiana);
            } else {
                nodoConPadres(redBayesiana);
            }

        }

    }

    private void nodoSinPadres() {
        switch (NodoActual.numRespuestas) {
            case 1:
                if (aleatorio <= (float) NodoActual.AL_TablaProbabilidades.get(0)) {
                    NodoActual.setRespuesta(1);
                } else {
                    NodoActual.setRespuesta(2);
                }
                break;
            case 2:
                if (aleatorio <= (float) NodoActual.AL_TablaProbabilidades.get(0)) {
                    NodoActual.setRespuesta(1);
                }
                if (aleatorio >= (float) NodoActual.AL_TablaProbabilidades.get(0) && aleatorio <= (float) NodoActual.AL_TablaProbabilidades.get(2)) {
                    NodoActual.setRespuesta(2);
                }
                if (aleatorio >= (float) NodoActual.AL_TablaProbabilidades.get(2)) {
                    NodoActual.setRespuesta(3);
                }
            default:
                break;
        }
    }

    private void nodoConPadres(ArrayList redBayesiana) {        
        int udc = 0, codigo = 0;
        double probabilidad = 0;
        if (NodoActual.AL_Padres.size() == 3) {
            udc = 100;
        } else {
            udc = 10;
        }
        for (int j = 1; j <= NodoActual.AL_Padres.size(); j++) {
            codigo += ((Nodo) redBayesiana.get((int) NodoActual.AL_Padres.get(j - 1))).Respuesta * udc;
            udc /= 10;
        }       
        probabilidad = (float) NodoActual.AL_TablaProbabilidades.get(codigo);
        if (aleatorio <= probabilidad) {
            NodoActual.setRespuesta(1);
        } else {
            NodoActual.setRespuesta(2);
        }       
    }
    private void nodoFinal(ArrayList redBayesiana) {
        int codigo = 0;
        double probabilidad = 0;
        for (int j = 1; j <= 16; j++) {
            if (j == 1) {
                codigo = +((Nodo) NodoActual.AL_Padres.get(j)).Respuesta;
            } else {
                codigo = +(j * ((Nodo) NodoActual.AL_Padres.get(j)).Respuesta);
            }
        }
        probabilidad = (double) NodoActual.AL_TablaProbabilidades.get(codigo);
        if (aleatorio <= probabilidad) {
            NodoActual.setRespuesta(1);
        } else {
            NodoActual.setRespuesta(2);
        }
    }

}
