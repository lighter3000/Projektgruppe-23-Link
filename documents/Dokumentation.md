# Dokumentation: CodeClash

## Die Einleitung

Dieses Projekt hat das Ziel, ein Programm zu entwickeln, welches Schülern an einem eventuellen tag der offenen Tür, die Informatik näher zu bringen.
Das Ergebnis des Projekts ist ein 2D-Spiel auf Drag&Drop basis in der Godot Engine, bei dem die Schüler lernen wie bestimmte Elemente funktionieren, die in nahezu allen Programmiersprachen vorkommen.

In der folgenden Arbeit werden die Anforderungen der Anwendung sowie die Entwicklungsumgebung genauer erläutert. Im Anschluss wird die Grafische Oberfläche der Anwendung und der grobe Ablauf eines levels beschrieben.
Zum Abschluss folgt ein direktes Beispiel anhand des ersten levels, in dem nocheinmal ein konkretes Beispiel zur veranschaulichung des Spielablaufs erläutert wird.




## Die Anforderungen an das Projekt



## Die Entwicklungsumgebung



## Grafische Oberfläche

### GUI allgemein

- Leiste mit Blöcken am unteren Bildschirmrand: Diese Blöcke müssen platziert und teilweise kombiniert werden, um ein Programm zu erstellen und die Aufgabe zu bewältigen.

- Blöcke: Diese Blöcke können per Drag'n'Drop auf der "Platine" platziert werden. Sie beinhalten immer eine Funktion einer spezifischen Programmstruktur.

- Viereckige Slots auf der "Platine": Hier werden die Blöcke platziert. Die Linien zwischen den Slots dienen danach als Verknüpfung der unterschiedlichen Blöcke.

- DELETE-Button: Mit diesem Button kann der aktuelle Levelfortschritt zurückgesetzt und es kann von vorne begonnen werden, wenn man einen Fehler gemacht hat.

- START-Button: Sind alle Blöcke platziert, die man platzieren wollte, kann dieser Button gedrückt werden, um das Programm zu starten. Nun wird geprüft, ob das Programm funktionsfähig ist und die Aufgabe somit erfolgreich bearbeitet wurde.

- HELP-Button: Mit diesem Button lässt sich ein Pop-Up öffnen, das Hilfestellungen zur jeweiligen Aufgabe bietet.

- BACK-Button: Mit diesem Button kommt man zurück zur vorherigen Ansicht (Menüs).

### Blöcke

- START-Block: Dieser Block ist statisch und symbolisiert den Programmstart.

- ZIEL-Block: Dieser Block ist ebenfalls statisch und symbolisiert das Ende des Programms.

- WHILE-Block: Dieser Block erhöht eine Variable (hier: x) so lange, bis der im Block angegebene Wert erreicht wurde und leitet das Signal dann zum nächsten Block weiter.

- IF-Block: Dieser Block prüft, ob eine Variable (hier: x) einen gegebenen Wert hat oder nicht, je nachdem wird entweder der rote (false) oder der grüne (true) Ausgang verwendet. 

- END-Block: Dieser Block wird symbolisch für den nicht verwendeten Ausgang eines IF-Blocks verwendet (hier meist "false").



## Beispiel



## Installation

- Virtualbox Version 7.0.12 installieren.
- Ubuntu Version 23.04 VM in Virtualbox aufsetzen.
- Linux-Export des Spiels in Ubuntu herunterladen.
- In Ubuntu das Terminal im Zielordner öffnen.
- Das Spiel mit dem Befehl: chmod +x CodeClash.exe.sh ausführbar machen.
- Mit dem Befehl ./CodeClash.exe.sh ausführen.



## Ausblick

