import sys
import traceback
from browser import document, timer, html, ajax

FIRST_TIME = True
def inform(*args):
    document["status-info"].html = "".join(args)

def _write(*args):
    document["turtle-print-output"].html += "".join(args)
def __write(*args):
    document["turtle-print-output"].html += '<span class="error">' + "".join(args) + "</span>"

sys.stdout.write = _write
sys.stderr.write = __write

def clear_print():
    document["turtle-print-output"].html = ""

def run_code(ev):
    global FIRST_TIME
    if FIRST_TIME:
        FIRST_TIME = False
        inform("Importing turtle module for the first time and processing; please wait")
    else:
        inform("Processing")
    document["run"].class_name = "btn-disabled"
    # delay to allow updated DOM with above text to be shown.
    timer.set_timeout(exec_code, 1)

document["run"].bind("click", run_code)

def exec_code():
    _code= document["source"].text
    try:
        exec(_code)
    except:
        try:
            traceback.print_exc()
        except:
            print("could not print traceback")
    document["clear"].class_name = "btn-enabled"
    document["replay-scene"].class_name = "btn-enabled"
    inform("")

def delayed_clear():
    from turtle import restart
    restart()
    inform("")
    document["run"].class_name = "btn-enabled"
    document["replay-scene"].class_name = "btn-disabled"
    document["clear"].class_name = "btn-disabled"
    clear_print()

def clear(ev):
    global FIRST_TIME
    if FIRST_TIME:
        FIRST_TIME = False
        inform("Importing turtle module for the first time and processing; please wait")
        document["run"].class_name = "btn-disabled"
    # delay to allow updated DOM with above text to be shown.
    timer.set_timeout(delayed_clear, 1)

document["clear"].bind("click", clear)

def replay(ev):
    # importing turtle earlier slows down the loading
    # of this page
    from turtle import replay_scene
    replay_scene()

document["replay-scene"].bind("click", replay)

def copy_content(ev):
    choice = document["demo_selector"].value
    document["source"].html = document['level_'+ str(choice) + "_code"].text
    document["info"].html = document['level_'+ str(choice) + "_tutorial"].html
    clear(ev)

document["demo_selector"].bind("change", copy_content)

def load_level_html(on_success=None, on_error=None):
    level_names = ["level_1", "level_2"]
    def on_complete(req):
        if req.status == 200:
            level_content = req.text
            level_div = html.DIV()
            level_div.html = level_content
            document <= level_div
            if on_success is not None:
                on_success()
        else:
            print("Fehler beim Laden von " + level_name + ".html")
            if on_error is not None:
                on_error()
    for level_name in level_names:
        ajax.get("levels/" + level_name + ".html", oncomplete=on_complete)

# Beispielaufruf von load_level_html mit Erfolgs- und Fehler-Rückruffunktionen
def after_level_loaded():
    # Hier können Sie den Code ausführen, der nach dem Laden der HTML-Datei ausgeführt werden soll
    document["source"].html = document["level_1_code"].text
    document["info"].html = document["level_1_tutorial"].html


def on_error_loading_level():
    nop()
    # Hier können Sie den Code ausführen, der im Fehlerfall ausgeführt werden soll

load_level_html(on_success=after_level_loaded, on_error=on_error_loading_level)