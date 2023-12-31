extends "res://game_objects/Drag&Drop/dragObject.gd"
class_name If_Block

func execute(number):
	print("if executed successfully")
	print("\nNow go and do something with the Number (Currently: ", number, " )\n")
	return number;

func set_block_name():
	block = "if_block"

