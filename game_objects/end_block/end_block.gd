class_name End_Block
extends Area2D


signal endblock_clicked(node: Node)


@onready var sprite = $end_block_sprite
@onready var end_block_collisionshape = $end_block_collisionshape
@onready var connector_collisionshape = $Area2D/connector_collisionshape

var predecessor = null
# Called when the node enters the scene tree for the first time.
#func _ready():
#	pass # Replace with function body.


# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass


func _on_gui_connection_to_end_block(node):
	if node != self:
		predecessor = node
	print("Endblock predecessor: %s" %predecessor)


func _on_area_2d_input_event(_viewport, event, _shape_idx):
	if event is InputEventMouseButton and event.pressed and event.button_index == MOUSE_BUTTON_LEFT:
		emit_signal("endblock_clicked", self)
