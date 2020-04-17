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

     public void addDocumento(Documento documento){
        Documentos. add(documento);
     }

     public void remoteDocumento(String documento){
        Documentos.remove(documento);
     }

     public double getSalario() {
        return Salario;
    }

     public void setSalario(double salario) {
       Salario = salario;
    }
}
