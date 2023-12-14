extends StaticBody2D

var block = " "
var draggable = false
var is_inside_dropable = false
var is_ontop = false
var body_ref
var offset : Vector2
var initialPos : Vector2

func _process(_delta):
	if draggable:
		if Input.is_action_just_pressed("click"):
			initialPos = global_position
			offset = get_global_mouse_position() - global_position
			intitialClass.is_dragging = true
		if Input.is_action_pressed("click"):
			global_position = get_global_mouse_position() - offset
		elif Input.is_action_just_released("click"):
			intitialClass.is_dragging = false
			var tween = get_tree().create_tween()
			if is_inside_dropable and !is_ontop:
				tween.tween_property(self,"position",body_ref.position,0.05).set_ease(Tween.EASE_OUT)
			else:
				tween.tween_property(self,"global_position",initialPos,0.05).set_ease(Tween.EASE_OUT)

func _on_area_2d_mouse_entered():
	if not intitialClass.is_dragging and !Input.is_action_pressed("click"):
		set_block_name()
		draggable = true
		scale = Vector2(1.1,1.1)

func _on_area_2d_mouse_exited():
	if not intitialClass.is_dragging:
		draggable = false
		scale = Vector2(1,1)

#If the body, wich the object enters/leaves has the group dropable, set is_inside_dropable variable to true/false
#If the body the object enters/leaves has the group collision, set collision variable to true/false
func _on_area_2d_body_entered(body:StaticBody2D):
	if body.is_in_group('dropable'):
		is_inside_dropable = true
		body.modulate = Color(Color.LIGHT_GRAY,1)
		
		#if body.block_name == " ":
		#	body.block_name = block
		
		if !body.is_in_group('busy'):
			self.add_to_group('busy')
			body.add_to_group('busy')
			body.block_name = block
		
		body._print_block_name()
		
		body_ref = body
	if body.is_in_group("collision"):
		is_ontop = true
	
	
func _on_area_2d_body_exited(body:StaticBody2D):
	if body.is_in_group('dropable'):
		is_inside_dropable = false
		body.modulate = Color(Color.LIGHT_GRAY,0.7)
		
		#if self.block == body.block_name:
		#	body.block_name = " "
		
		if body.is_in_group('busy') and self.is_in_group('busy'):
			body.remove_from_group('busy')
			self.remove_from_group('busy')
			body.block_name = " "
		
		body._print_block_name()
		
	if body.is_in_group("collision"):
		is_ontop = false

func set_block_name():
	block = " "
