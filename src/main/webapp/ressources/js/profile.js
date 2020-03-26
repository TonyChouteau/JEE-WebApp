function verifySecondPassword() {
    if (document.getElementById("fpassword1").value != document.getElementById("fpassword2").value) {
        document.getElementById("fpassword2").style["border"] = "1px solid red";
    } else {
        document.getElementById("fpassword2").style["border"] = "0px #00000000";
    }
}

function getDate(str) {
    const eq = {
        "janvier"   : 1,
        "février"   : 2,
        "mars"      : 3,
        "avril"     : 4,
        "mai"       : 5,
        "juin"      : 6,
        "juillet"   : 7,
        "aout"      : 8,
        "septembre" : 9,
        "octobre"   : 10,
        "novembre"  : 11,
        "decembre"  : 12,
    }
    
    let a = str.split(/[\s,]+/);
    
}

function loadData() {
    loadProfilePic();
    loadProfileInfo();
    /*loadCurrentGame();
    loadPastGames();*/
}
function loadProfilePic(){
    document.getElementById("picture").innerHTML = `
        <svg id="profile-picture" data-jdenticon-value="`+pseudo+`"></svg>
    `
}
function loadProfileInfo() {
    //fetch to get players personal information
    fetch('/getPlayer').then(response => {
        return response.json()
    }).then(data => {
        document.getElementById("femail").value = data.email;
        document.getElementById("fusername").value = data.pseudo;
    })
}
/*function loadCurrentGame() {
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
}*/