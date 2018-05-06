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
    
    public Pregunta(String STR_Pregunta,String R1,String R2,String R3,String R4,String R5){
        this.STR_Pregunta=STR_Pregunta;   
        String[] ArS_Respuestas=new String[5];
        ArS_Respuestas[0]=R1;
        ArS_Respuestas[1]=R2;
        ArS_Respuestas[2]=R3;
        ArS_Respuestas[3]=R4;
        ArS_Respuestas[4]=R5;     
        AL_Respuestas=new ArrayList();       
        for(int j=0;j<ArS_Respuestas.length;j++){
           if(ArS_Respuestas[j]!=null){
                AL_Respuestas.add(ArS_Respuestas[j]); 
           }
        }
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
