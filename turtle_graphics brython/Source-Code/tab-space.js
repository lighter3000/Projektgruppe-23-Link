// var editor;
var editor;
var editors = {};
// function handleCodeEditor()
// {
//     editor = CodeMirror(document.getElementById("code-editor-source"), {
//         lineNumbers: true,
//         value: "",
//         mode: "python",
//         theme: "Material",
//     });
// }

function handleCodeEditor(level, code)
{
    var containerId = "code-editor-" + level;
    var container = document.createElement("div");
    container.id = containerId;
    document.getElementById("code-editor-source").appendChild(container);

    editors[level] = CodeMirror(container, {
        lineNumbers: true,
        value: code,
        mode: "python",
        theme: "base16-dark",
    });

    addChangeListener(level)
    editor = editors[level]
}

// mdn-like
// standard
// material
// eclipse
// base16-dark


// function removeChangeListener(level) {
//     editors[level].off('beforeChange', beforeChangeHandler);
// }

function addChangeListener(level) {
    editors[level].on('beforeChange', beforeChangeHandler);
}

function beforeChangeHandler(cm, change) {
    var readOnlyLines = [0];
    if (~readOnlyLines.indexOf(change.from.line)) {
        change.cancel();
    }
}

// function makeReadOnlyLine(lineNumber) {
//     editor.markText(
//         { line: lineNumber, ch: 0 },
//         { line: lineNumber, ch: editor.getLine(lineNumber).length },
//         { readOnly: true, inclusiveLeft: true, inclusiveRight: true }
//     );
// }

// function setCodeMirrorContent(newContent){
//     if(editor){
//         editor.setValue(newContent);
//     } else {
//         console.error("CodeMirror-Editor ist noch nicht initialisert");
//     }
// }

function setCodeMirrorContent(newContent, level) { //, newContent){
    // var containerId = "code-editor-" + level;
    editor = editors[level];
    console.log(editors)
    if(editor){
        editor.setValue(newContent);
    } else {
        console.error("CodeMirror-Editor ist noch nicht initialisert");
    }
}


// function getCodeMirrorContent(){
//     if(editor){
//         return editor.getValue();
//     }
//     return "";
// }

function getCodeMirrorContent(level){
    // var containerId = "code-editor-" + level;
    editor = editors[level];
    if(editor){
        return editor.getValue();
    }
    return "";
}


// window.addEventListener('load', handleCodeEditor);
// window.setCodeMirrorContent = setCodeMirrorContent;
// window.getCodeMirrorContent = getCodeMirrorContent;