package ru.spbu.apmath.optmeth.lyubovyamshchikova;

public class MyFunction{
    public double paramB;
    public double paramA;
    public MyFunction(double paramA, double paramB){
        this.paramA = paramA;
        this.paramB = paramB;
    }
    public double getValue(double x){
        return paramA*x + paramB/(Math.exp(x));
    }
}
