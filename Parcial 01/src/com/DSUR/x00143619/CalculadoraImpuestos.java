package com.DSUR.x00143619;

public final class CalculadoraImpuestos {
private static double totalRenta=0;
private static double totalISSS=0;
private static double totalAFP=0;

    private CalculadoraImpuestos()  {}

    public static double calcularPago(Empleado empleado){
        double salarioliquido=0, auxtRenta=0, auxtISSS=0, auxtAFP=0, restante=0;
        double salario=empleado.getSalario();
        if(empleado instanceof ServicioProfesional) {
            auxtRenta=0.1*salario;
            salarioliquido=salario-auxtRenta;
            totalRenta+=auxtRenta;
        }
        else if(empleado instanceof PlazaFija){
            auxtAFP=0.0625*salario; totalAFP+=auxtAFP;
            auxtISSS=0.03*salario; totalISSS+=auxtISSS;
            restante=salario-auxtAFP-auxtISSS;
            if(restante>=0.01&&restante<=472.00)
                auxtRenta=0.00;
            else if(restante>=472.01&&restante<=895.24)
                auxtRenta=0.1*(restante-472)+17.67;
            else if(restante>=895.25&&restante<=2038.10)
                auxtRenta=0.2*(restante-895.24)+60;
            else if(restante>=2038.11)
                auxtRenta=0.3*(restante-2038.10)+288.57;
            salarioliquido=restante-auxtRenta;
            totalRenta+=auxtRenta;
        }
        return salarioliquido;
    }


    public static String mostrarTotales(){
        return "Total de Renta: $"+totalRenta+'\n'+"Total de ISSS: $"+totalISSS+'\n'+"Total de AFP: $"+totalAFP+'\n';
    }
}
