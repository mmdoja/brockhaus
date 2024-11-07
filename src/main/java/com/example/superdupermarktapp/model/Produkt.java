package com.example.superdupermarktapp.model;

import java.time.LocalDate;

public interface Produkt {
    String getName();
    double getPrice();
    int getQuality();
    LocalDate getExpirationDate();
    boolean isDiscarded();
    void setQuality(int qualitaet);
    void setDiscarded(boolean discarded);
    void updateDaily(LocalDate currentDate);
}

