package com.interview.vaccines.domain;

public enum VaccineType {
    Pfizer(30),
    Moderna(40),
    Astrazeneca(50);

    private final int cost;

    VaccineType(int cost) {
        this.cost = cost;
    }

    private int getCost() {
        return cost;
    }
}
