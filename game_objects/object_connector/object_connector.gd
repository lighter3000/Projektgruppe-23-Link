class_name Object_Connector
extends Node2D


signal connection_to_start_block(node: Node)
signal connection_to_end_block(node: Node)
signal connection_to_if_block(node: Node)
signal connection_to_while_block(node: Node)
signal connection_to_finish_block(node: Node)

var first_clicked = null

func _on_start_block_startblock_clicked(node):
	if first_clicked == null:
		first_clicked = node
	elif first_clicked != node: 
		emit_signal("connection_to_start_block", first_clicked)
		if first_clicked.is_in_group("if_block"):
			emit_signal("connection_to_if_block", node)
		elif first_clicked.is_in_group("while_block"):
			emit_signal("connection_to_while_block", node)
		elif first_clicked.is_in_group("end_block"):
			emit_signal("connection_to_end_block", node)
		first_clicked = null


func _on_end_block_endblock_clicked(node):
	if first_clicked == null:
		first_clicked = node
	elif first_clicked != node: 
		emit_signal("connection_to_end_block", first_clicked)
		if first_clicked.is_in_group("if_block"):
			emit_signal("connection_to_if_block", node)
		elif first_clicked.is_in_group("while_block"):
			emit_signal("connection_to_while_block", node)
		elif first_clicked.is_in_group("start_block"):
			emit_signal("connection_to_start_block", node)
		first_clicked = null


func _on_if_block_if_block_clicked(node):
	if first_clicked == null:
		first_clicked = node
	else:
		emit_signal("connection_to_if_block", first_clicked)
		first_clicked = null


func _on_while_block_while_block_clicked(_node):
	pass # Replace with function body.


func _on_finish_block_finish_block_clicked(_node):
	pass # Replace with function body.
