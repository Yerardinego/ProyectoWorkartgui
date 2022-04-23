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
public class Circulo extends Figura {
    int radio;

    public Circulo(int radio, Color color, int x, int y) {
        super(color, x, y);
        this.radio = radio;
    }
    
    public int area() {
        return 10;
    }
    
    public void setRadio(int radio) {
        this.radio = radio;
    }
    
    public int getRadio() {
        return radio;
    }
}
