**Anleitung zum Erstellen der Vokabelliste-Vorlage für die Vokabeltrainer-App**


**Schritt 1: Vorbereitung**

1. Öffnen Sie MIT App Inventor und erstellen Sie ein neues Projekt.

**Schritt 2: Anlegen des zweidimensionalen Arrays**

1. Gehen Sie zum "Designer" und fügen Sie ein "Label" hinzu. Dieses Label dient dazu, die Vokabeln und Übersetzungen anzuzeigen, während die App läuft.
2. Wechseln Sie zum "Blocks" Bereich.
3. Fügen Sie einen neuen globalen Block hinzu, indem Sie auf "Variablen" klicken und "globalen Block hinzufügen" auswählen. Nennen Sie diesen Block "Vokabelliste".
4. Klicken Sie auf den globalen Block "Vokabelliste" und wählen Sie die Option "Variable initialisieren". Legen Sie den Wert als einen leeren Liste fest.

**Schritt 3: Hinzufügen der Vokabeln und Übersetzungen**

1. Gehen Sie zurück zum "Designer" und klicken Sie auf das Label, das Sie hinzugefügt haben.

2. Im Eigenschaftenbereich finden Sie die Eigenschaft "Text". Klicken Sie auf den Stift-Button, um den Text-Editor zu öffnen.

3. Fügen Sie die Vokabeln und Übersetzungen in einer speziellen Syntax hinzu, z.B., "Vokabel:Übersetzung", und trennen Sie jedes Paar mit einem Zeilenumbruch. Zum Beispiel:

   ```
   apple:Apfel
   banana:Banane
   cat:Katze
   ```

4. Kopieren Sie den gesamten Text aus dem Text-Editor.

**Schritt 4: Verarbeiten der Vokabelliste**

1. Wechseln Sie zurück zum "Blocks" Bereich.

2. Verwenden Sie einen Event-Block, z.B., "Screen.Initialize", um den initialen Text für das Label festzulegen.

3. Verwenden Sie einen "Text"-Block und setzen Sie den Text des Labels auf den zuvor kopierten Text mit den Vokabeln und Übersetzungen.

4. Verwenden Sie den Block "Text in Text" aus der Kategorie "Text" und setzen Sie ihn in einen "Schleifen"-Block, z.B., "foreach item in list".

5. Zerlegen Sie den Text in Vokabeln und Übersetzungen, indem Sie ihn beim Doppelpunkt trennen.

6. Fügen Sie die aufgeteilten Teile in die globale "Vokabelliste" ein, indem Sie den "Vor Liste einfügen"-Block verwenden. Das resultierende Format sollte wie folgt aussehen:

   ```
   [[Vokabel, Übersetzung], [Vokabel, Übersetzung], ...]
   ```

**Schritt 5: Vokabeln zufällig auswählen**

1. Um Vokabeln zufällig auszuwählen, können Sie die Liste "Vokabelliste" verwenden. Verwenden Sie den "Zufallsauswahl aus Liste"-Block, um ein zufälliges Vokabel-Übersetzungs-Paar auszuwählen.
2. Zeigen Sie das ausgewählte Paar im Label an, damit die Benutzer die Übersetzung eingeben können.

**Schritt 6: Vokabel-Abfrage implementieren**

1. Implementieren Sie die Vokabel-Abfrage mit den Blockly-Blöcken, die Sie bereits in Ihrem ursprünglichen Schritt 1 erstellt haben. Vergleichen Sie die Benutzereingabe mit der richtigen Übersetzung und geben Sie eine entsprechende Meldung aus.
