/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.RedBayesiana;

import java.util.ArrayList;

/**
 *
 * @author EdgarMoncloa
 */
public class Nodo {
    private ArrayList AL_Padres,AL_Hijos;
    private int INT_NumRespuestas;
    public Nodo(ArrayList AL_Padres, ArrayList AL_Hijos, int INT_NumRespuestas) {
        this.AL_Padres = AL_Padres;
        this.AL_Hijos = AL_Hijos;
        this.INT_NumRespuestas = INT_NumRespuestas;
    }   
}
