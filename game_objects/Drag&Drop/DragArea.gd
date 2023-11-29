extends StaticBody2D

func _ready():
	modulate = Color(Color.GRAY, 0.7)

func _process(_delta):
	if intitialClass.is_dragging:
		visible = true
	else:
		visible = false
