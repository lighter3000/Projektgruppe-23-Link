extends Node

class_name intitialClass

enum AudioBus {
	MASTER = 0,
	MUSIC = 1,
	Sound_EFFFECTS = 2
}

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

	intitialClass.volume(AudioBus.MASTER, SaveSettings.get_master_volume())
	intitialClass.volume(AudioBus.MUSIC, SaveSettings.get_music_volume())
	intitialClass.volume(AudioBus.Sound_EFFFECTS, SaveSettings.get_sound_effects_volume())

func _process(_delta):
	pass

static func volume(bus_index, value):
	AudioServer.set_bus_volume_db(bus_index, value)
