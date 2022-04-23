/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.views;

import com.mycompany.repositories.Figuras;
import java.awt.HeadlessException;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

/**
 *
 * @author EST_2F_MCA_PC_04
 */
public class Ventana extends JFrame {
    JComboBox tipo;
    JComboBox severidad;
    JButton botonAbrirImagen;
    JButton boton;
    JFileChooser ventanaFileChooser;
    Panel panel;
    Figuras figuras;

    public Ventana(String title, Figuras figuras) throws HeadlessException {
        super(title);
        this.figuras = figuras;
        this.setSize(1200, 700);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio();
    }
    
    private void inicio() {
        tipo = new JComboBox();
        tipo.addItem("Ellipse");
        tipo.addItem("Circle");
        tipo.addItem("Square");
        tipo.addItem("Rectangle");
        tipo.addItem("Line");
        tipo.setBounds(10, 10, 100, 20);
        severidad = new JComboBox();
        severidad.addItem("Green");
        severidad.addItem("Blue");
        severidad.addItem("Yellow");
        severidad.addItem("Red");
        severidad.setBounds(120, 10, 100, 20);
        boton = new JButton("Guardar");
        boton.setBounds(230, 10, 80, 20);
        botonAbrirImagen = new JButton("Abrir Imagen");
        botonAbrirImagen.setBounds(320, 10, 130, 20);
        ventanaFileChooser = new JFileChooser();
        ventanaFileChooser.setCurrentDirectory(new File("C:\\Users\\adria\\OneDrive\\Fotos"));
        panel = new Panel(figuras);
        panel.setBounds(10, 40, 1160, 610);
        //panel.setVisible(false);
        this.add(tipo);
        this.add(severidad);
        this.add(boton);
        this.add(botonAbrirImagen);
        this.add(panel);
    }

    public JComboBox getTipo() {
        return tipo;
    }

    public JComboBox getSeveridad() {
        return severidad;
    }

    public JButton getBoton() {
        return boton;
    }
    
    public JButton getBotonAbrirImagen() {
        return botonAbrirImagen;
    }
    
    public JFileChooser getVentanaFileChooser() {
        return ventanaFileChooser;
    }
    
    public Panel getPanel() {
        return panel;
    }
    
    public void setPanel(Panel panel) {
        this.panel = panel;
    }
}
