extends Node2D

@onready var wrong_drag_areas = [$DragArea, $DragArea2, $DragArea6, $DragArea7, $DragArea8]
var wrong_block = false
var block = null
var starting_value = 0
var value
var value2

func _on_gui_start():
	print("\nstart button level 3 pressed!\n")
	
	for area in wrong_drag_areas:
		if area.has_block():
			wrong_block = true
	
	if wrong_block == false:
		if $DragArea3.has_block():
			block = $DragArea3.get_block_node()
			if not block.is_in_group("if_block"):
				print("while")
				value = block.execute(starting_value)
		
		if $DragArea4.has_block():
			block = $DragArea4.get_block_node()
			if block.is_in_group("if_block"):
				value = block.execute(value)
		
		if $DragArea5.has_block():
			block = $DragArea5.get_block_node()
			if block.is_in_group("end_block"):
				value2 = true
		
		if value and value2:
			print("Richtig!")
		else:
			print("Falsch!")
	else: 
		print("Block placed on a wrong area")
