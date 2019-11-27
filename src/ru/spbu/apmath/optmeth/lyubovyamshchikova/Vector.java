package ru.spbu.apmath.optmeth.lyubovyamshchikova;

import java.util.ArrayList;
import java.util.List;

public class Vector{
    public double x;
    public double y;
    public Vector(double x, double y){
        this.x = x;
        this.y = y;
    }
    public String represent(){

        return "(" + x + ", " + y + ")";
    }
    public Vector add(Vector another){
        return new Vector(x + another.x, y + another.y);
    }
    public Vector sub(Vector another){
        return new Vector(x - another.x, y - another.y);
    }
    public Vector mul(double a){
        return new Vector(x*a, y*a);
    }
    public Vector div(double a){
        return new Vector(x/a,y/a);
    }
    public double skal(Vector another){
        return (x*another.x + y*another.y);
    }
    public static Vector[] prodmm(Vector[] m1, Vector[] m2){
        Vector x1 = new Vector( m1[0].x * m2[0].x + m1[0].y * m2[1].x, m1[0].x * m2[0].y + m1[0].y * m2[1].y) ;
        Vector x2 = new Vector( m1[1].x * m2[0].x + m1[1].y * m2[1].x, m1[1].x * m2[0].y + m1[1].y * m2[1].y) ;
        return new Vector[] {x1,x2};
    }
    public static Vector[] add(Vector[] m1, Vector[] m2){
        Vector x1 = new Vector(m1[0].x + m2[0].x, m1[0].y + m2[0].y);
        Vector x2 = new Vector(m1[1].x + m2[1].x, m1[1].y + m2[1].y);
        return new Vector[] {x1,x2};
    }
    public static Vector[] mul(Vector[] m, double a){
        m[0].x = m[0].x*a;
        m[0].y = m[0].y*a;
        m[1].x = m[1].x*a;
        m[1].y = m[1].y*a;
        return m;
    }
    public static Vector[] sub(Vector[] m1, Vector[] m2){
        return Vector.add(m1, Vector.mul(m2,(-1)));
    }
    public List<Double> coord(){
        ArrayList<Double> coord = new ArrayList<>();
        coord.add(x);
        coord.add(y);
        return coord;
    }
    public static Vector[] mulVect(Vector v1, Vector v2){
        Vector x = new Vector(v1.x * v2.x, v1.x * v2.y);
        Vector y  = new Vector(v1.y * v2.x, v1.y * v2.y);
        return new Vector[]{x,y};
    }
    public static Vector mulMatVect(Vector[] m, Vector v){
        double x = m[0].x* v.x + m[0].y*v.y;
        double y = m[1].x* v.x + m[1].y*v.y;
        return new Vector(x,y);
    }
    public double length(){
        return Math.sqrt(x*x +y*y);
    }

    public static ArrayList<Vector> sortVect(ArrayList<Vector> vect, BiFunction fun){
        if (vect.size()<=1)
            return vect;
        ArrayList<Vector> lesser = new ArrayList<>();
        ArrayList<Vector> greater = new ArrayList<>();
        Vector pivot = vect.get(vect.size()-1);
        for (int i=0; i<vect.size()-1;i++){
            if (fun.getValue(vect.get(i))<fun.getValue(pivot)){
                lesser.add(vect.get(i));
            }else{
                greater.add(vect.get(i));
            }
        }
        lesser = sortVect(lesser,fun);
        greater = sortVect(greater,fun);

        lesser.add(pivot);
        lesser.addAll(greater);
        return  lesser;
    }
}
