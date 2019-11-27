package ru.spbu.apmath.optmeth.lyubovyamshchikova;

import java.util.Scanner;

public class Interaction {
    public static void main(String[] args) {
        Scanner ina = new Scanner(System.in);
        System.out.print("Введите a:");
        String a = ina.nextLine();
        Scanner inb = new Scanner(System.in);
        System.out.print("Введите b:");
        String b = inb.nextLine();
        try {
            double paramA = Double.parseDouble(a);
            double paramB = Double.parseDouble(b);
            MyFunction func = new MyFunction(paramA, paramB);
            Dichotomy dich = new Dichotomy();
            GoldenSection goldsec = new GoldenSection();
            double minDich = dich.findMin(func,-8, 8 );
            double minGold = goldsec.findMin(func,-8, 8 );
            System.out.println("Точка минимума (метод дихотомии): " + minDich + " Значение функции: " + func.getValue(minDich));
            System.out.println("Точка минимума (метод золотого сечения): " + minGold +  " Значение функции: " + func.getValue(minGold));
        } catch (NumberFormatException ex) {
            System.out.println("Нужно ввести десятичное число!");
        }

            Rosenbrock ros = new Rosenbrock(1, 100);
            Himmelblau him = new Himmelblau(11, 7);
            NelderMead nd = new NelderMead();
            System.out.println("Точка минимума (н-д): " + nd.findMin(30,ros).coord());
            System.out.println("Точка минимума (н-д): " + nd.findMin(30,him).coord());
            ConjugateGrad cg = new ConjugateGrad();
            System.out.println("Точка минимума Розенброк (сопр. град): " + cg.findMin(ros).coord());
            System.out.println("Точка минимума Химмельблау (сопр. град): " + cg.findMin(him).coord());
            GradientDescent gd = new GradientDescent();
            System.out.println("Точка минимума Розенброк (наискор. спуск): " + gd.findMin(new Vector(0,0),ros).coord());
            System.out.println("Точка минимума Химмельблау (наискор. спуск): " + gd.findMin(new Vector(0,0), him).coord());
            CoordDiscent cd = new CoordDiscent();
            System.out.println("Точка минимума Розенброк (покоорд. спуск): " + cd.findMin(ros).coord());
            System.out.println("Точка минимума Химмельблау (покоорд. спуск): " + cd.findMin(him).coord());
            QuasiNewton qn = new QuasiNewton();
            System.out.println("Точка минимума Розенброк (Квази-Ньютоновскй): " + qn.findMin(new Vector(1,0),ros).coord());
            System.out.println("Точка минимума Химмельблау (Квази-Ньютоновскй): " + qn.findMin(new Vector(2,1), him).coord());

    }

}
