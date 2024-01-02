extends Node

@onready var wrong_drag_areas = [$DragArea3, $DragArea4, $DragArea5, $DragArea6]
var starting_value = 8
var wrong_block = false
var value1 = false
var value2 = false
var block = null

func _on_gui_start():
	print("\nstart button level 2 pressed!\n")
	
	for area in wrong_drag_areas:
		if area.has_block():
			wrong_block = true
	
	if wrong_block == false:
		if $DragArea.has_block():
			block = $DragArea.get_block_node()
			if block.is_in_group("if_block"):
				value1 = block.execute(starting_value)
		
		if $DragArea2.has_block():
			block = $DragArea2.get_block_node()
			if block.is_in_group("end_block"):
				value2 = true
		
		if value1 && value2:
			print("Richtig!")
			SaveSettings.set_lvl2_status(true)
		else:
			print("Falsch!")
	else: 
		print("Block placed on a wrong area")
