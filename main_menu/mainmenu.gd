extends Control


# Called when the node enters the scene tree for the first time.
func _ready():
	pass


# Called every frame. 'delta' is the elapsed time since the previous frame.
func _process(_delta):
	pass


func _on_quit_game_texture_button_pressed():
	get_tree().quit()


func _on_options_game_texture_button_2_pressed():
	get_tree().change_scene_to_file("res://options/options.tscn")


func _on_start_game_texture_button_pressed():
	get_tree().change_scene_to_file("res://level_overview/level_overview.tscn")
