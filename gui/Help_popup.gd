extends Popup

var message

# Called when the node enters the scene tree for the first time.
func _ready():
	message = get_node("help_message")
	if get_parent().get_parent().is_in_group("level1"):
		$help_message.text = "While the number is smaller then 10, increase it by 1."

# Called every frame. 'delta' is the elapsed time since the previous frame.
func _process(_delta):
	pass
