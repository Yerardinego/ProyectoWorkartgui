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
public class Figura {

    Color color;
    int x, y;

    public Figura(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public int area() {
        return 0;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
