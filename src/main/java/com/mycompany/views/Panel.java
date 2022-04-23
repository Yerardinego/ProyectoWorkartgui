/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.views;

import com.mycompany.repositories.Figuras;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author EST_2F_MCA_PC_04
 */
public class Panel extends JPanel {

    Figuras figuras;
    BufferedImage imagen;
    int width;
    int height;

    public Panel(Figuras figuras) {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setOpaque(false);
        this.figuras = figuras;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Helper helper = new Helper(g);
        helper.dibujarImagen(imagen, width, height);
        helper.dibujar(figuras);
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void ajustarImagen(int x1, int y1, int x2, int y2) {
        int a;
        if (x1 < x2 && y1 < y2) {
            if ((x2 - x1) < (y2 - y1)) {
                a = x2 - x1;
                width = x1 + a;
                height = y1 + (a * y1 / x1);
            } else {
                a = y2 - y1;
                width = x1 + (a * x1 / y1);
                height = y1 + a;
            }
        }

        if (x1 > x2 && y1 > y2) {
            if ((x1 - x2) > (y1 - y2)) {
                a = x1 - x2;
                width = x1 - a;
                height = y1 - (a * y1 / x1);
            } else {
                a = y1 - y2;
                width = x1 - (a * x1 / y1);
                height = y1 - a;
            }
        }

        if (x1 > x2 && y1 < y2) {
            a = x1 - x2;
            width = x1 - a;
            height = y1 - (a * y1 / x1);
        }

        if (x1 < x2 && y1 > y2) {
            a = y1 - y2;
            width = x1 - (a * x1 / y1);
            height = y1 - a;
        }
        //System.out.println(width + " " + height);
    }
}
