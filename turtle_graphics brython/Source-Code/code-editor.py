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

    if 'solution_code' in level_globals:
        document["solution_code"].text = level_globals['solution_code']         
        document["solution_comments"].text = get_solution_text(level_globals['solution_code'])
        
    
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
        
def export_download(ev):
    create_html(download_html)

def export_print(ev):
    create_html(print_html)

def export_qrcode(ev):
    create_html(upload_html)

def run_code(ev):
    document["console"].html = ""
    # _code = window.getCodeMirrorContent(level_index)
    _code = getCodeMirrorContent(level_index)
    #_code = document["code-editor-source"].text

    # Ansatz wie man die Größe des Canvases bei jedem run neu setzen kann. Dafür muss brython_stdlib.js bearbeitet werden.
    # canvas_size = "turtle.set_defaults(canvwidth = document['canvas'].clientWidth, canvheight = document['canvas'].clientHeight)\n"
    
    # code_with_turtle_setup_and_rollback = "t = turtle.Turtle() \n" + _code + "\nturtle.done()"
    code_with_turtle_rollback = _code + "\n\nturtle.done()"
    
    restart()
    exec(code_with_turtle_rollback)

    # window.requestAnimationFrame(check_canvas_existence)
    
    written_code[level_index] = _code

    # edit_level_container(level_index)

def init_turtle(turtle):
    turtle.set_defaults(canvwidth = document['canvas'].clientWidth, canvheight = document['canvas'].clientHeight)
    t = turtle.Turtle()
    t.width(5)
    return t
    
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

###-----Solution Buttons--------------#####
def show_solution(ev):
    document['solution_comments_container'].style.display = 'block'
    document['solution_code_container'].style.display = 'none'
    document["solutionModal"].style.display = "block"

def paste_solution(ev):
    # window.setCodeMirrorContent(document["solution_code"].text, level_index)
    setCodeMirrorContent(clean_text(document["solution_code"].text), level_index)

def show_solution_code(ev):
    if document["solution_password"].value == "Passwort":
        document['solution_comments_container'].style.display = 'none'
        document['solution_code_container'].style.display = 'block'

        document["solution_password"].value = ""
    else:
        document["solution_password"].value = ""

def show_init_code(ev):
    document['initcodeModal'].style.display = 'block'
    
def toggle_coordinate_system(ev):
    coordinates_element = document["coordinates"]

    if coordinates_element.style.display == "block":
        coordinates_element.style.display = "none"
    else:
        coordinates_element.style.display = "block"

#####------------------Button Bindings-------------------#####  
document["previous_level"].bind("click", previous_level)
document["next_level"].bind("click", next_level)
document["export_download"].bind("click", export_download)
document["export_print"].bind("click", export_print)
document["export_qrcode"].bind("click", export_qrcode)
document["run_code"].bind("click", run_code)
document["dark-mode-button"].bind('click', toggle_dark_mode)
document["show_solution"].bind("click", show_solution)
document["paste_solution"].bind("click", paste_solution)
document["show_solution_code"].bind("click", show_solution_code)
document["show_init_code"].bind("click", show_init_code)
document["toggle_coordinate_system"].bind("click", toggle_coordinate_system)



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



#####------------------Canvas----------------------------#####  
def resize_canvas():
    turtle_canvas = document.getElementById("turtle-canvas")
    canvas = document.getElementById("canvas")
    turtle_canvas.setAttribute('width', canvas.clientWidth)
    turtle_canvas.setAttribute('height', canvas.clientHeight)

#####------------------Console----------------------------#####  
def _writeConsole(*args):
    document["console"].html += "".join(args)
    document["console"].html += "<br/>"

sys.stdout.write = _writeConsole
sys.stderr.write = _writeConsole 

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

###-----dialog modal for init-code----#####
initcode_modal = document.getElementById("initcodeModal")

# set event to close button on modal to hide modal
initcode_modal_close_button = initcode_modal.getElementsByClassName("close")[0]
initcode_modal_close_button.bind("click", lambda ev: initcode_modal.style.__setitem__("display", "none"))

#set event to click in background to hide modal
document.bind("click", lambda event: initcode_modal.style.__setitem__("display", "none") if event.target == initcode_modal else None)

#####------------------Export PDF------------------------#####  

###-----init level container----------#####
def initialize_levels_container(level_num):
    levels_container = document["levelsContainer"]

    for level in range(level_num):
        level_container = create_container("level " + str(level))

        level_container.appendChild(create_title("H2", "Level " + str(level)))
        level_container.appendChild(create_title("H3", "Aufgabenstellung und Hinweise"))
        level_container.appendChild(create_container("level" + str(level) + "_exercise"))
        level_container.appendChild(create_title("H3", "Dein Code"))
        level_container.appendChild(create_container("level" + str(level) + "_code"))
        level_container.appendChild(create_title("H3", "Canvas"))
        level_container.appendChild(create_container("level" + str(level) + "_canvas_container"))

        if level == 0:
            level_container.classList.add("first-level-container")

        level_container.classList.add("empty-level-container")

        levels_container.appendChild(level_container)

        document["level" + str(level) + "_exercise"].html = get_exercise(level)

def create_title(element_type, text):
    title = document.createElement(element_type)
    title.html = text
    return title

def create_container(container_id):
    container = document.createElement("div")
    container.id = container_id
    return container

def get_exercise(level):
    level_file_path = f"/levels/level_{level}.py"
    
    with open(level_file_path, "r") as level_file:
        level_code = level_file.read()
    
    level_globals = {}
    exec(level_code, level_globals)
    
    if 'tutorial' in level_globals:
        return level_globals['tutorial']

def edit_level_container(level):
    level_container = document["level " + str(level)]
    level_container.classList.remove("empty-level-container")

    document["level" + str(level) + "_exercise"].html = document["tutorial"].html

    add_code_from_code_mirror(document["level" + str(level) + "_code"])

    canvas_container = document["level" + str(level) + "_canvas_container"]
    canvas_container.html = document["canvas"].html
    rename_animation_ids(canvas_container, level)

def add_code_from_code_mirror(code_container):
    code_container.html = ''
    
    pre_element = document.createElement("pre")

    code_element = document.createElement("code")
    code_element.text = editor.getValue()

    pre_element.appendChild(code_element)
    code_container.appendChild(pre_element)

    code_container.classList.add("code-container")

def rename_animation_ids(canvas_container, level):
    svg = canvas_container.child_nodes[0]

    for element in svg.querySelectorAll('[id^="animation_frame"]'):
        current_id = element.id
        new_id = 'level' + str(level) + "_" + current_id

        element.id = new_id

        for element in svg.querySelectorAll('[begin="' + current_id + '.end"]'):
            element.setAttribute('begin', new_id + '.end')

    svg.id = svg.id + "-" + str(level)

def create_html(callback_function):
    html_content = document.getElementById('levelsContainer').outerHTML
    html_content = html_content.replace('hidden=""', '')

    callback_function(html_content)


def download_html(html_content):
    blob = window.Blob.new([html_content], {"type": "text/html"})
    url = window.URL.createObjectURL(blob)
    
    link = document.createElement('a')
    link.href = url
    link.download = 'exported.html'

    document.body.appendChild(link)
    link.click()
    document.body.removeChild(link)

def print_html(html_content):
    modified_content = html_content.replace('var printExport = false;', 'var printExport = true;')
    
    window.on_message_from_new_window = on_message_from_new_window
    window.addEventListener('message', on_message_from_new_window)
    
    new_window = window.open("", "_blank")
    new_window.document.write(modified_content)
    new_window.document.close()
    show_modal()
    
def on_message_from_new_window(event):
    if event.data == 'new_window_closed':
        hide_modal()

def show_modal():
    modal = document.getElementById("print-modal")
    modal.style.display = "block"

def hide_modal():
    modal = document.getElementById("print-modal")
    modal.style.display = "none"

qrcode_modal = document.getElementById("qrcodeModal")
link_to_download = document.getElementById("linkToDownload")
qr_code_to_download = document.getElementById("qrCodeToDownload")
message = document.getElementById("message")
error_message = document.getElementById("errorMessage")

def upload_html(html_content):

    show_qr_code_modal()
    
    form_data = window.FormData.new()
    form_data.append('file', window.Blob.new([html_content], {'type': 'text/html'}), 'exported.html')

    window.fetch('https://api.gofile.io/getServer')\
        .then(lambda response: response.json())\
        .then(lambda data: handle_server_response(data, form_data))\
        .catch(lambda error: handle_upload_error('Error beim Upload:\n' + error.message))

def handle_server_response(data, form_data):
    if data['status'] == 'ok':
        upload_file_url = 'https://' + data['data']['server'] + '.gofile.io/uploadFile'
        window.fetch(upload_file_url, {
            'method': 'POST',
            'body': form_data
        })\
            .then(lambda response: response.json())\
            .then(lambda data: handle_upload_response(data))\
            .catch(lambda error: handle_upload_error('Error beim Upload:\n' + error.message))
    else:
        handle_upload_error('Error beim Upload:\n' + data['status'])

def handle_upload_response(data):
    if data['status'] == 'ok':
        handle_upload_on_success(data)
    else:
        handle_upload_error('Error beim Upload:\n' + data['status'])

def handle_upload_on_success(data):
    qr_code_to_download.innerHTML = ''
    qrcode = window.QRCode.new(qr_code_to_download)

    qrcode.clear()
    qrcode.makeCode(data['data']['downloadPage'])

    link_to_download.href = data['data']['downloadPage']
    link_to_download.text = data['data']['downloadPage']

    qrcode._oDrawing._elImage.style.width = "100%"
    
    javascript.this().console.log("B1")

    qr_code_to_download.style.display = "block"
    link_to_download.style.display = "block"
    message.innerText = 'QR-Code scannen zum Herunterladen!'

def handle_upload_error(error_msg):
    message.style.display = "none"
    error_message.innerText = error_msg
    error_message.style.display = "block"
    qrcode_modal.style.display = "block"


###-----dialog modal for qrcode-------#####
def show_qr_code_modal():
    qr_code_to_download.style.display = "none"
    link_to_download.style.display = "none"
    error_message.style.display = "none"

    message.innerText = "Warten auf Upload ..."
    message.style.display = "block"
    qrcode_modal.style.display = "block"

qrcode_modal = document.getElementById("qrcodeModal")

# set event to close button on modal to hide modal
qrcode_modal_close_button = qrcode_modal.getElementsByClassName("close")[0]
qrcode_modal_close_button.bind("click", lambda ev: qrcode_modal.style.__setitem__("display", "none"))

#set event to click in background to hide modal
document.bind("click", lambda event: qrcode_modal.style.__setitem__("display", "none") if event.target == qrcode_modal else None)

#####------------------zoom------------------------------#####  
def handle_zoom_change(ev):
    if document.get(selector='#turtle-canvas'):
        run_code(ev)
    window.showCoordinates()

window.addEventListener('resize', handle_zoom_change)

#####------------------onload----------------------------#####   
# Funktion die bei Beginn einmal geladen werden sollen
load_level(level_index)
initialize_levels_container(6)
window.showCoordinates()


# Globalisiert Funktionen, damit JavaScript drauf zugreifen kann

