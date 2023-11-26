class_name While_Block
extends Area2D


signal while_block_clicked(node: Node)


@onready var sprite = $while_block_sprite
@onready var while_block_collisionshape = $while_block_collisionshape
@onready var input_connector_collisionshape = $input_detector/input_connector_collisionshape
@onready var output_connector_collisionshape = $output_detector/output_connector_collisionshape


var predecessor = null
var successor = null


# Called when the node enters the scene tree for the first time.
#func _ready():
#	pass # Replace with function body.


# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass


func _on_gui_connection_to_while_block(_node):
	pass # Replace with function body.
