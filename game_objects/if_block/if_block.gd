class_name If_Block
extends StaticBody2D


signal if_block_clicked(node: Node)


var predecessor = null
var successor_green = null
var successor_red = null


func _on_red_output_detector_input_event(_viewport, event, _shape_idx):
	if event is InputEventMouseButton and event.pressed and event.button_index == MOUSE_BUTTON_LEFT:
		emit_signal("if_block_clicked", self)


func _on_object_connector_connection_to_if_block(node):
	if not node.is_in_group("if_block"):
		print("yes!")
