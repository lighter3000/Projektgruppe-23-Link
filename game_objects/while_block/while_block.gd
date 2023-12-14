extends "res://game_objects/Drag&Drop/dragObject.gd"
class_name While_Block

signal while_block_clicked(node: Node)


var predecessor = null
var successor = null

var set_predecessor = false
var set_successor = false

func set_block_name():
	block = "while_block"

func _on_input_detector_input_event(_viewport, event, _shape_idx):
	if event is InputEventMouseButton and event.pressed and event.button_index == MOUSE_BUTTON_LEFT:
		if set_predecessor == false:
			set_predecessor = true
		emit_signal("while_block_clicked", self)


func _on_output_detector_input_event(_viewport, event, _shape_idx):
	if event is InputEventMouseButton and event.pressed and event.button_index == MOUSE_BUTTON_LEFT:
		if set_successor == false:
			set_successor = true
		emit_signal("while_block_clicked", self)


func _on_object_connector_connection_to_while_block(node):
	if node != self and node != predecessor and node != successor:
		if set_predecessor == true:
			predecessor = node
			set_predecessor = false
			print("While-Block predecessor: %s" %predecessor)
		elif set_successor == true:
			successor = node
			set_successor = false
			print("While-Block successor: %s" %successor)
