# Programmieren mit Audio
Szenario der Projektgruppe WS23/24 (Programmiererlebnisse) an der Hochschule Emden / Leer

### Stakeholder: 
- Prof. Carsten Link
- Frederik Gosewehr, M.Eng.
### Entwicklerteam:
- Jan Willms


## Webanwendung zum interaktiven Erlernen von Programmiergrundlagen mithilfe eines Audiointerface
![](<./Programmieren_Mit_Audio/Source-Code/images/Programmieren_Mit_Audio_Webanwendung.png>)
Das Szenarienpaket Programmieren mit Audio ist im Rahmen der Projektgruppe WS23/24 bei Prof. Link entstanden.
Es soll Schülern erste Programmiergrundlagen beibringen, dabei aber nicht auf Konsolenausgaben setzen sondern auch auf die Ausgabe von Tönen oder Musik per ABC-Notation.

### Installation und Inbetriebnahme der Webanwendung
Zur Installation des Szenarienpakets müssen folgende Schritte abgearbeitet werden:
* Rufen Sie die Gitlab Seite der Projektgruppe auf (https://gitlab.technik-emden.de/da6338/projektgruppe-23-link).
* Wählen Sie den Branch "musik-sounds" aus.
* Drücken Sie auf den blauen Button "Code" und wählen unter "Download source code" das gewünschte Kompressionsformat aus. Es sollte der Download des source codes beginnen.
* Nach dem Download entpacken Sie die Datei an einen gewünschten Zielort.
* Öffnen Sie den Ordner "projektgruppe-23-link-musik-sounds" und folgen Sie dem Pfad "projektgruppe-23-link-musik-sounds" \(\rightarrow\) "Programmieren mit Audio" \(\rightarrow\) "Source-Code". Sie sollten jetzt in einem Verzeichnis sein, das unter anderem eine HTML-Datei namens "code-editor" sowie ein Verzeichnis namens "levels" enthalten sollte.
* Öffnen Sie in diesem Ordner ein Terminal. Gegebenenfalls können Sie nicht direkt im Ordner ein Terminal öffnen, Sie sollten dann ein allgemeines Terminal Fenster öffnen und in den Ordner namens "Source-Code" navigieren.
* Sind Sie im Ordner angekommen, geben Sie "python -m http.server 8080" ein um den Server des Webeditors auf Port 8080 zu öffnen.
* Öffnen Sie jetzt einen beliebigen Browser und geben Sie in die Adressleiste http://localhost:8080/code-editor.html
* Es sollte sich der Webeditor des Projekts öffnen. Ab jetzt können die Aufgaben bearbeitet werden.

### Dokumentation und Anleitungen
Die Dokumentation des Szenarienpakets sowie die Anleitungen für Lehrer und Schüler, die unter anderem die Aufgaben und Musterlösungen enthalten, finden Sie im Ordner "documentation".

### Lizenz
Dieses Projekt ist unter der GNU General Public License lizensiert. Bitte lesen Sie die LICENSE.md für weitere Details.

### Externe Bibliotheken
Die folgenden externen Bibliotheken werden in diesem Projekt verwendet. Die jeweiligen Lizenzen finden Sie in den hinterlegten Lizenz-Dateien:

- [Brython](<./Programmieren_mit_Audio/Source-Code/lib/brython_LICENSE>)
- [CodeMirror](<./Programmieren_mit_Audio/Source-Code/lib/codemirror_LICENSE>)
- [D3.js](<./Programmieren_mit_Audio/Source-Code/lib/de_LICENSE>)
- [qrcode.js](<./Programmieren_mit_Audio/Source-Code/lib/qrcode_LICENSE>)
- [musical.js](<./Programmieren_mit_Audio/Source-Code/lib/musical.js-master/LICENSE>)
