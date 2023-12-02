class_name Start_Block
extends StaticBody2D


signal startblock_clicked(node: Node)


var successor = null


func _on_detector_input_event(_viewport, event, _shape_idx):
	if event is InputEventMouseButton and event.pressed and event.button_index == MOUSE_BUTTON_LEFT:
		emit_signal("startblock_clicked", self)


func _on_object_connector_connection_to_start_block(node):
	if node != self and node != successor:
		successor = node
		print("Startblock successor: %s" %successor)
