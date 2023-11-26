class_name If_Block
extends Area2D


signal if_block_clicked(node: Node)


@onready var sprite = $if_block_sprite
@onready var if_block_collisionshape = $if_block_collisionshape
@onready var input_connector_collisionshape = $input_detector/input_connector_collisionshape
@onready var green_output_connector_collisionshape = $green_output_detector/green_output_connector_collisionshape
@onready var red_output_connector_collisionshape = $red_output_detector/red_output_connector_collisionshape


var predecessor = null
var successor_green = null
var successor_red = null


# Called when the node enters the scene tree for the first time.
#func _ready():
#	pass # Replace with function body.


# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass


func _on_gui_connection_to_if_block(_node):
	pass # Replace with function body.
