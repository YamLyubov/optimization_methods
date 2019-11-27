package ru.spbu.apmath.optmeth.lyubovyamshchikova;

public class GoldenSection {
    final double PHI = (1 + Math.sqrt(5)) / 2;



    double findMin(MyFunction func, double lBorder, double rBorder){
        final double eps = 0.0005;
        double x1, x2;
        int k = 1;
        while (true){
            x1 = rBorder - (rBorder - lBorder) / PHI;
            x2 = lBorder + (rBorder - lBorder) / PHI;
            if (func.getValue(x1)>=func.getValue(x2)){
                lBorder = x1;
                //System.out.println(("k = " + k + " Длина промежутка: " + Math.abs(rBorder - lBorder) + " Значение функции: " + func.getValue(x1)));
            }else {
                rBorder = x2;
                //System.out.println(("k = " + k + " Длина промежутка: " + Math.abs(rBorder - lBorder) + " Значение функции: " + func.getValue(x2)));
            }
            if (Math.abs(rBorder - lBorder) < eps)
                break;
            k++;
        }
        System.out.println("k = " + k);
        return (lBorder + rBorder) / 2;
    }
}
