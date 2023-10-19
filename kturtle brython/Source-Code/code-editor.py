from browser import document, timer, html, ajax
import sys, traceback


FIRST_TIME = True


#####                  Output functions                  #####

def _writeCanvas(*args):
    document["canvas-area"].html += "".join(args)
    
def _writeConsole(*args):
    document["console-area"].html += "".join(args)

sys.stdout.write = _writeCanvas
sys.stderr.write = _writeConsole


#####                  button functions                  #####

def previous_level(ev):
    print("previous_level")

def next_level(ev):
    print("next_level")

def export_download(ev):
    print("export_download")

def export_print(ev):
    print("export_print")

def export_qrcode(ev):
    print("export_qrcode")

def run_code(ev):
    document["run_code"].class_name = "btn-disabled"
    _code = document["code-editor-source"].text
    try:
        exec(_code)
    except:
        try:
            traceback.print_exc()
        except:
            print("could not print traceback")
    document["debug_code"].class_name = "btn-enabled"
    
    

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