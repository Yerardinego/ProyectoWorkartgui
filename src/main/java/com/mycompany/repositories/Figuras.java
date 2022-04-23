/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repositories;

import com.mycompany.models.Figura;
import java.util.ArrayList;

/**
 *
 * @author EST_2F_MCA_PC_04
 */
public class Figuras {
    ArrayList<Figura> figuras;
    
    public Figuras() {
        figuras = new ArrayList<>();
    }

    public ArrayList<Figura> getFiguras() {
        return figuras;
    }
    
    public void addFigura(Figura figura) {
        this.figuras.add(figura);
    }
}
