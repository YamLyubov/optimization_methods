package ru.spbu.apmath.optmeth.lyubovyamshchikova;

import java.util.ArrayList;

public class NelderMead {

    private double alpha = 1;
    private double beta = 0.5;
    private double gamma = 3;

    public Vector findMin(int maxIter, BiFunction fun) {
        Vector v1 = new Vector(1,5);
        Vector v2 = new Vector(2,8);
        Vector v3 = new Vector(0,1);
        ArrayList<Vector> vert = new ArrayList<>();
        for(int i=0;i<maxIter; i++) {
            //берем 3 точки
            vert.add(v1);
            vert.add(v2);
            vert.add(v3);

            //сортируем по значению функции от лучшей к худшей
            ArrayList<Vector> sortVert = Vector.sortVect(vert, fun);

            //переобозначаем точки
            Vector best = sortVert.get(0);
            Vector good = sortVert.get(1);
            Vector worst = sortVert.get(2);
            //System.out.println(fun.getValue(best) + " " + fun.getValue(good) + " " + fun.getValue(worst));

            //находим сереину отрезка с концами best и good
            Vector mid = (good.add(best)).div(2);

            //применяем отражение: xRefl = mid + alpha*(mid - worst)
            Vector xRefl = mid.add((mid.sub(worst)).mul(alpha));
            //System.out.println("точка отражения " + xRefl.represent() + " значение " + fun.getValue(xRefl));

            //проверяем, хорошая ли это точка
            if (fun.getValue(xRefl) < fun.getValue(worst)) {
                //если да, то берем ее
                worst = xRefl;
                //System.out.println(i + ": " + "refl(good) worst = " + worst.coord() );
            //если нет, то может хотя бы лучше наихудшей?
            } else {
                if (fun.getValue(xRefl) < fun.getValue(worst)) {
                    worst = xRefl;
                    //System.out.println(i + ": " + "refl(worst) worst = " + worst.coord() );
                    //попробуем немного отступить назад
                    Vector c = (worst.add(mid)).div(2);
                    if (fun.getValue(c) < fun.getValue(worst)) {
                        worst = c;
                        //System.out.println(i + ": " + "refl(отст назад) worst = " + worst.coord() );
                    }
                }

            }
            //казалось, что это наилучшая точка
            if (fun.getValue(xRefl) < fun.getValue(best)) {
                //попробуем пойти в этом направлении дальше
                //применяем растяжени: xExp = mid + gamma*(xRefl - mid)
                Vector xExp = mid.add((xRefl.sub(mid)).mul(gamma));
                if (fun.getValue(xExp) < fun.getValue(xRefl)) {
                    //стало лучше - берем точку
                    worst = xExp;
                    //System.out.println(i + ": " + "exp(растянули) worst = " + worst.coord() );
                } else {
                    //не стало - останавливаемся на достигнутом
                    worst = xRefl;
                    //System.out.println(i + ": " + "exp (не раст) worst = " + worst.coord() );

                }
            }
            //данная точка оказалась нехорошей
            if (fun.getValue(xRefl) > fun.getValue(good)) {
                //применяем сжатие, т.е. ищем точки внутри треугольника:
                // xContr = mid - beta*(worst - mid)
                Vector xContr = mid.add((worst.sub(mid)).mul(beta));
                //System.out.println("точка сжатия " + xContr.represent() + " значение " + fun.getValue(xContr));
                if (fun.getValue(xContr) < fun.getValue(worst)) {
                    worst = xContr;
                    //System.out.println(i + ": " + "contr worst = " + worst.coord() );
                }
            }
            v1 = best;
            v2 = good;
            v3 = worst;
            vert.clear();
        }
        //берем 3 точки
        vert.add(v1);
        vert.add(v2);
        vert.add(v3);

        //сортируем по значению функции от лучшей к худшей
        ArrayList<Vector> sortVert = Vector.sortVect(vert, fun);
        return sortVert.get(0);
    }

}
