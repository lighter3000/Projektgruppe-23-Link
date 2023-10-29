

## App Inventor Dependencies

Folgende Programme werden benötigt um den App Inventor bauen zu können:

- Java Development Kit (JDK) 1.8
  - Überprüfen kann man das mit dem Befehl `$ javac -version`. Ausgabe sollte zum Beispiel `$ javac 1.8.0_1112` sein (die ersten beiden Ziffern müssen übereinstimmen)
- Apache Ant 1.10+ (http://ant.apache.org/)
  - Lässt sich mit dem Befehl `$ ant -version` überprüfen
- Python um den Code zu kompilieren und den Server zu laufen
- Google Cloud SDK für Java (https://cloud.google.com/appengine/docs/standard/java/download)



## Building App Inventor

Öffne das Terminal (z.B. cmd) und navigiere zu `\appinventor-sources-master\appinventor`. Führe folgenden Befehl aus:

-  `$ ant clean`

Wichtig: Alle vorhandenden Projekte werden gelöscht. Also vorher sicherstellen dass ein Backup von den Projekten gemacht wird falls man diese behalten will.



Falls der App Inventor zuvor noch nie gebaut wurde, so wird ein 'authkey' benötigt. Dieser musst einmalig erstellt werden in dem man folgenden Befehl ausführt:

- `$ ant MakeAuthKey`

Nun kann der App Inventor mit dem folgenden Befehl gebaut werden

- `$ ant`



