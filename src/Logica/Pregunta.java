/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author EdgarMoncloa
 */
public class Pregunta {
    private String STR_Pregunta;   
    private ArrayList AL_Respuestas;
    private Double Dec_peso;
    
    public Pregunta(String STR_Pregunta,ArrayList AL_Respuestas,Double Dec_peso){
        this.STR_Pregunta=STR_Pregunta;
        this.AL_Respuestas=AL_Respuestas;
        this.Dec_peso=Dec_peso;
    }
    public int getNRespuestas(){
        return AL_Respuestas.size();
    }
    public String getPregunta(){
        return STR_Pregunta;
    }
    public String getRespuesta(int index){
        if(index<=AL_Respuestas.size()){
            return (String)AL_Respuestas.get(index);
        }else{
            return null;
        }             
        
    }
}
