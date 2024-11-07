package com.example.superdupermarktapp.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class ProduktFabrikTest {
    @Test
    void testCreateKaeseProduct() {
        Produkt kaese = ProduktFabrik.createProduct("kaese", "Brie", 6.0, 32, LocalDate.now().plusDays(80));
        assertTrue(kaese instanceof Kaese, "Produkt sollte vom type Kaese sein");
    }

    @Test
    void testCreateWeinProduct() {
        Produkt wein = ProduktFabrik.createProduct("wein", "Merlot", 10.0, 20, null);
        assertTrue(wein instanceof Wein, "Produkt sollte vom type Wein sein");
    }

    @Test
    void testCreateGeneralProduct() {
        Produkt allgemein = ProduktFabrik.createProduct("allgemein", "Milch", 2.5, 15, LocalDate.now().plusDays(10));
        assertTrue(allgemein instanceof AllgemeinProdukt, "Produkt sollte vom type AllgemeinProdukt sein");
    }
}