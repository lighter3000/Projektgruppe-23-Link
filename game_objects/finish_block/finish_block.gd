class_name Finish_Block
extends Area2D


signal finish_block_clicked(node: Node)


var predecessor = null


func _on_connector_detector_input_event(_viewport, event, _shape_idx):
	if event is InputEventMouseButton and event.pressed and event.button_index == MOUSE_BUTTON_LEFT:
		emit_signal("finish_block_clicked", self)


func _on_object_connector_connection_to_finish_block(node):
	if not node.is_in_group("finish_block"):
		predecessor = node
	print("Endblock predecessor: %s" %predecessor)
