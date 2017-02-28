package com.trivialman.function;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import com.trivialman.Consts;

/**
 * Created by TrivialMan on 28/02/2017.
 */
public abstract class functionC2 implements Function {
    public double secondprime(double x){
        return x;
    }
    // le nombre d'intervalles est passé en paramètre
    public double[] getsecondprimevals(int n){
        double[] vals=new double[n-1];
        double pas=(Consts.END- Consts.START)/n;
        for(int i=0;i<n-1;i++){
            vals[i]=secondprime(Consts.START+pas*(i+1));
        }
        return vals;
    }
}
