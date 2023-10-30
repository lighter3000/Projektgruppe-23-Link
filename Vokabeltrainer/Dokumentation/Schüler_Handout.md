# Schülerhandout: App-Programmierung mit einem Vokabeltrainer

## Workshop-Ziele:

- Grundlegende Einführung in die App-Entwicklung.
- Erlernen der Benutzeroberfläche des MIT App Inventor.
- Erstellung eines einfachen Vokabeltrainers.

## Agenda:

- Schritt 1: Einführung (10 Minuten).
- Schritt 2: Anmeldung und Benutzeroberfläche (10 Minuten).
- Schritt 3: Szenario 1 - Vokabel hinzufügen (20 Minuten).
- Schritt 4: Szenario 2 - Vokabeln anzeigen und bearbeiten (30 Minuten).
- Schritt 5: Fortschrittsverfolgung und Belohnungen (20 Minuten).
- Schritt 6: Abschluss (10 Minuten).

## Schritt 1: Einführung (10 Minuten)

- Heute lernt ihr, wie man eine eigene App erstellt, die als Vokabeltrainer dient.
- Ziel: Spaß beim Programmieren und Lernen!

## Schritt 2: Anmeldung und Benutzeroberfläche (10 Minuten)

- Besucht die MIT App Inventor-Website ([https://appinventor.mit.edu](https://appinventor.mit.edu/)).
- Erstellt ein neues Projekt und nennt es "Vokabeltrainer + Euer Name".

- Weitere Erklärungen zur Oberfläche (TODO)

## Schritt 3: Vokabel hinzufügen (20 Minuten)

#### Aufgabe 1: Oberfläche (Design) - Vokabel hinzufügen

Euer Vokabeltrainer soll in dieser Aufgabe folgende Dinge machen können:

- Vokabelpaare (Deutsch - Englisch) eingeben
- Vokabeln hinzufügen

- Überlegt euch welche Komponenten (Schaltflächen, Textfelder, etc.) aus der Design-Ansicht nötig sind und fügt sie eurer App hinzu.
- Es wird empfohlen den Komponenten aussagekräftige Namen zu geben wie z.B. "Schaltfläche_Hinzufügen"


#### Aufgabe 2: Programmieren (Blocks) - Vokabel hinzufügen

- Klickt auf "Blocks".
- Verwendet die folgenden Blockly-Blöcke, um den "Hinzufügen"-Button zu programmieren:
    - `when Hinzufügen.Click` - Dieser Block wird aktiviert, wenn der "Hinzufügen"-Button angeklickt wird.
    - `set Vokabel to Textbox_Vokabel.Text` - Dieser Block speichert den Text aus dem Texteingabefeld für die Vokabel in einer Variable namens "Vokabel".
    - `set Übersetzung to Textbox_Übersetzung.Text` - Dieser Block speichert den Text aus dem Texteingabefeld für die Übersetzung in einer Variable namens "Übersetzung".
    - `if Vokabel ≠ "" and Übersetzung ≠ ""` - Dieser Block prüft, ob sowohl das Vokabel- als auch das Übersetzungsfeld ausgefüllt sind.
    - `add item to Vokabelliste` - Dieser Block fügt einen Eintrag zur Liste "Vokabelliste" hinzu.
    - `set item to Vokabel & ": " & Übersetzung` - Dieser Block erstellt den Eintrag in der Liste im Format "Vokabel: Übersetzung".
    - `Textbox_Vokabel.Text = ""` und `Textbox_Übersetzung.Text = ""` - Diese Blöcke setzen die Texteingabefelder zurück.


## Schritt 4: Vokabeln anzeigen und bearbeiten (30 Minuten)


#### Aufgabe 1: Oberfläche (Design) - Vokabeln anzeigen
Um die Vokabeln anzuzeigen brauchen wir eine Liste (ListView).

- Fügt eine "Listview" hinzu, um die gespeicherten Vokabeln anzuzeigen.

#### Aufgabe 2: Programmieren (Blocks) - Vokabeln anzeigen

- Klickt auf "Blocks".
- Verwendet die folgenden Blockly-Blöcke, um die Vokabeln aus der Liste in der "Listview" anzuzeigen:
    - `when Screen1.Initialize` - Dieser Block wird beim Start der App aktiviert.
    - `for each item in Vokabelliste` - Dieser Block durchläuft alle Einträge in der Liste "Vokabelliste".
    - `add item to Listview1` - Dieser Block fügt die Einträge in die "Listview" hinzu.

Außerdem soll beim Drücken von "Hinzufügen" die Anzeige der Liste aktualisiert werden. Deshalb erweitern wir den "Hinzufügen" Code aus Schritt 3 mit folgendem Befehl:

- `update Listview1` - Dieser Block aktualisiert die "Listview", um die neuen Vokabeln anzuzeigen.

#### Aufgabe 3: Programmieren (Blocks) - Vokabeln bearbeiten

- In dieser Aufgabe könnt ihr die Vokabeln, die ihr bereits hinzugefügt habt, bearbeiten.

1. Klickt auf die Vokabel in der "Listview", die ihr bearbeiten möchtet.
2. Ein Popup-Fenster sollte erscheinen und euch auffordern, die Vokabel zu bearbeiten.
3. Gebt die gewünschten Änderungen ein und klickt auf "OK", um die Bearbeitung abzuschließen.


## Schritt 5: Fortschrittsverfolgung und Belohnungen (20 Minuten)

#### Aufgabe 1: Punktesystem hinzufügen

- In dieser Aufgabe werdet ihr ein einfaches Punktesystem hinzufügen, um euren Fortschritt im Vokabeltrainer zu verfolgen.

1. Fügt eine "Label" (Textanzeige) -Komponente hinzu und nennt sie "Punktestand".
2. Erstellt eine neue Variable namens "Punkte" und setzt sie auf 0.
3. Programmierungs-Hinweise:
    - Wenn eine Vokabel richtig beantwortet wird, erhöht den Punktestand um eine bestimmte Anzahl Punkte (z.B., 10 Punkte).
    - Wenn eine Vokabel falsch beantwortet wird, könnt ihr den Punktestand um eine bestimmte Anzahl Punkte verringern (z.B., 5 Punkte), aber achtet darauf, dass der Punktestand nicht unter 0 fällt.

## Schritt 6: Abschluss (10 Minuten)

- Präsentiert eure Apps und teilt eure Erfahrungen.

  