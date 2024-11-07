package com.example.superdupermarktapp;

import com.example.superdupermarktapp.data.ProduktCSVLoader;
import com.example.superdupermarktapp.model.Kaese;
import com.example.superdupermarktapp.model.Produkt;
import com.example.superdupermarktapp.model.Wein;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SuperDuperMarktAppTest {
	@Test
	void testDailyUpdateIntegration() {
		String csvFilePath = "src/main/resources/produkten.csv";
		List<Produkt> inventory = ProduktCSVLoader.loadProductsFromCSV(csvFilePath);

		for (int day = 1; day <= 30; day++) {
			for (Produkt produkt : inventory) {
				produkt.updateDaily(LocalDate.now().plusDays(day));
			}
		}

		for (Produkt produkt : inventory) {
			if (produkt instanceof Kaese) {
				assertTrue(produkt.getQuality() <= 40, "Die Qualität der Käse sollte mit der Zeit abnehmen");
			}
			if (produkt instanceof Wein) {
				assertTrue(produkt.getQuality() <= 50, "Die Weinqualität sollte 50 % nicht überschreiten");
			}
		}
	}
}
