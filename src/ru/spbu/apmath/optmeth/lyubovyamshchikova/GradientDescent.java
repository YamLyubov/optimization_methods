package ru.spbu.apmath.optmeth.lyubovyamshchikova;

public class GradientDescent {
    private double eps = 0.0011;

    public Vector findMin(Vector v, BiFunction fun) {
        Vector grad = fun.getDer(v);
        Integer iter = 1;
    //    System.out.println("В точке " + v.represent() + " производная " + grad.represent());
        while(grad.length() > eps){
            double lambda;
            //дихотомия
            double x1, x2;
            double a = 0;
            double b = 10;
            double del = 0.0005;
            do {
                double middle = (a+b)/2;
                x1 = middle - del;
                x2 = middle + del;
                double i1 = fun.getValue(v.sub(grad.mul(x1)));
                double i2 = fun.getValue(v.sub(grad.mul(x2)));
                if (i1 < i2) {
                    b = x2;
                } else {
                    a = x1;
                }
            } while (Math.abs(b - a) > eps);
            lambda = (a+b)/2;
            v = v.sub(grad.mul(lambda));
            grad = fun.getDer(v);
            iter++;
            //System.out.println("В точке " + v.represent() + " значение " + fun.getValue(v));
       }
        System.out.println("k = " + iter);
        return v;
    }
}
