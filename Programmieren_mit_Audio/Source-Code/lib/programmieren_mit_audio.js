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

function play_tone_array(toneArray){
    let index = 0;

    function playNextTone() {
      if (index < toneArray.length) {
        play_tone(toneArray[index]);
        index++;
        setTimeout(playNextTone, 800);
      }
    }
  
    playNextTone();
}