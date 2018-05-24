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
     ArrayList AL_RedBayesiana;
     public double[] Categorias;
    public Red_Bayesiana(ArrayList Respuestas,ArrayList NumRespuestas) {
        Categorias=new double[5];
        for(int j=0;j<5;j++){
            Categorias[j]=0;
        }
        AL_Respuestas=new ArrayList[2];
        AL_Respuestas[0]=Respuestas;
        AL_Respuestas[1]=NumRespuestas;
        
        //Se crea la red
        AL_RedBayesiana = new ArrayList();        
        AL_RedBayesiana.add(new Nodo((float) 0.2, (float) 0.3, (float) 0.5));
        AL_RedBayesiana.add(new Nodo((float) 0.4, (float) 0.6));
        AL_RedBayesiana.add(new Nodo((float) 0.3, (float) 0.4, (float) 0.3));
        AL_RedBayesiana.add(new Nodo((float) 0.3, (float) 0.3, (float) 0.4));
        AL_RedBayesiana.add(new Nodo((float) 0.3, (float) 0.7));
        AL_RedBayesiana.add(new Nodo((float) 0.2, (float) 0.4, (float) 0.4));
        AL_RedBayesiana.add(new Nodo((float) 0.6, (float) 0.4));
        AL_RedBayesiana.add(new Nodo((float) 0.2, (float) 0.5, (float) 0.3));
        AL_RedBayesiana.add(new Nodo((float) 0.4, (float) 0.6));
        AL_RedBayesiana.add(new Nodo((float) 0.5, (float) 0.5));
        AL_RedBayesiana.add(new Nodo((float) 0.45, (float) 0.55));
        AL_RedBayesiana.add(new Nodo((float) 0.35, (float) 0.45, (float) 0.2));
        AL_RedBayesiana.add(new Nodo((float) 0.3, (float) 0.4, (float) 0.3));
        AL_RedBayesiana.add(new Nodo((float) 0.2, (float) 0.45, (float) 0.35));
        AL_RedBayesiana.add(new Nodo((float) 0.25, (float) 0.50, (float) 0.25));
        /*ArrayList Actitud=new ArrayList();
        Actitud.add(111, (float).2);
        Actitud.add(112, (float).2);
        Actitud.add(121, (float).2);
        Actitud.add(122, (float).2);
        Actitud.add(131, (float).2);
        Actitud.add(132, (float).2);
        Actitud.add(211, (float).2);
        Actitud.add(212, (float).2);
        Actitud.add(221, (float).2);
        Actitud.add(222, (float).2);
        Actitud.add(231, (float).2);
        Actitud.add(232, (float).2);
        Actitud.add(311, (float).2);
        Actitud.add(312, (float).2);
        Actitud.add(321, (float).2);
        Actitud.add(322, (float).2);
        Actitud.add(331, (float).2);
        Actitud.add(332, (float).2);
        AL_RedBayesiana.add(new Nodo(Actitud));*/
        
    }
   /* public double calcularProbabilidad(){
       float DOB_ProbNo=1,DOB_ProbSi=1;
       
       for(int j=0;j<AL_Respuestas[0].size();j++){
           DOB_ProbSi+=(float)(((Nodo)AL_RedBayesiana.get(j)).AL_Probabilidad.get((int)AL_Respuestas[0].get(j)));             
       }
       DOB_ProbNo=DOB_ProbSi;
       //DOB_ProbSi*=.7;
       DOB_ProbNo*=.3;
        return 0;
       //return DOB_ProbSi/(++-AL_Respuestas[0].size()-1);
    }*/
    public double calcularProbabilidad(){
       double total=0,probabilidad=0;       
       for(int j=0;j<AL_Respuestas[0].size();j++){
           probabilidad+=(int)AL_Respuestas[0].get(j);
           total+=(int)AL_Respuestas[1].get(j)-1; 
           
           if(j==3 || j==4 || j==8 || j==13){
               Categorias[0]+=(int)AL_Respuestas[0].get(j);
           }
           if(j==1 || j==3 || j==5){
               Categorias[1]+=(int)AL_Respuestas[0].get(j);
           }
           if(j==0 || j==3 || j==5 || j==7){
               Categorias[2]+=(int)AL_Respuestas[0].get(j);
           }
           if(j==0 || j==1 || j==2 || j==4 || j==10 || j==11 || j==12){
               Categorias[3]+=(int)AL_Respuestas[0].get(j);
           }
           if(j==6 || j==9){
               Categorias[4]+=(int)AL_Respuestas[0].get(j);
           }   
       }       
       Categorias[0]=Categorias[0]*10/6;
       Categorias[1]=Categorias[1]*10/5;
       Categorias[2]=Categorias[2]*10/8;
       Categorias[3]=Categorias[3]*10/11;
       Categorias[4]=Categorias[4]*10/2;
       for(int j=0;j<5;j++){
           if(Categorias[j]<=3){
               Categorias[j]=3;
           }
       }       
       return (.80*(probabilidad/total)/1)+.10;
    }
     public Red_Bayesiana() throws SQLException {
        ConeccionBDD con = new ConeccionBDD();
        for (int j = 0; j < 1000000; j++) {
            for (int k = 0; k < 8; k++) {
                new generaDatos((Nodo) AL_RedBayesiana.get(k));
            }
            con.ingresarRespuestas(AL_RedBayesiana);
            System.out.println("j:"+j);
        }
        con.close();
    }
   

    
    
    
}
