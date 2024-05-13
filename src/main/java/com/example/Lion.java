package com.example;

import java.util.List;

public class Lion extends Feline {

    private boolean hasMane;
    private Feline feline;

    public Lion(String sex, Feline feline) throws Exception {

        this.feline = feline;

        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        return this.feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return this.feline.getFood("Хищник");
    }
}
