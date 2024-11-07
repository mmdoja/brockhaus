package com.example.superdupermarktapp.model;

import java.time.LocalDate;

public class ProduktFabrik {
    public static Produkt createProduct(String type, String name, double grundPreis, int qualitaet, LocalDate expirationDate) {
        return switch (type.toLowerCase()) {
            case "kaese" -> new Kaese(name, grundPreis, qualitaet, expirationDate);
            case "wein" -> new Wein(name, grundPreis, qualitaet);
            default -> new AllgemeinProdukt(name, grundPreis, qualitaet, expirationDate);
        };
    }
}


