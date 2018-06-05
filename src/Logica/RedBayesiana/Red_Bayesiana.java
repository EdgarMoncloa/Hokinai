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

    ArrayList AL_Respuestas;
    ArrayList AL_nRespuestas;
    ArrayList AL_RedBayesiana;
    public double[] Categorias;

    public Red_Bayesiana(ArrayList Respuestas, ArrayList NumRespuestas) {
        Categorias = new double[5];
        for (int j = 0; j < 5; j++) {
            Categorias[j] = 0;
        }
        AL_Respuestas = new ArrayList();
        AL_Respuestas = Respuestas;
        AL_nRespuestas = NumRespuestas;

        //Probabilidad de las preguntas
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
        AL_RedBayesiana.add(new Nodo((float) 0.45, (float) 0.55));
        AL_RedBayesiana.add(new Nodo((float) 0.35, (float) 0.45, (float) 0.2));
        AL_RedBayesiana.add(new Nodo((float) 0.3, (float) 0.4, (float) 0.3));
        AL_RedBayesiana.add(new Nodo((float) 0.2, (float) 0.45, (float) 0.35));
        AL_RedBayesiana.add(new Nodo((float) 0.25, (float) 0.50, (float) 0.25));//13 respuestas sin padres

        //Nodos Categorias       
        //-----   
        ArrayList AL_ActitudPadres = new ArrayList();
        AL_ActitudPadres.add(3);
        AL_ActitudPadres.add(8);
        AL_ActitudPadres.add(13);
        AL_RedBayesiana.add(new Nodo(AL_ActitudPadres,"Actitud"));
        //----------
        ArrayList AL_ResPadres = new ArrayList();
        AL_ResPadres.add(1);
        AL_ResPadres.add(3);
        AL_ResPadres.add(5);
        AL_RedBayesiana.add(new Nodo(AL_ResPadres,"Responsabilidad"));
        //-------------
        ArrayList AL_TiempoPadres = new ArrayList();
        AL_TiempoPadres.add(0);
        AL_TiempoPadres.add(5);
        AL_TiempoPadres.add(7);
        AL_RedBayesiana.add(new Nodo(AL_TiempoPadres,"TiempoDedicado"));
        //----
        ArrayList AL_ConocimientoPadres = new ArrayList();
        AL_ConocimientoPadres.add(1);
        AL_ConocimientoPadres.add(2);
        AL_ConocimientoPadres.add(4);
        AL_RedBayesiana.add(new Nodo(AL_ConocimientoPadres,"ConocimientoCarrera"));
        //-- ------
        ArrayList AL_AutodidactaPadres = new ArrayList();
        AL_AutodidactaPadres.add(6);
        AL_AutodidactaPadres.add(7);
        AL_AutodidactaPadres.add(9);
        AL_RedBayesiana.add(new Nodo(AL_AutodidactaPadres,"Autodidacta"));
        //------
        ArrayList AL_ProbTerminarPadres = new ArrayList();
        AL_ProbTerminarPadres.add(14);
        AL_ProbTerminarPadres.add(15);
        AL_ProbTerminarPadres.add(16);
        AL_ProbTerminarPadres.add(17);
        AL_ProbTerminarPadres.add(18);
        AL_RedBayesiana.add(new Nodo(AL_ProbTerminarPadres, "Probabilidad"));

    }

    public void calcularCategorias() {
        for (int j = 0; j < AL_Respuestas.size(); j++) {

            //calcula valor de las categorias
            if (j == 3 || j == 4 || j == 8 || j == 13) {
                Categorias[0] += (int) AL_Respuestas.get(j);
            }
            if (j == 1 || j == 3 || j == 5) {
                Categorias[1] += (int) AL_Respuestas.get(j);
            }
            if (j == 0 || j == 3 || j == 5 || j == 7) {
                Categorias[2] += (int) AL_Respuestas.get(j);
            }
            if (j == 0 || j == 1 || j == 2 || j == 4 || j == 10 || j == 11 || j == 12) {
                Categorias[3] += (int) AL_Respuestas.get(j);
            }
            if (j == 6 || j == 9) {
                Categorias[4] += (int) AL_Respuestas.get(j);
            }
        }
        //normaliza valor de las categorias
        Categorias[0] = Categorias[0] * 10 / 6;
        Categorias[1] = Categorias[1] * 10 / 5;
        Categorias[2] = Categorias[2] * 10 / 8;
        Categorias[3] = Categorias[3] * 10 / 11;
        Categorias[4] = Categorias[4] * 10 / 2;
        for (int j = 0; j < 5; j++) {
            if (Categorias[j] <= 5) {
                Categorias[j] = 5;
            }
        }
    }

    public float calcularProbabilidad() {
        double total = 0, probabilidad = 0;
        for (int j = 0; j < AL_Respuestas.size(); j++) {
            // Calcula Probabilidad
            probabilidad += (int) AL_Respuestas.get(j);
            total += (int) AL_nRespuestas.get(j) - 1;
        }
        //Normaliza valor probabilidades
        return (float) ((.60 * (probabilidad / total) / 1) + .15);
    }

    public double calcularMuestreoPorPriori() throws SQLException, ClassNotFoundException {
        ConeccionBDD con = new ConeccionBDD();
        float Flo_probabilidad = con.calcularProbabilidad(AL_Respuestas);
        con.close();
        if (Flo_probabilidad == 0.0) {
            Flo_probabilidad = calcularProbabilidad();
        }
        if (Flo_probabilidad >= .70) {
            Flo_probabilidad = (float) .75;
        }
        return Flo_probabilidad;
    }

    public void GenerarDatos() throws SQLException, ClassNotFoundException {        
        ConeccionBDD con = new ConeccionBDD();
        int val = 0;
        for (int j = 0; j < 1000000; j++) {
            if (j == val) {
                System.out.println(j);
                val += 1000;
            }
            for (int k = 0; k < AL_RedBayesiana.size(); k++) {
                new generaDatos((Nodo) AL_RedBayesiana.get(k), AL_RedBayesiana,con);
            }
            con.ingresarRespuestas(AL_RedBayesiana);
        }
        con.close();
    }

}
