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

    public final ArrayList AL_TablaProbabilidades;
    public ArrayList AL_Padres;
    public int Respuesta;
    public int numRespuestas;
    public boolean nodoFinal;    
    //float PR1,PR2,PR3;

    public Nodo(ArrayList AL_TablaProbabilidades, ArrayList AL_Padres) {   
        this.AL_Padres=AL_Padres;
        this.AL_TablaProbabilidades=AL_TablaProbabilidades;        
        numRespuestas = 2;
        nodoFinal=false;
    }    
    public Nodo(ArrayList AL_TablaProbabilidades,ArrayList AL_Padres,boolean nodoFinal) {
        this.AL_Padres=AL_Padres;
        this.AL_TablaProbabilidades=AL_TablaProbabilidades;        
        numRespuestas = 2;
        nodoFinal=true;
    }  
    public Nodo(float PR1, float PR2) {
        AL_TablaProbabilidades = new ArrayList();
        AL_TablaProbabilidades.add(PR1);
        AL_TablaProbabilidades.add(PR2);
        AL_Padres=new ArrayList();        
        numRespuestas = AL_TablaProbabilidades.size() - 1;
        nodoFinal=false;
    }
    public Nodo(float PR1, float PR2, float PR3) {
        AL_TablaProbabilidades = new ArrayList();
        AL_TablaProbabilidades.add(PR1);
        AL_TablaProbabilidades.add(PR2);
        AL_TablaProbabilidades.add(PR3);
        AL_Padres=new ArrayList();  
        numRespuestas = AL_TablaProbabilidades.size() - 1;
        nodoFinal=false;
    }  
    public void setRespuesta(int Respuesta) {
        this.Respuesta = Respuesta;
    }
}
