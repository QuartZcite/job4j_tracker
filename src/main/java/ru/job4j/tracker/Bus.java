package ru.job4j.tracker;

public class Bus implements Transport {
    @Override
    public void go() {
        boolean on;
        double speed;
    }

    @Override
    public void passengers(int count) {
        int capacity = 100;
        boolean full = count <= capacity;
    }

    @Override
    public double gas(double liters) {
        double coust = 50;
        return coust * liters;
    }
}
