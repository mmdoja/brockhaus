package com.example.superdupermarktapp;

import com.example.superdupermarktapp.data.ProduktCSVLoader;
import com.example.superdupermarktapp.model.Produkt;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SuperDuperMarktApp {
	public static void main(String[] args) {

		List<Produkt> inventory;

		String csvFilePath = "src/main/resources/produkten.csv";
		inventory = ProduktCSVLoader.loadProductsFromCSV(csvFilePath);

		LocalDate simulationDate = LocalDate.now();

		for (int day = 1; day <= 30; day++) {
			System.out.println("Tag " + day);
			for (Produkt produkt : inventory) {
				produkt.updateDaily(simulationDate);
				System.out.printf("%s - Preis: %.2f, _______Qualitaet: %d, _______Ausgeraeumt: %b%n",
						produkt.getName(), produkt.getPrice(), produkt.getQuality(), produkt.isDiscarded());
			}
			System.out.println();
			simulationDate = simulationDate.plusDays(1);
		}
	}
}
