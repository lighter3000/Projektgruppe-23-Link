from browser import document, window

import re

current_editor = None
editors = []


# function creates code-mirror code editor, appends that to editors and sets first line read only
def create_code_editor(level, code):
    global current_editor

    containerId = "code-editor-" + str(level)
    container = document.createElement("div")
    container.id = containerId
    document["code-editor-source"].appendChild(container)

    editors.append(
        window.CodeMirror(
            container,
            {
                "lineNumbers": True,
                "value": clean_code(code),
                "mode": "python",
                "theme": "vscode-light",
                "indentWithTabs": True,
                "tabSize": 4,
                "extraKeys": {"Enter": lambda cm: custom_enter_key_handler(cm)},
            },
        )
    )

    current_editor = editors[level]

    add_read_only()


# function counts tabs in current line
def count_tabs_in_line(line):
    tabs = re.match(r"^\s*", line).group()
    return tabs.count("\t")


# function, which is triggered by the enter key, appends the correct number of tabs in the next line
def custom_enter_key_handler(cm):
    cursor = cm.getCursor()
    line = cm.getLine(cursor.line)

    # Prüfen, ob die aktuelle Zeile schreibgeschützt ist
    if is_line_readonly(cm, cursor.line):
        # Prüfen, ob der Cursor am Ende der Zeile ist
        if cursor.ch == len(line):
            cm.replaceRange("\n", {"line": cursor.line, "ch": cursor.ch})
        return  # Keine Änderungen, wenn die Zeile schreibgeschützt ist


    tabs_str = ""
    for _ in range(count_tabs_in_line(line)):
        tabs_str += "\t"

    if ":" in line.strip():
        tabs_str = "\n\t" + tabs_str
    else:
        tabs_str = "\n" + tabs_str

    cm.replaceRange(tabs_str, {"line": cursor.line, "ch": cursor.ch})


def is_line_readonly(cm, line_number):
    """Prüft, ob eine bestimmte Zeile schreibgeschützt ist."""
    line_handle = cm.getLineHandle(line_number)
    if line_handle:
        for mark in cm.findMarksAt({"line": line_number, "ch": 0}):
            if mark.readOnly:
                return True
    return False


# function removes character \u200B from given code
def clean_code(code):
    return code.replace("\u200B", "")


# function sets first line read only
def add_read_only():
    line_handle = current_editor.getLineHandle(0)
    if line_handle:
        current_editor.markText(
            {"line": -1, "ch": 0},
            {"line": 0, "ch": len(line_handle["text"])},
            {"readOnly": True},
        )
    else:
        print("Error when adding write protection: Line not found")


# function removes the read only first line so that solution can be inserted
def remove_read_only():
    for mark in current_editor.getAllMarks():
        mark.clear()


# function is called by paste_solution to insert solution to code editor
def setCodeMirrorContent(newContent):
    remove_read_only()
    current_editor.setValue(clean_code(newContent))
    add_read_only()


# function is called by run_code to return value of code editor
def getCodeMirrorContent(level):
    if editors[level]:
        return editors[level].getValue()
    return ""


# function sets theme of code editor of given level
def set_theme(theme):
    if current_editor != None:
        current_editor.setOption("theme", theme)


# function hides editor on level switch
def hide_editor(level):
    document["code-editor-" + str(level)].style.display = "none"


# function shows editor on level switch
def show_editor(level):
    global current_editor
    current_editor = editors[level]
    document["code-editor-" + str(level)].style.display = "block"
