package com.DSUR.x00143619;

public class InvalidIntException extends Exception{
    public static void ValidateInt(double salario){
        if(salario<=0.00)
            throw new ArithmeticException("Salario invalido!");
    }
}
