extends Control
@onready var setting_options = $Setting_Options
@onready var video = $Video
@onready var audio = $Audio

# Called when the node enters the scene tree for the first time.
func _ready():
	$Setting_Options/VBoxContainer/Video.grab_focus()
	apply_settings()

# Called every frame. 'delta' is the elapsed time since the previous frame.
func _process(_delta):
	if Input.is_action_just_pressed("ui_cancel"):
		get_tree().change_scene_to_file("res://main_menu/mainmenu.tscn")

# shows given first node and hides given second node
func show_and_hide(first, second):
	first.show()
	second.hide()

func _on_video_pressed():
	show_and_hide(video, setting_options)
	$Video/HBoxContainer/Buttons/Full_Screen_Button.grab_focus()

func _on_audio_pressed():
	show_and_hide(audio, setting_options)
	$Audio/HBoxContainer/Sliders/SoundFX_Slider.grab_focus()

func _on_back_from_options_button_pressed():
	get_tree().change_scene_to_file("res://main_menu/mainmenu.tscn")

func _on_full_screen_button_toggled(button_pressed):
	if button_pressed == true:
		DisplayServer.window_set_mode(DisplayServer.WINDOW_MODE_FULLSCREEN)
	else:
		DisplayServer.window_set_mode(DisplayServer.WINDOW_MODE_MAXIMIZED)
	SaveSettings.set_full_screen_activation(button_pressed)

func _on_v_sync_button_toggled(button_pressed):
	if button_pressed == true:
		DisplayServer.window_set_vsync_mode(DisplayServer.VSYNC_ENABLED)
	else:
		DisplayServer.window_set_vsync_mode(DisplayServer.VSYNC_DISABLED)
	SaveSettings.set_vsync_activation(button_pressed)

func _on_back_from_video_button_pressed():
	show_and_hide(setting_options, video)
	$Setting_Options/VBoxContainer/Video.grab_focus()

func _on_master_slider_value_changed(value):
	intitialClass.volume(intitialClass.AudioBus.MASTER, value)
	SaveSettings.set_master_volume(value)

func _on_music_slider_value_changed(value):
	intitialClass.volume(intitialClass.AudioBus.MUSIC, value)
	SaveSettings.set_music_volume(value)

func _on_sound_fx_slider_value_changed(value):
	intitialClass.volume(intitialClass.AudioBus.Sound_EFFFECTS, value)
	SaveSettings.set_sound_effects_volume(value)

func _on_back_from_audio_button_pressed():
	show_and_hide(setting_options, audio)
	$Setting_Options/VBoxContainer/Video.grab_focus()

func apply_settings():
	$Video/HBoxContainer/Buttons/Full_Screen_Button.button_pressed = SaveSettings.is_full_screen_activated()
	$Video/HBoxContainer/Buttons/VSync_Button.button_pressed = SaveSettings.is_vsync_activated()
	$Audio/HBoxContainer/Sliders/Master_Slider.value = SaveSettings.get_master_volume()
	$Audio/HBoxContainer/Sliders/Music_Slider.value = SaveSettings.get_music_volume()
	$Audio/HBoxContainer/Sliders/SoundFX_Slider.value = SaveSettings.get_sound_effects_volume()
