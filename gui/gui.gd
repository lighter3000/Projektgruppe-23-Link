class_name GUI
extends Node2D

signal start()
var help_popup


func _on_ready():
	help_popup = get_node("Help_popup")
	if get_parent().is_in_group("level1"):
		$Control/MarginContainer/VBoxContainer/toolbar_top_margin/toolbar_top/left_items/title.text = "Level 1"
	elif get_parent().is_in_group("level2"):
		$Control/MarginContainer/VBoxContainer/toolbar_top_margin/toolbar_top/left_items/title.text = "Level 2"
	elif get_parent().is_in_group("level3"):
		$Control/MarginContainer/VBoxContainer/toolbar_top_margin/toolbar_top/left_items/title.text = "Level 3"


func _on_back_button_pressed():
	get_tree().change_scene_to_file("res://level_overview/level_overview.tscn")


func _on_delete_button_pressed():
	get_tree().reload_current_scene()


func _on_help_button_pressed():
	help_popup.popup()


func _on_start_button_pressed():
	emit_signal("start")

