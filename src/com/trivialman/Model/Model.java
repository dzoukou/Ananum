package com.trivialman.Model;

import com.trivialman.function.Function;
import com.trivialman.function.functionC2;

/**
 * Created by TrivialMan on 28/02/2017.
 */
public class Model {

    public double[] solve(Function function, int n, double start,double end) throws Exception{

        if(n<3) throw new Exception("Le nombre d'intervalle doit etre supérieure à 2");
        if(end-start<=0) throw new Exception("l'intervalle est mal définie");


        double[] vals=((functionC2)function).getsecondprimevals(start,end,n);


        double[] apprvals=resolve(function.value(start),function.value(end),start,end,vals);


        return apprvals;
    }

    public double[] resolve(double Ua,double Ub,double start,double end,double[] values){

        int n=values.length;
        double h= (end-start)/(n+1);
        System.out.println("Pas -> "+h);

        // Finalisation du Système
        values[0]+=(Ua/(h*h));
        values[n-1]+=(Ub/(h*h));
        // Variables de la décomposition LU
        double[] L_b=new double[n];
        double[] U_c=new double[n-1];

        //Variables pour la résolution LU
        double[] X=new double[n];
        double[] Y=new double[n];

        //Initialisation
        L_b[0]=2;
        U_c[0]=-1.0/2;

        //Boucle
        for(int i=1;i<n-1;i++){
            L_b[i]=2+U_c[i-1];
            U_c[i]=-1.0/L_b[i];
        }

        //Fin Initialisation
        L_b[n-1]=2+U_c[n-2];

        //Premiere étape LU
        Y[0]=values[0]/L_b[0];
        for(int i=1;i<n;i++){
            Y[i]=(values[i]+Y[i-1])/L_b[i];
        }

        //Seconde étape LU
        X[n-1]=values[n-1];
        for(int i=n-2;i>=0;i--){
            X[i]=Y[i]-U_c[i]*X[i+1];
        }

        //Finalisation
        for(int i=0;i<n;i++){
            X[i]*=(h*h);
        }

        // Renvoie de la solution du système
        return X;
    }
}
