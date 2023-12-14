extends StaticBody2D

var block_name = " "

func _ready():
	modulate = Color(Color.GRAY, 0.7)

func _process(_delta):
	if intitialClass.is_dragging:
		visible = true
	else:
		visible = false

func _print_block_name():
	print(self.get_node("."))
	print(block_name)

func get_block_name():
	return block_name
