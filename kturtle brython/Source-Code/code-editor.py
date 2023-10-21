from browser import document, timer, html, ajax
import sys, traceback, json

#####                  Output functions                  #####

def _writeCanvas(*args):
    document["canvas-area"].html += "".join(args)
    
def _writeConsole(*args):
    document["console-area"].html = "".join(args)

sys.stdout.write = _writeCanvas
sys.stderr.write = _writeConsole

current_level = 1
#####                  button functions                  #####
# Zum Einlesen der JSON-Datei und dem Zuweisen zu den entsprechenden HTML-Elementen
def load_level(level_index=1):
    with open ("/levels/level_" + str(level_index) + ".json", "r") as level_file:
            level_data = json.load(level_file)
    
    document["level_title"].text = "Level " + str(current_level)
    level_info = level_data[0]  
    document["tutorial_text"].text = level_info["tutorial"]["instructions"]
    document["tutorial_code"].html = level_info["tutorial"]["code"]
    
    code_text = ""
    if level_info["code"]["imports"] is not None:
        code_text = code_text + "\n".join(level_info["code"]["imports"]) + "\n\n"
        
    if level_info["code"]["setup"] is not None:
        code_text = code_text + level_info["code"]["setup"] + "\n\n"
        
    if "functions" in level_info["code"]:
        for function in level_info["code"]["functions"]:
            code_text = code_text + "def " + function["name"] + ":\n\t" + function["code"] + "\n\n"
        
    if level_info["code"]["execution"] is not None:
        code_text = code_text + level_info["code"]["execution"] + "\n\n"
        
    if "finish" in level_info["code"]:
        code_text = code_text + level_info["code"]["finish"] + "\n\n"
        
    document["code-editor-source"].html = code_text
   
    
    
    
def previous_level(ev):
    global current_level
    if (current_level > 0):
        current_level -= 1
        load_level(current_level)
        


def next_level(ev):
    global current_level
    if (current_level < 10):
        current_level += 1
        load_level(current_level)
        
    
    
def export_download(ev):
    print("export_download")

def export_print(ev):
    print("export_print")

def export_qrcode(ev):
    print("export_qrcode")

def run_code(ev):
    _code = document["code-editor-source"].text
    try:
        exec(_code)
    except:
        try:
            traceback.print_exc()
        except:
            print("could not print traceback")
    
    

def debug_code(ev):
    print("debug_code")
    

    
#####                  button bindings                   #####

document["previous_level"].bind("click", previous_level)
document["next_level"].bind("click", next_level)
document["export_download"].bind("click", export_download)
document["export_print"].bind("click", export_print)
document["export_qrcode"].bind("click", export_qrcode)
document["run_code"].bind("click", run_code)
document["debug_code"].bind("click", debug_code)

load_level(1)