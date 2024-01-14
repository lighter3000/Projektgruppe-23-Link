# Inhaltsverzeichnis
- Installation für Mac Geräte
- Lernziele
- Benutzeroberfläche
- Blöcke
- Aufgabenbeschreibung
- Lösungen

## Installation für Mac-Geräte
1. Virtualbox Version 7.0.12 installieren.
2. Ubuntu Version 23.04 VM in Virtualbox aufsetzen.
3. Linux-Export des Spiels in Ubuntu herunterladen.
4. In Ubuntu das Terminal im Zielordner öffnen.
5. Das Spiel mit dem Befehl: `chmod +x CodeClash.exe.sh` ausführbar machen.
6. Mit dem Befehl `./CodeClash.exe.sh` ausführen.

## Lernziele

Die Schüler sollen mithilfe dieses Spiels die grundlegenden Funktionen der Programmierung kennenlernen. 

Dabei soll das Spiel ermöglichen, dass Spieler ohne programmiererische Vorkenntnisse Programme entwerfen können.

Der Spieler muss sich dabei keine Gedanken um die Programmiersprache, IDE oder die zugrunde liegende Syntax machen. 

Der Spieler lernt die Benutzung von Bedingungen und Schleifen zur Lösung gestellter Aufgaben.

## Benutzeroberfläche:

- Leiste mit Blöcken am unteren Bildschirmrand: Diese Blöcke müssen platziert und teilweise kombiniert werden, um ein Programm zu erstellen und die Aufgabe zu bewältigen.

- Blöcke: Diese Blöcke können per Drag'n'Drop auf der "Platine" platziert werden. Sie beinhalten immer eine Funktion einer spezifischen Programmstruktur.

- Viereckige Slots auf der "Platine": Hier werden die Blöcke platziert. Die Linien zwischen den Slots dienen danach als Verknüpfung der unterschiedlichen Blöcke.

- DELETE-Button: Mit diesem Button kann der aktuelle Levelfortschritt zurückgesetzt und es kann von vorne begonnen werden, wenn man einen Fehler gemacht hat.

- START-Button: Sind alle Blöcke platziert, die man platzieren wollte, kann dieser Button gedrückt werden, um das Programm zu starten. Nun wird geprüft, ob das Programm funktionsfähig ist und die Aufgabe somit erfolgreich bearbeitet wurde.

- HELP-Button: Mit diesem Button lässt sich ein Pop-Up öffnen, das Hilfestellungen zur jeweiligen Aufgabe bietet.

- BACK-Button: Mit diesem Button kommt man zurück zur vorherigen Ansicht (Menüs).

## Blöcke:

- START-Block: Dieser Block ist statisch und symbolisiert den Programmstart.

- ZIEL-Block: Dieser Block ist ebenfalls statisch und symbolisiert das Ende des Programms.

- WHILE-Block: Dieser Block erhöht eine Variable (hier: x) so lange, bis der im Block angegebene Wert erreicht wurde und leitet das Signal dann zum nächsten Block weiter.

- IF-Block: Dieser Block prüft, ob eine Variable (hier: x) einen gegebenen Wert hat oder nicht, je nachdem wird entweder der rote (false) oder der grüne (true) Ausgang verwendet. 

- END-Block: Dieser Block wird symbolisch für den nicht verwendeten Ausgang eines IF-Blocks verwendet (hier meist "false").

## Aufgabenbeschreibung

Das Spielfeld besitzt einen unbeweglichen Start- und Zielblock, sowie Felder auf denen Blöcke platziert werden können. 

Der Startblock symbolisiert den Beginn des Programms und der Zielblock das Ende des Programms.

Die Felder werden als Platinen dargestellt und die Verbindung der Felder sind als Leiterbahnen dargestellt.

Der Spieler zieht per Drag and Drop die gewünschten Blöcke aus der unteren Leiste auf eines der Felder. 

Um zu prüfen, ob das Programm die gestellten Anforderungen erfüllt drückt der Spieler auf den Start-Knopf in der oberen Leiste. Sollte die Lösung des Spielers falsch sein oder der Spieler unzufrieden mit seiner Auswahl sein kann der Delete-Button gedrückt werden um das Level zurückzusetzen.


## Lösungen
Ist ein Level korrekt gelöst wird dies dem Spieler in der oberen Leiste angezeigt. In der Level-Übersicht verändert sich die Farbe des Level-Buttons, sollte das Level einmal korrekt gelöst worden sein. 

Ungelöstes Level:   
![Level-Button ungeloest](assets/icons/level1_button/lvl_1_button.png)

Gelöstes Level:     
![Level-Button geloest](assets/icons/level1_button/lvl_1_completed_button.png)

### Level 1: 
![Loesung 1](documents/loesungen/loesung_level1.PNG)
### Level 2: 
![Loesung 2](documents/loesungen/loesung_level2.PNG)
### Level 3: 
![Loesung 3](documents/loesungen/loesung_level3.PNG)
