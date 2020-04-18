package com.DSUR.x00143619;

public class ServicioProfesional extends Empleado {
    private int MesesContrato;

    public ServicioProfesional(String nombre, String puesto, double salario, int mesesContrato) {
        super(nombre, puesto, salario);
        this.MesesContrato = mesesContrato;
    }

    public int getMesesContrato() {
        return MesesContrato;
    }

    public void setMesesContrato(int mesesContrato) {
        MesesContrato = mesesContrato;
    }

    @Override
    public String toString() {
        return "ServicioProfesional{" +
                "Nombre='" + Nombre + '\'' +
                ", MesesContrato=" + MesesContrato +'\''+
                ", Puesto='" + Puesto + '\'' +
                ", Documentos=" + Documentos +
                ", Salario=" + Salario +
                '}';
    }
}

