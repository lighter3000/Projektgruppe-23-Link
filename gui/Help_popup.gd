extends Popup

var message

# Called when the node enters the scene tree for the first time.
func _ready():
	message = get_node("help_message")
	if get_parent().get_parent().is_in_group("level1"):
		$help_message.text = "While the number is smaller then 5, increase it by 1."
	if get_parent().get_parent().is_in_group("level2"):
		$help_message.text = "Only Numbers equal to 8 are allowed."
	if get_parent().get_parent().is_in_group("level3"):
		$help_message.text = "Only Numbers equal to 6 are allowed."
