package com.DSUR.x00143619;
import java.util.ArrayList;
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
                    System.out.print("Salario: "); double salario= in.nextDouble(); in.nextLine();
                    System.out.print(submenu); opcion2 = in.nextByte(); in.nextLine();
                    switch (opcion2){
                        case 1:
                            System.out.print("Meses de contrato: ");  int contrato=in.nextInt(); in.nextLine();
                            ServicioProfesional empleado= new ServicioProfesional(nombre,puesto,salario,contrato);
                            empresa.addEmpleado(empleado);
                            agregarDocumuentos(empleado);

                            break;
                        case 2:
                            System.out.print("Extencion: ");  int extencion=in.nextInt(); in.nextLine();
                            PlazaFija empleado2= new PlazaFija(nombre,puesto,salario,extencion);
                            empresa.addEmpleado(empleado2);
                            agregarDocumuentos(empleado2);
                            break;
                    } break;

                case 2:
                    System.out.print("Digite el nombre del empleado a despedir: ");   String nombre1= in.nextLine();
                    empresa.quitEmpleado(nombre1);
                    break;
                case 4:
                    System.out.print("Digite el nombre del empleado que desea consultar su salirio liquido: ");
                    String nombre2= in.nextLine();
                    boolean found=false;
                    double salarioliquido=0;
                    for (Empleado s : empresa.getPlanilla()) {
                        if (s.getNombre().equals(nombre2)) {
                            found=true;
                            salarioliquido=CalculadoraImpuestos.calcularPago(s);
                        }
                    }
                    if(!found)
                        System.out.println("No existe el empleado!");
                    else
                        System.out.println("Salario : "+salarioliquido);
                    break;
            }

        }
        while (opcion!=0);

}
   public static void agregarDocumuentos(Empleado empleado){
       System.out.print("Numero de documentos a registar: ");int documentos=in.nextInt(); in.nextLine();
       for(int i=0;i<documentos;i++){
           System.out.print("Nombre del docuemento a agregar: "); String nombredoc= in.nextLine();
           System.out.print("Numero del docuemento a agregar: "); String doc=in.nextLine();
           empleado.addDocumento(new Documento(nombredoc,doc));
       }
   }
}

