extends "res://game_objects/Drag&Drop/dragObject.gd"
class_name End_Block


signal endblock_clicked(node: Node)


var predecessor = null


func _on_area_2d_input_event(_viewport, event, _shape_idx):
	if event is InputEventMouseButton and event.pressed and event.button_index == MOUSE_BUTTON_LEFT:
		emit_signal("endblock_clicked", self)


func _on_object_connector_connection_to_end_block(node):
	if not node.is_in_group("end_block"):
		predecessor = node
	print("Endblock predecessor: %s" %predecessor)
