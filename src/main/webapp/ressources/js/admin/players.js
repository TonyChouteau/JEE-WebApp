
function loadPlayers(){
    //fetch to get past games
    
    let content = `
        <h3 class="game-list-title">
            Players 
        </h3>
    `;

    fetch('/getListPlayers').then(response => {
        return response.json()
    }).then(data => {
        let adding = ""
        for (let i in data){
            adding+=`
                <div class="gamelist-item">
                    <div class="game player-id">
                        `+data[i].uid+`
                    </div>
                    <div class="verticalSeparator"></div>
                    <div class="game player-name">
                        `+data[i].pseudo+`
                    </div>
                    <div class="verticalSeparator"></div>
                    <div class="game player-address">
                        `+data[i].email+`
                    </div>
                    <div class="verticalSeparator"></div>
                    <button     onclick="changeStateGame(`+ data[i].uid +`, `+ data[i].banned +`)" class="game player-banabality" style="background-color:`+(data[i].banned?"red":"green")+`;">
                        `+(data[i].banned?"banned":"not banned")+`
                    </button>
                </div>
            `;
        }
        document.getElementById("games-list").innerHTML = content+adding;
    })
}

function changeStateGame(id, banned){
    console.log(id, banned);

    if (!banned) {
        fetch("/ban?uid="+id).then(() => {loadPlayers()})
    } else {
        fetch("/unban?uid="+id).then(() => {loadPlayers()})
    }
}
