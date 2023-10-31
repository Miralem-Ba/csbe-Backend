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
Bei der Erstellung dieses Projekts habe ich besonders auf die Strukturierung und Benennung der API-Endpunkte geachtet. Hier ist ein kurzer Überblick über die Endpunkte und die erwarteten Parameter:

## Auth Controller:
- Endpunkt: /api/auth/registration: für diesen Endpunkt erwarte ich die notwendigen Anmeldedaten eines Benutzers, einschließlich Benutzername, Passwort und andere relevante Details, um einen neuen Benutzer zu registrieren.
- Endpunkt: /api/auth/login: Über diesen Endpunkt können sich die Benutzer mit ihren Anmeldedaten, wie Benutzername und Passwort, anmelden.

## Kategorie-Controller:
- Endpunkt: /api/categories: Hier können Benutzer alle verfügbaren Kategorien abrufen oder eine neue Kategorie über eine POST-Anforderung erstellen, wobei ich entsprechende Kategoriedaten im Anforderungskörper erwarte.
- Endpunkt: /api/categories/{categoryId}: Dieser Endpunkt ermöglicht das Abrufen, Aktualisieren oder Löschen einer bestimmten Kategorie auf der Grundlage der übergebenen categoryId.

## Produkte Controller:
- Endpunkt: /api/products: Hier können Benutzer eine Liste aller Produkte abrufen oder ein neues Produkt hinzufügen. Wenn ich ein Produkt hinzufüge, erwarte ich die Produktdetails im Request Body.
- Endpunkt: /api/products/{productId}: Dieser Endpunkt ermöglicht es Benutzern, bestimmte Produkte anhand ihrer productId abzurufen, zu aktualisieren oder zu löschen.

## Benutzer-Controller:
- Endpunkt: /api/user: Dieser allgemeine Endpunkt ist für Benutzeraktionen gedacht. Er ermöglicht das Abrufen einer Liste aller Benutzer oder das Hinzufügen neuer Benutzer.
- Endpunkt: /api/user/{id} und andere mit Benutzer-ID: Diese Endpunkte können verwendet werden, um spezifische Benutzeraktionen auf der Grundlage der Benutzer-ID durchzuführen. Ich kann sie verwenden, um Benutzerdaten je nach der angeforderten Aktion abzurufen, zu aktualisieren oder zu löschen.

Mit dieser Struktur und Benennung der Endpunkte hoffe ich, dass die API-Interaktion sowohl für mich als auch für andere Entwickler, die mit diesem Projekt arbeiten oder es nutzen wollen, transparent und einfach ist.

# Endpoints
- /api/auth/registration	POST	Dieser Endpunkt wird verwendet, damit sich ein nicht registrierter Benutzer registrieren kann.
- /api/auth/login	POST	Dieser Endpunkt wird verwendet, damit sich ein registrierter Benutzer anmelden kann.
- /api/categories/{categoryId}	GET	Dieser Endpunkt wird verwendet, um eine bestimmte Kategorie anhand einer ID zu bekommen.
- /api/categories	GET	Dieser Endpunkt wird verwendet, um alle Kategorien zu bekommen.
- /api/categories	POST	Dieser Endpunkt wird verwendet, um eine neue Kategorie zu erstellen (nur Admin).
- /api/categories/{categoryId}	PUT	Dieser Endpunkt wird verwendet, um eine bestimmte Kategorie anhand einer ID zu aktualisieren (nur Admin).
- /api/categories/{categoryId}	DELETE	Dieser Endpunkt wird verwendet, um eine bestimmte Kategorie anhand einer ID zu löschen (nur Admin).
- /api/product/{productId}	GET	Dieser Endpunkt wird verwendet, um ein bestimmtes Produkt anhand einer ID zu bekommen.
- /api/product	GET	Dieser Endpunkt wird verwendet, um alle Produkte zu bekommen.
- /api/products	POST	Dieser Endpunkt wird verwendet, um ein neues Produkt zu erstellen.
- /api/product/{productId}	PUT	Dieser Endpunkt wird verwendet, um ein bestimmtes Produkt anhand einer ID zu aktualisieren (nur Admin).
- /api/product/{productId}	DELETE	Dieser Endpunkt wird verwendet, um ein bestimmtes Produkt anhand einer ID zu löschen (nur Admin).
- /api/user/{id}	GET	Dieser Endpunkt wird verwendet, um einen bestimmten Benutzer anhand einer ID zu bekommen.
- /api/user	GET	Dieser Endpunkt wird verwendet, um alle Benutzer zu bekommen.
- /api/user	POST	Dieser Endpunkt wird verwendet, um einen neuen Benutzer zu erstellen.
- /api/user/promote/{userId}	POST	Dieser Endpunkt wird verwendet, um einen bestimmten Benutzer zum Admin zu befördern (nur Admin).
- /api/user/{id}/admin	PUT	Dieser Endpunkt wird verwendet, um einen bestimmten Benutzer zum Admin zu aktualisieren (nur Admin).
- /api/user/{id}	DELETE	Dieser Endpunkt wird verwendet, um einen bestimmten Benutzer zu löschen (nur Admin).

# Namensschema-für-Daten

## Entitäten
- Category
- Product
- User

## DTO ( Data Transfer Object

In meinem Projekt nutze ich das Konzept der Data Transfer Objects (DTOs), um Daten zwischen verschiedenen Teilen der Anwendung zu übertragen, insbesondere bei Interaktionen zwischen dem Frontend und dem Backend. Durch die Verwendung von DTOs kann ich sicherstellen, dass nur die benötigten Daten übertragen werden, und eventuelle unnötige oder sensible Daten verborgen bleiben.

Hier ist eine Übersicht über die Haupt-DTOs, die ich in diesem Projekt verwendet habe:

- RegistrationDto: Dieses DTO nutze ich, um die notwendigen Informationen von Nutzern zu sammeln, die sich für meine Anwendung registrieren möchten. Es enthält Felder wie Benutzername, Passwort und E-Mail.
- LoginDto: Hiermit erfasse ich die Anmeldedaten eines Benutzers. Typischerweise sind dies Benutzername und Passwort.
- CategoryDTO: Mit diesem DTO kann ich Kategorieninformationen übertragen, beispielsweise für Produkte oder Dienstleistungen in meiner Anwendung.
- ProductDTO: Dieses DTO dient dazu, Produktinformationen zwischen verschiedenen Teilen der Anwendung zu übertragen. Es kann Details wie den Produktnamen, den Preis und die Beschreibung enthalten.
- UserAuthDTO: Nachdem ein Benutzer sich angemeldet hat, verwende ich dieses DTO, um Authentifizierungsinformationen und Token zu übertragen. So kann der Benutzer sicher auf geschützte Bereiche der Anwendung zugreifen.
- UserDto: Mit diesem DTO übertrage ich grundlegende Benutzerinformationen. Es enthält Felder wie Name, Vorname und Profilbild.
- Durch die klare Trennung und Definition dieser DTOs kann ich sicherstellen, dass meine Anwendung effizient und sicher funktioniert, wobei der Datenverkehr optimiert und das Risiko von Datenlecks minimiert wird.
   
# Arbeitsjournal
| Datum       | Arbeit                                                           | Zeit in Stunden |
|-------------|------------------------------------------------------------------|----------------:|
| Oct 3, 2023 | - Überarbeitung des Datenmodells.                                 |              2h |
|             | - Aufbau einer neuen Dokumentationsstruktur.                      |              1h |
| Oct 4, 2023 | - Einbindung von Redis für Session-Management.                    |              2h |
| Oct 5, 2023 | - Erweiterung der Benutzerschnittstelle für mobile Geräte.        |              2h |
|             | - Debugging von Cross-Origin-Problemen.                           |                 |
| Oct 9, 2023 | - Implementierung von Filtern für Produktsuche.                   |              3h |
| Oct 11, 2023| - Einführung von CI/CD-Pipelines.                                 |              2h |
|             | - Überarbeitung des Build-Prozesses.                              |              1h |
| Oct 12, 2023| - Überarbeitung des Fehlermanagements.                            |             1.5h|
|             | - Testen von Ausnahme-Szenarien.                                  |                 |
| Oct 15, 2023| - Performance-Optimierung der Anwendung.                          |             2.5h|
|             | - Überarbeitung der Benutzerrollen und -berechtigungen.           |              2h |
| Oct 17, 2023| - Integration von WebSockets für Echtzeitbenachrichtigungen.      |              2h |
| Oct 18, 2023| - Einbindung von Drittanbieter-APIs.                              |              3h |
| Oct 19, 2023| - Implementierung von Aspektorientiertem Programmieren.           |             1.5h|
|             | - Aktualisierung der API-Dokumentation.                           |                 |
| Oct 21, 2023| - Optimierung der Datenbankabfragen.                              |              2h |
|             | - Validierung von Eingabedaten für den UserController.            |              2h |
| Oct 24, 2023| - Unit-Tests für den CategoryService.                             |              2h |
|             | - Anwendung von Caching für häufig abgerufene Daten.              |             1.5h|
| Oct 25, 2023| - Fehlerbehandlung für den CategoryController.                    |              1h |
|             | - Überarbeitung der Produktbilder-Upload-Funktion.                |              2h |
| Oct 26, 2023| - Implementierung der Suche für Produkte.                         |              3h |
| Oct 29, 2023| - Hinzufügen von Paginierung zu den Produktendpunkten.            |              2h |
|             | - Überprüfung der Datenbankrelationen und -indizes.               |              1h |
| Oct 31, 2023| - Integrationstests für den UserService geschrieben.              |              3h |
|             | - Debugging von JWT-Authentifizierungsproblemen.                  |             1.5h|
|-------------|-------------------------------------------------------------------|---------------:|

# Quellen
- Unterricht vom Herrn Daniel Schmitz und Stefano Mavilio
- Daniel Schmitz und Stefano Mavilio
- Schulkameraden
- https://de.wikipedia.org/wiki/Frontend_und_Backend
- https://bsh-ag.de/it-wissensdatenbank/backend/
- https://de.ryte.com/wiki/Backend

