package com.DSUR.x00143619;
import  java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        byte opcion=0, opcion2=0;

        String menu = "\n...MENU PRINCIPAL...\n"+
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

       boolean continuar=false;
        String NombreEmpresa = "";
        String nombre2= "";
        do {
            try {
                continuar = false;
                System.out.print("Digite el nombre de su empresa: ");
                 NombreEmpresa = in.nextLine();
                if(verificacion(NombreEmpresa))
                    throw new NullArgumentException("Ingreso datos invalidos !!!");
                else if (verificacionNumero(NombreEmpresa))
                    throw new NumberFormatException("Los nombres no llevan numeros");
                else if(verificacionFormato(NombreEmpresa))
                    throw new InvalidStringFormatException("Nombre demasiado corto");

            }catch (NullArgumentException | InvalidStringFormatException ex) {
                System.out.println(ex.getMessage() + "\n Por favor vuelva a intentarlo ..."+"\n");
                continuar=true;
            }catch (NumberFormatException ex){
                System.out.println(ex.getMessage() + "\n Por favor vuelva a intentarlo ..."+"\n");
                continuar=true;
            }
        }while(continuar);
        Empresa empresa = new Empresa(NombreEmpresa);

        do {
            boolean continuar1=false;
            do {
                try {
                    continuar1=false;
                    System.out.print(menu);
                    opcion = in.nextByte();
                    in.nextLine();
                } catch (InputMismatchException ex) {
                    in.nextLine();
                    System.out.println("Digite un formato valido!" + "\n Por favor vuelva a intentarlo ..."+"\n");
                    continuar1 = true;
                }
            }while(continuar1);


        switch (opcion){

                case 1:
                    boolean continuar2= false;
                    do {
                        try {
                            continuar2 = false;
                            System.out.print("Digite el nombre del empleado: ");
                            String nombre = in.nextLine();
                            verificacion(nombre);
                            if (verificacion(nombre))
                                throw new NullArgumentException("Ingreso datos invalidos ");
                            else if (verificacionNumero(nombre))
                                throw new NumberFormatException("Los nombres no llevan numeros");
                            else if (verificacionFormato(nombre))
                                throw new InvalidStringFormatException("Nombre demasiado corto");
                            System.out.print("Digite el puesto del empleado: ");
                            String puesto = in.nextLine();
                            if (verificacion(puesto))
                                throw new NullArgumentException("Ingreso datos invalidos ");
                            else if (verificacionNumero(puesto))
                                throw new NumberFormatException("Los nombres no llevan numeros");
                            else if (verificacionFormato(puesto))
                                throw new InvalidStringFormatException("Nombre demasiado corto");
                            System.out.print("Salario: ");
                            double salario = in.nextDouble();
                            in.nextLine();
                            InvalidIntException.ValidateInt(salario);

                            boolean continuar01= false;
                            do {
                                System.out.print(submenu);
                                opcion2 = in.nextByte();
                                in.nextLine();
                                 continuar01=false;

                            switch (opcion2) {
                                case 1:
                                    System.out.print("Meses de contrato: ");
                                    int contrato = in.nextInt();in.nextLine();
                                    InvalidIntException.ValidateInt(contrato);
                                    //.toLowerCase para no tener problemas al verificar
                                    ServicioProfesional empleado = new ServicioProfesional(nombre.toLowerCase(), puesto,
                                            salario, contrato);
                                    empresa.addEmpleado(empleado);
                                    agregarDocumentos(empleado);
                                    break;

                                case 2:
                                    System.out.print("Extencion: ");
                                    int extencion = in.nextInt();
                                    in.nextLine();
                                    PlazaFija empleado2 = new PlazaFija(nombre, puesto, salario, extencion);
                                    empresa.addEmpleado(empleado2);
                                    agregarDocumentos(empleado2);
                                    break;

                                    default:
                                        System.out.println(" Ingreso un dato erroneo !"+"\n");
                                        continuar01=true;
                                        break;
                            }
                            }while (continuar01);

                        }catch (NullArgumentException | InvalidStringFormatException ex) {
                            System.out.println(ex.getMessage() + "\n Por favor vuelva a intentarlo ..."+"\n");
                            continuar2=true;
                        }catch (NumberFormatException|ArithmeticException ex){
                            System.out.println(ex.getMessage() + "\n Por favor vuelva a intentarlo ..."+"\n");
                            continuar2=true;
                        }catch(InputMismatchException ex){
                            in.nextLine();
                            System.out.println("Digite un formato valido!"+"\n Por favor vuelva a intentarlo ..."+"\n");
                            continuar2=true;
                        }

                    }while (continuar2);
                    break;

                case 2:
                    boolean continuar3= false;
                    do {
                        try {
                            continuar3=false;
                            System.out.print("Digite el nombre del empleado a despedir: ");
                            String nombre1= in.nextLine();
                            if(verificacion(nombre1))
                                throw new NullArgumentException("Ingreso datos invalidos ");
                            else if (verificacionNumero(nombre1))
                                throw new NumberFormatException("Los nombres no llevan numeros");
                            empresa.quitEmpleado(nombre1.toLowerCase());
                        }catch (NullArgumentException ex) {
                            System.out.println(ex.getMessage() + "\n Por favor vuelva a intentarlo ..."+"\n");
                            continuar3=true;
                        }catch (NumberFormatException ex){
                            System.out.println(ex.getMessage() + "\n Por favor vuelva a intentarlo ..."+"\n");
                            continuar3=true;
                        }
                    }while (continuar3);
                    break;

                case 3:
                    String Lista="";
                    System.out.println("---LISTA DE EMPLEADOS---");
                    System.out.println("Empresa: "+ empresa.getNombre ());
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
                    boolean continuar4= false;
                    do {
                        try {
                            continuar4=false;
                            System.out.print("Digite el nombre del empleado que desea consultar su salirio liquido: ");
                            nombre2 = in.nextLine();
                            if(verificacion(nombre2))
                                throw new NullArgumentException("Ingreso datos invalidos ");
                            else if (verificacionNumero(nombre2))
                                throw new NumberFormatException("Los nombres no llevan numeros");

                        }catch (NullArgumentException ex) {
                            System.out.println(ex.getMessage() + "\n Por favor vuelva a intentarlo ..."+"\n");
                            continuar4=true;
                        }catch (NumberFormatException ex){
                            System.out.println(ex.getMessage() + "\n Por favor vuelva a intentarlo ..."+"\n");
                            continuar4=true;
                        }
                    }while(continuar4);

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
                    System.out.println("------ADIOS------");
                    break;

                default:
                    System.out.println("Esta opcion no es valida ");
            }
        } while (opcion!=0);
}

   public static void agregarDocumentos(Empleado empleado){
       boolean continuar5 = false;
       System.out.print("Numero de documentos a registar: ");int documentos=in.nextInt(); in.nextLine();
       for(int i=0;i<documentos;i++) {
           do {
               try {
                   continuar5 = false;
                   System.out.print("Nombre del docuemento a agregar: ");
                   String nombredoc = in.nextLine();
                   if (verificacion(nombredoc))
                       throw new NullArgumentException("Ingreso datos invalidos ");
                   else if (verificacionFormato(nombredoc))
                       throw new InvalidStringFormatException("Nombre demasiado corto");
                   else if (verificacionNumero(nombredoc))
                       throw new NumberFormatException("Los nombres no llevan numeros");
                   System.out.print("Numero del docuemento a agregar: ");
                   String doc = in.nextLine();
                   if (verificacion(doc))
                       throw new NullArgumentException("Ingreso datos invalidos ");
                   else if (verificacionFormato(doc))
                       throw new InvalidStringFormatException("Formato demasiado corto");
                   empleado.addDocumento(new Documento(nombredoc, doc));
               } catch (NullArgumentException | InvalidStringFormatException ex) {
                   System.out.println(ex.getMessage() + "\n Por favor vuelva a intentarlo..."+"\n");
                   continuar5 = true;
               }catch (NumberFormatException ex) {
                   System.out.println(ex.getMessage() + "\n Por favor vuelva a intentarlo..."+"\n");
                   continuar5 = true;
               }
           }while(continuar5);
       }
    }
   //Funcion para verificar que no sea un espacio lo que se rellene en el string.
   public static boolean verificacion(String verificar){
        if(verificar.length()==0||verificar==null|| verificar.replaceAll("\\s+","").length()==0)
       return true;
                return false;
   }
   //Funcion para verificar que no sean solo numeros en un nombre.
   public static boolean verificacionNumero(String VerNum){
           char[] letras = VerNum.toCharArray();
           for(char v : letras){
               if(Character.isDigit(v))
                   return true;
       }
           return false;
   }
   //Funcion para verificar que un nombre no contenga menos de dos letras ya que no hay nombres con 1 o 2 letras.
   public static boolean verificacionFormato(String VerFor){
       if (VerFor.length()<=2 && VerFor.length()>0)
           return true;
       return false;
   }
}



