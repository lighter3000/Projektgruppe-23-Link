from browser import document, timer, html, ajax
from turtle import restart
import sys, traceback, json
import javascript

#####                  Output functions                  #####    
def _writeConsole(*args):
    document["console"].html += "".join(args)

sys.stdout.write = _writeConsole
sys.stderr.write = _writeConsole

level_index = 1

# Einlesen des Codes und Tutorials aus .py Dateien
def load_level(level_index):
    level_file_path = f"/levels/level_{level_index}.py"
    
    with open(level_file_path, "r") as level_file:
        level_code = level_file.read()
    
    level_globals = {}
    exec(level_code, level_globals)
   
    
    document["level_title"].text = "Level " + str(level_index)
     
    if 'tutorial_text' in level_globals:
        document["tutorial_text"].html = level_globals['tutorial_text']
    if 'tutorial_code' in level_globals:
        document["tutorial_code"].text = level_globals['tutorial_code']
    
    """ if 'written_code' in level_globals is not "":
        document["code-editor-source"].text = level_globals['written_code']    """
        
    if 'init_code' in level_globals:
        document["code-editor-source"].text = level_globals['init_code']

    
#####                  button functions                  #####    
def previous_level(ev):
    global level_index
    if (level_index > 0):
        level_index -= 1
        load_level(level_index)
        


def next_level(ev):
    global level_index
    if (level_index < 10):
        level_index+= 1
        load_level(level_index)
        
def export_download(ev):
    pass

def export_print(ev):
    pass

def export_qrcode(ev):
    javascript.this().uploadFile()

def run_code(ev):
    document["console"].html = ""
    _code = document["code-editor-source"].text
    restart()
    exec(_code)    
    # Zum Einlesen des Codes in Datei muss noch implementiert werden
    """level_file_path = f"/levels/level_{level_index}.py"
    with open(level_file_path, "w") as level_file:
        level_code = level_file.read()
    
    level_globals = {}
    exec(level_code, level_globals)
    
    level_globals["written_code"] = _code """
    
def debug_code(ev):
    pass


#####                  button bindings                   #####
document["previous_level"].bind("click", previous_level)
document["next_level"].bind("click", next_level)
document["export_download"].bind("click", export_download)
document["export_print"].bind("click", export_print)
document["export_qrcode"].bind("click", export_qrcode)
document["run_code"].bind("click", run_code)
document["debug_code"].bind("click", debug_code)


#####                  dialog modal for qrcode           #####
qrcode_modal = document.getElementById("qrcodeModal")

# set event to close button on modal to hide modal
qrcode_modal_close_button = document.getElementsByClassName("close")[0]
qrcode_modal_close_button.bind("click", lambda ev: qrcode_modal.style.__setitem__("display", "none"))

#set event to click in background to hide modal
document.bind("click", lambda event: qrcode_modal.style.__setitem__("display", "none") if event.target == qrcode_modal else None)

#####                  darkmode                          #####

def toggle_dark_mode(event):
    document.body.classList.toggle('darkmode')

    document["modal-content"].classList.toggle('darkmode')

    document["linkToDownload"].classList.toggle('darkmode')

    buttons = document.select("button")
    for button in buttons:
        button.classList.toggle("darkmode")

    if (document["dark-mode-button"].text == "Dark Mode"):
        document["dark-mode-button"].text = "Light Mode"
    else:
        document["dark-mode-button"].text = "Dark Mode"
    

document["dark-mode-button"].bind('click', toggle_dark_mode)

toggle_dark_mode(EnvironmentError)

load_level(level_index)