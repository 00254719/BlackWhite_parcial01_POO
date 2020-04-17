package com.DSUR.x00143619;

import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        byte opcion=0, opcion2=0;

        String menu = "...MENU PRINCIPAL...\n"+
                "1) Agregar Empleado.\n"+
                "2) Despedir Empleado.\n"+
                "3) Ver lista de Empleado.\n"+
                "4) Calcular sueldo.\n"+
                "5) Mostrar totales.\n"+
                "0) Salir...\n"+
                "  Opcion: ";

        String submenu= "Tipo de contrato...\n"+
                "1) Servicio Profesioal.\n"+
                "2) Plaza fija.\n"+
                "  Opcion: ";

        System.out.print("Digite el nombre de su empresa: ");
        String NombreEmpresa= in.nextLine();
        Empresa empresa = new Empresa(NombreEmpresa);

        do {
            System.out.print(menu);
            opcion = in.nextByte(); in.nextLine();

            switch (opcion){

                case 1:

                    System.out.print("Dijite el nombre del empleado: ");   String nombre= in.nextLine();
                    System.out.print("Dijite el puesto del empleado: ");  String puesto=in.nextLine();
                    System.out.print("Salario: ");    double salario= in.nextDouble(); in.nextLine();
                    System.out.print(submenu);            opcion2 = in.nextByte(); in.nextLine();

                    switch (opcion2){

                        case 1:
                            System.out.println("Meses de contrato: ");  int contrato=in.nextInt(); in.nextLine();
                            new ServicioProfesional(nombre,puesto,salario,contrato);
                            empresa.addEmpleado( new ServicioProfesional(nombre,puesto,salario,contrato));
                            break;

                        case 2:
                            System.out.println("Extencion: ");  int extencion=in.nextInt(); in.nextLine();
                            new PlazaFija(nombre,puesto,salario,extencion);
                            empresa.addEmpleado( new ServicioProfesional(nombre,puesto,salario,extencion));
                            break;
                    } break;

                case 2: 
            }

        }
        while (opcion!=0);

}
}
