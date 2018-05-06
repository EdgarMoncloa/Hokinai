/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import Bus.Coneccion;
import Logica.Pregunta;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
//import java.awt.geom.AffineTransform;

/**
 *
 * @author e_raz
 */
public class JP_Preguntas extends javax.swing.JPanel {

    /**
     * Creates new form JP_Preguntas
     */
    // private boolean[] Bol_Seleccion;
    private BufferedImage[] BI_Respuestas, BI_Respuestas_Seleccion;
    private BufferedImage BI_Siguiente, BI_Anterior, BI_Siguiente_Terminar, BI_Anterior_Inicio;
    //private String[] STR_Preguntas;
    private String[] STR_Respuestas;
    private int INT_Apuntador;
    private Coneccion con;
    private ArrayList AL_Preguntas;
    private ArrayList AL_Respuestas;
    public JPanel JP_Inicio;

    public JP_Preguntas(Coneccion con) throws IOException {
        this.con = con;
        this.JP_Inicio = JP_Inicio;
        STR_Respuestas = new String[5];
        //Se Obtienen las preguntas
        AL_Preguntas = con.getPreguntas();
        AL_Respuestas = new ArrayList();
        //Bol_Seleccion = new boolean[5];
        BI_Respuestas = new BufferedImage[5];
        BI_Respuestas_Seleccion = new BufferedImage[5];
        INT_Apuntador = 0;
        for (int j = 0; j < 5; j++) {
            //Bol_Seleccion[j] = false;
            String urlRespuestas = "src/Interfaz/Preguntas1080/Bot_Respuesta" + (j + 1) + ".png";
            String urlRespuestas_Seleccion = "src/Interfaz/Preguntas1080/Bot_Respuesta" + (j + 1) + "_Seleccion.png";
            BI_Respuestas[j] = ImageIO.read(new File(urlRespuestas));
            BI_Respuestas_Seleccion[j] = ImageIO.read(new File(urlRespuestas_Seleccion));
        }
        BI_Siguiente = ImageIO.read(new File("src/Interfaz/Preguntas1080/Bot_Siguiente.png"));
        BI_Siguiente_Terminar = ImageIO.read(new File("src/Interfaz/Preguntas1080/Bot_Siguiente_Terminar.png"));
        BI_Anterior = ImageIO.read(new File("src/Interfaz/Preguntas1080/Bot_Anterior.png"));
        BI_Anterior_Inicio = ImageIO.read(new File("src/Interfaz/Preguntas1080/Bot_Anterior_Inicio.png"));
        initComponents();
        JB_Siguiente.setEnabled(false);
        escribirPreguntas();
        this.setBounds(0, 0, 1080, 720);
        this.setVisible(true);
    }

    public void escribirPreguntas() {
        int width = 200, height = 200;
        /*STR_Respuestas=new String[(((Pregunta) AL_Preguntas.get(INT_Apuntador)).getNRespuestas())];
        JL_Respuestas=new JLabel[(((Pregunta) AL_Preguntas.get(INT_Apuntador)).getNRespuestas())];       
        for(int j=0;j<(((Pregunta) AL_Preguntas.get(INT_Apuntador)).getNRespuestas());j++){            
        }*/
        switch (((Pregunta) AL_Preguntas.get(INT_Apuntador)).getNRespuestas()) {
            case 2:
                //Actibar labels
                JL_Respuesta1.setVisible(true);
                JL_Respuesta2.setVisible(true);
                JL_Respuesta3.setVisible(false);
                JL_Respuesta4.setVisible(false);
                JL_Respuesta5.setVisible(false);
                //activar botones
                JB_Respuesta1.setVisible(true);
                JB_Respuesta2.setVisible(true);
                JB_Respuesta3.setVisible(false);
                JB_Respuesta4.setVisible(false);
                JB_Respuesta5.setVisible(false);
                //posicionar botones                    
                JB_Respuesta1.setBounds(300, 400, width, height);
                JB_Respuesta2.setBounds(600, 400, width, height);
                //posicionar Labels
                JL_Respuesta1.setBounds(350, 370, width, height);
                JL_Respuesta2.setBounds(650, 370, width, height);
                //Escribir texto
                //Escribir texto
                JL_Respuesta1.setText(((Pregunta) AL_Preguntas.get(INT_Apuntador)).getRespuesta(0));
                JL_Respuesta2.setText(((Pregunta) AL_Preguntas.get(INT_Apuntador)).getRespuesta(1));
                break;
            case 3:
                //Actibar labels
                JL_Respuesta1.setVisible(true);
                JL_Respuesta2.setVisible(true);
                JL_Respuesta3.setVisible(true);
                JL_Respuesta4.setVisible(false);
                JL_Respuesta5.setVisible(false);
                //activar botones
                JB_Respuesta1.setVisible(true);
                JB_Respuesta2.setVisible(true);
                JB_Respuesta3.setVisible(true);
                JB_Respuesta4.setVisible(false);
                JB_Respuesta5.setVisible(false);
                //posicionar botones                   
                JB_Respuesta1.setBounds(200, 350, width, height);
                JB_Respuesta2.setBounds(450, 500, width, height);
                JB_Respuesta3.setBounds(700, 350, width, height);
                //posicionar Labels
                JL_Respuesta1.setBounds(250, 320, width, height);
                JL_Respuesta2.setBounds(500, 470, width, height);
                JL_Respuesta3.setBounds(750, 320, width, height);
                //Escribir texto
                JL_Respuesta1.setText(((Pregunta) AL_Preguntas.get(INT_Apuntador)).getRespuesta(0));
                JL_Respuesta2.setText(((Pregunta) AL_Preguntas.get(INT_Apuntador)).getRespuesta(1));
                JL_Respuesta3.setText(((Pregunta) AL_Preguntas.get(INT_Apuntador)).getRespuesta(2));
                break;
            case 4:
                //Actibar labels
                JL_Respuesta1.setVisible(true);
                JL_Respuesta2.setVisible(true);
                JL_Respuesta3.setVisible(true);
                JL_Respuesta4.setVisible(true);
                JL_Respuesta5.setVisible(false);
                //activar botones
                JB_Respuesta1.setVisible(true);
                JB_Respuesta2.setVisible(true);
                JB_Respuesta3.setVisible(true);
                JB_Respuesta4.setVisible(true);
                JB_Respuesta5.setVisible(false);
                //posicionar botones               
                JB_Respuesta1.setBounds(220, 310, width, height);
                JB_Respuesta2.setBounds(660, 320, width, height);
                JB_Respuesta3.setBounds(350, 510, width, height);
                JB_Respuesta4.setBounds(600, 510, width, height);
                //posicionar Labels
                JL_Respuesta1.setBounds(270, 280, width, height);
                JL_Respuesta2.setBounds(710, 290, width, height);
                JL_Respuesta3.setBounds(400, 480, width, height);
                JL_Respuesta4.setBounds(650, 480, width, height);
                //Escribir texto
                JL_Respuesta1.setText(((Pregunta) AL_Preguntas.get(INT_Apuntador)).getRespuesta(0));
                JL_Respuesta2.setText(((Pregunta) AL_Preguntas.get(INT_Apuntador)).getRespuesta(1));
                JL_Respuesta3.setText(((Pregunta) AL_Preguntas.get(INT_Apuntador)).getRespuesta(2));
                JL_Respuesta4.setText(((Pregunta) AL_Preguntas.get(INT_Apuntador)).getRespuesta(3));
                break;
            case 5:
                //Actibar labels
                JL_Respuesta1.setVisible(true);
                JL_Respuesta2.setVisible(true);
                JL_Respuesta3.setVisible(true);
                JL_Respuesta4.setVisible(true);
                JL_Respuesta5.setVisible(true);
                //activar botones
                JB_Respuesta1.setVisible(true);
                JB_Respuesta2.setVisible(true);
                JB_Respuesta3.setVisible(true);
                JB_Respuesta4.setVisible(true);
                JB_Respuesta5.setVisible(true);
                //posicionar botones                  
                JB_Respuesta1.setBounds(120, 310, width, height);
                JB_Respuesta2.setBounds(410, 320, width, height);
                JB_Respuesta3.setBounds(750, 310, width, height);
                JB_Respuesta4.setBounds(270, 510, width, height);
                JB_Respuesta5.setBounds(600, 510, width, height);
                //posicionar Labels
                JL_Respuesta1.setBounds(170, 280, width, height);
                JL_Respuesta2.setBounds(460, 290, width, height);
                JL_Respuesta3.setBounds(800, 280, width, height);
                JL_Respuesta4.setBounds(320, 480, width, height);
                JL_Respuesta5.setBounds(650, 480, width, height);
                //Escribir texto
                JL_Respuesta1.setText(((Pregunta) AL_Preguntas.get(INT_Apuntador)).getRespuesta(0));
                JL_Respuesta2.setText(((Pregunta) AL_Preguntas.get(INT_Apuntador)).getRespuesta(1));
                JL_Respuesta3.setText(((Pregunta) AL_Preguntas.get(INT_Apuntador)).getRespuesta(2));
                JL_Respuesta4.setText(((Pregunta) AL_Preguntas.get(INT_Apuntador)).getRespuesta(3));
                JL_Respuesta5.setText(((Pregunta) AL_Preguntas.get(INT_Apuntador)).getRespuesta(4));
                break;
            default:
                break;
        }
        JL_Pregunta.setText(((Pregunta) AL_Preguntas.get(INT_Apuntador)).getPregunta());

        /*JL_Pregunta.setText(STR_Preguntas[INT_Apuntador]);
        JL_Respuesta1.setText(STR_Respuestas[INT_Apuntador][0]);
        JL_Respuesta2.setText(STR_Respuestas[INT_Apuntador][1]);
        JL_Respuesta3.setText(STR_Respuestas[INT_Apuntador][2]);
        JL_Respuesta4.setText(STR_Respuestas[INT_Apuntador][3]);
        JL_Respuesta5.setText(STR_Respuestas[INT_Apuntador][4]);*/
    }

    public void redibujar(int entrada) {
        //si se selecciono un boton se puede seguir adelante

        //reinicia los estados de los botones        
        JB_Respuesta1.setIcon(new ImageIcon(BI_Respuestas[0]));
        JB_Respuesta2.setIcon(new ImageIcon(BI_Respuestas[1]));
        JB_Respuesta3.setIcon(new ImageIcon(BI_Respuestas[2]));
        JB_Respuesta4.setIcon(new ImageIcon(BI_Respuestas[3]));
        JB_Respuesta5.setIcon(new ImageIcon(BI_Respuestas[4]));
        //verifica si se selecciono algun boton
        if (entrada < 5) {            
            if (AL_Respuestas.size() <= INT_Apuntador) {
                AL_Respuestas.add(entrada);
               
            } else {
                AL_Respuestas.set(INT_Apuntador, entrada);
            }
            switch (entrada) {
                case 0:
                    JB_Respuesta1.setIcon(new ImageIcon(BI_Respuestas_Seleccion[0]));
                    break;
                case 1:
                    JB_Respuesta2.setIcon(new ImageIcon(BI_Respuestas_Seleccion[1]));
                    break;
                case 2:
                    JB_Respuesta3.setIcon(new ImageIcon(BI_Respuestas_Seleccion[2]));
                    break;
                case 3:
                    JB_Respuesta4.setIcon(new ImageIcon(BI_Respuestas_Seleccion[3]));
                    break;
                case 4:
                    JB_Respuesta5.setIcon(new ImageIcon(BI_Respuestas_Seleccion[4]));
                    break;
                default:
                    break;
            }
        } else {
            //Verifica si se regreso 
            if (INT_Apuntador < AL_Respuestas.size()) {
                switch ((int) AL_Respuestas.get(INT_Apuntador)) {
                    case 0:
                        JB_Respuesta1.setIcon(new ImageIcon(BI_Respuestas_Seleccion[0]));
                        break;
                    case 1:
                        JB_Respuesta2.setIcon(new ImageIcon(BI_Respuestas_Seleccion[1]));
                        break;
                    case 2:
                        JB_Respuesta3.setIcon(new ImageIcon(BI_Respuestas_Seleccion[2]));
                        break;
                    case 3:
                        JB_Respuesta4.setIcon(new ImageIcon(BI_Respuestas_Seleccion[3]));
                        break;
                    case 4:
                        JB_Respuesta5.setIcon(new ImageIcon(BI_Respuestas_Seleccion[4]));
                        break;
                    default:
                        break;
                }
            }

        }
        //if (INT_Apuntador <= AL_Respuestas.size() - 1) {
        JB_Siguiente.setEnabled(true);
        //}
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JB_Anterior = new javax.swing.JButton();
        JB_Siguiente = new javax.swing.JButton();
        JL_SoporteExtra = new javax.swing.JLabel();
        JL_Marco = new javax.swing.JLabel();
        JL_Respuesta1 = new javax.swing.JLabel();
        JL_Respuesta2 = new javax.swing.JLabel();
        JL_Respuesta3 = new javax.swing.JLabel();
        JL_Respuesta4 = new javax.swing.JLabel();
        JL_Respuesta5 = new javax.swing.JLabel();
        JB_Respuesta1 = new javax.swing.JButton();
        JB_Respuesta2 = new javax.swing.JButton();
        JB_Respuesta3 = new javax.swing.JButton();
        JB_Respuesta4 = new javax.swing.JButton();
        JB_Respuesta5 = new javax.swing.JButton();
        JL_Pregunta = new javax.swing.JLabel();
        JL_FondoPregunta = new javax.swing.JLabel();
        JL_Fondo = new javax.swing.JLabel();
        JL_Vidrio = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1080, 720));
        setLayout(null);

        JB_Anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Preguntas1080/Bot_Anterior_Inicio.png"))); // NOI18N
        JB_Anterior.setBorderPainted(false);
        JB_Anterior.setContentAreaFilled(false);
        JB_Anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Accion_Anterior(evt);
            }
        });
        add(JB_Anterior);
        JB_Anterior.setBounds(-40, 570, 230, 100);

        JB_Siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Preguntas1080/Bot_Siguiente.png"))); // NOI18N
        JB_Siguiente.setBorderPainted(false);
        JB_Siguiente.setContentAreaFilled(false);
        JB_Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Accion_Siguiente(evt);
            }
        });
        add(JB_Siguiente);
        JB_Siguiente.setBounds(830, 570, 250, 100);

        JL_SoporteExtra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Preguntas1080/Fon_SoporteExtra.png"))); // NOI18N
        add(JL_SoporteExtra);
        JL_SoporteExtra.setBounds(-60, 30, 230, 190);

        JL_Marco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Preguntas1080/Fon_Marco.png"))); // NOI18N
        add(JL_Marco);
        JL_Marco.setBounds(0, 0, 1080, 720);

        JL_Respuesta1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JL_Respuesta1.setText("Texto de prueba");
        add(JL_Respuesta1);
        JL_Respuesta1.setBounds(160, 380, 140, 80);

        JL_Respuesta2.setText("Texto de prueba");
        add(JL_Respuesta2);
        JL_Respuesta2.setBounds(460, 380, 160, 80);

        JL_Respuesta3.setText("Texto de prueba");
        add(JL_Respuesta3);
        JL_Respuesta3.setBounds(750, 370, 140, 80);

        JL_Respuesta4.setText("Texto de prueba");
        add(JL_Respuesta4);
        JL_Respuesta4.setBounds(320, 550, 80, 14);

        JL_Respuesta5.setText("Texto de prueba");
        add(JL_Respuesta5);
        JL_Respuesta5.setBounds(660, 590, 80, 14);

        JB_Respuesta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Preguntas1080/Bot_Respuesta1.png"))); // NOI18N
        JB_Respuesta1.setBorderPainted(false);
        JB_Respuesta1.setContentAreaFilled(false);
        JB_Respuesta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Accion_respuesta1(evt);
            }
        });
        add(JB_Respuesta1);
        JB_Respuesta1.setBounds(110, 330, 200, 200);

        JB_Respuesta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Preguntas1080/Bot_Respuesta2.png"))); // NOI18N
        JB_Respuesta2.setBorderPainted(false);
        JB_Respuesta2.setContentAreaFilled(false);
        JB_Respuesta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Accion_respuesta2(evt);
            }
        });
        add(JB_Respuesta2);
        JB_Respuesta2.setBounds(410, 330, 200, 200);

        JB_Respuesta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Preguntas1080/Bot_Respuesta3.png"))); // NOI18N
        JB_Respuesta3.setBorderPainted(false);
        JB_Respuesta3.setContentAreaFilled(false);
        JB_Respuesta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Accion_respuesta3(evt);
            }
        });
        add(JB_Respuesta3);
        JB_Respuesta3.setBounds(710, 320, 200, 200);

        JB_Respuesta4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Preguntas1080/Bot_Respuesta4.png"))); // NOI18N
        JB_Respuesta4.setBorderPainted(false);
        JB_Respuesta4.setContentAreaFilled(false);
        JB_Respuesta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Accion_respuesta4(evt);
            }
        });
        add(JB_Respuesta4);
        JB_Respuesta4.setBounds(270, 500, 200, 200);

        JB_Respuesta5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Preguntas1080/Bot_Respuesta5.png"))); // NOI18N
        JB_Respuesta5.setBorderPainted(false);
        JB_Respuesta5.setContentAreaFilled(false);
        JB_Respuesta5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Accion_respuesta5(evt);
            }
        });
        add(JB_Respuesta5);
        JB_Respuesta5.setBounds(590, 500, 200, 200);

        JL_Pregunta.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        JL_Pregunta.setText("-------------------------------------------------------------------------------------------------------------------------------------**-*-*-*-*-*-*-*");
        add(JL_Pregunta);
        JL_Pregunta.setBounds(250, 50, 590, 200);

        JL_FondoPregunta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Preguntas1080/Fon_Pregunta.png"))); // NOI18N
        add(JL_FondoPregunta);
        JL_FondoPregunta.setBounds(10, -30, 1080, 720);

        JL_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Preguntas1080/Fon_Base.png"))); // NOI18N
        add(JL_Fondo);
        JL_Fondo.setBounds(0, 0, 1080, 720);

        JL_Vidrio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Preguntas1080/Fon_Vidrio.png"))); // NOI18N
        add(JL_Vidrio);
        JL_Vidrio.setBounds(0, 0, 1080, 720);
    }// </editor-fold>//GEN-END:initComponents

    private void Accion_respuesta1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Accion_respuesta1
        redibujar(0);
    }//GEN-LAST:event_Accion_respuesta1

    private void Accion_respuesta2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Accion_respuesta2
        redibujar(1);
    }//GEN-LAST:event_Accion_respuesta2

    private void Accion_respuesta3(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Accion_respuesta3
        redibujar(2);
    }//GEN-LAST:event_Accion_respuesta3

    private void Accion_respuesta4(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Accion_respuesta4
        redibujar(3);
    }//GEN-LAST:event_Accion_respuesta4

    private void Accion_respuesta5(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Accion_respuesta5
        redibujar(4);
    }//GEN-LAST:event_Accion_respuesta5

    private void Accion_Siguiente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Accion_Siguiente

        if (INT_Apuntador == AL_Preguntas.size() - 1) {
            con.setRespuestasUsuario(AL_Respuestas);
            con.cambiarEstadisticas();
        } else {
            if (INT_Apuntador < AL_Preguntas.size() - 1) {
                INT_Apuntador += 1;
                redibujar(10);
                escribirPreguntas();
                JB_Siguiente.setIcon(new ImageIcon(BI_Siguiente));
                JB_Anterior.setIcon(new ImageIcon(BI_Anterior));

            }
            //si es el ultimo numero cambia el boton a terminar
            if (INT_Apuntador == AL_Preguntas.size() - 1) {
                JB_Siguiente.setIcon(new ImageIcon(BI_Siguiente_Terminar));
            }
            //si no se ha contestado la pregunta no se permite dar siguiente         
            if (INT_Apuntador == AL_Respuestas.size()) {
                JB_Siguiente.setEnabled(false);
            }
        }

        


    }//GEN-LAST:event_Accion_Siguiente

    private void Accion_Anterior(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Accion_Anterior

        
        if (INT_Apuntador == 0) {
            try {
                con.cambiarInicio();
            } catch (IOException ex) {
                Logger.getLogger(JP_Preguntas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (INT_Apuntador == 1) {
            JB_Anterior.setIcon(new ImageIcon(BI_Anterior_Inicio));
            INT_Apuntador -= 1;
        }
        if (INT_Apuntador > 1) {
            JB_Anterior.setIcon(new ImageIcon(BI_Anterior));
            INT_Apuntador -= 1;
        }
        redibujar(10);
        escribirPreguntas();

    }//GEN-LAST:event_Accion_Anterior


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_Anterior;
    private javax.swing.JButton JB_Respuesta1;
    private javax.swing.JButton JB_Respuesta2;
    private javax.swing.JButton JB_Respuesta3;
    private javax.swing.JButton JB_Respuesta4;
    private javax.swing.JButton JB_Respuesta5;
    private javax.swing.JButton JB_Siguiente;
    private javax.swing.JLabel JL_Fondo;
    private javax.swing.JLabel JL_FondoPregunta;
    private javax.swing.JLabel JL_Marco;
    private javax.swing.JLabel JL_Pregunta;
    private javax.swing.JLabel JL_Respuesta1;
    private javax.swing.JLabel JL_Respuesta2;
    private javax.swing.JLabel JL_Respuesta3;
    private javax.swing.JLabel JL_Respuesta4;
    private javax.swing.JLabel JL_Respuesta5;
    private javax.swing.JLabel JL_SoporteExtra;
    private javax.swing.JLabel JL_Vidrio;
    // End of variables declaration//GEN-END:variables
}
