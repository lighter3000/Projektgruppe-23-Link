extends Node

class_name SaveSettings

static var settings: Dictionary = {
	'video': {
		'full_screen': true,
		'vsync': true
	}
}

static var original_settings: Dictionary
static var auto_flush = false

static  func load_settings():
	
	if not FileAccess.file_exists('res://settings.json'):
		save_settings()
	else:
		var json_as_text = FileAccess.get_file_as_string('res://settings.json')
		var json_as_dict = JSON.parse_string(json_as_text)

		if json_as_dict:
			if json_as_dict.has('video'):
				var video_dict = json_as_dict['video']

				if video_dict.has('full_screen'):
					settings['video']['full_screen'] = video_dict['full_screen']
				if video_dict.has('vsync'):
					settings['video']['vsync'] = video_dict['vsync']

	original_settings = settings.duplicate(true)


static func use_auto_flush():
	auto_flush = true


static func save_settings():
	if original_settings.hash() != settings.hash():
		var file = FileAccess.open('res://settings.json', FileAccess.WRITE)
		file.store_string(JSON.stringify(settings))
		file.close()


static func video():
	return settings['video']


static func is_full_screen_activated():
	return video()['full_screen']


static func set_full_screen_activation(active):
	video()['full_screen'] = active

	if auto_flush:
		save_settings()

static func is_vsync_activated():
	return video()['vsync']

static func set_vsync_activation(active):
	video()['vsync'] = active

	if auto_flush:
		save_settings()
