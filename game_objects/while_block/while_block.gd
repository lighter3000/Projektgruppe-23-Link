extends "res://game_objects/Drag&Drop/dragObject.gd"
class_name While_Block

func execute(number):
	while number < 5:
		number = number + 1
	print("while executed successfully")
	return number

func set_block_name():
	block = "while_block"
