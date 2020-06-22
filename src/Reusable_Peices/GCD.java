package Reusable_Peices;

public class GCD {

    int GCD(int a, int b){
        if(a > b) return EcluidGCD(a, b);

        return EcluidGCD(b,a);
    }



    int EcluidGCD(int a, int b){
        if(b == 0) return a;

        return EcluidGCD(a, a % b);
    }
}