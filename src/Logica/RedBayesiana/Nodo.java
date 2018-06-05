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

    //public  ArrayList AL_TablaProbabilidades;
    public ArrayList AL_Padres;
    public int Respuesta;
    public int numRespuestas;
    public boolean nodoFinal;    
    //float PR1,PR2,PR3;
    float[][][] Flo_TablaProbabilidades=new float[3][3][3];
    
    //nodo con padres
    public Nodo(float[][][] Flo_TablaProbabilidades, ArrayList AL_Padres){
        this.Flo_TablaProbabilidades=Flo_TablaProbabilidades;
        this.AL_Padres=AL_Padres;   
        numRespuestas = 2;
        nodoFinal=false;
    }
    //nodo final
    public Nodo(float[] Flo_TablaProbabilidades, ArrayList AL_Padres){        
        this.Flo_TablaProbabilidades[0][0]=Flo_TablaProbabilidades;
        this.AL_Padres=AL_Padres;   
        numRespuestas = 2;
        nodoFinal=true;
        
    }
    
    //Nodos sin padres
    public Nodo(float PR1, float PR2) {
        Flo_TablaProbabilidades[0][0][0]=PR1;
        Flo_TablaProbabilidades[0][0][1]=PR2;
        AL_Padres=new ArrayList();        
        numRespuestas = 2;
        nodoFinal=false;
    }
    public Nodo(float PR1, float PR2, float PR3) {        
        Flo_TablaProbabilidades[0][0][0]=PR1;
        Flo_TablaProbabilidades[0][0][1]=PR2;
        Flo_TablaProbabilidades[0][0][2]=PR3;
        AL_Padres=new ArrayList();  
        numRespuestas = 3;
        nodoFinal=false;
    }  
    public void setRespuesta(int Respuesta) {
        this.Respuesta = Respuesta;
    }
    public float getFlo_TablaProbabilidades(int x,int y,int z){
        return Flo_TablaProbabilidades[x][y][z];
    }
}
