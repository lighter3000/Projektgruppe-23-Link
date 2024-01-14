# Dokumentation: CodeClash

## Die Einleitung

Dieses Projekt hat das Ziel, ein Programm zu entwickeln, welches Schülern an einem eventuellen tag der offenen Tür, die Informatik näher zu bringen.
Das Ergebnis des Projekts ist ein 2D-Spiel auf Drag&Drop basis in der Godot Engine, bei dem die Schüler lernen wie bestimmte Elemente funktionieren, die in nahezu allen Programmiersprachen vorkommen.

In der folgenden Arbeit werden die Anforderungen der Anwendung sowie die Entwicklungsumgebung genauer erläutert. Im Anschluss wird die Grafische Oberfläche der Anwendung und der grobe Ablauf eines levels beschrieben.
Zum Abschluss folgt ein direktes Beispiel anhand des ersten levels, in dem nocheinmal ein konkretes Beispiel zur veranschaulichung des Spielablaufs erläutert wird.

## Die Anforderungen an das Projekt

- Die Schüler sollen mithilfe dieses Spiels die grundlegenden Funktionen der Programmierung kennenlernen. 
- Dabei soll das Spiel ermöglichen, dass Spieler ohne programmiererische Vorkenntnisse Programme entwerfen können.
- Der Spieler muss sich dabei keine Gedanken um die Programmiersprache, IDE oder die zugrunde liegende Syntax machen. 
- Der Spieler lernt die Benutzung von Bedingungen und Schleifen zur Lösung gestellter Aufgaben.

## Die Entwicklungsumgebung

Das Projekt wurde in der kostenlosen open-source game engine Godot entwickelt.
Bei Godot handelt es sich um eine script-based game engine in der man 2D und 3D Szenen erstellen und mit Kontent füllen kann.
Anhand einer Baumstruktur werden vorgefertigte Elemente in eine Szene gelegt. Diese Elemente können nun mit der Engine eigenen Scriptsprache GDScript implementiert werden, um z.B. einem vorgefertigten Button eine funktion zuzuweisen.

## Grafische Oberfläche

### Hauptmenü GUI

- Play-Button: Dieser Button öffnet die Levelauswahl, in der man zwischen den verschiedenen Leveln wählen kann, um diese zu spielen.

![Play_button](assets/icons/play_button/play_button.png)

- Options-Button: Mit diesem Button lässt sich das Options Menü öffnen, wo sich Fullscreen und Vsync aktivieren oder deaktivieren lassen.

![Options_button](assets/icons/options_button/options_button.png)

- Exit-Button: Wenn man das Spiel verlassen möchte, kann man diesen Button drücken.

![Exit_button](assets/icons/exit_button/exit_button.png)

### Level GUI

- Leiste mit Blöcken am unteren Bildschirmrand: Diese Blöcke müssen platziert und teilweise kombiniert werden, um ein Programm zu erstellen und die Aufgabe zu bewältigen.

- Blöcke: Diese Blöcke können per Drag'n'Drop auf der "Platine" platziert werden. Sie beinhalten immer eine Funktion einer spezifischen Programmstruktur.

- Viereckige Slots auf der "Platine": Hier werden die Blöcke platziert. Die Linien zwischen den Slots dienen danach als Verknüpfung der unterschiedlichen Blöcke.

- DELETE-Button: Mit diesem Button kann der aktuelle Levelfortschritt zurückgesetzt und es kann von vorne begonnen werden, wenn man einen Fehler gemacht hat.

![Delete_button](assets/icons/delete_button/delete_button.png)

- START-Button: Sind alle Blöcke platziert, die man platzieren wollte, kann dieser Button gedrückt werden, um das Programm zu starten. Nun wird geprüft, ob das Programm funktionsfähig ist und die Aufgabe somit erfolgreich bearbeitet wurde.

![Start_button](assets/icons/start_button/start_button.png)

- HELP-Button: Mit diesem Button lässt sich ein Pop-Up öffnen, das Hilfestellungen zur jeweiligen Aufgabe bietet.

![Help_button](assets/icons/help_button/help_button.png)

- BACK-Button: Mit diesem Button kommt man zurück zur vorherigen Ansicht (Menüs).

![Back_button](assets/icons/back_button/back_button.png)

### Blöcke

- START-Block: Dieser Block ist statisch und symbolisiert den Programmstart.

<img src="game_objects/assets/start_block.png" height="256" />

- ZIEL-Block: Dieser Block ist ebenfalls statisch und symbolisiert das Ende des Programms.

<img src="game_objects/assets/finish_block.png" height="256" />

- WHILE-Block: Dieser Block erhöht eine Variable (hier: x) so lange, bis der im Block angegebene Wert erreicht wurde und leitet das Signal dann zum nächsten Block weiter.

<img src="game_objects/assets/while_block.png" height="256" />

- IF-Block: Dieser Block prüft, ob eine Variable (hier: x) einen gegebenen Wert hat oder nicht, je nachdem wird entweder der rote (false) oder der grüne (true) Ausgang verwendet. 

<img src="game_objects/assets/if_block.png" height="256" />

- END-Block: Dieser Block wird symbolisch für den nicht verwendeten Ausgang eines IF-Blocks verwendet (hier meist "false").

<img src="game_objects/assets/end_block.png" height="256" />

## Beispiel
Das Spielfeld besitzt einen unbeweglichen Start- und Zielblock, sowie Felder auf denen Blöcke platziert werden können.
Der Startblock symbolisiert den Beginn des Programms und der Zielblock das Ende des Programms.
Die Felder werden als Platinen dargestellt und die Verbindung der Felder sind als Leiterbahnen dargestellt.
Der Spieler zieht per Drag and Drop die gewünschten Blöcke aus der unteren Leiste auf eines der Felder.
Um zu prüfen, ob das Programm die gestellten Anforderungen erfüllt drückt der Spieler auf den Start-Knopf in der oberen Leiste. Sollte die Lösung des Spielers falsch sein oder der Spieler unzufrieden mit seiner Auswahl sein kann der Delete-Button gedrückt werden um das Level zurückzusetzen.

<img src="documents/loesungen/loesung_level1.PNG" height="512" />

## Installation für Mac-Geräte

1. Virtualbox Version 7.0.12 installieren.
2. Ubuntu Version 23.04 VM in Virtualbox aufsetzen.
3. Linux-Export des Spiels in Ubuntu herunterladen.
4. In Ubuntu das Terminal im Zielordner öffnen.
5. Das Spiel mit dem Befehl: `chmod +x CodeClash.exe.sh` ausführbar machen.
6. Mit dem Befehl `./CodeClash.exe.sh` ausführen.



## Ausblick

Die grundlegenden Anforderungen, welche and das Projekt gestellt wurden, sind realisiert. Das Projektergebnis hat jedoch noch viel Potenzial.
Wie der Leser sicher schon bemerkt hat gibt es derzeit nur 3 grundlegende Level, welche um weitere Level erweitert werden können.
Ebenso gibt es derzeit nur simple while-schleifen und if-abfragen in den Aufgaben. Neue Blöcke wie z.B. Addition oder Subtraktion würden dem Spiel viele neue Levelmöglichkeiten geben.
Ebenso kann dynamisches Feedback in den Leveln und ein ausführliches Tutorial dem Spieler eine neue Stufe an Immersion geben.
Diese Ideen und weitere könnte der nächste Student, welcher an dem Projekt arbeitet, umsetzen und erweitern.
