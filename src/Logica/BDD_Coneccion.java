/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EdgarMoncloa
 */
public class BDD_Coneccion {
  String url = "src\\Datos\\BDD.db";
    Connection connect;
    public void BDD_Coneccion(){
 try {
     connect = DriverManager.getConnection("jdbc:sqlite:"+url);
     if (connect!=null) {
         System.out.println("Conectado");
     }
 }catch (SQLException ex) {
     System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
 }
}
 public void close(){
        try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(BDD_Coneccion.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
  public void mostrarAlumnos(){
        ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement("select * from BD_Tab_Evidencias");
            result = st.executeQuery();
            while (result.next()) {
                System.out.print("ID: ");
                System.out.println(result.getInt("Id"));
 
                System.out.print("Pregunta: ");
                System.out.println(result.getString("pregunta"));
 
                System.out.print("Respuesta1: ");
                System.out.println(result.getString("respuesta1"));
                
                System.out.print("Respuesta2: ");
                System.out.println(result.getString("respuesta2"));
                
                System.out.print("Respuesta3: ");
                System.out.println(result.getString("respuesta3"));
                
                System.out.print("Respuesta5: ");
                System.out.println(result.getString("respuesta5"));
                
                System.out.print("Respuesta5: ");
                String x=(result.getString("respuesta5"));
                if(x == null){
                    System.out.println("nulo");
                }
                
                System.out.println("=======================");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}

