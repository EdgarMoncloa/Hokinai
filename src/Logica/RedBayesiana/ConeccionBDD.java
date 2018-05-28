/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.RedBayesiana;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EdgarMoncloa
 */
public class ConeccionBDD {

    String url = "src\\Datos\\BDD.db";
    Connection connect;

    public ConeccionBDD() {        
        try {            
            connect = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (connect != null) {
                //System.out.println("Conectado");
            }else{
                System.out.println("Coneccion nula");
            }
        } catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
        }
    }

    public void close() {
        try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ingresarRespuestas(ArrayList respuestas) throws SQLException {
        String insert = "INSERT INTO BDD_Evidencias(A,B,C,D,E,F,G,H,I,J,K,L,M,N,V,W,X,Y,Z,Q) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement st = connect.prepareStatement(insert);       
        for (int j = 1; j <= respuestas.size(); j++) {
            st.setDouble(j,((Nodo) respuestas.get(j - 1)).Respuesta);
        }
        st.executeUpdate();
    }
    public float calcularProbabilidad(ArrayList AL_Respuestas) throws SQLException {
        int int_ProbSi=0,int_ProbTot=0;
        ResultSet ProbTot = null;
        ResultSet ProbSi = null;
        String Str_sql=
                " A="+AL_Respuestas.get(0)+
                " and B="+AL_Respuestas.get(1)+
                " and C="+AL_Respuestas.get(2)+
                " and D="+AL_Respuestas.get(3)+
                " and E="+AL_Respuestas.get(4)+
                " and F="+AL_Respuestas.get(5)+
                " and G="+AL_Respuestas.get(6)+
                " and H="+AL_Respuestas.get(7)+
                " and I="+AL_Respuestas.get(8)
                //" and J="+AL_Respuestas.get(9)+
                //" and K="+AL_Respuestas.get(10)+
               // " and L="+AL_Respuestas.get(11)+
               // " and M="+AL_Respuestas.get(12)+
                //" and N="+AL_Respuestas.get(13)                                            
                ;
        PreparedStatement st = connect.prepareStatement("SELECT COUNT(*) AS prob FROM BDD_Evidencias WHERE "+Str_sql+" and Q=1");
        ProbSi = st.executeQuery();
        PreparedStatement st2 = connect.prepareStatement("SELECT COUNT(*) AS prob FROM BDD_Evidencias WHERE "+Str_sql);
        ProbTot=st2.executeQuery();
        int_ProbSi=ProbSi.getInt("prob");
        int_ProbTot=ProbTot.getInt("prob");
        if(int_ProbTot==0){
            return (float)0.0;
        }else{
            return (float)int_ProbSi/int_ProbTot;
        }
    }

}
