package com.example.superdupermarktapp.model;

import java.time.LocalDate;

public class Wein extends AllgemeinProdukt {
    private int daysSinceLastIncrease = 0;
    public Wein(String name, double grundPreis, int qualitaet) {
        super(name, grundPreis, qualitaet, null);
    }

    @Override
    public double getPrice() {
        return getBasePrice();
    }

    @Override
    public void updateDaily(LocalDate currentDate) {
        daysSinceLastIncrease++;

        if (daysSinceLastIncrease == 10 && getQuality() < 50) {
            setQuality(Math.min(getQuality() + 1, 50));
            daysSinceLastIncrease = 0;
            /* if (getQuality() < 50 && currentDate.getDayOfYear() % 10 == 0) {
            setQuality(Math.min(getQuality() + 1, 50));*/
        }
    }
}
