package org.maven3;

import java.util.List;

import org.maven3.models.Personas;
import org.maven3.models.PersonasDao;
import org.maven3.views.form1;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        crearVista();


     
    }


    private static void crearVista(){
        form1 view = new form1();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(view.getPanel1());
        frame.pack();
        frame.setVisible(true);

    }
}