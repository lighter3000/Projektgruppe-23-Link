extends "res://game_objects/Drag&Drop/dragObject.gd"
class_name If_Block

signal if_block_clicked(node: Node)


var predecessor = null
var successor_green = null
var successor_red = null

var set_predecessor = false
var set_successor_green = false
var set_successor_red = false

func _on_input_detector_input_event(_viewport, event, _shape_idx):
	if event is InputEventMouseButton and event.pressed and event.button_index == MOUSE_BUTTON_LEFT:
		if set_predecessor == false:
			set_predecessor = true
		emit_signal("if_block_clicked", self)


func _on_green_output_detector_input_event(_viewport, event, _shape_idx):
	if event is InputEventMouseButton and event.pressed and event.button_index == MOUSE_BUTTON_LEFT:
		if set_successor_green == false:
			set_successor_green = true
		emit_signal("if_block_clicked", self)


func _on_red_output_detector_input_event(_viewport, event, _shape_idx):
	if event is InputEventMouseButton and event.pressed and event.button_index == MOUSE_BUTTON_LEFT:
		if set_successor_red == false:
			set_successor_red = true
		emit_signal("if_block_clicked", self)


func _on_object_connector_connection_to_if_block(node):
	if node != self and node != predecessor and node != successor_green and node != successor_red:
		if set_predecessor == true:
			predecessor = node
			set_predecessor = false
			print("If-Block predecessor: %s" %predecessor)
		elif set_successor_green == true:
			successor_green = node
			set_successor_green = false
			print("If-Block successor (green): %s" %successor_green)
		elif set_successor_red == true:
			successor_red = node
			set_successor_red = false
			print("If-Block successor (red): %s" %successor_red)

