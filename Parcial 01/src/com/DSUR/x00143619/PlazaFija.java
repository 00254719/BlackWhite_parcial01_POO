package com.DSUR.x00143619;

public class PlazaFija extends Empleado {
    private int Extension;

    public PlazaFija(String nombre, String puesto, double salario, int extension) {
        super(nombre, puesto, salario);
        this.Extension = extension;
    }

    public int getExtension() {
        return Extension;
    }

    public void setExtension(int extension) {
        Extension = extension;
    }
}

