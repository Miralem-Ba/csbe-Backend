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
Die Datenstruktur besteht aus zwei Tabellen, die durch einen Fremdschlüssel miteinander verbunden sind. Es handelt sich um die Tabellen product und category. Durch den Fremdschlüssel category_id wird ein Produkt einer Kategorie zugewiesen. Ein Produkt kann auch keine Kategorie haben (sprich: das Produkt ist nicht gelistet).

- Produkt: (Beschreibung)
- Kategorie: (Beschreibung)

Die Tabelle: „Users“ gilt es selbst zu definieren. Achten Sie dabei auf die hier implementierten Namenskonventionen. 

## Dokumentation
- Alle Endpoints müssen sauber gemäss OpenAPI dokumentiert werden, sodass diese durch eine Swagger-Applikation eingesehen werden können.
Es muss eine Datei vorhanden sein, die alle Endpoints zu einer OpenAPI-Datei im YAML/JSON-Format zusammenfasst und ausgibt

- Die allgemeinen formalen Anforderungen (Schriftgrösse, Formalität, Gliederung, etc...) müssen beachtet werden
Es muss ein Arbeitsjournal mit der Auflistung der Tätigkeiten und der Arbeitszeit sowie mit einer Reflexion für jeden Arbeitstag geführt werden
Alle Endpoints der API müssen in der Dokumentation detailliert aufgelistet werden
Alle Endpoints der API müssen zudem mit einer OpenAPI-Dokumentation vollständig beschrieben sein
Es muss ein einheitliches Namensschema für die API-Parameter sowie für Datenbanktabellen und -spalten schriftlich definiert werden


## Technologien
Es wird mit einem Java Spring Boot Server (Spring Boot 3.X / Spring Framework 6.X) und einer MariaDB gearbeitet. Den Code-Editor oder die IDE wählen Sie selbst.
Zum Einsehen der Schnittstellendokumentation wird die Web-App swagger-ui verwendet.

## Anforderungen
Funktonal

- Ein nicht authentifizierter Benutzer kann sich authentifizieren
- Ein nicht authentifizierter Benutzer kann ein Konto erstellen
- Ein authentifizierter Benutzer mit Administrationsrechte kann einen Benutzer zum Administrator befördern
- Mittels einem Database Seeder werden initiale Daten in die Datenbank geladen
- Ein authentifizierter Benutzer mit Administrationsrechte kann Produkte erstellen
- Ein authentifizierter und nicht authentifizierter Benutzer kann Produkte einsehen
- Ein authentifizierter Benutzer mit Administrationsrechte kann Produkte bearbeiten
- Ein authentifizierter Benutzer mit Administrationsrechte kann Produkte löschen
- Ein authentifizierter Benutzer und nicht authentifizierter Benutzer kann alle Produkte auflisten
- Ein authentifizierter Benutzer mit Administrationsrechte kann Produktkategorien erstellen
- Ein authentifizierter und nicht authentifizierter Benutzer kann Produktkategorien einsehen
- Ein authentifizierter Benutzer mit Administrationsrechte kann Produktkategorien bearbeiten
- Ein authentifizierter Benutzer mit Administrationsrechte kann Produktkategorien löschen
- Ein authentifizierter Benutzer und nicht authentifizierter Benutzer kann alle Produktkategorien auflisten
- Ein authentifizierter Benutzer und nicht authentifizierter Benutzer kann alle Produkte einer Produktekategorie auflisten

Nichtfunktional

- Die Applikation erfüllt die REST-Richtlinien (Insbesondere sind die Endpoints einheitlich und sinnvoll zu benennen)
- Die Datenbankanbindung erfolgt mittels Spring JDBC
- Die Authentifizierung für die geschützten Endpoints wird mittels JWT umgesetzt
- Es muss stets ein Benutzer mit Administratorenrechte im System geben
- Passwörter werden mit einem starken Verschlüsslungsalgorithmus geschützt

# Benutzer

# Datenbank-Seed

# Sicherheit

# Authentifizierung

# Dateistruktur

# Tabellenstruktur

# Code-Kommentare

# Einhaltung-der-Code-Style-Richtlinien

# OpenAPI-Dokumentation

# HTTP-Response-Codes

# API-Struktur

# Endpoints

# Namensschema-für-Daten

# Arbeitsjournal

# Quellen
