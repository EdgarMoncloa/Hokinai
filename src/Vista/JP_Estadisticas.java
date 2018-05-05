/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleInsets;
import Bus.Coneccion;
/**
 *
 * @author EdgarMoncloa
 */
public class JP_Estadisticas extends javax.swing.JPanel {

    /**
     * Creates new form JP_Estadisticas
     */
    private JFreeChart JFC_Grafica;
    private DefaultPieDataset DPD_Datos;
    private PiePlot PiP_Plot;
    private ChartPanel CP_Grafica;
    Coneccion con;
    double probabilidad;
    public JPanel JP_Inicio;
    public JP_Estadisticas(Coneccion con) {
        this.con=con;
        this.JP_Inicio=JP_Inicio;
        probabilidad=Math.random();
        initComponents();
        DPD_Datos=new DefaultPieDataset();
        DPD_Datos.insertValue(0, "probabilidad", probabilidad);
        DPD_Datos.insertValue(0, "fracaso", (1-probabilidad));
        JFC_Grafica=ChartFactory.createRingChart("Probabilidad de Exito", DPD_Datos, false, false, false);
        CP_Grafica=new ChartPanel(JFC_Grafica);
        CP_Grafica.setVisible(true);
        CP_Grafica.setBounds(-2, -2, 300, 300);
        JFC_Grafica.setBorderVisible(false);
        PiP_Plot=(PiePlot)JFC_Grafica.getPlot();
        PiP_Plot.setSectionPaint("probabilidad", Color.BLACK);
        PiP_Plot.setSectionPaint("fracaso", Color.WHITE);
        PiP_Plot.setBackgroundPaint(Color.WHITE);
        PiP_Plot.setBackgroundAlpha(0);
        PiP_Plot.setLabelGenerator(null);
        PiP_Plot.setInsets(new RectangleInsets(0,0,0, 0));
        JP_Probabilidad.add(CP_Grafica);
        JP_Probabilidad.setEnabled(false);
        JL_Probabilidad.setText(String.valueOf((int)(probabilidad*100))+"%");
        
        this.setBounds(0, 0, 1080, 720);           
        this.setVisible(true);
        
    }
    public JPanel getPanel(){
        return this;
    }
    public void calcularRandom(){
        probabilidad=Math.random();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        JP_Probabilidad = new java.awt.Panel();
        JL_Probabilidad = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(157, 11, 11));
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Estadisticas1080/Bot_Menu.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(440, 640, 210, 80);

        JP_Probabilidad.setBackground(new java.awt.Color(255, 255, 255));
        JP_Probabilidad.setMinimumSize(new java.awt.Dimension(300, 300));
        JP_Probabilidad.setPreferredSize(new java.awt.Dimension(300, 300));
        JP_Probabilidad.setLayout(null);

        JL_Probabilidad.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        JL_Probabilidad.setText("Exito");
        JP_Probabilidad.add(JL_Probabilidad);
        JL_Probabilidad.setBounds(100, 130, 100, 50);

        add(JP_Probabilidad);
        JP_Probabilidad.setBounds(400, 180, 300, 300);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Estadisticas1080/Fon_Estadisticas.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1080, 720);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            con.cambiarInicio();
        } catch (IOException ex) {
            Logger.getLogger(JP_Estadisticas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JL_Probabilidad;
    private java.awt.Panel JP_Probabilidad;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
