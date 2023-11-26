class_name Start_Block
extends Area2D

signal startblock_clicked(node: Node)

@onready var sprite = $start_block_sprite
@onready var block_collision_shape = $block_collisionshape
@onready var connector_collision_shape = $connector_detector/connector_collisionshape


var successor = null


# Called when the node enters the scene tree for the first time.
#func _ready():
#	


# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass


func _on_detector_input_event(_viewport, event, _shape_idx):
	if event is InputEventMouseButton and event.pressed and event.button_index == MOUSE_BUTTON_LEFT:
		emit_signal("startblock_clicked", self)


func _on_gui_connection_to_start_block(node):
	if node != self:
		successor = node
	print("Startblock successor: %s" %successor)
