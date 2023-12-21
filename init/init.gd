extends Node

class_name intitialClass

static var is_dragging = false


# Called when the node enters the scene tree for the first time.
func _ready():
	SaveSettings.load_settings()
	SaveSettings.use_auto_flush()
	if SaveSettings.is_full_screen_activated():
		DisplayServer.window_set_mode(DisplayServer.WINDOW_MODE_FULLSCREEN)
	else:
		DisplayServer.window_set_mode(DisplayServer.WINDOW_MODE_MAXIMIZED)

	if SaveSettings.is_vsync_activated():
		DisplayServer.window_set_vsync_mode(DisplayServer.VSYNC_ENABLED)
	else:
		DisplayServer.window_set_vsync_mode(DisplayServer.VSYNC_DISABLED)
