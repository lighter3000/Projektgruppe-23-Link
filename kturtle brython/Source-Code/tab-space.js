function handleTabKey(event) 
{
    if (event.key === "Tab") {

        // Verhindert das Standardverhalten der Tab-Taste (das Bewegen zum nächsten Element)
        event.preventDefault(); 

        // Snappt sich das Element und die markierte Stelle
        var code = document.getElementById("code-editor-source");
        // selectionEnd und selectionStart geht bei <code> nicht, nur bei <textField> und <input>
        var selection = window.getSelection();

        // überprüfe, ob die Auswahl in <code> liegt
        if(code.contains(selection.anchorNode)){
            var startOffset = selection.anchorOffset;   // Start der markierung
            var endOffset = selection.focusOffset;      // Ende der markierung

            console.log("Start Offset: " + startOffset);
            console.log("End Offset: " + endOffset);
        }

        // Der Tab wird mit reingepackt
        var text = code.textContent;
        var newText = text.substring(0, startOffset) + "\t" + text.substring(endOffset);

        // Der neue Text mit dem Tab wird eingefügt
        code.innerHTML = newText;

        // Die Position des Schreibers wird an die Originale Stelle plus den Tab zurückgesetzt
        var range = document.createRange();
        range.setStart(code.firstChild, startOffset+1);
        range.setEnd(code.firstChild, startOffset+1);
        selection.removeAllRanges();
        selection.addRange(range);



        /*
        //console.log(code);
        var start = code.selectionStart;
        console.log("Start: " + start);
        var end = code.selectionEnd;
        console.log("End: " + end);
        var text = code.textContent;

        */
        //var newText = text.substring(0, start) + 'FFFF' + text.substring(end);
        //var newText = text.substring(0, start) + "\t" + text.substring(end);
        //newText = "FFFF";
        
        
        //var newText = text.substring(0, start) + "\t";
        //code.innerHTML = newText;
        console.log("Test2");
        
        //console.log("hello");
    }
}
