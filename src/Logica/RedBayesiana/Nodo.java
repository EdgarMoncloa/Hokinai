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

    private final ArrayList AL_TablaProbabilidades;

    
    private ArrayList AL_Padres;
    private int Respuesta;
    private int numRespuestas;
    private boolean nodoFinal;  
    private String STR_categoria;
    //float PR1,PR2,PR3;

    public Nodo(ArrayList AL_Padres,String STR_categoria) {   
        this.STR_categoria=STR_categoria;
        this.AL_Padres=AL_Padres;
        AL_TablaProbabilidades=null;        
        numRespuestas = 2;
        nodoFinal=false;
        float[][][] Flo_Codigo;
    }  
    public Nodo(ArrayList AL_Padres,boolean nodoFinal) {   
        this.AL_Padres=AL_Padres;
        this.AL_TablaProbabilidades=null;        
        numRespuestas = 2;
        nodoFinal=true;
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
    public int getRespuesta(){
        return this.Respuesta;
    }
    public ArrayList getPadres(){
        return AL_Padres;
    }
    public boolean getNodoFinal(){
        return nodoFinal;
    }
    public int getNumRespuestas() {
        return numRespuestas;
    }
    public ArrayList getAL_TablaProbabilidades() {
        return AL_TablaProbabilidades;
    }
    public ArrayList getAL_Padres() {
        return AL_Padres;
    }

    public String getSTR_categoria() {
        return STR_categoria;
    }
    
}
