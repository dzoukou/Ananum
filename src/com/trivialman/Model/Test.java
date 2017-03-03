package com.trivialman.Model;

import com.trivialman.function.Function;
import com.trivialman.function.functionC2;

/**
 * Created by TrivialMan on 02/03/2017.
 */
public class Test {
    private Function function;
    private double start,end,Ua,Ub;
    int n;

    public Test(Function function, double start, double end, int n) {
        this.function = function;
        this.start = start;
        this.end = end;
        this.n = n;

        try {
            double[] apprvals=new Model().solve(function,n,start,end);
            double[] truevals;
            truevals=((functionC2)function).getvals(start,end,n);


            double err=0;
            for(int i=0;i<(n-1);i++){
                err+=Math.abs(truevals[i]-apprvals[i]);
                System.out.println("Valeurs approchées -> "+apprvals[i]+"\t Valeur réelle -> "+truevals[i]);
            }

            err/=(n-1);
            System.out.println("erreur : "+err);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
