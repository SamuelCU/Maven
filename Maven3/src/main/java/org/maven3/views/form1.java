package org.maven3.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class form1 {
    protected JTable pantallaTabla = new JTable();
    private JPanel panel1;

    public form1(){

        pantallaTabla.setModel(new DefaultTableModel(null, new String[]{
                "Cedula", "Nombre", "Edad"
        }));
    }

    public void createTable(){
        pantallaTabla.setModel(new DefaultTableModel(null, new String[]{
                "Cedula", "Nombre", "Edad"
        }));
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
