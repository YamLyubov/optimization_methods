package ru.spbu.apmath.optmeth.lyubovyamshchikova;

public class ConjugateGrad {
    private double eps = 0.0011;

    public Vector findMin(BiFunction ros) {
        double  a = 0,
                b = 10,
                iter = 1,
                x1,
                x2,
                alp,
                beta;
        Vector v = new Vector(2, 1);
        Vector anti_grad = ros.getDer(v).mul(-1);
        Vector dir_prev = anti_grad;
        Vector dir_cur;

        while (ros.getDer(v).length() > eps) {
            anti_grad = ros.getDer(v).mul(-1);
            //ортогонализация Грама-Шмидта
            if (iter == 1) {
                //первый вектор ортогон-ть не нужно
                dir_cur = anti_grad;
            } else {
                //коэффициент для ортогонализации (x,y)/(y,y)
                beta = (anti_grad.skal(dir_prev)) / (dir_prev.skal(dir_prev));
                //найдем направление спуска g = x - beta*y
                dir_cur = anti_grad.sub(dir_prev.mul(beta));
                //System.out.println("Новое напрвление: " + dir_cur.represent());
            }
            do {
                double middle = (a + b) / 2;
                x1 = middle - 0.0005;
                x2 = middle + 0.0005;
                double i1 = ros.getValue(v.add(dir_cur.mul(x1)));
                double i2 = ros.getValue(v.add(dir_cur.mul(x2)));
                if (i1 < i2) {
                    b = x2;
                } else {
                    a = x1;
                }
            } while (Math.abs(b - a) > eps);
            alp = (a + b) / 2;
            v = v.add(dir_cur.mul(alp));
            dir_prev = dir_cur;
            //System.out.println("k = " + iter + " Точка: " + v.represent() + " Значение: " + ros.getValue(v));
            iter++;

        }
        System.out.println("k = " + iter);
        return v;
    }
}
