class_name level_1
extends Node2D

var starting_value = 0;
var value;

# Called every frame. 'delta' is the elapsed time since the previous frame.
func _process(_delta):
	pass


func _ready():
	pass


func _on_gui_start():
	print("\nstart button pressed!\n")
	if $"Level-Objects/DragArea5".has_block():
		var block = $"Level-Objects/DragArea5".get_block_node()
		value = block.execute(starting_value)
	
	if value == 5:
		print("\nErgebniss: ", value, "\n")
