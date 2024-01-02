class_name level_1
extends Node2D


var starting_value = 0
var value
var wrong_block = false

@onready var wrong_drag_areas = [$DragArea, $DragArea2, $DragArea3, $DragArea4, $DragArea6]


func _on_gui_start():
	print("\nstart button pressed!\n")
	for area in wrong_drag_areas:
		if area.has_block():
			wrong_block = true

	if wrong_block == false:
		if $DragArea5.has_block():
			var block = $DragArea5.get_block_node()
			value = block.execute(starting_value)
		if value == 5:
			print("\nErgebniss: ", value, "\n")
			SaveSettings.set_lvl1_status(true)
			$Output.text = "Congratulations!"
		else:
			print("Wrong Block!")
			$Output.text = "Try again!"
	else:
		print("Block placed on a wrong area")
