extends Node

class_name SaveSettings

static var settings: Dictionary = {
	'audio': {
		'master': 0.25,
		'music': 0.25,
		'sound_effects': 0.25
	},
	'video': {
		'full_screen': true,
		'vsync': true
	}
}

static var original_settings: Dictionary
static var auto_flush = false

static  func load_settings():
	var json_as_text = FileAccess.get_file_as_string('res://settings.json')
	var json_as_dict = JSON.parse_string(json_as_text)

	if json_as_dict:
		if json_as_dict.has('audio'):
			var audio_dict = json_as_dict['audio']

			if audio_dict.has('master'):
				settings['audio']['master'] = audio_dict['master']
			if audio_dict.has('music'):
				settings['audio']['music'] = audio_dict['music']
			if audio_dict.has('sound_effects'):
				settings['audio']['sound_effects'] = audio_dict['sound_effects']

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

static func audio():
	return settings['audio']

static func video():
	return settings['video']

static func parse_volume_for_slider(volume):
	if volume <= 1:
		return volume * 100

	return volume

static func parse_volume_for_save(volume):
	if volume <= 1:
		return volume

	return volume / 100

static func get_master_volume():
	return parse_volume_for_slider(audio()['master'])

static func set_master_volume(volume):
	audio()['master'] = parse_volume_for_save(volume)

	if auto_flush:
		save_settings()

static func get_music_volume():
	return parse_volume_for_slider(audio()['music'])

static func set_music_volume(volume):
	audio()['music'] = parse_volume_for_save(volume)

	if auto_flush:
		save_settings()

static func get_sound_effects_volume():
	return parse_volume_for_slider(audio()['sound_effects'])

static func set_sound_effects_volume(volume):
	audio()['sound_effects'] = parse_volume_for_save(volume)

	if auto_flush:
		save_settings()

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
