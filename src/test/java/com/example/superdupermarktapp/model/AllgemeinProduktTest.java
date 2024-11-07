package com.example.superdupermarktapp.model;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
class AllgemeinProduktTest {
    @Test
    void testGeneralProductPriceCalculation() {
        AllgemeinProdukt produkt = new AllgemeinProdukt("Milch", 2.5, 20, LocalDate.now().plusDays(10));
        assertEquals(4.5, produkt.getPrice(), 0.01, "Price should be grundPreis + (0.10 * qualitaet)");
    }

    @Test
    void testGeneralProductDoesNotChangeQuality() {
        AllgemeinProdukt produkt = new AllgemeinProdukt("Milch", 2.5, 20, LocalDate.now().plusDays(10));
        produkt.updateDaily(LocalDate.now());
        assertEquals(20, produkt.getQuality(), "Die Qualitaet sollte bei allgemein produkten konstant bleiben");
    }

    @Test
    void testGeneralProductDiscardedAfterExpiration() {
        AllgemeinProdukt produkt = new AllgemeinProdukt("Brot", 1.0, 15, LocalDate.now().minusDays(1));
        produkt.updateDaily(LocalDate.now());
        assertTrue(produkt.isDiscarded(), "Produkt sollte nach Ablauf des Verfallsdatums entsorgt werden");
    }
}