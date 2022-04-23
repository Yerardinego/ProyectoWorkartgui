/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.views;

import com.mycompany.models.Circulo;
import com.mycompany.models.Cuadrado;
import com.mycompany.models.Elipse;
import com.mycompany.models.Figura;
import com.mycompany.models.Linea;
import com.mycompany.models.Rectangulo;
import com.mycompany.repositories.Figuras;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/**
 *
 * @author EST_2F_MCA_PC_04
 */
public class Helper {

    Graphics graphics;

    public Helper(Graphics graphics) {
        this.graphics = graphics;
    }

    public void dibujar(Figuras figuras) {
        for (Figura f : figuras.getFiguras()) {
            graphics.setColor(f.getColor());
            if (f instanceof Elipse) {
                Elipse e = (Elipse) f;
                graphics.fillOval(e.getX(), e.getY(), e.getRadioX() * 2, e.getRadioY() * 2);
            }
            if (f instanceof Cuadrado) {
                Cuadrado c = (Cuadrado) f;
                graphics.fillRect(c.getX(), c.getY(), c.getLado(), c.getLado());
            }
            if (f instanceof Circulo) {
                Circulo c = (Circulo) f;
                graphics.fillOval(c.getX(), c.getY(), c.getRadio() * 2, c.getRadio() * 2);
            }
            if (f instanceof Linea) {
                Linea l = (Linea) f;
                graphics.drawLine(l.getX(), l.getY(), l.getX2(), l.getY2());
            }
            if (f instanceof Rectangulo) {
                Rectangulo r = (Rectangulo) f;
                graphics.fillRect(r.getX(), r.getY(), r.getBase(), r.getAltura());
            }
        }
    }
    
    public void dibujarImagen(BufferedImage imagen, int width, int height) {
        graphics.drawImage(imagen, 0, 0, width, height, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
    }
}
