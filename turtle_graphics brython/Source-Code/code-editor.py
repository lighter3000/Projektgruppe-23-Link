from browser import document, window, bind
from turtle import restart
import turtle
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
    document['canvas'].html = ""
    document["console"].html = ""
    level_file_path = f"/levels/level_{level_index}.py"
    
    with open(level_file_path, "r") as level_file:
        level_code = level_file.read()
    
    level_globals = {}
    exec(level_code, level_globals)
   
    
    document["level_title"].text = "Level " + str(level_index)
    
    if 'tutorial' in level_globals:
        document["tutorial"].html = level_globals['tutorial']
    # if 'tutorial_code' in level_globals:
    #     document["tutorial_code"].text = level_globals['tutorial_code']
    
    if written_code[level_index - 1] != "":
        window.setCodeMirrorContent(clean_text(written_code[level_index - 1]))
        #document["code-editor-source"].text = written_code[level_index - 1]  
    elif 'init_code' in level_globals:
        window.setCodeMirrorContent(clean_text(level_globals['init_code']))
        #document["code-editor-source"].text = level_globals['init_code']

    if 'solution_code' in level_globals:
        document["solution_code"].text = level_globals['solution_code']         
        document["solution_comments"].text = get_solution_text(level_globals['solution_code'])
        
    
#####------------------Button Functions------------------#####  
def previous_level(ev):
    global level_index
    if (level_index > 0):
        #written_code[level_index - 1] = document["code-editor-source"].text
        written_code[level_index - 1] = window.getCodeMirrorContent()
        level_index -= 1
        load_level(level_index)
        #load_linesnumbers()
        


def next_level(ev):
    global level_index
    if (level_index < 10):
        #written_code[level_index - 1] = document["code-editor-source"].text
        written_code[level_index - 1] = window.getCodeMirrorContent()
        level_index+= 1
        load_level(level_index)
        #load_linesnumbers()
        
def export_download(ev):
    resize_canvas()

def export_print(ev):
    pass

def export_qrcode(ev):
    javascript.this().uploadFile()

def tone(str):
    javascript.this().tone(str)

def run_code(ev):
    document["console"].html = ""
    _code = window.getCodeMirrorContent()
    #_code = document["code-editor-source"].text

    # code_with_turtle_setup_and_rollback = "t = turtle.Turtle() \n" + _code + "\nturtle.done()"
    code_with_turtle_rollback = _code + "\nturtle.done()"
    
    restart()
    exec(code_with_turtle_rollback)

    # window.requestAnimationFrame(check_canvas_existence)
    
    written_code[level_index - 1] = _code
    
    
def save_code(ev):
    written_code[level_index - 1] = document["code-editor-source"].text
    
def reset_code(ev):
    level_file_path = f"/levels/level_{level_index}.py"
    with open(level_file_path, "r") as level_file:
        level_code = level_file.read()
    
    level_globals = {}
    exec(level_code, level_globals)
    
    #document["code-editor-source"].text = level_globals['init_code']
    window.setCodeMirrorContent(level_globals['init_code'])
    

def load_code(ev):
    if written_code[level_index - 1] != "":
        window.setCodeMirrorContent(written_code[level_index - 1])
        #document["code-editor-source"].text = written_code[level_index - 1]
        
###-----Dark-Mode Button--------------#####
def toggle_dark_mode(event):
    document.body.classList.toggle('darkmode')

    document["qrcode-modal-content"].classList.toggle('darkmode')
    document["solution-modal-content"].classList.toggle('darkmode')

    document["linkToDownload"].classList.toggle('darkmode')

    document["solution_password"].classList.toggle('darkmode')

    buttons = document.select("button")
    for button in buttons:
        button.classList.toggle("darkmode")

    if (document["dark-mode-button"].text == "Dark Mode"):
        document["dark-mode-button"].text = "Light Mode"
    else:
        document["dark-mode-button"].text = "Dark Mode"

###-----Solution Buttons--------------#####
def show_solution(ev):
    document['solution_comments_container'].style.display = 'block'
    document['solution_code_container'].style.display = 'none'
    document["solutionModal"].style.display = "block"

def paste_solution(ev):
    save_code(ev)
    window.setCodeMirrorContent(document["solution_code"].text)
    #document["code-editor-source"].text = document["solution_code"].text
    #load_linesnumbers()

def show_solution_code(ev):
    if document["solution_password"].value == "Passwort":
        document['solution_comments_container'].style.display = 'none'
        document['solution_code_container'].style.display = 'block'

        document["solution_password"].value = ""
    else:
        document["solution_password"].value = ""

#####------------------Button Bindings-------------------#####  
document["previous_level"].bind("click", previous_level)
document["next_level"].bind("click", next_level)
document["export_download"].bind("click", export_download)
document["export_print"].bind("click", export_print)
document["export_qrcode"].bind("click", export_qrcode)
document["run_code"].bind("click", run_code)
document["reset_code"].bind("click", reset_code)
document["load_code"].bind("click", load_code)
document["save_code"].bind("click", save_code)
document["dark-mode-button"].bind('click', toggle_dark_mode)
document["show_solution"].bind("click", show_solution)
document["paste_solution"].bind("click", paste_solution)
document["show_solution_code"].bind("click", show_solution_code)



#####------------------Code-Editor-----------------------#####   

def clean_text(text):
    return text.replace("\u200B", "")

#####------------------Canvas----------------------------#####  
def resize_canvas():
    turtle_canvas = document.getElementById("turtle-canvas")
    canvas = document.getElementById("canvas")
    turtle_canvas.setAttribute('width', canvas.clientWidth)
    turtle_canvas.setAttribute('height', canvas.clientHeight)

#####------------------Console----------------------------#####  
def _writeConsole(*args):
    document["console"].html += "".join(args)

# sys.stdout.write = _writeConsole
# sys.stderr.write = _writeConsole            

#####------------------Solution---------------------------#####
def get_solution_text(string):
    string = re.sub(re.compile(r'(.*)#'), r'#', string)
    lines = string.split('\n')

    for i in range(len(lines)):
        line = lines[i]
        
        if '#' not in line:
            lines[i] = ''

        return '\n'.join(lines)

###-----dialog modal for solution-----#####
soultion_modal = document.getElementById("solutionModal")

# set event to close button on modal to hide modal
soultion_modal_close_button = soultion_modal.getElementsByClassName("close")[0]
soultion_modal_close_button.bind("click", lambda ev: soultion_modal.style.__setitem__("display", "none"))

#set event to click in background to hide modal
document.bind("click", lambda event: soultion_modal.style.__setitem__("display", "none") if event.target == soultion_modal else None)
     
#####------------------Export PDF------------------------#####  
#  
###-----dialog modal for qrcode-------#####
qrcode_modal = document.getElementById("qrcodeModal")

# set event to close button on modal to hide modal
qrcode_modal_close_button = qrcode_modal.getElementsByClassName("close")[0]
qrcode_modal_close_button.bind("click", lambda ev: qrcode_modal.style.__setitem__("display", "none"))

#set event to click in background to hide modal
document.bind("click", lambda event: qrcode_modal.style.__setitem__("display", "none") if event.target == qrcode_modal else None)

#####------------------onload----------------------------#####   
# Funktion die bei Beginn einmal geladen werden sollen
load_level(level_index)
#load_linesnumbers()

# Globalisiert Funktionen, damit JavaScript drauf zugreifen kann
element = document.getElementById("code-editor-source")
