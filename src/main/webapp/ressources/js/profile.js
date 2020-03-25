function verifySecondPassword() {
    if (document.getElementById("fpassword1").value != document.getElementById("fpassword2").value) {
        document.getElementById("fpassword2").style["border"] = "1px solid red";
    } else {
        document.getElementById("fpassword2").style["border"] = "0px #00000000";
    }
}

function loadData() {
    loadProfileInfo();
    loadCurrentGame();
    loadPastGames();
}
function loadProfileInfo() {
    //fetch to get players personal information
}
function loadCurrentGame() {
    data = "Game 1";
    document.getElementById("current-game").innerHTML = data;
}
function loadPastGames(){
    //fetch to get past games
    data = [
        "Game1",
        "Game2",
        "Game3",
    ]
    for (let i in data){
        document.getElementById("past-games").innerHTML+=`
            <div class="gamelist-item">
                <div class="game">
                    `+data[i]+`
                </div>
            </div>
        `;
    }
}