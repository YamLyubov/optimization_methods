package ru.spbu.apmath.optmeth.lyubovyamshchikova;

public class Himmelblau implements BiFunction{
    public double b;
    public double a;
    public Himmelblau(double a, double b){
        this.a = a;
        this.b = b;
    }
    public double getValue(Vector v){
        double x = v.x;
        double y = v.y;
        return (x*x + y - a)*(x*x + y - a) + (x + y*y - b)*(x + y*y - b);
    }
    public Vector getDer(Vector v){
        double x = v.x;
        double y = v.y;
        double dx = 2*(x*x + y -a)*2*x + 2*(x + y*y - b);
        double dy = 2*(x*x + y -a) + 2*(x + y*y - b)*2*y;
        return new Vector(dx, dy);
    }

}
