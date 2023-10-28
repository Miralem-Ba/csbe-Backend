BACKEND FÜR APPLIKATIONEN REALISIEREN

# Inhalt
- [Projektauftrag](#projektauftrag)
- [Datenmodell](#datenmodell)
- [Dokumentation](#dokumentation)
- [Technologien](#technologien)
- [Anforderungen](#anforderungen)
- [Funktional](#funktional)
- [Nichtfunktional](#nichtfunktional)
- [Dokumentation](#dokumentation)
- [Benutzer](#benutzer)
- [Datenbank-Seed](#datenbank-Seed)
- [Sicherheit](#sicherheit)
- [Authentifizierung](#authentifizierung)
- [Dateistruktur](#dateistruktur)
- [Tabellenstruktur](#tabellenstruktur)
- [Code-Kommentare](#code-kommentare)
- [Einhaltung-der-Code-Style-Richtlinien](#einhaltung-der-Code-Style-Richtlinien)
- [OpenAPI-Dokumentation](#openAPI-Dokumentation)
- [HTTP-Response-Codes](#HTTP-Response-Codes)
- [API-Struktur](#API-Struktur)
- [Endpoints](#Endpoints)
- [Namensschema-für-Daten](#Namensschema-für-Daten)
- [Arbeitsjournal](#Arbeitsjournal)
- [Quellen](#Quellen)

## Projektauftrag
Sie müssen eine API zur Verwaltung von Produkten eines Online-Shops erstellen. Diese muss die nötigen Endpoints zur Verfügung stellen, um damit Produkte und Kategorien in einer Datenbank zu erstellen, lesen, ändern und löschen. Die Endpoints müssen dem REST-Standard entsprechen.
Das Frontend für das Web wird im Rahmen eines späteren Projekts entwickelt. Daher muss die API unbedingt sauber strukturiert und gut dokumentiert sein.
Die Datenbank müssen Sie selbst mit den nötigen Tabellen und Eigenschaften einrichten. Die Datenstruktur wird hierzu vorgegeben (siehe unten). Alle Eigenschaften beider Typen (mit Ausnahme der IDs) müssen durch die API korrekt verwaltet werden können. Anfrage und Antwort müssen in korrektem JSON strukturiert werden.
Alle Endpoints (ausser dies wird anderweitig entkräftet) der API müssen mittels JSON Web Token geschützt werden. Dafür muss es allerdings einen einzigen Endpoint zur Authentifizierung geben, der ohne Token erreichbar ist. Dieser Endpoint nimmt einen Benutzernamen und ein Passwort entgegen und gibt ein valides JWT zurück, das dann zur Authentifizierung von allen anderen Endpoints verwendet wird.

## Datenmodell
(Beschreibung des Datenmodells)

- Produkt: (Beschreibung)
- Kategorie: (Beschreibung)

## Dokumentation

## Technologien
Beschreiben Sie die verwendeten Technologien wie Java Spring Boot, MariaDB, usw.

## Anforderungen

### Funktonal

### Nichtfunktional

