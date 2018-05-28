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
        AL_RedBayesiana.add(new Nodo((float) 0.45, (float) 0.55));
        AL_RedBayesiana.add(new Nodo((float) 0.35, (float) 0.45, (float) 0.2));
        AL_RedBayesiana.add(new Nodo((float) 0.3, (float) 0.4, (float) 0.3));
        AL_RedBayesiana.add(new Nodo((float) 0.2, (float) 0.45, (float) 0.35));
        AL_RedBayesiana.add(new Nodo((float) 0.25, (float) 0.50, (float) 0.25));//13 respuestas sin padres
        

        //Nodos Categorias
        ArrayList Actitud = new ArrayList();
        ArrayList Responsabilidad = new ArrayList();
        ArrayList TiempoDedicado = new ArrayList();
        ArrayList ConocimientoCarrera = new ArrayList();
        ArrayList Autodidacta = new ArrayList();
        ArrayList ProbTerminar=new ArrayList();
        for (int j = 0; j <= 350; j++) {
            Actitud.add(null);
            Responsabilidad.add(null);
            TiempoDedicado.add(null);
            ConocimientoCarrera.add(null);
            Autodidacta.add(null);
            ProbTerminar.add(null);
        }
        //-----
        Actitud.add(111, (float) .5);
        Actitud.add(112, (float) .3);
        Actitud.add(113, (float) .6);

        Actitud.add(121, (float) .7);
        Actitud.add(122, (float) .5);
        Actitud.add(123, (float) .9);

        Actitud.add(211, (float) .4);
        Actitud.add(212, (float) .2);
        Actitud.add(213, (float) .5);

        Actitud.add(221, (float) .6);
        Actitud.add(222, (float) .4);
        Actitud.add(223, (float) .7);

        Actitud.add(311, (float) .4);
        Actitud.add(312, (float) .3);
        Actitud.add(313, (float) .4);

        Actitud.add(321, (float) .5);
        Actitud.add(322, (float) .3);
        Actitud.add(323, (float) .7);
        
        ArrayList AL_ActitudPadres=new ArrayList();
        AL_ActitudPadres.add(3);
        AL_ActitudPadres.add(8);
        AL_ActitudPadres.add(13);
        AL_RedBayesiana.add(new Nodo(Actitud,AL_ActitudPadres));
        //----------

        
        Responsabilidad.add(111, (float) .5);
        Responsabilidad.add(112, (float) .55);
        Responsabilidad.add(113, (float) .6);

        Responsabilidad.add(121, (float) .4);
        Responsabilidad.add(122, (float) .45);
        Responsabilidad.add(123, (float) .5);

        Responsabilidad.add(131, (float) .2);
        Responsabilidad.add(132, (float) .25);
        Responsabilidad.add(133, (float) .3);

        Responsabilidad.add(211, (float) .7);
        Responsabilidad.add(212, (float) .75);
        Responsabilidad.add(213, (float) .8);

        Responsabilidad.add(221, (float) .5);
        Responsabilidad.add(222, (float) .55);
        Responsabilidad.add(223, (float) .6);

        Responsabilidad.add(231, (float) .4);
        Responsabilidad.add(232, (float) .45);
        Responsabilidad.add(233, (float) .5);
        ArrayList AL_ResPadres=new ArrayList();
        AL_ResPadres.add(1);
        AL_ResPadres.add(3);
        AL_ResPadres.add(5);        
        AL_RedBayesiana.add(new Nodo(Responsabilidad,AL_ResPadres));
        //-------------

        TiempoDedicado.add(111, (float) .2);
        TiempoDedicado.add(111, (float) .3);
        TiempoDedicado.add(111, (float) .4);

        TiempoDedicado.add(121, (float) .3);
        TiempoDedicado.add(121, (float) .4);
        TiempoDedicado.add(121, (float) .5);

        TiempoDedicado.add(131, (float) .4);
        TiempoDedicado.add(131, (float) .5);
        TiempoDedicado.add(131, (float) .6);

        TiempoDedicado.add(211, (float) .25);
        TiempoDedicado.add(211, (float) .35);
        TiempoDedicado.add(211, (float) .45);

        TiempoDedicado.add(221, (float) .35);
        TiempoDedicado.add(221, (float) .45);
        TiempoDedicado.add(221, (float) .55);

        TiempoDedicado.add(231, (float) .45);
        TiempoDedicado.add(231, (float) .55);
        TiempoDedicado.add(231, (float) .65);

        TiempoDedicado.add(311, (float) .3);
        TiempoDedicado.add(311, (float) .4);
        TiempoDedicado.add(311, (float) .5);

        TiempoDedicado.add(321, (float) .4);
        TiempoDedicado.add(321, (float) .5);
        TiempoDedicado.add(321, (float) .6);

        TiempoDedicado.add(331, (float) .5);
        TiempoDedicado.add(331, (float) .6);
        TiempoDedicado.add(331, (float) .7);
        ArrayList AL_TiempoPadres=new ArrayList();
        AL_TiempoPadres.add(0);
        AL_TiempoPadres.add(5);
        AL_TiempoPadres.add(7);
        AL_RedBayesiana.add(new Nodo(TiempoDedicado,AL_TiempoPadres));

        //----
        ConocimientoCarrera.add(111, (float) .3);
        ConocimientoCarrera.add(112, (float) .5);

        ConocimientoCarrera.add(121, (float) .4);
        ConocimientoCarrera.add(122, (float) .6);

        ConocimientoCarrera.add(131, (float) .6);
        ConocimientoCarrera.add(132, (float) .8);

        ConocimientoCarrera.add(211, (float) .4);
        ConocimientoCarrera.add(212, (float) .6);

        ConocimientoCarrera.add(221, (float) .5);
        ConocimientoCarrera.add(222, (float) .7);

        ConocimientoCarrera.add(231, (float) .7);
        ConocimientoCarrera.add(232, (float) .9);
        ArrayList AL_ConocimientoPadres=new ArrayList();
        AL_ConocimientoPadres.add(1);
        AL_ConocimientoPadres.add(2);
        AL_ConocimientoPadres.add(4);
        AL_RedBayesiana.add(new Nodo(ConocimientoCarrera,AL_ConocimientoPadres));

        //-- ------
        Autodidacta.add(111, (float) .3);
        Autodidacta.add(112, (float) .4);

        Autodidacta.add(121, (float) .4);
        Autodidacta.add(122, (float) .5);

        Autodidacta.add(131, (float) .45);
        Autodidacta.add(132, (float) .55);

        Autodidacta.add(211, (float) .45);
        Autodidacta.add(212, (float) .55);

        Autodidacta.add(221, (float) .55);
        Autodidacta.add(222, (float) .65);

        Autodidacta.add(231, (float) .6);
        Autodidacta.add(232, (float) .7);
        ArrayList AL_Autodidacta=new ArrayList();
        AL_Autodidacta.add(6);
        AL_Autodidacta.add(7);
        AL_Autodidacta.add(9);
        AL_RedBayesiana.add(new Nodo(Autodidacta,AL_Autodidacta));
        
        ProbTerminar.add(1,(float).6);
        ProbTerminar.add(2,(float).6);
        ProbTerminar.add(3,(float).6);
        ProbTerminar.add(4,(float).6);
        ProbTerminar.add(5,(float).6);
        ProbTerminar.add(6,(float).6);
        ProbTerminar.add(7,(float).6);
        ProbTerminar.add(8,(float).6);
        ProbTerminar.add(9,(float).6);
        ProbTerminar.add(10,(float).6);
        ProbTerminar.add(11,(float).6);
        ProbTerminar.add(12,(float).6);
        ProbTerminar.add(13,(float).6);
        ProbTerminar.add(14,(float).6);
        ProbTerminar.add(15,(float).6);
        ProbTerminar.add(16,(float).6);
        ProbTerminar.add(17,(float).6);
        ProbTerminar.add(18,(float).6);
        ProbTerminar.add(19,(float).6);
        ProbTerminar.add(20,(float).6);
        ProbTerminar.add(21,(float).6);
        ProbTerminar.add(22,(float).6);
        ProbTerminar.add(23,(float).6);
        ProbTerminar.add(24,(float).6);
        ProbTerminar.add(25,(float).6);
        ProbTerminar.add(26,(float).6);
        ProbTerminar.add(27,(float).6);
        ProbTerminar.add(28,(float).6);
        ProbTerminar.add(29,(float).6);
        ProbTerminar.add(30,(float).6);
        ProbTerminar.add(31,(float).6);
        ProbTerminar.add(32,(float).6);
        ArrayList AL_ProbTerminarPadres=new ArrayList();
        AL_ProbTerminarPadres.add(14);
        AL_ProbTerminarPadres.add(15);
        AL_ProbTerminarPadres.add(16);
        AL_ProbTerminarPadres.add(17);
        AL_ProbTerminarPadres.add(18);
        AL_RedBayesiana.add(new Nodo(ProbTerminar,AL_ProbTerminarPadres,true));
        
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
    public float calcularProbabilidad(){
        double total = 0, probabilidad = 0;
        for (int j = 0; j < AL_Respuestas.size(); j++) {
            // Calcula Probabilidad
            probabilidad += (int) AL_Respuestas.get(j);
            total += (int) AL_nRespuestas.get(j) - 1;
        }        
        //Normaliza valor probabilidades
        return (float) ((.60 * (probabilidad / total) / 1) + .15);
    }
    public double calcularMuestreoPorPriori() throws SQLException{
        ConeccionBDD con=new ConeccionBDD();   
        float Flo_probabilidad=con.calcularProbabilidad(AL_Respuestas);
        con.close();
        if(Flo_probabilidad==0.0){
            Flo_probabilidad=calcularProbabilidad();
        }
        return  Flo_probabilidad;        
    }
    public void GenerarDatos() throws SQLException {
        ConeccionBDD con = new ConeccionBDD();
        int val=0;
        for (int j = 0; j < 1000000; j++) {
            if(j==val){
                 System.out.println(j);
                 val+=1000;
                }
            for (int k = 0; k < AL_RedBayesiana.size(); k++) {                
                new generaDatos((Nodo) AL_RedBayesiana.get(k),AL_RedBayesiana);
            }
            con.ingresarRespuestas(AL_RedBayesiana);
        }
        con.close();
    }

}
