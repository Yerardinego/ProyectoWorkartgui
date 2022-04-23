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
public class Rectangulo extends Figura {
    int base;
    int altura;

    public Rectangulo(int base, int altura, Color color, int x, int y) {
        super(color, x, y);
        this.base = base;
        this.altura = altura;
    }

    public int getBase() {
        return base;
    }

    public int getAltura() {
        return altura;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    
}
