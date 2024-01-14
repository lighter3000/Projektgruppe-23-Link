# Dokumentation: CodeClash

## Die Einleitung

Dieses Projekt hat das Ziel, ein Programm zu entwickeln, welches Schülern an einem eventuellen tag der offenen Tür, die Informatik näher zu bringen.
Das Ergebnis des Projekts ist ein 2D-Spiel auf Drag&Drop basis in der Godot Engine, bei dem die Schüler lernen wie bestimmte Elemente funktionieren, die in nahezu allen Programmiersprachen vorkommen.

In der folgenden Arbeit werden die Anforderungen der Anwendung sowie die Entwicklungsumgebung genauer erläutert. Im Anschluss wird die Grafische Oberfläche der Anwendung und der grobe Ablauf eines levels beschrieben.
Zum Abschluss folgt ein direktes Beispiel anhand des ersten levels, in dem nocheinmal ein konkretes Beispiel zur veranschaulichung des Spielablaufs erläutert wird.



## Die Anforderungen an das Projekt



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

![Start_Block](game_objects/assets/start_block.png =250x)

- ZIEL-Block: Dieser Block ist ebenfalls statisch und symbolisiert das Ende des Programms.

![Ziel_Block](game_objects/assets/finish_block.png)

- WHILE-Block: Dieser Block erhöht eine Variable (hier: x) so lange, bis der im Block angegebene Wert erreicht wurde und leitet das Signal dann zum nächsten Block weiter.

![While_Block](game_objects/assets/while_block.png)

- IF-Block: Dieser Block prüft, ob eine Variable (hier: x) einen gegebenen Wert hat oder nicht, je nachdem wird entweder der rote (false) oder der grüne (true) Ausgang verwendet. 

![If_Block](game_objects/assets/if_block.png)

- END-Block: Dieser Block wird symbolisch für den nicht verwendeten Ausgang eines IF-Blocks verwendet (hier meist "false").

![End_Block](game_objects/assets/end_block.png)

## Beispiel

![Loesung_level_1](documents/loesungen/loesung_level1.PNG)

## Installation für Mac-Geräte

1. Virtualbox Version 7.0.12 installieren.
2. Ubuntu Version 23.04 VM in Virtualbox aufsetzen.
3. Linux-Export des Spiels in Ubuntu herunterladen.
4. In Ubuntu das Terminal im Zielordner öffnen.
5. Das Spiel mit dem Befehl: `chmod +x CodeClash.exe.sh` ausführbar machen.
6. Mit dem Befehl `./CodeClash.exe.sh` ausführen.



## Ausblick

