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
- Ermutigen Sie sie, ein neues Projekt mit dem Namen "Vokabeltrainer + eigener Name" zu erstellen.
- Erläutern Sie die grundlegenden Funktionen (Design/Blöcke) der Oberfläche

## Schritt 3: Vokabel hinzufügen (20 Minuten)

#### Aufgabe 1: Oberfläche (Design) - Vokabel hinzufügen

- Helfen Sie den Schülern dabei darüber nachzudenken welche Komponenten benötigt werden um Vokabeln hinzufügen zu können.
- Gebe den Hinweis dass die Komponenten aussagekräftige Namen besitzen sollten und erkläre warum.

Komponenten:
- Zwei Textfelder zur Eingabe der Vokabelpaare
- Schaltfläche (Button) zum Hinzufügen

#### Aufgabe 3: Programmieren (Blockly) - Vokabel hinzufügen

- Hier ist eine Musterlösung

```
when Hinzufügen.Click
    set Vokabel to Textbox_Vokabel.Text
    set Übersetzung to Textbox_Übersetzung.Text
    if Vokabel ≠ "" and Übersetzung ≠ ""
        add item to Vokabelliste
        set item to Vokabel & ": " & Übersetzung
        Textbox_Vokabel.Text = ""
        Textbox_Übersetzung.Text = ""
```

## Schritt 4: Vokabeln anzeigen und bearbeiten (30 Minuten)

#### Aufgabe 1: Oberfläche (Design) - Vokabeln anzeigen

- Zeigen Sie den Schülerinnen und Schülern, wie sie eine "Listview"-Komponente hinzufügen, um die gespeicherten Vokabeln anzuzeigen.

#### Aufgabe 2: Programmieren (Blocks) - Vokabeln anzeigen

- Erklären Sie, wie die Schülerinnen und Schülern die folgende Musterlösung verwenden können, um die Vokabeln aus der Liste in der "Listview" anzuzeigen:

```
when Screen1.Initialize
    for each item in Vokabelliste
        add item to Listview1
```


Außerdem soll beim Drücken von "Hinzufügen" die Anzeige der Liste aktualisiert werden. Deshalb erweitern wir den "Hinzufügen" Code aus Schritt 3 mit folgendem Befehl:

- `update Listview1` - Dieser Block aktualisiert die "Listview", um die neuen Vokabeln anzuzeigen.

#### Aufgabe 3: Programmieren (Blocks) - Vokabeln bearbeiten

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