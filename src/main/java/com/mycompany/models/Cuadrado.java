/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

import java.awt.Color;

/**
 *
 * @author EST_2F_MCA_PC_04
 */
public class Cuadrado extends Figura {
    int lado;

    public Cuadrado(int lado, Color color, int x, int y) {
        super(color, x, y);
        this.lado = lado;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }
    
    
}
