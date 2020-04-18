package com.DSUR.x00143619;
import java.util.ArrayList;

public class Empresa {
    private String Nombre;
    private ArrayList<Empleado> planilla;

    public Empresa(String nombre) {
        this.Nombre = nombre;
        planilla= new ArrayList<>();
    }

    public String getNombre() {
        return Nombre;
    }
    public ArrayList<Empleado> getPlanilla() {
        return planilla;
    }
    public void addEmpleado(Empleado empleado){
        planilla.add(empleado);
    }
    public void quitEmpleado(String nombre){
        boolean remove=false;
        for (Empleado s : planilla) {
            if (s.getNombre().equals(nombre)) {
                remove=true;
            }
        }
        if(!remove)
            System.out.println("No existe el empleado!");
        else
            System.out.println("Empleado "+nombre+" despedido!");
        planilla.removeIf(n -> (n.getNombre().equals(nombre)));
    }
}
