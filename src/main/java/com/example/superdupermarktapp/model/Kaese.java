package com.example.superdupermarktapp.model;

import java.time.LocalDate;

public class Kaese extends AllgemeinProdukt {
    public Kaese(String name, double grundPreis, int qualitaet, LocalDate expirationDate) {
        super(name, grundPreis, qualitaet, expirationDate);
    }

    @Override
    public void updateDaily(LocalDate currentDate) {
        if (getQuality() > 29) {
            setQuality(getQuality() - 1);
        }
        if (getQuality() < 30) {
            setDiscarded(true);
        }
    }

}