class_name Start_Block
extends Area2D


signal startblock_clicked(node: Node)


var successor = null


func _on_detector_input_event(_viewport, event, _shape_idx):
	if event is InputEventMouseButton and event.pressed and event.button_index == MOUSE_BUTTON_LEFT:
		emit_signal("startblock_clicked", self)


func _on_object_connector_connection_to_start_block(node):
	if not node.is_in_group("start_block"):
		successor = node
	print("Startblock successor: %s" %successor)
