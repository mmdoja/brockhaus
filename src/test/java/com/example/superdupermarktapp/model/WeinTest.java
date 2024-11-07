package com.example.superdupermarktapp.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class WeinTest {
    @Test
    void testWeinFixedPrice() {
        Wein wein = new Wein("Merlot", 10.0, 20);
        assertEquals(10.0, wein.getPrice(), "Wein preis sollte auf dem grundpreis fest bleiben");
    }

    @Test
    void testWeinQualityIncreasesEvery10Days() {
        Wein wein = new Wein("Merlot", 10.0, 20);
        LocalDate startDate = LocalDate.now();

        for (int i = 1; i <= 30; i++) {
            wein.updateDaily(startDate.plusDays(i));
            if (i % 10 == 0) {
                assertEquals(20 + i / 10, wein.getQuality(), "Die Weinqualität sollte alle 10 Tage um 1 steigen");
            }
        }
    }

    @Test
    void testWeinQualityDoesNotExceed50() {
        Wein wein = new Wein("Chardonnay", 10.0, 49);

        LocalDate startDate = LocalDate.of(2023, 1, 1);
        for (int i = 1; i <= 10; i++) {
            wein.updateDaily(startDate.plusDays(i));
        }
        assertEquals(50, wein.getQuality(), "Weinqualität sollte bei maximal 50 liegen");

        for (int i = 11; i <= 20; i++) {
            wein.updateDaily(startDate.plusDays(i));
        }
        assertEquals(50, wein.getQuality(), "Weinqualität sollte 50 nicht überschreiten");
    }
}