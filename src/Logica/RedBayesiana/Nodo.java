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

    public ArrayList AL_Probabilidad;
    public ArrayList AL_Padres,AL_TablaProbabilidades;
    public int Respuesta;
    public int numRespuestas;
    //float PR1,PR2,PR3;

    public Nodo(ArrayList AL_Padres) {
        AL_Probabilidad = new ArrayList();        
        this.AL_Padres=AL_Padres;        
        numRespuestas = AL_Probabilidad.size() - 1;
    }    
    public Nodo(float PR1, float PR2) {
        AL_Probabilidad = new ArrayList();
        AL_Probabilidad.add(PR1);
        AL_Probabilidad.add(PR2);
        AL_Padres=new ArrayList();        
        numRespuestas = AL_Probabilidad.size() - 1;
    }
    public Nodo(float PR1, float PR2, float PR3) {
        AL_Probabilidad = new ArrayList();
        AL_Probabilidad.add(PR1);
        AL_Probabilidad.add(PR2);
        AL_Probabilidad.add(PR3);
        AL_Padres=new ArrayList();  
        numRespuestas = AL_Probabilidad.size() - 1;
    }  
    public void setRespuesta(int Respuesta) {
        this.Respuesta = Respuesta;
    }
}
