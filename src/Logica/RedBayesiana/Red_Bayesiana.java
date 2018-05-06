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
public class Red_Bayesiana {
    ArrayList[] AL_Respuestas;

    public Red_Bayesiana(ArrayList Respuestas,ArrayList NumRespuestas) {
        AL_Respuestas=new ArrayList[2];
        AL_Respuestas[0]=Respuestas;
        AL_Respuestas[1]=NumRespuestas;
    }
    public double calcularProbabilidad(){
       double total=0,probabilidad=0;
       
       for(int j=0;j<AL_Respuestas[0].size();j++){
           probabilidad+=(int)AL_Respuestas[0].get(j);
           total+=(int)AL_Respuestas[1].get(j)-1; 
       }
       return probabilidad/total;
    }
    
}
