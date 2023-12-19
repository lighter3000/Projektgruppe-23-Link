var inst = new Instrument();

function play_music(str) {
    inst.play(str);
}

function stop_music(){
    inst.silence();
}

function play_tone(str) {
    inst.tone(str);
}