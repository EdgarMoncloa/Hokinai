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
import Logica.RedBayesiana.Red_Bayesiana;

/**
 *
 * @author EdgarMoncloa
 */
public class Coneccion extends JFrame {
    // private JFrame Ventana;

    private JPanel JP_Principal;
    private Ventana Ventana;
    private BDD_Coneccion BDD;
    private ArrayList AL_Preguntas;
    private ArrayList AL_RespuestasUsuario;
    private double Dec_ProbExito;
    private boolean bol_Estadisticas;

    public Coneccion() throws IOException {
        AL_Preguntas = new ArrayList();
        bol_Estadisticas = false;
        inicializarPreguntas();
        AL_RespuestasUsuario = new ArrayList();
        BDD = new BDD_Coneccion();
        BDD.BDD_Coneccion();
        //BDD.mostrarAlumnos();        
        Ventana = new Ventana(this);
        JP_Principal = Ventana.getPanelPrincipal();
        JP_Principal.add(new JP_Inicio(this, bol_Estadisticas));
        Ventana.setVisible(true);
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
                formatoHtmlPregunta("1.- ¿Como piensas pagar tu inscripción?"),
                formatoHtmlRespuesta("Trabajando y estudiando"),
                formatoHtmlRespuesta("Con una Beca"),
                formatoHtmlRespuesta("La pagaran mis padres"),
                null,
                null));
        AL_Preguntas.add(new Pregunta(
                formatoHtmlPregunta("2.- ¿Has trabajado alguna vez en una empresa?  "),
                formatoHtmlRespuesta("Si"),
                formatoHtmlRespuesta("No"),
                null,
                null,
                null));
        AL_Preguntas.add(new Pregunta(
                formatoHtmlPregunta("3.- ¿Estas informado o te interesan los avances tecnológicos actuales en áreas de la carrera?"),
                formatoHtmlRespuesta("Si"),
                formatoHtmlRespuesta("No"),
                formatoHtmlRespuesta("Me interesan pero no estoy muy informado"),
                null,
                null));
        AL_Preguntas.add(new Pregunta(
                formatoHtmlPregunta("4.- ¿Cuantas materias reprobaste el último año de preparatoria?"),
                formatoHtmlRespuesta("Ninguna"),
                formatoHtmlRespuesta("1-2"),
                formatoHtmlRespuesta("3 o más"),
                null,
                null));
        AL_Preguntas.add(new Pregunta(
                formatoHtmlPregunta("23.- Cuando alguien critica tu trabajo generalmente tu:"),
                formatoHtmlRespuesta("Buscas dar justificaciones o defenderte"),
                formatoHtmlRespuesta("No le das mucha importancia"),
                formatoHtmlRespuesta("Analizas la critica y tratas de mejorar"),
                null,
                null));
        AL_Preguntas.add(new Pregunta(
                formatoHtmlPregunta("24.- ¿Que tan responsable te consideras?"),
                formatoHtmlRespuesta("Nada"),
                formatoHtmlRespuesta("Poco"),
                formatoHtmlRespuesta("Algo"),
                formatoHtmlRespuesta("Bastante"),
                formatoHtmlRespuesta("Mucho")));

    }

    private String formatoHtmlRespuesta(String texto) {
        return "<HTML><BODY><H3>" + texto + "</H3></BODY></HTML>";
    }

    private String formatoHtmlPregunta(String texto) {
        return "<HTML><BODY><H1>" + texto + "</H1></BODY></HTML>";
    }

    public void setRespuestasUsuario(ArrayList Respuestas) {
        AL_RespuestasUsuario = Respuestas;
    }

}
