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
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.awt.geom.AffineTransform;

/**
 *
 * @author e_raz
 */
public class JP_Preguntas extends javax.swing.JPanel {

    /**
     * Creates new form JP_Preguntas
     */
    
    private boolean[] Bol_Seleccion;
    private BufferedImage[] BI_Respuestas,BI_Respuestas_Seleccion;
    private BufferedImage BI_Siguiente,BI_Anterior,BI_Siguiente_Terminar,BI_Anterior_Inicio;
    private String[] STR_Preguntas;
    private String[][] STR_Respuestas;
    int INT_Apuntador;
    private Coneccion con;
    
    public JPanel JP_Inicio;
    public JP_Preguntas(Coneccion con) throws IOException {
      this.con=con;
      this.JP_Inicio=JP_Inicio;
      STR_Preguntas=new String[5];
      STR_Respuestas=new String[5][5];
      InicializarPreguntas(); 
      Bol_Seleccion=new boolean[5];
      BI_Respuestas=new BufferedImage[5];
      BI_Respuestas_Seleccion=new BufferedImage[5];
      INT_Apuntador=0;         
      for(int j=0;j<5;j++){
            Bol_Seleccion[j]=false;              
            String urlRespuestas="src/Interfaz/Preguntas1080/Bot_Respuesta"+(j+1)+".png";            
            String urlRespuestas_Seleccion="src/Interfaz/Preguntas1080/Bot_Respuesta"+(j+1)+"_Seleccion.png";
            BI_Respuestas[j]=ImageIO.read(new File(urlRespuestas));
            BI_Respuestas_Seleccion[j]=ImageIO.read(new File(urlRespuestas_Seleccion));
       }  
      BI_Siguiente=ImageIO.read(new File("src/Interfaz/Preguntas1080/Bot_Siguiente.png"));
      BI_Siguiente_Terminar=ImageIO.read(new File("src/Interfaz/Preguntas1080/Bot_Siguiente_Terminar.png"));
      BI_Anterior=ImageIO.read(new File("src/Interfaz/Preguntas1080/Bot_Anterior.png"));
      BI_Anterior_Inicio=ImageIO.read(new File("src/Interfaz/Preguntas1080/Bot_Anterior_Inicio.png"));
        initComponents(); 
        escribirPreguntas();
      this.setBounds(0, 0, 1080, 720);           
      this.setVisible(true);
    }
    //Se comprueba si existe otra respuesta ya seleccionada
    public void InicializarPreguntas(){        
        for (int j=0;j<5;j++){
            STR_Preguntas[j]="<html><boddy>Pregunta de ejemplo "+(j+1)+"<br> ****************************<br>****************************<br>*************</boddy></html>";
            for(int k=0;k<5;k++){
                STR_Respuestas[j][k]="<html><boddy>Respuesta "+(j+1)+"."+(k+1)+"<br>*************<br>****************<br>*********</boddy></html>";
            }
            
        }        
        
    }
    public boolean comprobarSeleccion(int pregunta){
        for(int j=0;j<5;j++){
            if(j!=pregunta && Bol_Seleccion[j]){
                return true;
            }      
        }        
        return false;        
    }    
    public void escribirPreguntas(){
        JL_Pregunta.setText(STR_Preguntas[INT_Apuntador]);
        JL_Respuesta1.setText(STR_Respuestas[INT_Apuntador][0]);
        JL_Respuesta2.setText(STR_Respuestas[INT_Apuntador][1]);
        JL_Respuesta3.setText(STR_Respuestas[INT_Apuntador][2]);
        JL_Respuesta4.setText(STR_Respuestas[INT_Apuntador][3]);
        JL_Respuesta5.setText(STR_Respuestas[INT_Apuntador][4]);
    }
    public void redibujar(int entrada){                  
        for(int j=0;j<5;j++){
                Bol_Seleccion[j]=false;                
        }            
            JB_Respuesta1.setIcon(new ImageIcon(BI_Respuestas[0]));
            JB_Respuesta2.setIcon(new ImageIcon(BI_Respuestas[1]));
            JB_Respuesta3.setIcon(new ImageIcon(BI_Respuestas[2]));
            JB_Respuesta4.setIcon(new ImageIcon(BI_Respuestas[3]));
            JB_Respuesta5.setIcon(new ImageIcon(BI_Respuestas[4]));
         if(entrada<5){  
            Bol_Seleccion[entrada]=true;
        }
          switch(entrada){
                case 1: 
                    JB_Respuesta1.setIcon(new ImageIcon(BI_Respuestas_Seleccion[0]));
                    break;
                case 2: 
                    JB_Respuesta2.setIcon(new ImageIcon(BI_Respuestas_Seleccion[1]));
                    break;
                case 3: 
                    JB_Respuesta3.setIcon(new ImageIcon(BI_Respuestas_Seleccion[2]));
                    break;
                case 4: 
                    JB_Respuesta4.setIcon(new ImageIcon(BI_Respuestas_Seleccion[3]));
                    break;
                case 5: 
                    JB_Respuesta5.setIcon(new ImageIcon(BI_Respuestas_Seleccion[4]));
                    break;
                default:                    
                    break;
            }
        
    }
 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JB_Respuesta5 = new javax.swing.JButton();
        JL_Respuesta5 = new javax.swing.JLabel();
        JB_Respuesta4 = new javax.swing.JButton();
        JL_Respuesta4 = new javax.swing.JLabel();
        JB_Anterior = new javax.swing.JButton();
        JB_Siguiente = new javax.swing.JButton();
        JL_SoporteExtra = new javax.swing.JLabel();
        JL_Respuesta1 = new javax.swing.JLabel();
        JL_Respuesta2 = new javax.swing.JLabel();
        JL_Respuesta3 = new javax.swing.JLabel();
        JB_Respuesta1 = new javax.swing.JButton();
        JB_Respuesta2 = new javax.swing.JButton();
        JB_Respuesta3 = new javax.swing.JButton();
        JL_Pregunta = new javax.swing.JLabel();
        JL_FondoPregunta = new javax.swing.JLabel();
        JL_Fondo = new javax.swing.JLabel();
        JL_Vidrio = new javax.swing.JLabel();

        JB_Respuesta5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Preguntas1080/Bot_Respuesta5.png"))); // NOI18N
        JB_Respuesta5.setBorderPainted(false);
        JB_Respuesta5.setContentAreaFilled(false);
        JB_Respuesta5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Accion_respuesta5(evt);
            }
        });

        JL_Respuesta5.setText("Texto de prueba");

        JB_Respuesta4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Preguntas1080/Bot_Respuesta4.png"))); // NOI18N
        JB_Respuesta4.setBorderPainted(false);
        JB_Respuesta4.setContentAreaFilled(false);
        JB_Respuesta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Accion_respuesta4(evt);
            }
        });

        JL_Respuesta4.setText("Texto de prueba");

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

        JL_Respuesta1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JL_Respuesta1.setText("Texto de prueba");
        add(JL_Respuesta1);
        JL_Respuesta1.setBounds(220, 440, 140, 80);

        JL_Respuesta2.setText("Texto de prueba");
        add(JL_Respuesta2);
        JL_Respuesta2.setBounds(460, 510, 160, 80);

        JL_Respuesta3.setText("Texto de prueba");
        add(JL_Respuesta3);
        JL_Respuesta3.setBounds(710, 430, 140, 80);

        JB_Respuesta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Preguntas1080/Bot_Respuesta1.png"))); // NOI18N
        JB_Respuesta1.setBorderPainted(false);
        JB_Respuesta1.setContentAreaFilled(false);
        JB_Respuesta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Accion_respuesta1(evt);
            }
        });
        add(JB_Respuesta1);
        JB_Respuesta1.setBounds(160, 360, 240, 250);

        JB_Respuesta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Preguntas1080/Bot_Respuesta2.png"))); // NOI18N
        JB_Respuesta2.setBorderPainted(false);
        JB_Respuesta2.setContentAreaFilled(false);
        JB_Respuesta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Accion_respuesta2(evt);
            }
        });
        add(JB_Respuesta2);
        JB_Respuesta2.setBounds(420, 450, 250, 220);

        JB_Respuesta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Preguntas1080/Bot_Respuesta3.png"))); // NOI18N
        JB_Respuesta3.setBorderPainted(false);
        JB_Respuesta3.setContentAreaFilled(false);
        JB_Respuesta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Accion_respuesta3(evt);
            }
        });
        add(JB_Respuesta3);
        JB_Respuesta3.setBounds(650, 390, 250, 210);

        JL_Pregunta.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        JL_Pregunta.setText("-------------------------------------------------------------------------------------------------------------------------------------**-*-*-*-*-*-*-*");
        add(JL_Pregunta);
        JL_Pregunta.setBounds(240, 90, 590, 200);

        JL_FondoPregunta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Preguntas1080/Fon_Pregunta.png"))); // NOI18N
        add(JL_FondoPregunta);
        JL_FondoPregunta.setBounds(20, 0, 1080, 720);

        JL_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Preguntas1080/Fon_Base.png"))); // NOI18N
        add(JL_Fondo);
        JL_Fondo.setBounds(0, 0, 1080, 720);

        JL_Vidrio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Preguntas1080/Fon_Vidrio.png"))); // NOI18N
        add(JL_Vidrio);
        JL_Vidrio.setBounds(0, 0, 1080, 720);
    }// </editor-fold>//GEN-END:initComponents

    private void Accion_respuesta1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Accion_respuesta1
       redibujar(1);
    }//GEN-LAST:event_Accion_respuesta1

    private void Accion_respuesta2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Accion_respuesta2
       redibujar(2);
    }//GEN-LAST:event_Accion_respuesta2

    private void Accion_respuesta3(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Accion_respuesta3
        redibujar(3);
    }//GEN-LAST:event_Accion_respuesta3

    private void Accion_respuesta4(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Accion_respuesta4
        redibujar(4);
    }//GEN-LAST:event_Accion_respuesta4

    private void Accion_respuesta5(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Accion_respuesta5
       redibujar(5);
    }//GEN-LAST:event_Accion_respuesta5

    private void Accion_Siguiente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Accion_Siguiente
         if(INT_Apuntador==STR_Preguntas.length-1){             
            /* JP_Estadisticas JPO_Est=new JP_Estadisticas(con);
             this.removeAll();;
             JPO_Est.getPanel().setVisible(true);
             JPO_Est.getPanel().setBounds(0, 0, 1200, 720);
             this.add(JPO_Est.getPanel());
             this.repaint();*/
             con.cambiarEstadisticas();
         }
        if(INT_Apuntador<STR_Preguntas.length-1){
        INT_Apuntador+=1;
        escribirPreguntas();
        redibujar(10);
        JB_Siguiente.setIcon(new ImageIcon(BI_Siguiente)); 
        JB_Anterior.setIcon(new ImageIcon(BI_Anterior)); 
        }
        if(INT_Apuntador==4){
            JB_Siguiente.setIcon(new ImageIcon(BI_Siguiente_Terminar)); 
        }
        
    }//GEN-LAST:event_Accion_Siguiente

    private void Accion_Anterior(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Accion_Anterior
        System.out.println(INT_Apuntador);
        if(INT_Apuntador==0){
            try {
                con.cambiarInicio();
            } catch (IOException ex) {
                Logger.getLogger(JP_Preguntas.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         if(INT_Apuntador==1){
            JB_Anterior.setIcon(new ImageIcon(BI_Anterior_Inicio)); 
            INT_Apuntador-=1; 
            System.out.println(INT_Apuntador);
        }    
        if(INT_Apuntador>1){  
        INT_Apuntador-=1;    
        escribirPreguntas();
        redibujar(10);
        JB_Anterior.setIcon(new ImageIcon(BI_Anterior)); 
        System.out.println(INT_Apuntador);
        }
      
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
