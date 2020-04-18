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

       boolean continuar1=false;
        String NombreEmpresa = "";
        do {
            try {
                continuar1 = false;
                System.out.print("Digite el nombre de su empresa: ");
                 NombreEmpresa = in.nextLine();
                if(verificacion(NombreEmpresa))
                    throw new NullArgument("Ingreso datos invalidos !!!");
                else if (verificacionNumero(NombreEmpresa))
                    throw new NumberFormatException("Los nombres no llevan numeros");
                else if(verificacionFormato(NombreEmpresa))
                    throw new InvalidStringFormat("Nombre demasiado corto");
                Empresa empresa = new Empresa(NombreEmpresa);

            }catch (NullArgument | InvalidStringFormat ex) {
                System.out.println(ex.getMessage() + "\n Por favor vuelva a intentarlo ...");
                continuar1=true;
            }catch (NumberFormatException ex){
                System.out.println(ex.getMessage() + "\n Por favor vuelva a intentarlo ...");
                continuar1=true;
            }
        }while(continuar1);
        Empresa empresa = new Empresa(NombreEmpresa);
        do {
            System.out.print(menu);
            opcion = in.nextByte(); in.nextLine();

            switch (opcion){

                case 1:
                    boolean continuar= false;
                    do {
                        try {
                            continuar=false;
                        System.out.print("Dijite el nombre del empleado: ");
                        String nombre = in.nextLine();
                        verificacion(nombre);
                        if(verificacion(nombre))
                            throw new NullArgument("Ingreso datos invalidos !!!");
                        else if (verificacionNumero(nombre))
                            throw new NumberFormatException("Los nombres no llevan numeros");
                            else if(verificacionFormato(nombre))
                                throw new InvalidStringFormat("Nombre demasiado corto");

                        System.out.print("Dijite el puesto del empleado: ");
                        String puesto = in.nextLine();
                            if(verificacion(puesto))
                                throw new NullArgument("Ingreso datos invalidos !!!");
                            else if (verificacionNumero(puesto))
                                throw new NumberFormatException("Los nombres no llevan numeros");
                            else if(verificacionFormato(puesto))
                                throw new InvalidStringFormat("Nombre demasiado corto");

                        System.out.print("Salario: ");
                        double salario = in.nextDouble();in.nextLine();

                        System.out.print(submenu);
                        opcion2 = in.nextByte();in.nextLine();

                        switch (opcion2) {
                            case 1:
                                System.out.print("Meses de contrato: ");
                                int contrato = in.nextInt();in.nextLine();
                                ServicioProfesional empleado = new ServicioProfesional(nombre, puesto, salario, contrato);
                                empresa.addEmpleado(empleado);
                                agregarDocumentos(empleado);
                                break;

                            case 2:
                                System.out.print("Extencion: ");
                                int extencion = in.nextInt();in.nextLine();
                                PlazaFija empleado2 = new PlazaFija(nombre, puesto, salario, extencion);
                                empresa.addEmpleado(empleado2);
                                agregarDocumentos(empleado2);
                                break;
                        }
                        }catch (NullArgument | InvalidStringFormat ex) {
                            System.out.println(ex.getMessage() + "\n Por favor vuelva a intentarlo ...");
                            continuar=true;
                        }catch (NumberFormatException ex){
                            System.out.println(ex.getMessage() + "\n Por favor vuelva a intentarlo ...");
                            continuar=true;
                        }
                    }while (continuar);
                    break;

                case 2:
                    System.out.print("Digite el nombre del empleado a despedir: ");   String nombre1= in.nextLine();
                    empresa.quitEmpleado(nombre1);
                    break;
                case 3:
                    String Lista="";
                    System.out.println("---LISTA DE EMPLEADOS---");
                    if (empresa.getPlanilla().isEmpty())
                        System.out.println("No hay Empleados ");

                    else {
                        for (Empleado p :empresa.getPlanilla()) {
                            Lista += p.toString() + "\n";
                        }
                        System.out.println(Lista);
                    }
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
                case 5:
                    System.out.println("total de impuestos: "+'\n'+CalculadoraImpuestos.mostrarTotales());
                    break;

                case 0:
                    System.out.println("Adios");
                    break;

                default:
                    System.out.println("Esta opcion no es valida !!!");
            }
        } while (opcion!=0);

}

   public static void agregarDocumentos(Empleado empleado){
       boolean continuar3 = false;
       System.out.print("Numero de documentos a registar: ");int documentos=in.nextInt(); in.nextLine();
       for(int i=0;i<documentos;i++) {
           do {
               try {
                   continuar3 = false;
                   System.out.print("Nombre del docuemento a agregar: ");
                   String nombredoc = in.nextLine();
                   if (verificacion(nombredoc))
                       throw new NullArgument("Ingreso datos invalidos !!!");
                   else if (verificacionFormato(nombredoc))
                       throw new InvalidStringFormat("Nombre demasiado corto");
                   else if (verificacionNumero(nombredoc))
                       throw new NumberFormatException("Los nombres no llevan numeros");
                   System.out.print("Numero del docuemento a agregar: ");
                   String doc = in.nextLine();
                   if (verificacion(doc))
                       throw new NullArgument("Ingreso datos invalidos !!!");
                   else if (verificacionFormato(doc))
                       throw new InvalidStringFormat("Formato demasiado corto");
                   empleado.addDocumento(new Documento(nombredoc, doc));
               } catch (NullArgument | InvalidStringFormat ex) {
                   System.out.println(ex.getMessage() + "\n Por favor vuelva a intentarlo !!!...");
                   continuar3 = true;
               }catch (NumberFormatException ex) {
                   System.out.println(ex.getMessage() + "\n Por favor vuelva a intentarlo !!!...");
                   continuar3 = true;
               }
           }while(continuar3);
       }
    }


   public static boolean verificacion(String verificar){
        if(verificar.length()==0||verificar==null)
       return true;
                return false;
   }

   public static boolean verificacionNumero(String VerNum){
        //"-?\\d+(\\.\\d+)?" formato para verificar que un string no lleve numeros
        if (VerNum.matches("-?\\d+(\\.\\d+)?"))
           return true;
       return false;
   }

   public static boolean verificacionFormato(String VerFor){
       if (VerFor.length()<=2 && VerFor.length()>0)
           return true;
       return false;
   }

}



