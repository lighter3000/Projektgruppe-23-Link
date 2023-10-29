# Handout für Lehrende: App-Programmierung mit einem Vokabeltrainer

## Workshop-Ziele:

- Die Schülerinnen und Schüler sollen grundlegende Kenntnisse in der App-Entwicklung erwerben.
- Sie sollen lernen, wie man die Benutzeroberfläche des MIT App Inventor verwendet.
- Ziel ist die Erstellung eines einfachen Vokabeltrainers.

## Agenda:

- Schritt 1: Einführung (10 Minuten).
- Schritt 2: Anmeldung und Benutzeroberfläche (10 Minuten).
- Schritt 3: Vokabel hinzufügen (20 Minuten).
- Schritt 4: Vokabeln anzeigen und bearbeiten (30 Minuten).
- Schritt 5: Fortschrittsverfolgung und Belohnungen (20 Minuten).
- Schritt 6: Abschluss (10 Minuten).

## Schritt 1: Einführung (10 Minuten)

- Begrüßen Sie die Schülerinnen und Schüler herzlich.
- Erklären Sie das Ziel des Workshops: Die Erstellung eines Vokabeltrainers mit dem MIT App Inventor.
- Betonen Sie den Spaß und die Lernmöglichkeiten in der App-Programmierung.

## Schritt 2: Anmeldung und Benutzeroberfläche (10 Minuten)

- Leiten Sie die Schülerinnen und Schüler an, die MIT App Inventor-Website ([https://appinventor.mit.edu](https://appinventor.mit.edu/)) zu besuchen.
- Ermutigen Sie sie, ein neues Projekt mit dem Namen "Vokabeltrainer" zu erstellen.

## Schritt 3: Vokabel hinzufügen (20 Minuten)

#### Aufgabe 1: App erstellen

- Führen Sie die Schülerinnen und Schüler durch den Prozess, einen neuen Projekt mit dem Namen "Vokabeltrainer" im "Designer" zu erstellen.

#### Aufgabe 2: Komponenten hinzufügen

- Erklären Sie, wie man eine "Listview"-Komponente hinzufügt, die zur Anzeige der gespeicherten Vokabeln dient.

#### Aufgabe 3: Programmieren (Musterlösung)

- Zeigen Sie den Schülerinnen und Schülern die folgende Musterlösung für das Programmieren des "Hinzufügen"-Buttons:

```
when Hinzufügen.Click
    set Vokabel to Textbox_Vokabel.Text
    set Übersetzung to Textbox_Übersetzung.Text
    if Vokabel ≠ "" and Übersetzung ≠ ""
        add item to Vokabelliste
        set item to Vokabel & ": " & Übersetzung
        Textbox_Vokabel.Text = ""
        Textbox_Übersetzung.Text = ""
        update Listview1
```

## Schritt 4: Vokabeln anzeigen und bearbeiten (30 Minuten)

#### Aufgabe 1: Komponenten hinzufügen

- Zeigen Sie den Schülerinnen und Schülern, wie sie eine "Listview"-Komponente hinzufügen, um die gespeicherten Vokabeln anzuzeigen.

#### Aufgabe 2: Programmieren - Vokabeln anzeigen (Musterlösung)

- Erklären Sie, wie die Schülerinnen und Schülern die folgende Musterlösung verwenden können, um die Vokabeln aus der Liste in der "Listview" anzuzeigen:

```
when Screen1.Initialize
    for each item in Vokabelliste
        add item to Listview1
```

#### Aufgabe 3: Programmieren - Vokabeln bearbeiten (Hilfestellung)

- Ermutigen Sie die Schülerinnen und Schülern, die Vokabeln in der "Listview" zu bearbeiten. Geben Sie Hinweise, wie sie dies tun können.

```
when Listview1.ItemClick
set Ausgewählte_Vokabel to Listview1.Selection
// Hier sollte die ausgewählte Vokabel in einer separaten Variable gespeichert werden.

    // Ein Popup-Fenster oder eine separate Ansicht sollte erscheinen, um die Vokabel zu bearbeiten.
    // Zeigen Sie den Schülern, wie sie ein Popup-Fenster erstellen können, das die Vokabel bearbeiten lässt.

    // Nachdem die Vokabel bearbeitet wurde, sollte die Liste aktualisiert werden:
    remove item from Vokabelliste (Ausgewählte_Vokabel)
    // Fügt die bearbeitete Vokabel wieder in die Vokabelliste ein.
    update Listview1
```

## Schritt 5: Fortschrittsverfolgung und Belohnungen (20 Minuten)

#### Aufgabe 1: Punktesystem hinzufügen (Musterlösung)

- Zeigen Sie den Schülerinnen und Schülern die folgende Musterlösung in Blockly-Code für das Hinzufügen eines Punktesystems:

```
when Screen1.Initialize
    set Punkte to 0
    set Punktestand.Text to "Punktestand: " & Punkte

when Richtige_Antwort.Click
    set Punkte to Punkte + 10
    update Punktestand
    // Weitere Aktionen für die richtige Antwort

when Falsche_Antwort.Click
    if Punkte >= 5
        set Punkte to Punkte - 5
    else
        set Punkte to 0
    end if
    update Punktestand
    // Weitere Aktionen für die falsche Antwort
```

## Schritt 6: Abschluss (10 Minuten)

- Ermutigen Sie die Schülerinnen und Schüler, ihre Apps zu präsentieren und ihre Erfahrungen zu teilen.
- Motivieren Sie sie zur weiteren Entwicklung ihrer Apps und zum Lernen von App-Programmierung.

