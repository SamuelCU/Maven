package org.maven3.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class PersonasDao {

    MySQLconnection cn = new MySQLconnection();
    Connection conn;
    PreparedStatement pst;

    ResultSet resultSet;
    public PersonasDao(){

    }

    public String cedula;
    public String nombre;
    public String edad;


    public ArrayList obtenerPersonas(){

        ArrayList<Personas> listpersonas = new ArrayList<>();
        String query = "SELECT *FROM registropersonas";

        try{

            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            resultSet = pst.executeQuery();
            

            while(resultSet.next()){
                Personas per = new Personas();
                per.setCi(resultSet.getInt("cedula"));
                per.setNombre(resultSet.getString("nombre"));
                per.setEdad(resultSet.getInt("edad"));

                listpersonas.add(per);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString()); //parent component aparece la ventana en el medio
        }

        return listpersonas;

    }


}

