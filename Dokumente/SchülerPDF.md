# Farbzauber und Funktionen -
### eine experimentelle Einführung in die Programmierung

## 1	&nbsp;	Lernziele
In dieser Übung sollst du mittels einfacher, kleiner Schritte ein Einblick in die Programmierung, vor allem in den Aufruf und die Verwendung von Methoden, bekommen.
Dabei solltest du aktiv mit kleinen Programmen experimentieren.
Durch Ausprobieren und mithilfe deiner Kommilitonen[^1] und des Dozenten[^2] sollte am Ende ein kleines Bild dabei rauskommen.
Mit der Bearbeitung der Aufgaben sollen folgenden Fähigkeiten erlangt werden:
-   Verständnis für den Begriff 'Methoden' im Kontext der Programmierung sind und wie diese verwendet werden
-   Erzeugung, Berechnung und Darstellung von Farben auf dem Bildschirm
-   Programmierung von einfachen Berechnungen auf Zahlen und diese in einer Schleife automatisch ausführen
-   Eine Einleitung in weitere grundlegende Konzepte der Programmierung und ggf. Verwendung und Vertiefung dieser.

Dabei dieses Ziel zu erreichen kann helfen:
- Immer langsam, je mehr man versteht, umso weniger muss auswendig gelernt werden
- Darüber reden, laut am besten mal mit dem Sitznachbar
- Notizen machen am besten mit einem Stift, nicht nur die Übungen ansehen
- Viel trinken, denn das Gehirn braucht Wasser. (Aber bitte nicht hier am Platz)

Hilft auch im normalen Unterricht und bei den Hausaufgaben

## 2	&nbsp;	Vorbereitung

Auf dem Desktop befindet sich ein Ordner namens Programmiererlebnisse, zunächst klickst du einmal mit der rechten Maustaste darauf und
wählst *Neues Terminal beim Ordner* aus

![Neues Terminal Mac](TerminalMac.png)

//todo bessere Bild
![Terminal](Terminal.png)

Danach öffne den Ordner und dort sollte ein Programm namens *ASCII.jar*, die aussieht wie eine heiße Tasse Kaffee, zu finden sein.

![Swing Programm im Finder](SwingImFinder.png)

Wenn du diese öffnest, erscheint unsere Leinwand. Sollte dem nicht der Fall sein und du bekommst stattdessen eine Fehlermeldung,
dann starte das Programm übers Terminal mit dem Kommando `java -jar ASCII.jar`

![Option B jar zu öffnen](TerminalSwing.png)

![Unsere Swing Leinwand](SwingLeinwand.png)

und zum Schluss öffnet man noch die *Shapes_Main.cpp* im 
//todo editor

und nun kann man im Terminal folgendes eingeben:

`clang Shapes-Main.cpp -o a`

womit im selben Ordner wie die *Shapes_Main.cpp* eine Datei mit dem Namen *a.out* erscheinen sollte.

welche sich mit dem "Choose" Button unserer Leinwand öffnen lässt und uns unser erstes Bild zeichnet.

## 3	&nbsp;	Variablen

## 4	&nbsp;	Farben auf dem Bildschirm

## 5	&nbsp;	Funktionen

## 6	&nbsp;	Schleifen

Du kannst auch einmal versuchen den Kreis oder die Linie mehrmals aufzurufen,
wobei du vor allem darauf achten musst jeden neuen Kreis einen eigenen Namen zu geben zum Beispiel:

```
    //Kreis   
    Circle* gruen = new Circle(400,250,50,0,255,0,5);
    gruen->draw();
    Circle* gruen2 = new Circle(400,350,50,0,255,0,5);
    gruen2->fill();
    Circle* gruen3 = new Circle(400,450,50,0,255,0,5);
    gruen3->draw();
```
Erkennst du vielleicht schon das Problem? Was ist, wenn du 10 Kreise oder vielleicht sogar 100 neue Kreise zeichnen wolltest?

Für solche Fälle gibt es ein Konzept in der Programmierung namens Schleifen, es gibt vor allem Drei Varianten:

Die while-Schleife, welche stets erst eine gegebene Bedingung überprüft bevor sie ausführt:
```
while(Bedingung = wahr){
    mach etwas
}
```
Die Do-While-Schleife, welche im Gegensatz erst einmal ausführt bevor sie die gegebene Bedingung ausgeführt wird:
```
do{
    mach etwas
}while(Bedingung = wahr)
```
Und die for-Schleife welche auch die zählende Schleife genannt wird, da sie oft genutzt wird um eine Aktion eine bestimmte Anzahl von Malen auszuführen.
```
for(Startwert;Bedingung;Schrittweite){
    mach etwas
}
```
Für unsere Zwecke eignet sich vor allem die for-Schleife, weil mit dieser lässt sich der Code von oben so vereinfachen
```
for(int i = 250; i <= 450; i = i + 100){
    Circle* gruen = new Circle(400,i,50,0,255,0,5);
    gruen->draw();
    delete gruen;
}
```
Außerdem müssen wir nun auch darauf achten unser erzeugtes Objekt auch wieder zu löschen damit wir es noch einmal neu an anderer Stelle nue zu zeichnen.

## 7	&nbsp;	If-Abfragen

Aber vielleicht fällt dir ein Unterschied zwischen der vorherigen Ausgabe und jetzt auf, der mittlere Kreis ist nicht mehr ausgefüllt!
Da müssen wir wohl eine bedingte Ausnahme festlegen. Hier kommen nun sogenannte "if-Abfragen" ins Spiel.

```
if(Bedingung == wahr){
    mach etwas
}else{
    mach etwas Anderes
}
```
Man kann auch mehrere verschiedene Abfragen aufeinander stapeln welche jeweils nur ausgeführt werden, wenn die vorherigen Abfragen unerfüllt blieben.

```
if(Bedingung == wahr){
    mach etwas
}else if( Andere Bedingung == wahr){
    mach etwas Anderes
}else{
    mach etwas ganz Anderes
```
Dies erlaubt uns verschiedene Aktionen basierend auf einer Bedingung auszuführen zum Beispiel unseren mittleren Kreis zu füllen.

```
for(int i = 250; i <= 450; i = i + 100){
    Circle* gruen = new Circle(400,i,50,0,255,0,5);
    if( i == 350){
        gruen->fill();
    }else {
        gruen->draw();
    }
    delete gruen;
}
```


## 8	&nbsp;	Getting Started

Wenn man nun in der *Shapes_Main.cpp* im Editor nach unten scrollt bis `int main(){` findet man folgende Aufrufe und Methoden:

```
    //Rechteck
    Rectangle* blau = new Rectangle(100,200,50,50,0,0,255,10);
    blau->fill();
    
    //Dreick
    Triangle* weiss = new Triangle(750,250,500,150,600,250,255,255,255,10);
    weiss->draw();
      
    //Text
    StringText* stringText = new StringText(250, 0, "Hallo Welt", "Comic Sans", 24, 1,100,0,255);
    stringText->draw();

    //Linie
    Line* rot = new Line(250, 250, 250, 150, 255, 0, 0, 5);
    rot->draw();
    
    //Kreis   
    Circle* gruen = new Circle(400,250,50,0,255,0,2);
    gruen->draw();
    
    //Pixel
    setPixel(325,250,0,0,0);
```

<p>"//" Zeigt einen Kommentar an, dieser wird von einem Programm nicht beachtet, sondern dient lediglich nur dir als Programmierer</p>
<p>"Rectangle* blau = new Rectangle" ruft einen sogenannten Konstruktor auf welcher für uns ein neues Rechteck mit dem Namen "blau" erstellt.</p>
Der interessante Teil hierbei sind die Zahlen die wir als sogenannte "Parameter" dabei übergeben.
Wenn man diese Verändert, verändert sich das Rechteck. 
Probier es einfach mal aus und verändere einige der Parameter und schaue was passiert aber Achtung, einige der Werte können nicht höher als 255 gesetzt werden, welche das sind und warum klären wir später.

`blau->fill();` zeichnet dann tatsächlich das Rechteck bzw. `blau->draw();` würde dann nur den Umriss zeichnen wie du gut an dem Dreieck oder Kreis sehen kannst

Speichere die Änderungen, keine Sorge du kannst alle Änderungen mit dem Tastenkürzel "⌘ + Z"[^4] jederzeit rückgängig machen so lange du den Editor nicht schließt.
Übersetze noch einmal mit dem Terminal mit `clang Shapes-Main.cpp -o a` und dann lass dir mit dem "Choose" Button auf der Leinwand die Änderungen zeichnen.
Sollten dir dabei Fehlermeldungen anzeigen dann frag doch einmal den Dozenten.

## 9	&nbsp;	Konventionen

Zum Schluss solltest du noch ein paar Konventionen[^5] und sogenannte "good practices" also gute Gewohnheiten beim Programmieren mitnehmen von denen du auch so einige
hier schon gesehen hast

Variablennamen sollten eindeutig sein und werden meist kleingeschrieben, wobei es mehrere Möglichkeiten gibt, hier nur mal zwei.</br>
-> erhöht die Lesbarkeit und hilft beim Verständnis
```
pixelPositionY = 125;
```
oder
```
pixel_position_y = 125;
```

Code zwischen {} sollte mit der *tab* Taste stets (weiter) eingerückt werden </br>
Zudem werden geschweifte Klammern "{" bzw. "}" direkt hinter die Funktion geschrieben bzw. in dieselbe Reihe beim Schließen </br>
-> erhöht die Lesbarkeit deutlich
```
if(x == true){
    if(y == true){
        do;
    }
}    
```
Vergesse nicht Kommentare zu schreiben und achte darauf die Umlaute wie ä ö ü vermieden werden sollten </br>
-> Hilft deutlich beim Verständnis und Umlaute werden nicht von allen Texteditoren oder Entwicklungsumgebungen unterstützt 
```
//Hier koennte ihr Kommentar stehen
```
Somit solltest du eigentlich gewappnet[^6] sein das, wahrscheinlich von dem Dozenten vorgegeben Bild, gut zu zeichnen oder
deiner kreativität freien lauf zu lassen.

Viel Glück und Erfolg!

## 10	&nbsp;	Glossar

[^1]: Jemand mit dir zur selben Zeit zur selben Schule geht.
[^2]: Lehrer an einer Hochschule.
[^3]: Datei Explorer nur für Mac.
[^4]: ⌘ wird uch CMD oder Commmand Taste genannt.
[^5]: Regeln oder Vereinbarungen für das (soziale) Verhalten.
[^6]: Gut ausgerüstet/ausgestattet, um schwierige Situationen zu überstehen
