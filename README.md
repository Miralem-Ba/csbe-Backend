BACKEND FÜR APPLIKATIONEN REALISIEREN 295

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
## Funktional
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

## Nichtfunktional
- Die Applikation erfüllt die REST-Richtlinien (Insbesondere sind die Endpoints einheitlich und sinnvoll zu benennen)
- Die Datenbankanbindung erfolgt mittels Spring JDBC
- Die Authentifizierung für die geschützten Endpoints wird mittels JWT umgesetzt
- Es muss stets ein Benutzer mit Administratorenrechte im System geben
- Passwörter werden mit einem starken Verschlüsslungsalgorithmus geschützt

# Benutzer
Die Benutzerkomponente ermöglicht die Verwaltung von Benutzern innerhalb des Systems. Jeder Benutzer hat verschiedene Attribute wie Name, Nachname, Benutzername, Passwort und mehr.

## Entität: Benutzer
Jeder Benutzer im System wird durch die Entität Benutzer dargestellt. Hier sind die wichtigsten Attribute:

- id: Ein eindeutiger Bezeichner für den Benutzer.
- name: Der Vorname des Benutzers.
- lastname: Der Nachname des Benutzers.
- username: Ein eindeutiger Benutzername für die Anmeldung.
- password: Das Passwort des Benutzers.
- Beschreibung: Eine kurze Beschreibung des Benutzers.
- Bild: Ein Bild oder Avatar des Benutzers.
- aktiv: Der Aktivierungsstatus des Benutzers.
- isAdmin: Ein boolescher Wert, der angibt, ob der Benutzer über Administratorrechte verfügt.
- productId: Die dem Benutzer zugeordnete Produkt-ID (falls zutreffend).

## API-Endpunkte
- GET /api/users: Gibt eine Liste aller Benutzer zurück.
- GET /api/users/{id}: Gibt einen bestimmten Benutzer anhand seiner ID zurück.
- POST /api/users: Legt einen neuen Benutzer an.
- PUT /api/users/{id}: Aktualisiert einen vorhandenen Benutzer auf der Grundlage seiner ID.
- DELETE /api/users/{id}: Löscht einen Benutzer auf der Grundlage seiner ID.
- 
## Dienst
Die Hauptgeschäftslogik für Benutzer wird im UserService verwaltet. Dieser Dienst bietet Methoden zum Erstellen, Abrufen, Aktualisieren und Löschen von Benutzern.

## Repository
Das UserRepository stellt die Datenzugriffsmethoden bereit und erweitert JpaRepository.

## Benutzer-DTO (UserDto)
In bestimmten Fällen, in denen nicht alle Benutzerattribute benötigt werden, kann UserDto verwendet werden, um eine reduzierte Sicht auf einen Benutzer darzustellen.

# Datenbank-Seed
Die Datenbank-Seed-Funktion ermöglicht es Entwicklern, die Datenbank mit ersten Daten zu füllen. Dies ist besonders nützlich, um eine konsistente Entwicklungs- und Testumgebung zu gewährleisten.

## Wie es funktioniert
Das Seeding-Tool verwendet vordefinierte Daten aus einer Quelle (z. B. JSON-Dateien, SQL-Skripts oder Java-Klassen) und fügt diese Daten in die Datenbank ein.

## Schritte zum Seeding der Datenbank
- Vorbereitung: Stellen Sie sicher, dass Ihre Datenbank läuft und korrekt konfiguriert ist.
- Datenquellen: Überprüfen Sie die Dateien im Verzeichnis path/to/seeds, um die Seed-Daten zu sehen. Passen Sie die Daten bei Bedarf an.
- Ausführen des Seed-Skripts: Führen Sie das Skript seedDatabaseScript (oder ein entsprechend benanntes Skript) aus, um die Seed-Daten in die Datenbank zu laden.
- Überprüfen Sie Ihre Datenbank, um sicherzustellen, dass die Daten korrekt eingefügt wurden.

## Vorsicht
- Das Seeding-Skript kann vorhandene Daten in der Datenbank überschreiben. Stellen Sie sicher, dass Sie eine Sicherungskopie Ihrer Datenbank haben, bevor Sie das Skript ausführen.
- Verwenden Sie das Seeding-Skript nicht in einer Produktionsumgebung, wenn dies nicht ausdrücklich erforderlich ist und Sie die damit verbundenen Risiken kennen.

## Häufige Probleme und deren Behebung
- Fehlermeldung "Datenbankverbindung fehlgeschlagen": Überprüfen Sie Ihre Datenbankverbindung und Ihre Konfigurationsdateien.
- Daten fehlen oder sind unvollständig: Stellen Sie sicher, dass Ihre Seed-Daten korrekt formatiert sind und alle erforderlichen Informationen enthalten.

# Sicherheit
Die Sicherheit der Anwendung liegt mir besonders am Herzen. Hier möchte ich Sie über die von mir implementierten Sicherheitsmaßnahmen und -praktiken informieren und Ihnen einige Empfehlungen für eine sichere Nutzung geben.

## Authentifizierung und Autorisierung
Meine Benutzerdaten: Ich speichere Passwörter, die mit einem starken kryptografischen Algorithmus verschlüsselt sind.
Sitzungsverwaltung: Ich habe dafür gesorgt, dass die Sitzungen sicher und zeitlich begrenzt sind. Sie werden automatisch abgemeldet, wenn Sie nicht mehr aktiv sind.
Zugriffskontrolle: Ich habe Maßnahmen ergriffen, um sicherzustellen, dass nur autorisierte Benutzer auf bestimmte Ressourcen zugreifen können.

## Datenübertragung
Verschlüsselung: Alle Daten, die zwischen Ihrem Gerät und meinem Server übertragen werden, werden mit TLS/SSL verschlüsselt.
Cookies: Ich setze HttpOnly- und Secure-Flags auf meinen Cookies, um Sicherheitsrisiken zu minimieren.

## Code-Sicherheit
SQL-Injection: Ich habe meine Datenbankanfragen so gestaltet, dass Risiken durch SQL-Injection minimiert werden.
Cross-Site Scripting (XSS): Ich validiere und bereinige Benutzereingaben, um Risiken durch XSS zu minimieren.

## Drittanbieter-Komponenten
Ich halte alle meine Abhängigkeiten und Bibliotheken stets aktuell, um bekannten Sicherheitslücken vorzubeugen.
Ich nutze nur vertrauenswürdige und geprüfte Libraries.

## Meine Empfehlungen für euch
Bitte stellt sicher, dass ihr stets die neueste Version meiner Anwendung nutzt.
Nutzt starke Passwörter und ändert sie regelmäßig.
Betreibt meine Anwendung in einer sicheren Umgebung.

# Authentifizierung
Als ich diese Anwendung entwickelte, wollte ich eine sichere und benutzerfreundliche Authentifizierung anbieten. Hier möchte ich erklären, wie ich den Authentifizierungsprozess gestaltet habe und wie Sie ihn am besten nutzen können.

## Meine Methoden
Passwortbasiert: Ich speichere Ihre Passwörter nicht im Klartext. Stattdessen verwende ich eine starke Einweg-Hash-Funktion, um sicherzustellen, dass Ihre Passwörter auch im Falle eines Datenlecks sicher sind.
Sitzungsverarbeitung: Nach erfolgreicher Registrierung erstelle ich eine Sitzung für Sie. Diese Sitzung ist zeitlich begrenzt, so dass sie nach einer bestimmten Zeit der Inaktivität automatisch endet.

## Zwei-Faktor-Authentifizierung
Um eine zusätzliche Sicherheitsebene zu schaffen, habe ich die Zwei-Faktor-Authentifizierung (2FA) eingeführt. Ich empfehle Ihnen dringend, diese Funktion in Ihren Einstellungen zu aktivieren.

## Tokens und API-Zugriff
Wenn ihr über unsere API auf die Anwendung zugreifen möchtet, biete ich Token-basierte Authentifizierung an. Dieser Token gewährleistet, dass ihr sicher auf unsere Dienste zugreifen könnt, ohne euer Passwort erneut eingeben zu müssen.

## Meine Empfehlungen
Wählt ein starkes, einzigartiges Passwort für euren Account.
Aktiviert, wenn möglich, die Zwei-Faktor-Authentifizierung, um euren Account zusätzlich zu schützen.
Gebt euer Passwort nie weiter und achtet darauf, in welcher Umgebung ihr euch authentifiziert. Öffentliche Netzwerke können riskant sein.

# Dateistruktur
In meinem Projekt habe ich mich für eine klare und verständliche Dateistruktur entschieden, um den Überblick zu behalten und die Zusammenarbeit zu erleichtern.

- /src: In diesem Ordner bewahre ich den Hauptcode meines Projekts auf. Hier habe ich alle wichtigen Module, Klassen und Funktionen untergebracht.
- /src/main: Dieser Unterordner enthält den Hauptcode meiner Anwendung.
- /src/test: Hier habe ich alle meine Testdateien abgelegt. Mit ihrer Hilfe kann ich sicherstellen, dass alles so funktioniert, wie ich es mir vorgestellt habe.
- /docs: Hier bewahre ich alle Dokumentationsdateien und zugehörige Ressourcen auf. Dieser Ordner ist besonders hilfreich für jeden, der tiefer in mein Projekt eintauchen möchte.
- .gitignore: Ich verwende diese Datei, um sicherzustellen, dass bestimmte Dateien oder Verzeichnisse nicht zu meinem GitHub-Repository hinzugefügt werden, beispielsweise temporäre Dateien oder vertrauliche Konfigurationsdateien.
- README.md: In dieser Datei gebe ich einen Überblick über mein Projekt, erkläre die Einrichtung, die Anforderungen und gebe andere wichtige Informationen weiter, die für Entwickler oder Benutzer nützlich sein könnten.

Dank dieser Struktur fällt es mir leicht, den Überblick zu behalten, und ich glaube, dass sie auch anderen Entwicklern helfen wird, sich in meinem Projekt zurechtzufinden.

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
- 21.10.23
  https://blog.back4app.com/de/top-10-backend-sprachen-die-sie-kennen-sollten/
- 

