extends "res://game_objects/Drag&Drop/dragObject.gd"
class_name If_Block

func execute(number):
	if(number < 5):
		return true
	return false


func set_block_name():
	block = "if_block"

