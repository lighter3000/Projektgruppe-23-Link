from browser import document

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
    print("run_code")

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