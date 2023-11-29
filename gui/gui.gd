class_name GUI
extends Node2D

func _on_back_button_pressed():
	get_tree().change_scene_to_file("res://level_overview/level_overview.tscn")

