extends Node2D

var _level1_texture1 = load("res://assets/icons/level1_button/lvl_1_button.png")
var _level1_texture2 = load("res://assets/icons/level1_button/lvl_1_hovered_button.png")
var _level1_texture3 = load("res://assets/icons/level1_button/lvl_1_completed_button.png")
var _level1_texture4 = load("res://assets/icons/level1_button/lvl_1_completed_hovered_button.png")

var _level2_texture1 = load("res://assets/icons/level2_button/lvl_2_button.png")
var _level2_texture2 = load("res://assets/icons/level2_button/lvl_2_hovered_button.png")
var _level2_texture3 = load("res://assets/icons/level2_button/lvl_2_completed_button.png")
var _level2_texture4 = load("res://assets/icons/level2_button/lvl_2_completed_hovered_button.png")

var _level3_texture1 = load("res://assets/icons/level3_button/lvl_3_button.png")
var _level3_texture2 = load("res://assets/icons/level3_button/lvl_3_hovered_button.png")
var _level3_texture3 = load("res://assets/icons/level3_button/lvl_3_completed_button.png")
var _level3_texture4 = load("res://assets/icons/level3_button/lvl_3_completed_hovered_button.png")

# Called when the node enters the scene tree for the first time.
func _ready():
	_level_texture()


# Called every frame. 'delta' is the elapsed time since the previous frame.
func _process(_delta):
	pass


func _on_menu_button_pressed():
	get_tree().change_scene_to_file("res://main_menu/mainmenu.tscn")


func _on_level_1_button_pressed():
	get_tree().change_scene_to_file("res://levels/level1/level_1.tscn")


func _on_level_2_button_pressed():
	get_tree().change_scene_to_file("res://levels/level2/level_2.tscn")


func _on_level_3_button_pressed():
	get_tree().change_scene_to_file("res://levels/level3/level_3.tscn")

func _level_texture():
	if SaveSettings.lvl1_status() == true:
		$HBoxContainer/VBoxContainer/Level_1_Button.texture_normal = _level1_texture3
		$HBoxContainer/VBoxContainer/Level_1_Button.texture_hover =_level1_texture4
	else:
		$HBoxContainer/VBoxContainer/Level_1_Button.texture_normal = _level1_texture1
		$HBoxContainer/VBoxContainer/Level_1_Button.texture_hover =_level1_texture2
		
	if SaveSettings.lvl2_status() == true:
		$HBoxContainer/VBoxContainer/Level_2_Button.texture_normal = _level2_texture3
		$HBoxContainer/VBoxContainer/Level_2_Button.texture_hover =_level2_texture4
	else:
		$HBoxContainer/VBoxContainer/Level_2_Button.texture_normal = _level2_texture1
		$HBoxContainer/VBoxContainer/Level_2_Button.texture_hover =_level2_texture2
		
	if SaveSettings.lvl3_status() == true:
		$HBoxContainer/VBoxContainer/Level_3_Button.texture_normal = _level3_texture3
		$HBoxContainer/VBoxContainer/Level_2_Button.texture_hover =_level3_texture4
	else:
		$HBoxContainer/VBoxContainer/Level_3_Button.texture_normal = _level3_texture1
		$HBoxContainer/VBoxContainer/Level_3_Button.texture_hover =_level3_texture2


