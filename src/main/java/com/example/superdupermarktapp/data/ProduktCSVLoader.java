package com.example.superdupermarktapp.data;

import com.example.superdupermarktapp.model.Produkt;
import com.example.superdupermarktapp.model.ProduktFabrik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProduktCSVLoader {
    public static List<Produkt> loadProductsFromCSV(String filePath) {
        List<Produkt> produkten = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                if (line.trim().isEmpty()) continue;

                String[] values = line.split(",");

                String type = values[0].trim();
                String name = values[1].trim();
                double grundPreis = Double.parseDouble(values[2].trim());
                int qualitaet = Integer.parseInt(values[3].trim());

                // Handle optional expiration date
                LocalDate expirationDate = values.length > 4 && !values[4].trim().isEmpty()
                        ? LocalDate.parse(values[4].trim())
                        : null;

                produkten.add(ProduktFabrik.createProduct(type, name, grundPreis, qualitaet, expirationDate));
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Laden von Produkten aus CSV: " + e.getMessage());
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Fehler beim parsen von CSV main.java.example.superdupermarktapp.data: " + e.getMessage());
        }
        return produkten;
    }
}
