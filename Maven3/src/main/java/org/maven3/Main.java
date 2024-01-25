package org.maven3;

import org.maven3.models.PersonasDao;

public class Main {
    public static void main(String[] args) {

        PersonasDao people = new PersonasDao();

        System.out.println(people.obtenerPersonas());
     
    }
}