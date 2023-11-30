class_name GUI
extends Node2D

var help_popup

func _on_ready():
	help_popup = get_node("Help_popup")

func _on_back_button_pressed():
	get_tree().change_scene_to_file("res://level_overview/level_overview.tscn")


func _on_delete_button_pressed():
	get_tree().reload_current_scene()


func _on_help_button_pressed():
	help_popup.popup()


