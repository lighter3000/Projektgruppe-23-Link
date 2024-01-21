from browser import document, window, bind
from collections import defaultdict
import sys, traceback, json
import javascript
import re
import html

#####------------------Level Switch----------------------#####  
level_index = 0
written_code = defaultdict(str)
solution_code = defaultdict(str)
# Einlesen des Codes und Tutorials aus .py Dateien
def load_level(level_index):
    document["console"].html = ""
    level_file_path = f"/levels/level_{level_index}.py"
    
    #####  
    
    # Dynamisch einen neuen Container für CodeMirror erstellen
    #editor_container_id = f"code-editor-{level_index}"
    #editor_container = document.createElement('div')
    #editor_container.id = editor_container_id
    #document['code-editor-source'].clear()
    #document['code-editor-source'] <= editor_container
    
    
    #####
    
    with open(level_file_path, "r") as level_file:
        level_code = level_file.read()
    
    level_globals = {}
    exec(level_code, level_globals)
   
    
    document["level_title"].text = "Level " + str(level_index)
    
    if 'tutorial' in level_globals:
        document["tutorial"].html = level_globals['tutorial']
    
    if written_code[level_index] == 1: # if written_code[level_index] != "":
        document["code-editor-" + str(level_index)].style.display = "block"
        #window.setCodeMirrorContent(clean_text(written_code[level_index]))
        # window.setCodeMirrorContent(level_index) #, clean_text(written_code[level_index]))
        document["init_code"].text = level_globals['init_code'] 
    elif 'init_code' in level_globals:
        # window.removeChangeListener()
        handleCodeEditor(level_index, clean_text(level_globals['init_code']))
        # window.addChangeListener(level_index)
        #window.setCodeMirrorContent(level_index, clean_text(level_globals['init_code']))
        #window.setCodeMirrorContent(clean_text(level_globals['init_code']))
        document["init_code"].text = level_globals['init_code'] 
    
#####------------------Button Functions------------------#####  
def previous_level(ev):
    global level_index
    if (level_index > 0):
        #written_code[level_index] = window.getCodeMirrorContent()
        # written_code[level_index] = window.getCodeMirrorContent(level_index)
        document["code-editor-" + str(level_index)].style.display = "none"
        written_code[level_index] = 1
        level_index -= 1
        load_level(level_index)

def next_level(ev):
    global level_index
    if (level_index < 5):
        #written_code[level_index] = window.getCodeMirrorContent()
        #written_code[level_index] = window.getCodeMirrorContent(level_index)
        document["code-editor-" + str(level_index)].style.display = "none"
        written_code[level_index] = 1
        level_index+= 1
        load_level(level_index)

def play(str):
    javascript.this().play_music(str)

def tone(str):
    javascript.this().play_tone(str)

def tones(arr):
    javascript.this().play_tone_array(arr)
    
def stop_code(ev):
    javascript.this().stop_music()

def run_code(ev):
    document["console"].html = ""
    # _code = window.getCodeMirrorContent(level_index)
    _code = getCodeMirrorContent(level_index)
    #_code = document["code-editor-source"].text

    # Ansatz wie man die Größe des Canvases bei jedem run neu setzen kann. Dafür muss brython_stdlib.js bearbeitet werden.
    # canvas_size = "turtle.set_defaults(canvwidth = document['canvas'].clientWidth, canvheight = document['canvas'].clientHeight)\n"
    
    # code_with_turtle_setup_and_rollback = "t = turtle.Turtle() \n" + _code + "\nturtle.done()"

    exec(_code)

    # window.requestAnimationFrame(check_canvas_existence)
    
    written_code[level_index] = _code

    # edit_level_container(level_index)

        
###-----Dark-Mode Button--------------#####
def toggle_dark_mode(event):
    document.body.classList.toggle('darkmode')
    
    document["qrcode-modal-content"].classList.toggle('darkmode')
    document["initcode-modal-content"].classList.toggle('darkmode')
    document["solution-modal-content"].classList.toggle('darkmode')

    document["linkToDownload"].classList.toggle('darkmode')

    document["solution_password"].classList.toggle('darkmode')

    buttons = document.select("button")
    for button in buttons:
        button.classList.toggle("darkmode")

    if (document["dark-mode-button"].text == "Dark Mode"):
        document["dark-mode-button"].text = "Light Mode"
        editors[level_index].getWrapperElement().style.color = "white" # eventuell ersetzen mit Light Theme
    else:
        document["dark-mode-button"].text = "Dark Mode"
        editors[level_index].getWrapperElement().style.color = "black" # eventuell ersetzen mit Dark Theme

#####------------------Button Bindings-------------------#####  
document["previous_level"].bind("click", previous_level)
document["next_level"].bind("click", next_level)
document["run_code"].bind("click", run_code)
document["stop_code"].bind("click", stop_code)
document["dark-mode-button"].bind('click', toggle_dark_mode)

#####------------------Code-Editor-----------------------#####   

def clean_text(text):
    return text.replace("\u200B", "")


editors = {}
editor = None

def handleCodeEditor(level, code):
    global editor
    containerId = "code-editor-" + str(level)
    container = document.createElement("div")
    container.id = containerId
    document["code-editor-source"].appendChild(container)

    editors[level] = window.CodeMirror(container, {
        'lineNumbers': True,
        'value': code,
        'mode': "python",
        'theme': "base16-dark"
    })

    editor = editors[level]
    addReadOnly(level)

def addReadOnly(level):
    line_handle = editor.getLineHandle(0)
    if line_handle:
        editor.markText({"line": 0, "ch": 0}, {"line": 0, "ch": len(line_handle["text"])}, {"readOnly": True})
    else:
        print("Fehler beim Hinzufügen des Schreibschutzes: Zeile nicht gefunden")

def removeReadOnly(level):
    for mark in editor.getAllMarks():
        mark.clear()

# def addChangeListener(level):
#     editors[level].on('beforeChange', beforeChangeHandler)
    
# def removeChangeListener(level):
#     editors[level].removeEventListener('beforeChange', beforeChangeHandler)

def beforeChangeHandler(cm, change):
    readOnlyLines = [0]
    from_line = change['from']['line']  # Accessing the property using bracket notation
    if from_line in readOnlyLines:
        change.cancel()

def setCodeMirrorContent(newContent, level):
    global editor
    editor = editors[level]
    if editor:
        removeReadOnly(level)
        editor.setValue(newContent)
        addReadOnly(level)
    else:
        javascript.this().console.log("CodeMirror-Editor ist noch nicht initialisiert")

def getCodeMirrorContent(level):
    global editor
    editor = editors[level]
    if editor:
        return editor.getValue()
    return ""


#####------------------Console----------------------------#####  
def _writeConsole(*args):
    document["console"].html += "".join(args)
    document["console"].html += "<br/>"

sys.stdout.write = _writeConsole
sys.stderr.write = _writeConsole 

###-----dialog modal for init-code----#####
initcode_modal = document.getElementById("initcodeModal")

# set event to close button on modal to hide modal
initcode_modal_close_button = initcode_modal.getElementsByClassName("close")[0]
initcode_modal_close_button.bind("click", lambda ev: initcode_modal.style.__setitem__("display", "none"))

#set event to click in background to hide modal
document.bind("click", lambda event: initcode_modal.style.__setitem__("display", "none") if event.target == initcode_modal else None)

#####------------------onload----------------------------#####   
# Funktion die bei Beginn einmal geladen werden sollen
load_level(level_index)


# Globalisiert Funktionen, damit JavaScript drauf zugreifen kann

