from browser import document, window

from modules import code_mirror

# button function toggles theme of web application
def toggle_application_theme(ev):
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

    set_highlighting_theme()
    set_navbar_image()

# function sets theme of code editor of current level
def set_highlighting_theme():
    if (document["dark-mode-button"].text == "Dark Mode"):
        code_mirror.set_theme("vscode-light")
    else:
        code_mirror.set_theme("vscode-dark")

# function sets application theme on system settings
def set_application_theme_on_system_settings():
    dark = window.matchMedia("(prefers-color-scheme:dark)").matches
    if dark:
        toggle_application_theme(None)

# function sets navbar image on theme change
def set_navbar_image():
    navbar_image = document["navbar-image"]
    
    if (document["dark-mode-button"].text == "Dark Mode"):
        navbar_image.src = "images/turtle_lightmode.png"
    else:
        navbar_image.src = "images/turtle_darkmode.png"