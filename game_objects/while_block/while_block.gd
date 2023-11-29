class_name While_Block
extends Area2D


signal while_block_clicked(node: Node)


var predecessor = null
var successor = null


func _on_object_connector_connection_to_while_block(node):
	pass # Replace with function body.


func _on_input_detector_input_event(viewport, event, shape_idx):
	if event is InputEventMouseButton and event.pressed and event.button_index == MOUSE_BUTTON_LEFT:
		emit_signal("while_block_clicked", self)
