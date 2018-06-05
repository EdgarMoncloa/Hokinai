/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.RedBayesiana;

import static java.lang.Math.pow;
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
            case 2:
                if (aleatorio <= (float) NodoActual.getFlo_TablaProbabilidades(0, 0, 0)) {
                    NodoActual.setRespuesta(0);
                } else {
                    NodoActual.setRespuesta(1);
                }
                break;
            case 3:
                if (aleatorio < (float) NodoActual.getFlo_TablaProbabilidades(0, 0, 0)) {
                    NodoActual.setRespuesta(0);
                } else {
                    if (aleatorio > 1 - (float) NodoActual.getFlo_TablaProbabilidades(0, 0, 2)) {
                        NodoActual.setRespuesta(2);
                    } else {
                        NodoActual.setRespuesta(1);
                    }
                }
            default:
                break;
        }

    }

    private void nodoConPadres(ArrayList redBayesiana) {
        int[] Int_RespPadres = new int[3];
        float probabilidad = 0;
        for (int j = 0; j <= NodoActual.AL_Padres.size() - 1; j++) {
            Int_RespPadres[j] = ((Nodo) redBayesiana.get((int) NodoActual.AL_Padres.get(j))).Respuesta;
        }
        probabilidad = (float) NodoActual.getFlo_TablaProbabilidades(Int_RespPadres[0], Int_RespPadres[1], Int_RespPadres[2]);
        if (aleatorio <= probabilidad) {
            NodoActual.setRespuesta(0);
        } else {
            NodoActual.setRespuesta(1);
        }
    }

    private void nodoFinal(ArrayList redBayesiana) {
        int Int_RespPadres = 0;
        double probabilidad = 0;
        for (int j = 0; j <= NodoActual.AL_Padres.size() - 1; j++) {
            if (NodoActual.getFlo_TablaProbabilidades(0, 0, j) == 1) {
                Int_RespPadres += pow(2, j);
            }
        }
        probabilidad = (double) NodoActual.getFlo_TablaProbabilidades(0, 0, Int_RespPadres);
        if (aleatorio <= probabilidad) {
            NodoActual.setRespuesta(0);
        } else {
            NodoActual.setRespuesta(1);
        }
    }

}
