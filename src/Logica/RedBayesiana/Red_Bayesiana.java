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
     public Red_Bayesiana() throws SQLException {
         ConeccionBDD con = new ConeccionBDD();
        ArrayList red = new ArrayList();
        //con.coneccionBDD();
        red.add(new Nodo((float) 0.2, (float) 0.3, (float) 0.5));
        red.add(new Nodo((float) 0.4, (float) 0.6));
        red.add(new Nodo((float) 0.3, (float) 0.4, (float) 0.3));
        red.add(new Nodo((float) 0.3, (float) 0.3, (float) 0.4));
        red.add(new Nodo((float) 0.3, (float) 0.7));
        red.add(new Nodo((float) 0.2, (float) 0.4, (float) 0.4));
        red.add(new Nodo((float) 0.6, (float) 0.4));
        red.add(new Nodo((float) 0.2, (float) 0.5, (float) 0.3));
        red.add(new Nodo((float) 0.4, (float) 0.6));
        red.add(new Nodo((float) 0.5, (float) 0.5));
        red.add(new Nodo((float) 0.45, (float) 0.55));
        red.add(new Nodo((float) 0.35, (float) 0.45, (float) 0.2));
        red.add(new Nodo((float) 0.3, (float) 0.4, (float) 0.3));
        red.add(new Nodo((float) 0.2, (float) 0.45, (float) 0.35));
        red.add(new Nodo((float) 0.25, (float) 0.50, (float) 0.25));
        

        for (int j = 0; j < 1000000; j++) {
            for (int k = 0; k < 8; k++) {
                new generaDatos((Nodo) red.get(k));
            }
            con.ingresarRespuestas(red);
            System.out.println("j:"+j);
        }
        con.close();
    }
   

    
    
    
}
