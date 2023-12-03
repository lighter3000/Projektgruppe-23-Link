var editor;

function handleCodeEditor()
{
    editor = CodeMirror(document.getElementById("code-editor-source"), {
        lineNumbers: true,
        value: "",
        mode: "python",
        theme: "Material",
    });
}

function setCodeMirrorContent(newContent){
    if(editor){
        editor.setValue(newContent);
    } else {
        console.error("CodeMirror-Editor ist noch nicht initialisert");
    }
}

function getCodeMirrorContent(){
    if(editor){
        return editor.getValue();
    }
    return "";
}


window.addEventListener('load', handleCodeEditor);
window.setCodeMirrorContent = setCodeMirrorContent;
window.getCodeMirrorContent = getCodeMirrorContent;