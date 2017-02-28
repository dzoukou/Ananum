package com.trivialman.function;

/**
 * Created by TrivialMan on 28/02/2017.
 */
public class Constant extends functionC2{
    private double Const;

    public Constant(double Const){
        this.Const=Const;
    }

    public double value(double x){
        return Const;
    }

    public double secondprime(double x){
        return 0;
    }
}
