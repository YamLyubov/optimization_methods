package ru.spbu.apmath.optmeth.lyubovyamshchikova;


public class Dichotomy {
    public double findMin(MyFunction func, double lBorder, double rBorder){
        final double eps = 0.0011;
        final double del = 0.0005;
        double middle;
        int k = 1;
        while (true){
            middle = (rBorder+lBorder)/2;
            if (func.getValue(middle-del)<=func.getValue(middle+del)) {
                rBorder = middle + del;
               // System.out.println("k = " + k + " Длина промежутка: " + Math.abs(rBorder - lBorder) + " Значение функции: " + func.getValue(middle-del));
            }else {
                lBorder = middle - del;
               // System.out.println(("k = " + k + " Длина промежутка: " + Math.abs(rBorder - lBorder) + " Значение функции: " + func.getValue(middle+del)));
            }
            if (rBorder - lBorder <= eps)
                break;
            k++;
        }
        System.out.println("k = " + k);
        return (rBorder + lBorder) / 2;
    }

}
