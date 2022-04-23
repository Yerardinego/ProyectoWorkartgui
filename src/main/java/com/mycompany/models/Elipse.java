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
public class Elipse extends Figura {
    int radioX;
    int radioY;

    public Elipse(int radioX, int radioY, Color color, int x, int y) {
        super(color, x, y);
        this.radioX = radioX;
        this.radioY = radioY;
    }

    public int getRadioX() {
        return radioX;
    }

    public void setRadioX(int radioX) {
        this.radioX = radioX;
    }

    public int getRadioY() {
        return radioY;
    }

    public void setRadioY(int radioY) {
        this.radioY = radioY;
    }
    
    
}
