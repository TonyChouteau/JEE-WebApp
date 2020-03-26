
function loadGame(){
    //Nothing for now
}
let playing = false;
let score = 0;
function playingButton() {
    playing = !playing;
    if (playing){
        document.getElementById("play-button").innerHTML = "Pause";
    } else {
        document.getElementById("play-button").innerHTML = "Continue";
    }
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
function submitScore(){
    playing = false;
    document.getElementById("play-button").setAttribute("disabled","disabled");
    document.getElementById("submit-button").setAttribute("disabled","disabled");

    document.getElementById("play-button").innerHTML = "End";

    fetch("/submitScore", {
        method:'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            "uid"   : userID,
            "gid"   : gameID,
            "score" : score,
        })
    })

    document.getElementById("buttons").innerHTML = `
        <a href="/play?gid=` + gameID + `" class="new-button">
            <button id="play-button" class="button" href="/play">
                Restart
            </button>
        </a>
        <a href="/home" class="new-button">
            <button id="submit-button" class="button" onclick="submitScore()">
                Leave
            </button>
        </a>
    `
}