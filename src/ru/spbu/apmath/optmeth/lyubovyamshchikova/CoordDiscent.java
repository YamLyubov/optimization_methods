package ru.spbu.apmath.optmeth.lyubovyamshchikova;

public class CoordDiscent {

    public Vector findMin(BiFunction fun){
        Vector vect = new Vector(20,0);
        Vector e1 = new Vector(1,0);
        Vector e2 = new Vector(0, 1);
        double eps = 0.1;
        int k = 0;
        while ((fun.getDer(vect).length()>eps) && k<500)  {
            double alpha = 0.5;
            for (int i = 0; i < 20; i++) {
               // System.out.println("Оптимизация по x");
                if (fun.getValue(vect.sub(e1.mul(alpha))) < fun.getValue(vect)) {
                    vect = vect.sub(e1.mul(alpha));
//                    System.out.println("Вычли " + e1.mul(alpha) + " Получили " + vect.coord());
//                    System.out.println("Получилось. Было: " + rosFun.getValue(vect) + " Стало: " + rosFun.getValue(vect.sub(e1.mul(alpha))) );
                } else {
                   // System.out.println("Не получилось. Было: " + rosFun.getValue(vect) + " Стало: " + rosFun.getValue(vect.sub(e1.mul(alpha))) );
                    if (fun.getValue(vect.add(e1.mul(alpha))) < fun.getValue(vect)) {
                        vect = vect.add(e1.mul(alpha));
                   //     System.out.println("Прибавили " + e1.mul(alpha).coord() + " Получили " + vect.coord());
                    } else {
                      //  System.out.println("Не получилось. Было: " + rosFun.getValue(vect) + " Стало: " + rosFun.getValue(vect.add(e1.mul(alpha))) );
                        alpha = alpha / 2;
                    //    System.out.println("alpha = " + alpha);
                    }
                }
            }
            alpha = 0.5;
          //  System.out.println("Оптимизация по y");
            for (int i = 0; i < 20; i++) {
                if (fun.getValue(vect.sub(e2.mul(alpha))) < fun.getValue(vect)) {
                    vect = vect.sub(e2.mul(alpha));
                 //   System.out.println("Вычли " + e2.mul(alpha).coord() + " Получили " + vect.coord());
                } else {
                    if (fun.getValue(vect.add(e2.mul(alpha))) < fun.getValue(vect)) {
                        vect = vect.add(e2.mul(alpha));
                       // System.out.println("Прибавили " + e2.mul(alpha).coord() + " Получили " + vect.coord());
                    } else {
                        alpha = alpha / 2;
                      //  System.out.println("alpha = " + alpha);
                    }
                }
            }
         //   System.out.println("k = " + k + " Производная: " + rosFun.getDer(vect).coord() + " Модуль производнойЖ " + rosFun.getDer(vect).length());
            k++;
        }
        return vect;
    }
}
