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
public class Nodo {
   ArrayList Probabilidad;
    int Respuesta;
    int numRespuestas;
    //float PR1,PR2,PR3;

    public Nodo(float PR1, float PR2) {
        Probabilidad=new ArrayList();
        Probabilidad.add(PR1);
        Probabilidad.add(PR2);
        numRespuestas=Probabilidad.size()-1;
    }
    public Nodo(float PR1, float PR2, float PR3) {   
        Probabilidad=new ArrayList();
        Probabilidad.add(PR1);
        Probabilidad.add(PR2);
        Probabilidad.add(PR3);        
        numRespuestas=Probabilidad.size()-1;
    }
     public void setRespuesta(int Respuesta) {
        this.Respuesta = Respuesta;
    }
}