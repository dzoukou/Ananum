package com.trivialman.function;

/**
 * Created by TrivialMan on 28/02/2017.
 */
public abstract class functionC2 implements Function {
    public double secondprime(double x){
        return x;
    }
    // le nombre d'intervalles est passé en paramètre
    public double[] getsecondprimevals(double start,double end,int n){
        double[] vals=new double[n-1];
        double pas=(end-start)/n;
        for(int i=0;i<(n-1);i++){
            vals[i]=secondprime(start+pas*(i+1));
        }
        return vals;
    }
    public double[] getvals(double start,double end,int n){
        double[] vals=new double[n-1];
        double pas=(end-start)/n;
        for(int i=0;i<(n-1);i++){
            vals[i]=value(start+pas*(i+1));
        }
        return vals;
    }
}
