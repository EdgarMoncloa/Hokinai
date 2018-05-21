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

    public void coneccionBDD() {
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (connect != null) {
                System.out.println("Conectado");
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
        String insert = "INSERT INTO respuestas2 (A,B,C,D,E,F,G,H,I,J,K) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement st = connect.prepareStatement(insert);
        for (int j = 1; j <= respuestas.size(); j++) {
            st.setString(j, String.valueOf(((Nodo) respuestas.get(j - 1)).Respuesta));
        }
        st.executeUpdate();
    }

    public float calcularProbabilidad() throws SQLException {
        ResultSet ProbTot = null;
        ResultSet ProbSi = null;
        PreparedStatement st = connect.prepareStatement("select count(*) AS prob from estudiantes");
        ProbTot = st.executeQuery();
        PreparedStatement st2 = connect.prepareStatement("select count(*) AS prob from estudiantes");
        ProbSi=st2.executeQuery();
        return ProbSi.getInt("prob")/ProbTot.getInt("prob");
    }

}
