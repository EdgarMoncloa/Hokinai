/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.RedBayesiana;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author EdgarMoncloa
 */
public class generaDatos {

    private Nodo NodoActual;
    private float aleatorio;
    private ConeccionBDD con;
    private ArrayList AL_RedBayesiana;

    public generaDatos(Nodo Pregunta, ArrayList AL_RedBayesiana, ConeccionBDD con) throws SQLException, ClassNotFoundException {       
        
        this.con = con;
        this.AL_RedBayesiana = AL_RedBayesiana;
        this.NodoActual = Pregunta;
        aleatorio = (float) Math.random();
        if (NodoActual.getPadres().isEmpty()) {
            nodoSinPadres();
        } else {
            /* if (NodoActual.getNodoFinal()) {
                nodoFinal(AL_RedBayesiana);
            } else {
                nodoConPadres(AL_RedBayesiana);
           }*/
            nodoConPadres(AL_RedBayesiana);
        }
       
    }

    private void nodoSinPadres() {
        switch (NodoActual.getNumRespuestas()) {
            case 1:
                if (aleatorio <= (float) NodoActual.getAL_TablaProbabilidades().get(0)) {
                    NodoActual.setRespuesta(1);
                } else {
                    NodoActual.setRespuesta(2);
                }
                break;
            case 2:
                if (aleatorio <= (float) NodoActual.getAL_TablaProbabilidades().get(0)) {
                    NodoActual.setRespuesta(1);
                }
                if (aleatorio >= (float) NodoActual.getAL_TablaProbabilidades().get(0) && aleatorio <= (float) NodoActual.getAL_TablaProbabilidades().get(2)) {
                    NodoActual.setRespuesta(2);
                }
                if (aleatorio >= (float) NodoActual.getAL_TablaProbabilidades().get(2)) {
                    NodoActual.setRespuesta(3);
                }
            default:
                break;
        }
    }

    private void nodoConPadres(ArrayList redBayesiana) throws SQLException, ClassNotFoundException {        
        
        int[] padres = new int[3];
        System.out.println(NodoActual.getSTR_categoria());
        for (int j = 0; j < 3; j++) {
            padres[j] = (int) NodoActual.getAL_Padres().get(j);
            System.out.println( ((Nodo) AL_RedBayesiana.get(padres[j])).getRespuesta());
        }
      
        float probabilidad = con.buscarProbabilidadNodo(
                NodoActual.getSTR_categoria(),
                ((Nodo) AL_RedBayesiana.get(padres[0])).getRespuesta(),
                ((Nodo) AL_RedBayesiana.get(padres[1])).getRespuesta(),
                ((Nodo) AL_RedBayesiana.get(padres[2])).getRespuesta());        
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
                codigo = +((Nodo) NodoActual.getAL_Padres().get(j)).getRespuesta();
            } else {
                codigo = +(j * ((Nodo) NodoActual.getAL_Padres().get(j)).getRespuesta());
            }
        }
        probabilidad = (double) NodoActual.getAL_TablaProbabilidades().get(codigo);
        if (aleatorio <= probabilidad) {
            NodoActual.setRespuesta(1);
        } else {
            NodoActual.setRespuesta(2);
        }
    }

}
