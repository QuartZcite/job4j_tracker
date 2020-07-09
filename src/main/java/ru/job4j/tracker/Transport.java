package ru.job4j.tracker;

public interface Transport {
    void go();
    void passengers(int count);
    double gas(double liters);
}
