/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;

import Vista.Ventana;
import Vista.JP_Estadisticas;
import Vista.JP_Preguntas;
import Vista.JP_Inicio;
import javax.swing.JPanel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import Logica.BDD_Coneccion;
import Logica.Pregunta;
import Logica.RedBayesiana.Nodo;
import Logica.RedBayesiana.*;
import java.sql.SQLException;

/**
 *
 * @author EdgarMoncloa
 */
public class Coneccion extends JFrame {
    // private JFrame Ventana;

    private JPanel JP_Principal;
    private Ventana Ventana;
   // private BDD_Coneccion BDD;
    private ArrayList AL_Preguntas;
    private ArrayList AL_RespuestasUsuario;
    private double Dec_ProbExito;
    private boolean bol_Estadisticas;

    public Coneccion() throws IOException {
        AL_Preguntas = new ArrayList();
        bol_Estadisticas = false;
        inicializarPreguntas();
        AL_RespuestasUsuario = new ArrayList();
        //BDD = new BDD_Coneccion();
        //BDD.BDD_Coneccion();
        //BDD.mostrarAlumnos();        
        Ventana = new Ventana(this);
        JP_Principal = Ventana.getPanelPrincipal();
        JP_Principal.add(new JP_Inicio(this, bol_Estadisticas));
        Ventana.setVisible(true);
    }

    public void redBayesiana() throws SQLException{
        ConeccionBDD con = new ConeccionBDD();
        ArrayList red = new ArrayList();
        //con.coneccionBDD();
        red.add(new Nodo((float) 0.1, (float) 0.9));
        red.add(new Nodo((float) 0.2, (float) 0.2, (float) 0.6));
        red.add(new Nodo((float) 0.3, (float) 0.4, (float) 0.3));
        red.add(new Nodo((float) 0.3, (float) 0.7));
        red.add(new Nodo((float) 0.6, (float) 0.4));
        red.add(new Nodo((float) 0.4, (float) 0.6));
        red.add(new Nodo((float) 0.3, (float) 0.7));
        red.add(new Nodo((float) 0.4, (float) 0.6));

        for (int j = 0; j < 1000000; j++) {
            for (int k = 0; k < 8; k++) {
                new generaDatos((Nodo) red.get(k));
            }
            con.ingresarRespuestas(red);
            System.out.println("j:"+j);
        }
        con.close();
    }
    public void cambiarInicio() throws IOException {
        JP_Principal.removeAll();
        JP_Principal.add(new JP_Inicio(this, bol_Estadisticas));
        JP_Principal.repaint();
    }

    public void cambiarPreguntas() throws IOException {
        JP_Principal.removeAll();
        JP_Principal.add(new JP_Preguntas(this));
        JP_Principal.repaint();
    }

    public void cambiarEstadisticas() {
        Dec_ProbExito = (new Red_Bayesiana(AL_RespuestasUsuario, this.getNumPreguntas())).calcularProbabilidad();
        JP_Principal.removeAll();
        JP_Principal.add(new JP_Estadisticas(this));
        JP_Principal.repaint();
        bol_Estadisticas = true;
    }

    public double getProbExito() {
        return Dec_ProbExito;
    }

    public ArrayList getPreguntas() {
        return AL_Preguntas;
    }

    public ArrayList getNumPreguntas() {
        ArrayList NumPreguntas = new ArrayList();
        for (int j = 0; j < AL_Preguntas.size(); j++) {
            NumPreguntas.add(((Pregunta) AL_Preguntas.get(j)).getNRespuestas());
        }
        return NumPreguntas;
    }

    private void inicializarPreguntas() {
        AL_Preguntas.add(new Pregunta(
                "1.- ¿Como piensas pagar tu inscripción?",
                "Trabajando y estudiando",
                "Con una Beca",
                "La pagaran mis padres"
        ));
        AL_Preguntas.add(new Pregunta(
                "2.- ¿Has trabajado alguna vez en una empresa?  ",
                "No",
                "Si"
        ));
        AL_Preguntas.add(new Pregunta(
                "3.- ¿Estas informado o te interesan los avances tecnológicos actuales en áreas de la carrera?",
                "No",
                "Me interesan pero no estoy muy informado",
                "Si"
        ));
        AL_Preguntas.add(new Pregunta(
                "4.- ¿Cuantas materias reprobaste el último año de preparatoria?",
                "Ninguna",
                "1-2",
                "3 o más"
        ));
         AL_Preguntas.add(new Pregunta(
                "5.- ¿Has recibido orientación vocacional para elegir una carrera? ",
                "No",
                "Si"
        ));
         AL_Preguntas.add(new Pregunta(
                "6.- ¿Con qué frecuencia entregas a tiempo las tareas de tus materias?",
                "Pocas veces",
                "Regularmente",
                "Siempre"
        ));
        AL_Preguntas.add(new Pregunta(
                "7.- ¿Aplicas alguna técnica para estudiar? (Por ejemplo: subrayar, hacer mapas mentales, etc )",
                "No",
                "Si"
        ));
        AL_Preguntas.add(new Pregunta(
                "8.- En tu día prefieres:",
                "Tener algunas cosas planeadas y ser algo espontáneo",
                "Ser espontáneo",
                "Tener la mayoria de cosas planeadas"
        ));
        AL_Preguntas.add(new Pregunta(
                "9.- ¿Puedes escuchar a alguien durante un largo periodo, sin interrumpirle y entender los puntos claves de los que está hablando?",
                "No",
                "Si"
        ));
        AL_Preguntas.add(new Pregunta(
                "10.- ¿Te gusta armar rompecabezas geométricos (cubo de Ruby por ejemplo)?",
                "No",
                "Si"                
        ));
        AL_Preguntas.add(new Pregunta(
                "11.- ¿Puedes darte cuenta rápido de cuál es el error de un compañero que no puede resolver un problema de matemáticas?",
                "No",
                "Si"
        ));
         AL_Preguntas.add(new Pregunta(
                "12.- ¿Te gusta conocer programas computacionales para hacer cálculos y operaciones matemáticas?",
                "Me desagrada",
                "Me es indiferente",
                "Me gusta"
        ));
          AL_Preguntas.add(new Pregunta(
                "13.- ¿Te gustaría aprender como un ingeniero aplica las matemáticas en su trabajo?",
                "No me interesa",
                "Me llama algo la atencion",
                "Me interesa"
        ));
           AL_Preguntas.add(new Pregunta(
                "14.- ¿Te interesaría observar como el centro de computación de una empresa organiza los datos referentes a nóminas prestaciones a los empleados?",
                "No me intereza",
                "Me llama algo la atencion",
                "Me gustaria"
        ));
        AL_Preguntas.add(new Pregunta(
                "15.- Cuando alguien critica tu trabajo generalmente tu:",
                "Buscas dar justificaciones o defenderte",
                "No le das mucha importancia",
                "Analizas la critica y tratas de mejorar"
        ));
       /* AL_Preguntas.add(new Pregunta(
                "16.- ¿Que tan responsable te consideras?",
                "Nada",
                "Algo",
                "Mucho"
        ));
         AL_Preguntas.add(new Pregunta(
                "17.-¿Cuantas horas estudias por tu cuenta a la semana?",
                "0-2",
                "3-6",
                "7+"
        ));
         AL_Preguntas.add(new Pregunta(
                "18.-¿Te consideras alguien autodidacta?",
                "Si",
                "No"
        ));
         AL_Preguntas.add(new Pregunta(
                "19.-¿Que tanto conoces la carga académica de la carrera?",
                "Poco",
                "Algo",                
                "Bastante"
        ));*/

    }

    public void setRespuestasUsuario(ArrayList Respuestas) {
        AL_RespuestasUsuario = Respuestas;
    }

}
