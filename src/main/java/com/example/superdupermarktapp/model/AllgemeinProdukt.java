package com.example.superdupermarktapp.model;

import java.time.LocalDate;

public class AllgemeinProdukt implements Produkt {
    private String name;
    private double grundPreis;
    private int qualitaet;
    private LocalDate expirationDate;
    private boolean discarded;

    public AllgemeinProdukt(String name, double grundPreis, int qualitaet, LocalDate expirationDate) {
        this.name = name;
        this.grundPreis = grundPreis;
        this.qualitaet = qualitaet;
        this.expirationDate = expirationDate;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getGrundPreis() {
        return grundPreis;
    }

    @Override
    public double getPrice() {
        return grundPreis + (0.10 * qualitaet);
    }

    @Override
    public int getQuality() {
        return qualitaet;
    }

    @Override
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public boolean isDiscarded() {
        return discarded;
    }


    @Override
    public void setQuality(int qualitaet) {
        this.qualitaet = qualitaet;
    }

    @Override
    public void setDiscarded(boolean discarded) {
        this.discarded = discarded;
    }

    @Override
    public void updateDaily(LocalDate currentDate) {
        if (expirationDate != null && currentDate.isAfter(expirationDate)) {
            discarded = true;
        }
    }
}