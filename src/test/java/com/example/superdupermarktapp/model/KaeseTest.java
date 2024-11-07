package com.example.superdupermarktapp.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class KaeseTest {
    @Test
    void testKaeseDecreasesQualityDaily() {
        Kaese kaese = new Kaese("Cheddar", 5.0, 40, LocalDate.now().plusDays(80));
        kaese.updateDaily(LocalDate.now());
        assertEquals(39, kaese.getQuality(), "Kaese qualitaet sollte taeglich um 1 abnehmen");
    }

    @Test
    void testKaeseDiscardedWhenQualityFallsBelow30() {
        Kaese kaese = new Kaese("Gouda", 5.0, 31, LocalDate.now().plusDays(80));
        kaese.updateDaily(LocalDate.now());
        assertFalse(kaese.isDiscarded(), "Kaese sollte nicht bei qualitaet 30 entsorgt werden");

        kaese.updateDaily(LocalDate.now());
        assertTrue(kaese.isDiscarded(), "Kaese sollte entsorgt werden, wenn die qualitaet unter 30 faellt");
    }
}