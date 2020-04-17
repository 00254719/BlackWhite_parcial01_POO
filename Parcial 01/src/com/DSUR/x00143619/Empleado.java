package com.DSUR.x00143619;
import java.util.ArrayList;


abstract class Empleado {

    protected String Nombre;
    protected String Puesto;
    protected ArrayList<Documento> Documentos;
    protected double Salario;

    public Empleado(String nombre, String puesto, double salario) {
        this.Nombre = nombre;
        this.Puesto = puesto;
        Documentos = new ArrayList<>();
        this.Salario = salario;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getPuesto() {
        return Puesto;
    }

    public ArrayList<Documento> getDocumentos() {
        return Documentos;
    }

    public void addDocumento(Documento documento) {
        Documentos.add(documento);
    }

    public void removeDocumento(String documento) {
        boolean remove = false;
        for (Documento s : Documentos) {
            if (s.getNombre() == Nombre) {
                remove = true;
            }
        }
        if (!remove)
            System.out.println("No existe ese Nombre dentro de lista");
        else
            System.out.println("Documento de" + Nombre + "ha sido eliminado");
        Documentos.removeIf(n -> (n.getNombre() == Nombre));
    }

     public double getSalario() {
        return Salario;
    }

     public void setSalario(double salario) {
       Salario = salario;
    }




}
