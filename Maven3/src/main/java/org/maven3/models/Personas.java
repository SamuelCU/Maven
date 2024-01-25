package org.maven3.models;

public class Personas {
    protected int ci;
    protected String nombre;
    protected int edad;


    public Personas(){};

    public Personas(int ci, String nombre, int edad) {
        this.ci = ci;
        this.nombre = nombre;
        this.edad = edad;
    }


    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
