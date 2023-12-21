extends Node2D


# Called when the node enters the scene tree for the first time.
func _ready():
	pass # Replace with function body.


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
