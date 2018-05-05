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
/**
 *
 * @author EdgarMoncloa
 */
public class Coneccion extends JFrame{
   // private JFrame Ventana;
    private JPanel JP_Principal;
    private Ventana Ventana;
    private ArrayList AL_Preguntas;
    private BDD_Coneccion BDD;
    
    public Coneccion() throws IOException{
        BDD=new BDD_Coneccion();
        BDD.BDD_Coneccion();
        BDD.mostrarAlumnos();
        AL_Preguntas=new ArrayList();
        Ventana=new Ventana(this);
        JP_Principal=Ventana.getPanelPrincipal();
        JP_Principal.add(new JP_Inicio(this));            
        Ventana.setVisible(true);        
    }
    public void cambiarInicio() throws IOException{
        JP_Principal.removeAll(); 
        JP_Principal.add(new JP_Inicio(this));                      
        JP_Principal.repaint();  
    }
    public void cambiarPreguntas() throws IOException{
        JP_Principal.removeAll(); 
        JP_Principal.add(new JP_Preguntas(this));        
        JP_Principal.repaint();        
    }
    public void cambiarEstadisticas(){
        JP_Principal.removeAll(); 
        JP_Principal.add(new JP_Estadisticas(this));        
        JP_Principal.repaint();          
    }
}
