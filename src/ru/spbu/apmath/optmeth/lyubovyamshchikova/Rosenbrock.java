package ru.spbu.apmath.optmeth.lyubovyamshchikova;

public class Rosenbrock implements BiFunction{
    public double b;
    public double a;
    public Rosenbrock(double a, double b){
        this.a = a;
        this.b = b;
    }
    public double getValue(Vector v){
        double x = v.x;
        double y = v.y;
        return (a-x)*(a-x) + b*(y - x*x)*(y - x*x);
    }
    public Vector getDer(Vector v){
        double x = v.x;
        double y = v.y;
        double dx = (-2)*(a-x) - 4*b*(y - x*x)*x;
        double dy = 2*b*(y-x*x);
        return new Vector(dx, dy);
    }

}
