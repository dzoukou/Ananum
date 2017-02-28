package com.trivialman.schema;

import com.trivialman.Consts;
import com.trivialman.function.Function;
import com.trivialman.function.functionC2;

/**
 * Created by TrivialMan on 28/02/2017.
 */
public class Schema {

    public Schema(Function function,int nbreinter) throws Exception{
        int n=nbreinter;
        if(n<3) throw new Exception("Le nombre d'intervalle doit etre supérieure à 2");
        double[] vals=((functionC2)function).getsecondprimevals(n);
        double[] apprvals=resolve(function.value(Consts.START),function.value(Consts.END),vals);
        double[] truevals=new double[n-1];
        for(int i=0;i<n-1;i++){
            truevals[i]=function.value((i+1)/(1.0*(n)));
        }
        double err=0;
        for(int i=0;i<n-1;i++){
            err+=Math.abs(truevals[i]-apprvals[i]);
            System.out.println("Valeurs approchées -> "+apprvals[i]+"\t Valeur réelle -> "+truevals[i]);
        }
        err/=(n-1);
        System.out.println("erreur : "+err);
    }

    public double[] resolve(double a,double b,double[] values){

        int n=values.length;
        double h= (Consts.END-Consts.START)/(n+1);
        System.out.println("Pas -> "+h);

        // Finalisation du Système
        values[0]+=(a/(h*h));
        values[n-1]+=(b/(h*h));
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
            X[i]*=h*h;
        }

        // Renvoie de la solution du système
        return X;
    }
}
