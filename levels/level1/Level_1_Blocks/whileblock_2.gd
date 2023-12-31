extends "res://game_objects/while_block/while_block.gd"

func execute(number):
	while number < 2:
		number = number + 1
	return number
