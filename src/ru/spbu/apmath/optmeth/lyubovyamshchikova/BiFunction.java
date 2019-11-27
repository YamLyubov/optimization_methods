package ru.spbu.apmath.optmeth.lyubovyamshchikova;

public interface BiFunction {
    public double getValue(Vector v);

    public Vector getDer(Vector v);
}