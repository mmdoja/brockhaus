# **SuperDuperMarkt**

Ein modulares Java-Projekt zur Verwaltung des Produktinventars. Die Anwendung berechnet Preise und Qualität basierend auf anpassbaren Regeln für verschiedene Produkttypen wie Käse, Wein und allgemeine Produkte. Die Daten werden aus einer CSV-Datei geladen, und tägliche Qualitäts- und Preisaktualisierungen werden entsprechend den Produkttyp-spezifischen Regeln vorgenommen.

**Inhaltsverzeichnis**
* Beschreibung
* Voraussetzungen
* Verwendete Design Patterns
* Tests

### **Beschreibung**

SuperDuperMarkt ist ein Inventarverwaltungssystem, das über die Konsole ausgeführt wird. Es unterstützt mehrere Produkttypen:

**Kaese (Cheese)**: Qualität sinkt täglich und das Produkt wird verworfen, wenn die Qualität unter 30 fällt.

**Wein (Wine)**: Qualität steigt alle 10 Tage, der Preis bleibt jedoch fixiert.

**Allgemeine Produkte (General)**: Qualität bleibt unverändert, wird jedoch nach Ablauf des Verfallsdatums verworfen.

Die Daten werden aus einer CSV-Datei geladen, und die Anwendung führt eine tägliche Aktualisierung über 30 Tage hinweg durch.

### **Voraussetzungen**

* Java 11 oder höher
* Maven (für Abhängigkeitsmanagement)
* JUnit 5 (für Tests)
* Spring Boot (für die Anwendung)

### **Verwendete Design Patterns**

Die Anwendung nutzt Design Patterns, um Modularität und Erweiterbarkeit zu fördern:

**Factory Pattern:**
ProduktFabrik erstellt verschiedene Produkttypen basierend auf der Konfiguration.

**Strategy Pattern:**
Jeder Produkttyp (Kaese, Wein, AllgemeinProdukt) hat eigene Regeln zur Anpassung von Qualität und Preis.

**Template Method Pattern:**
Die AllgemeinProdukt-Klasse bietet eine gemeinsame Basis für Verfallsprüfungen, die von Unterklassen erweitert werden können.

### Tests

Das Projekt enthält Unit- und Integrationstests.

