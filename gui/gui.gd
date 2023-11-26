class_name GUI
extends Node2D


signal connection_to_start_block(node: Node)
signal connection_to_end_block(node: Node)
signal connection_to_if_block(node: Node)
signal connection_to_while_block(node: Node)


var first_clicked = null


# Called when the node enters the scene tree for the first time.
func _ready():
	pass # Replace with function body.


# Called every frame. 'delta' is the elapsed time since the previous frame.
func _process(_delta):
	pass


func _on_back_button_pressed():
	get_tree().change_scene_to_file("res://level_overview/level_overview.tscn")


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
		#draw Line2D
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
