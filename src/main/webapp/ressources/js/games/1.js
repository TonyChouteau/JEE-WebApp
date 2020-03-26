
function loadGame(){
    //Nothing for now
}
let playing = false;
let score = 0;
function playingButton() {
    playing = !playing;
}
setInterval(() => {
    play()
}, 1000)
function play(){
    if (playing){
        score ++;
        document.getElementById("score").innerHTML = score;
        console.log(score);
    }
}