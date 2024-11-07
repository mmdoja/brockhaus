package com.example.superdupermarktapp.data;

import com.example.superdupermarktapp.model.Kaese;
import com.example.superdupermarktapp.model.Produkt;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ProduktCSVLoaderTest {
    @Test
    void testLoadProductsFromCSV() {
        String filePath = "src/main/resources/produkten.csv";
        List<Produkt> produkten = ProduktCSVLoader.loadProductsFromCSV(filePath);

        assertTrue(produkten.size() > 0, "Produkten sollten aus CSV geladen werden");

        assertTrue(produkten.get(0) instanceof Kaese, " Erste produkt muss Kaese sein");
    }
}