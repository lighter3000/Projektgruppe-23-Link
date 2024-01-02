extends "res://game_objects/while_block/while_block.gd"

func execute(number):
	while number < 8:
		number = number + 1
	return number
