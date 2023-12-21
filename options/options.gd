extends Control
@onready var setting_options = $Setting_Options


# Called when the node enters the scene tree for the first time.
func _ready():
	$Setting_Options/HBoxContainer/Buttons/Full_Screen_Button.grab_focus()
	apply_settings()


# Called every frame. 'delta' is the elapsed time since the previous frame.
func _process(_delta):
	if Input.is_action_just_pressed("ui_cancel"):
		get_tree().change_scene_to_file("res://main_menu/mainmenu.tscn")


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


func apply_settings():
	$Setting_Options/HBoxContainer/Buttons/Full_Screen_Button.button_pressed = SaveSettings.is_full_screen_activated()
	$Setting_Options/HBoxContainer/Buttons/VSync_Button.button_pressed = SaveSettings.is_vsync_activated()
