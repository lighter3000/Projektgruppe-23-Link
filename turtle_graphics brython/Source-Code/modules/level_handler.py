from browser import document
from collections import defaultdict

from modules import code_mirror
from modules import solution
from modules import canvas
from modules import console
from modules import initcode
from modules import theme

level_index = 0
written_code = defaultdict(str)

# function reads level parameters from file system
def read_level_from_filesystem(level_index):
    level_file_path = f"/levels/level_{level_index}.py"
    
    with open(level_file_path, "r") as level_file:
        level_code = level_file.read()
    
    level_parameter = {}
    exec(level_code, level_parameter)

    return level_parameter

# function loads level parameters (tutorial, code, initcode, solution), clears canvas and console
def load_level():
    canvas.clear_canvas()
    console.clear_console()
    
    level_parameter = read_level_from_filesystem(level_index)
   
    set_level_title(level_index)
    
    
    set_tutorial(level_parameter['tutorial'])
    
    if allready_loaded(level_index):
        code_mirror.show_editor(level_index)
    elif 'init_code' in level_parameter:
        code_mirror.create_code_editor(level_index, level_parameter['init_code'])
    
    theme.set_highlighting_theme()
    
    initcode.set_initcode(level_parameter['init_code'])

    solution.set_solution(level_parameter['solution_code'])

# function sets level title
def set_level_title(level):
    document["level_title"].text = "Level " + str(level)

# function sets tutorial
def set_tutorial(tutorial):
    if tutorial != None:
        document["tutorial"].html = tutorial

# function returns true if level is allready loaded 
def allready_loaded(level):
    return written_code[level] == 1

# button function switches to previous level
def previous_level(ev):
    global level_index
    if (level_index > 0):
        code_mirror.hide_editor(level_index)
        written_code[level_index] = 1
        level_index -= 1
        load_level()

# button function switches to next level
def next_level(ev):
    global level_index
    if (level_index < 5):
        code_mirror.hide_editor(level_index)
        written_code[level_index] = 1
        level_index+= 1
        load_level()