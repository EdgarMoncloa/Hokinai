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
        //-----
        float[][][] Flo_Actitud = new float[3][2][3];
        Flo_Actitud[0][0][0] = (float) .5;
        Flo_Actitud[0][0][1] = (float) .3;
        Flo_Actitud[0][0][2] = (float) .6;

        Flo_Actitud[0][1][0] = (float) .7;
        Flo_Actitud[0][1][1] = (float) .5;
        Flo_Actitud[0][1][2] = (float) .9;

        Flo_Actitud[1][0][0] = (float) .4;
        Flo_Actitud[1][0][1] = (float) .2;
        Flo_Actitud[1][0][2] = (float) .5;

        Flo_Actitud[1][1][0] = (float) .6;
        Flo_Actitud[1][1][1] = (float) .4;
        Flo_Actitud[1][1][2] = (float) .7;

        Flo_Actitud[2][0][0] = (float) .4;
        Flo_Actitud[2][0][1] = (float) .3;
        Flo_Actitud[2][0][2] = (float) .4;

        Flo_Actitud[2][1][0] = (float) .5;
        Flo_Actitud[2][1][1] = (float) .3;
        Flo_Actitud[2][1][2] = (float) .7;

        ArrayList AL_ActitudPadres = new ArrayList();
        AL_ActitudPadres.add(3);
        AL_ActitudPadres.add(8);
        AL_ActitudPadres.add(13);
        AL_RedBayesiana.add(new Nodo(Flo_Actitud, AL_ActitudPadres));
        //----------
        float[][][] FLo_Responsabilidad = new float[2][3][3];
        FLo_Responsabilidad[0][0][0] = (float) .5;
        FLo_Responsabilidad[0][0][1] = (float) .55;
        FLo_Responsabilidad[0][0][2] = (float) .6;

        FLo_Responsabilidad[0][1][0] = (float) .4;
        FLo_Responsabilidad[0][1][1] = (float) .45;
        FLo_Responsabilidad[0][1][2] = (float) .5;

        FLo_Responsabilidad[0][2][0] = (float) .2;
        FLo_Responsabilidad[0][2][1] = (float) .25;
        FLo_Responsabilidad[0][2][2] = (float) .3;

        FLo_Responsabilidad[1][0][0] = (float) .7;
        FLo_Responsabilidad[1][0][1] = (float) .75;
        FLo_Responsabilidad[1][0][2] = (float) .8;

        FLo_Responsabilidad[1][1][0] = (float) .5;
        FLo_Responsabilidad[1][1][1] = (float) .55;
        FLo_Responsabilidad[1][1][2] = (float) .6;

        FLo_Responsabilidad[1][2][0] = (float) .4;
        FLo_Responsabilidad[1][2][1] = (float) .45;
        FLo_Responsabilidad[1][2][2] = (float) .5;
        ArrayList AL_ResPadres = new ArrayList();
        AL_ResPadres.add(1);
        AL_ResPadres.add(3);
        AL_ResPadres.add(5);
        AL_RedBayesiana.add(new Nodo(FLo_Responsabilidad, AL_ResPadres));
        //-------------
        float[][][] Flo_TiempoDedicado = new float[3][3][3];
        Flo_TiempoDedicado[0][0][0] = (float) .2;
        Flo_TiempoDedicado[0][0][1] = (float) .3;
        Flo_TiempoDedicado[0][0][2] = (float) .4;

        Flo_TiempoDedicado[0][1][0] = (float) .3;
        Flo_TiempoDedicado[0][1][1] = (float) .4;
        Flo_TiempoDedicado[0][1][2] = (float) .5;

        Flo_TiempoDedicado[0][2][0] = (float) .4;
        Flo_TiempoDedicado[0][2][1] = (float) .5;
        Flo_TiempoDedicado[0][2][2] = (float) .6;

        Flo_TiempoDedicado[1][0][0] = (float) .25;
        Flo_TiempoDedicado[1][0][1] = (float) .35;
        Flo_TiempoDedicado[1][0][2] = (float) .45;

        Flo_TiempoDedicado[1][1][0] = (float) .35;
        Flo_TiempoDedicado[1][1][1] = (float) .45;
        Flo_TiempoDedicado[1][1][2] = (float) .55;

        Flo_TiempoDedicado[1][2][0] = (float) .45;
        Flo_TiempoDedicado[1][2][1] = (float) .55;
        Flo_TiempoDedicado[1][2][2] = (float) .65;

        Flo_TiempoDedicado[2][0][0] = (float) .3;
        Flo_TiempoDedicado[2][0][1] = (float) .4;
        Flo_TiempoDedicado[2][0][2] = (float) .5;

        Flo_TiempoDedicado[2][1][0] = (float) .4;
        Flo_TiempoDedicado[2][1][1] = (float) .5;
        Flo_TiempoDedicado[2][1][2] = (float) .6;

        Flo_TiempoDedicado[2][2][0] = (float) .5;
        Flo_TiempoDedicado[2][2][1] = (float) .6;
        Flo_TiempoDedicado[2][2][2] = (float) .7;
        ArrayList AL_TiempoPadres = new ArrayList();
        AL_TiempoPadres.add(0);
        AL_TiempoPadres.add(5);
        AL_TiempoPadres.add(7);
        AL_RedBayesiana.add(new Nodo(Flo_TiempoDedicado, AL_TiempoPadres));

        //----
        float[][][] Flo_ConocimientoCarrera = new float[2][3][2];
        Flo_ConocimientoCarrera[0][0][0]= (float) .3;
        Flo_ConocimientoCarrera[0][0][1]= (float) .5;

        Flo_ConocimientoCarrera[0][1][0]= (float) .4;
        Flo_ConocimientoCarrera[0][1][1]= (float) .6;

        Flo_ConocimientoCarrera[0][2][0]= (float) .6;
        Flo_ConocimientoCarrera[0][2][1]= (float) .8;

        Flo_ConocimientoCarrera[1][0][0]= (float) .4;
        Flo_ConocimientoCarrera[1][0][1]= (float) .6;

        Flo_ConocimientoCarrera[1][1][0]= (float) .5;
        Flo_ConocimientoCarrera[1][1][1]= (float) .7;

        Flo_ConocimientoCarrera[1][2][0]= (float) .7;
        Flo_ConocimientoCarrera[1][2][1]= (float) .9;
        ArrayList AL_ConocimientoPadres = new ArrayList();
        AL_ConocimientoPadres.add(1);
        AL_ConocimientoPadres.add(2);
        AL_ConocimientoPadres.add(4);
        AL_RedBayesiana.add(new Nodo(Flo_ConocimientoCarrera, AL_ConocimientoPadres));

        //-- ------
         float[][][] Flo_Autodidacta = new float[2][3][2];
        Flo_Autodidacta[0][0][0]= (float) .3;
        Flo_Autodidacta[0][0][1]= (float) .4;

        Flo_Autodidacta[0][1][0]= (float) .4;
        Flo_Autodidacta[0][1][1]= (float) .5;

        Flo_Autodidacta[0][2][0]= (float) .45;
        Flo_Autodidacta[0][2][1]= (float) .55;

        Flo_Autodidacta[1][0][0]= (float) .45;
        Flo_Autodidacta[1][0][1]= (float) .55;

        Flo_Autodidacta[1][1][0]= (float) .55;
        Flo_Autodidacta[1][1][1]= (float) .65;

        Flo_Autodidacta[1][2][0]= (float) .6;
        Flo_Autodidacta[1][2][1]= (float) .7;
        ArrayList AL_Autodidacta = new ArrayList();
        AL_Autodidacta.add(6);
        AL_Autodidacta.add(7);
        AL_Autodidacta.add(9);
        AL_RedBayesiana.add(new Nodo(Flo_Autodidacta, AL_Autodidacta));
        float[] Flo_Prob=new float[32];
        Flo_Prob[0]= (float) .2;
        Flo_Prob[1]= (float) .22;
        Flo_Prob[2]= (float) .24;
        Flo_Prob[3]= (float) .26;
        Flo_Prob[4]= (float) .28;
        Flo_Prob[5]= (float) .30;
        Flo_Prob[6]= (float) .32;
        Flo_Prob[7]= (float) .34;
        Flo_Prob[8]= (float) .36;
        Flo_Prob[9]= (float) .38;
        Flo_Prob[10]= (float) .40;
        Flo_Prob[11]= (float) .42;
        Flo_Prob[12]= (float) .44;
        Flo_Prob[13]= (float) .46;
        Flo_Prob[14]= (float) .48;
        Flo_Prob[15]= (float) .50;
        Flo_Prob[16]= (float) .52;
        Flo_Prob[17]= (float) .54;
        Flo_Prob[18]= (float) .56;
        Flo_Prob[19]= (float) .58;
        Flo_Prob[20]= (float) .60;
        Flo_Prob[21]= (float) .62;
        Flo_Prob[22]= (float) .64;
        Flo_Prob[23]= (float) .66;
        Flo_Prob[24]= (float) .68;
        Flo_Prob[25]= (float) .70;
        Flo_Prob[26]= (float) .72;
        Flo_Prob[27]= (float) .74;
        Flo_Prob[28]= (float) .76;
        Flo_Prob[29]= (float) .78;
        Flo_Prob[30]= (float) .80;
        Flo_Prob[31]= (float) .82;
        ArrayList AL_ProbTerminarPadres = new ArrayList();
        AL_ProbTerminarPadres.add(14);
        AL_ProbTerminarPadres.add(15);
        AL_ProbTerminarPadres.add(16);
        AL_ProbTerminarPadres.add(17);
        AL_ProbTerminarPadres.add(18);
        AL_RedBayesiana.add(new Nodo(Flo_Prob, AL_ProbTerminarPadres));

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
        System.out.println("entra");
        if (Flo_probabilidad == 0.0) {
            System.out.println("no hay");
            Flo_probabilidad = calcularProbabilidad();
        }
        /*if (Flo_probabilidad >= .70) {
            Flo_probabilidad = (float) .75;
        }*/
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
                new generaDatos((Nodo) AL_RedBayesiana.get(k), AL_RedBayesiana);
            }
            con.ingresarRespuestas(AL_RedBayesiana);
        }
        con.close();
    }

}
