from browser import document, window, bind
import turtle
from collections import defaultdict
import sys

from modules import code_mirror
from modules import export
from modules import solution

#####------------------Level Switch----------------------#####  
level_index = 0

written_code = defaultdict(str)
solution_code = defaultdict(str)

def read_level_from_filesystem(level_index):
    level_file_path = f"/levels/level_{level_index}.py"
    
    with open(level_file_path, "r") as level_file:
        level_code = level_file.read()
    
    level_globals = {}
    exec(level_code, level_globals)

    return level_globals

# Einlesen des Codes und Tutorials aus .py Dateien
def load_level(level_index):
    clear_canvas()
    clear_console()
    
    level_values = read_level_from_filesystem(level_index)
   
    
    document["level_title"].text = "Level " + str(level_index)
    
    if 'tutorial' in level_values:
        document["tutorial"].html = level_values['tutorial']
    
    if written_code[level_index] == 1:
        code_mirror.show_editor(level_index)
    elif 'init_code' in level_values:
        code_mirror.create_code_editor(level_index, level_values['init_code'])
    
    code_mirror.set_theme(level_index)
    
    set_initcode(level_values['init_code'])

    if 'solution_code' in level_values:
        solution.set_solution(level_values['solution_code'])

#####------------------Button Functions------------------#####  
def previous_level(ev):
    global level_index
    if (level_index > 0):
        code_mirror.hide_editor(level_index)
        written_code[level_index] = 1
        level_index -= 1
        load_level(level_index)

def next_level(ev):
    global level_index
    if (level_index < 5):
        code_mirror.hide_editor(level_index)
        written_code[level_index] = 1
        level_index+= 1
        load_level(level_index)

def run_code(ev):
    document["console"].html = ""
    _code = code_mirror.getCodeMirrorContent(level_index)
    
    code_with_turtle_rollback = _code + "\n\nturtle.done()"
    
    turtle.restart()
    exec(code_with_turtle_rollback)

    export.edit_level_container(level_index, code_mirror.editors[level_index])

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
    document["print-modal-content"].classList.toggle('darkmode')


    document["linkToDownload"].classList.toggle('darkmode')

    document["solution_password"].classList.toggle('darkmode')

    buttons = document.select("button")
    for button in buttons:
        button.classList.toggle("darkmode")

    if (document["dark-mode-button"].text == "Dark Mode"):
        document["dark-mode-button"].text = "Light Mode"
    else:
        document["dark-mode-button"].text = "Dark Mode"

    code_mirror.set_theme(level_index)

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
document["export_download"].bind("click", export.export_download)
document["export_print"].bind("click", export.export_print)
document["export_qrcode"].bind("click", export.export_qrcode)
document["run_code"].bind("click", run_code)
document["dark-mode-button"].bind('click', toggle_dark_mode)
document["show_solution"].bind("click", solution.show_solution)
document["paste_solution"].bind("click", solution.paste_solution)
document["show_solution_code"].bind("click", solution.show_solution_code)
document["show_init_code"].bind("click", show_init_code)
document["toggle_coordinate_system"].bind("click", toggle_coordinate_system)

#####------------------Canvas----------------------------##### 
    
def show_coordinates():
    width = document["coordinates"].clientWidth
    height = document["coordinates"].clientHeight
    
    document["coordinates"].html = ""
    
    svg = window.d3.select("#coordinates").append("svg") \
        .attr("width", width) \
        .attr("height", height)

    g = svg.append("g")

    x_scale = window.d3.scaleLinear() \
        .domain([-width / 2, width / 2]) \
        .range([0, width])

    y_scale = window.d3.scaleLinear() \
        .domain([-height / 2, height / 2]) \
        .range([height, 0])

    x_axis = window.d3.axisBottom(x_scale)
    y_axis = window.d3.axisLeft(y_scale)

    g.append("g") \
        .attr("transform", f"translate(0, {height / 2})") \
        .call(x_axis)

    g.append("g") \
        .attr("transform", f"translate({width / 2}, 0)") \
        .call(y_axis)

def clear_canvas():
    document['canvas'].html = ""

#####------------------Console----------------------------#####  
def _writeConsole(*args):
    if args[0] == "\n":
        document["console"].html += "<br/>"
    else:
        document["console"].html += "".join(args)

def use_console_for_prints_and_errors():
    sys.stdout.write = _writeConsole
    sys.stderr.write = _writeConsole

def clear_console():
    document['console'].html = ""

#####------------------initcode---------------------------#####

def set_initcode(initcode):
    document["init_code"].text = initcode

# function sets event listeners for close initcode modal
def set_event_listeners_for_close_initcode_modal():
    initcode_modal = document["initcodeModal"]

    # set event to close button on modal to hide modal
    initcode_modal_close_button = initcode_modal.getElementsByClassName("close")[0]
    initcode_modal_close_button.bind("click", lambda ev: initcode_modal.style.__setitem__("display", "none"))

    #set event to click in background to hide modal
    document.bind("click", lambda event: initcode_modal.style.__setitem__("display", "none") if event.target == initcode_modal else None)

#####------------------zoom------------------------------#####  
def handle_zoom_change(ev):
    if document.get(selector='#turtle-canvas'):
        run_code(ev)
    show_coordinates()

#####------------------onload----------------------------##### 

def init():
    load_level(level_index)
    show_coordinates()
    dark = window.matchMedia("(prefers-color-scheme:dark)").matches
    if dark:
        toggle_dark_mode(None)

    use_console_for_prints_and_errors()

    window.addEventListener('resize', handle_zoom_change)

    solution.set_event_listeners_for_close_solution_modal()
    set_event_listeners_for_close_initcode_modal()

    export.initialize_levels_container(6)
    export.set_event_listeners_for_close_qrcode_modal()

init()