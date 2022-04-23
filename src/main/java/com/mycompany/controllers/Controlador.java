/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.models.Circulo;
import com.mycompany.models.Cuadrado;
import com.mycompany.models.Elipse;
import com.mycompany.models.Figura;
import com.mycompany.models.Linea;
import com.mycompany.models.Rectangulo;
import com.mycompany.repositories.Figuras;
import com.mycompany.views.Ventana;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

/**
 *
 * @author EST_2F_MCA_PC_04
 */
public class Controlador implements ActionListener, MouseListener {

    Figuras figuras;
    Ventana ventana;
    int x1, y1, x2, y2;
    Color[] colores;
    RuntimeTypeAdapterFactory<Figura> RUNTIME_TYPE_ADAPTER = RuntimeTypeAdapterFactory.of(Figura.class, "tipo").registerSubtype(Elipse.class, "elipse").registerSubtype(Circulo.class, "circulo").registerSubtype(Cuadrado.class, "cuadrado").registerSubtype(Rectangulo.class, "rectangulo").registerSubtype(Linea.class, "linea");
    Gson gson = new GsonBuilder().registerTypeAdapterFactory(RUNTIME_TYPE_ADAPTER).create();

    public Controlador() {
        figuras = new Figuras();
        ventana = new Ventana("WorkArt Design", figuras);
        colores = new Color[4];
        colores[0] = Color.green;
        colores[1] = Color.blue;
        colores[2] = Color.yellow;
        colores[3] = Color.red;
    }

    public void iniciar() {
        ventana.getBoton().addActionListener(this);
        ventana.getBotonAbrirImagen().addActionListener(this);
        ventana.getPanel().addMouseListener(this);
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventana.getBoton()) {
            String json = gson.toJson(figuras);
            try {
                PrintWriter printer = new PrintWriter("filaname.json");
                printer.print(json);
                printer.close();
            } catch (Exception er) {
                er.printStackTrace();
            }
        }
        if (e.getSource() == ventana.getBotonAbrirImagen()) {
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG", "jpg", "png");
            ventana.getVentanaFileChooser().setFileFilter(filtro);
            int respuesta = ventana.getVentanaFileChooser().showOpenDialog(ventana);

            if (respuesta == JFileChooser.APPROVE_OPTION) {
                File archivo = new File(ventana.getVentanaFileChooser().getSelectedFile().getAbsolutePath());
                //System.out.println(archivo);
                BufferedImage img = null;
                try {
                    img = ImageIO.read(archivo);
                    //System.out.println(img.getWidth() + " " + img.getHeight());
                    ventana.getPanel().setImagen(img);
                    ventana.getPanel().ajustarImagen(img.getWidth(), img.getHeight(), ventana.getPanel().getWidth(), ventana.getPanel().getHeight());
                    ventana.getPanel().repaint();
                } catch (IOException error) {
                    System.out.println("No se pudo cargar la imagen");
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        System.out.println("x1: " + x1 + " y1: " + y1);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        System.out.println("x2: " + x2 + " y2: " + y2);

        if (ventana.getTipo().getSelectedIndex() == 0) {
            Color c = colores[ventana.getSeveridad().getSelectedIndex()];
            Elipse elipse = new Elipse((x2 - x1) / 2, (y2 - y1) / 2, c, x1, y1);
            figuras.addFigura(elipse);
        }

        if (ventana.getTipo().getSelectedIndex() == 1) {
            Color c = colores[ventana.getSeveridad().getSelectedIndex()];
            Circulo circulo = new Circulo((x2 - x1) / 2, c, x1, y1);
            figuras.addFigura(circulo);
        }

        if (ventana.getTipo().getSelectedIndex() == 2) {
            Color c = colores[ventana.getSeveridad().getSelectedIndex()];
            Cuadrado cuadrado = new Cuadrado(x2 - x1, c, x1, y1);
            figuras.addFigura(cuadrado);
        }

        if (ventana.getTipo().getSelectedIndex() == 3) {
            Color c = colores[ventana.getSeveridad().getSelectedIndex()];
            Rectangulo rectangulo = new Rectangulo(x2 - x1, y2 - y1, c, x1, y1);
            figuras.addFigura(rectangulo);
        }

        if (ventana.getTipo().getSelectedIndex() == 4) {
            Color c = colores[ventana.getSeveridad().getSelectedIndex()];
            Linea linea = new Linea(x2, y2, c, x1, y1);
            figuras.addFigura(linea);
        }
        ventana.getPanel().repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
