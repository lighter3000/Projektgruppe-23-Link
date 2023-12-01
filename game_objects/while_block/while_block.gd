extends "res://game_objects/Drag&Drop/dragObject.gd"
class_name While_Block

signal while_block_clicked(node: Node)


var predecessor = null
var successor = null


func _on_object_connector_connection_to_while_block(_node):
	pass # Replace with function body.


func _on_input_detector_input_event(_viewport, event, _shape_idx):
	if event is InputEventMouseButton and event.pressed and event.button_index == MOUSE_BUTTON_LEFT:
		emit_signal("while_block_clicked", self)
