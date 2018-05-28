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
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleEdge;
/**
 *
 * @author EdgarMoncloa
 */
public class JP_Estadisticas extends javax.swing.JPanel {

    /**
     * Creates new form JP_Estadisticas
     */
    private CategoryDataset CD_Categorias;
    private JFreeChart Gra_Categorias ;
    
    private JFreeChart JFC_Grafica;
    private DefaultPieDataset DPD_Datos;
    private PiePlot PiP_Plot;
    private ChartPanel CP_Grafica;
    Coneccion con;
    double probabilidad;
    private JPanel JP_Inicio;
    private static double[] dob_Categorias;
    public JP_Estadisticas(Coneccion con) {
        this.con=con;
        this.JP_Inicio=JP_Inicio;
        dob_Categorias=con.dob_Categorias;
        probabilidad=con.getProbExito();
        initComponents();
        //agrega valores a la tabla con la probabilidad de exito
        DPD_Datos=new DefaultPieDataset();
        DPD_Datos.insertValue(0, "probabilidad", probabilidad);
        DPD_Datos.insertValue(0, "fracaso", (1-probabilidad));
        JFC_Grafica=ChartFactory.createRingChart("Probabilidad de Exito", DPD_Datos, false, false, false);
        CP_Grafica=new ChartPanel(JFC_Grafica);
        CP_Grafica.setVisible(true);
        CP_Grafica.setBounds(-2, -2, 302, 302);
        JFC_Grafica.setBorderVisible(false);
        PiP_Plot=(PiePlot)JFC_Grafica.getPlot();
        PiP_Plot.setSectionPaint("probabilidad", Color.BLACK);
        PiP_Plot.setSectionPaint("fracaso", Color.WHITE);
        PiP_Plot.setBackgroundPaint(Color.WHITE);
        PiP_Plot.setBackgroundAlpha(0);
        PiP_Plot.setLabelGenerator(null);
        PiP_Plot.setInsets(new RectangleInsets(0,0,0, 0));        
        
        //Agrega grafica y texto al panel
        JP_Probabilidad.add(CP_Grafica);
        JP_Probabilidad.setEnabled(false);
        JL_Probabilidad.setText(String.valueOf((int)(probabilidad*100))+"%");
        
        
        //Grafica de categorias
        CD_Categorias = createDataset();
        Gra_Categorias = createChart(CD_Categorias); 
        ChartPanel CP_Categorias = new ChartPanel(Gra_Categorias);
        CP_Categorias.setBounds(-1, 4, 555, 420);   
        Gra_Categorias.setBackgroundPaint(Color.white); 
        JP_Spider.setBackground(Color.WHITE);
        JP_Spider.add(CP_Categorias);
        
       // JP_Spider.setVisible(true);
      
        this.setBounds(0, 0, 1080, 720);           
        this.setVisible(true);
        
    }
      private static JFreeChart createChart(CategoryDataset categorydataset)   
    {   
        SpiderWebPlot spiderwebplot = new SpiderWebPlot(categorydataset);   
        spiderwebplot.setInsets(new RectangleInsets(0,0,0,0));
        JFreeChart jfreechart = new JFreeChart("Categorias", TextTitle.DEFAULT_FONT, spiderwebplot, false);  
        LegendTitle legendtitle = new LegendTitle(spiderwebplot);   
        legendtitle.setPosition(RectangleEdge.BOTTOM);   
        jfreechart.addSubtitle(legendtitle);  
        return jfreechart;   
    }  
     private static CategoryDataset createDataset()   
    {   
        String PromedioEgresados = "Promedio Egresados";   
        String Personal = "Personal";
        String Categoria1 = "Responsabilidad";   
        String Categoria2 = "Tiempo Dedicado";   
        String Categoria3 = "Actitud";
        String Categoria4 = "Autodidacta";   
        String Categoria5 = "Interes en la carrera";              
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();   
        defaultcategorydataset.addValue(8, PromedioEgresados, Categoria1);   
        defaultcategorydataset.addValue(8, PromedioEgresados, Categoria2);   
        defaultcategorydataset.addValue(8, PromedioEgresados, Categoria3);   
        defaultcategorydataset.addValue(8, PromedioEgresados, Categoria4);   
        defaultcategorydataset.addValue(8, PromedioEgresados, Categoria5);   
        defaultcategorydataset.addValue(dob_Categorias[0], Personal, Categoria1);   
        defaultcategorydataset.addValue(dob_Categorias[1], Personal, Categoria2);   
        defaultcategorydataset.addValue(dob_Categorias[2], Personal, Categoria3);   
        defaultcategorydataset.addValue(dob_Categorias[3], Personal, Categoria4);   
        defaultcategorydataset.addValue(dob_Categorias[4], Personal, Categoria5); 
        return defaultcategorydataset;   
    } 
    public JPanel getPanel(){
        return this;
    }
    private String formatoHtml(String texto) {
        return "<HTML><BODY><H3>" + texto + "</H3></BODY></HTML>";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        JB_Menu = new javax.swing.JButton();
        JP_Spider = new javax.swing.JPanel();
        JP_Probabilidad = new java.awt.Panel();
        JL_Probabilidad = new javax.swing.JLabel();
        JL_Categorias = new javax.swing.JLabel();
        JB_Responsabilidad = new javax.swing.JButton();
        JB_TiempoDedicado = new javax.swing.JButton();
        JB_ImagenPersonal = new javax.swing.JButton();
        JB_Autodidacta = new javax.swing.JButton();
        JB_ConocimientoCarrera = new javax.swing.JButton();
        JL_Fondo = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setBackground(new java.awt.Color(157, 11, 11));
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setLayout(null);

        JB_Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Estadisticas1080/Bot_Menu.png"))); // NOI18N
        JB_Menu.setBorderPainted(false);
        JB_Menu.setContentAreaFilled(false);
        JB_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_MenuActionPerformed(evt);
            }
        });
        add(JB_Menu);
        JB_Menu.setBounds(440, 640, 210, 80);

        JP_Spider.setBackground(new java.awt.Color(217, 83, 83));
        add(JP_Spider);
        JP_Spider.setBounds(460, 70, 555, 420);

        JP_Probabilidad.setBackground(new java.awt.Color(204, 255, 255));
        JP_Probabilidad.setMinimumSize(new java.awt.Dimension(300, 300));
        JP_Probabilidad.setPreferredSize(new java.awt.Dimension(300, 300));
        JP_Probabilidad.setLayout(null);

        JL_Probabilidad.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        JL_Probabilidad.setText("Exito");
        JP_Probabilidad.add(JL_Probabilidad);
        JL_Probabilidad.setBounds(100, 130, 150, 50);

        add(JP_Probabilidad);
        JP_Probabilidad.setBounds(120, 150, 300, 300);
        add(JL_Categorias);
        JL_Categorias.setBounds(160, 490, 230, 110);

        JB_Responsabilidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Estadisticas1080/Bot_Responsabilidad.png"))); // NOI18N
        JB_Responsabilidad.setBorderPainted(false);
        JB_Responsabilidad.setContentAreaFilled(false);
        JB_Responsabilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_ResponsabilidadActionPerformed(evt);
            }
        });
        add(JB_Responsabilidad);
        JB_Responsabilidad.setBounds(540, 510, 110, 70);

        JB_TiempoDedicado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Estadisticas1080/Bot_TiempoDedicado.png"))); // NOI18N
        JB_TiempoDedicado.setBorderPainted(false);
        JB_TiempoDedicado.setContentAreaFilled(false);
        JB_TiempoDedicado.setDefaultCapable(false);
        JB_TiempoDedicado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_TiempoDedicadoActionPerformed(evt);
            }
        });
        add(JB_TiempoDedicado);
        JB_TiempoDedicado.setBounds(600, 580, 110, 70);

        JB_ImagenPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Estadisticas1080/Bot_Actitud.png"))); // NOI18N
        JB_ImagenPersonal.setBorderPainted(false);
        JB_ImagenPersonal.setContentAreaFilled(false);
        JB_ImagenPersonal.setDefaultCapable(false);
        JB_ImagenPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_ImagenPersonalActionPerformed(evt);
            }
        });
        add(JB_ImagenPersonal);
        JB_ImagenPersonal.setBounds(690, 510, 120, 70);

        JB_Autodidacta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Estadisticas1080/Bot_Autodidacta.png"))); // NOI18N
        JB_Autodidacta.setBorderPainted(false);
        JB_Autodidacta.setContentAreaFilled(false);
        JB_Autodidacta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_AutodidactaActionPerformed(evt);
            }
        });
        add(JB_Autodidacta);
        JB_Autodidacta.setBounds(770, 580, 110, 70);

        JB_ConocimientoCarrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Estadisticas1080/Bot_ConocimientoInteresDeLaCarrera.png"))); // NOI18N
        JB_ConocimientoCarrera.setBorderPainted(false);
        JB_ConocimientoCarrera.setContentAreaFilled(false);
        JB_ConocimientoCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_ConocimientoCarreraActionPerformed(evt);
            }
        });
        add(JB_ConocimientoCarrera);
        JB_ConocimientoCarrera.setBounds(840, 510, 120, 70);

        JL_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Estadisticas1080/Fon_Estadisticas.png"))); // NOI18N
        add(JL_Fondo);
        JL_Fondo.setBounds(0, 0, 1080, 720);
    }// </editor-fold>//GEN-END:initComponents

    private void JB_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_MenuActionPerformed
        try {
            con.cambiarInicio();
        } catch (IOException ex) {
            Logger.getLogger(JP_Estadisticas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JB_MenuActionPerformed

    private void JB_TiempoDedicadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_TiempoDedicadoActionPerformed
        JL_Categorias.setText(formatoHtml("Tiempo dedicado al estudio <br> Tiempo que dedicas a tareas o actividades relacionadas a la carrera ")); 
    }//GEN-LAST:event_JB_TiempoDedicadoActionPerformed

    private void JB_ImagenPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ImagenPersonalActionPerformed
        JL_Categorias.setText(formatoHtml("Actitud <br> El que tan buen estudiante te consideras y tu conducta al estudiar "));
    }//GEN-LAST:event_JB_ImagenPersonalActionPerformed

    private void JB_ConocimientoCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ConocimientoCarreraActionPerformed
       JL_Categorias.setText(formatoHtml("Conocimiento e interes sobre la carrera <br> Conocimientos sobre el ambito laboral, oportunidades y lo que te gusta de la carrera "));
    }//GEN-LAST:event_JB_ConocimientoCarreraActionPerformed

    private void JB_AutodidactaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_AutodidactaActionPerformed
       JL_Categorias.setText(formatoHtml("Autodidacta <br> El aprender por tu cuenta para reforzar lo visto en clases "));       
    }//GEN-LAST:event_JB_AutodidactaActionPerformed

    private void JB_ResponsabilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ResponsabilidadActionPerformed
       JL_Categorias.setText(formatoHtml("Responsabilidad <br> Entregar tareas en tiempo y forma, llegar puntual y aceptar las reglas ")); 
    }//GEN-LAST:event_JB_ResponsabilidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_Autodidacta;
    private javax.swing.JButton JB_ConocimientoCarrera;
    private javax.swing.JButton JB_ImagenPersonal;
    private javax.swing.JButton JB_Menu;
    private javax.swing.JButton JB_Responsabilidad;
    private javax.swing.JButton JB_TiempoDedicado;
    private javax.swing.JLabel JL_Categorias;
    private javax.swing.JLabel JL_Fondo;
    private javax.swing.JLabel JL_Probabilidad;
    private java.awt.Panel JP_Probabilidad;
    private javax.swing.JPanel JP_Spider;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
