function handleTabKey(event) 
{
    const isCtrlOrCommand = event.ctrlKey || event.metaKey;


    if (event.key === "Tab") {
        // Verhindert das Standardverhalten der Tab-Taste (das Bewegen zum nächsten Element)
        event.preventDefault(); 
        insertElement("\t");
    }

    if (event.key === "Enter") {
        // Verhindert das Standardverhalten der Enter-Taste (das Einfügen von <br/>)
        event.preventDefault();
        
        insertElement("\n");
        codeEditorLines(countLines());
    }

    if(event.key === "Backspace"){
        codeEditorLines(countLines());
    }

    if(isCtrlOrCommand && event.key === "c"){
        console.log("Strg+C");
    } 

    if(isCtrlOrCommand && event.key === "v"){
        console.log("Strg+V");
    } 
}

function insertElement(element){ 
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

        if(startOffset>endOffset){
            var swap = startOffset;
            startOffset = endOffset;
            endOffset = swap;
        }

        // Der Tab wird mit reingepackt
        var text = code.textContent;
        var newText = text.substring(0, startOffset) + element + text.substring(endOffset);

        // Der neue Text mit dem Tab wird eingefügt
        code.textContent = newText;

        // Die Position des Schreibers wird an die Originale Stelle plus den Tab zurückgesetzt
        var range = document.createRange();
        range.setStart(code.firstChild, startOffset+1);
        range.setEnd(code.firstChild, startOffset+1);
        selection.removeAllRanges();
        selection.addRange(range);
    }
}

function countLines(){
    var code = document.getElementById("code-editor-source");
    var text = code.innerText;
    var lines = text.split("\n").length-1;
    return lines;
}

function codeEditorLines(lines){
    var numbers = document.getElementById("line-number-area");
    numbers.innerHTML = "";
    for(let i=1; i<=lines; i++){
           numbers.innerHTML += i+"<br/>";
    }
}