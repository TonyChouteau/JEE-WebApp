
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
                    <button     onclick="changeStateGame(`+ data[i].gid +`, `+ data[i].banned +`)" class="game player-availability" style="background-color:`+(data[i].banned?"green":"red")+`;">
                        `+(data[i].banned?"available":"disable")+`
                    </button>
                </div>
            `;
        }
        document.getElementById("games-list").innerHTML = content+adding;
    })
}

function changeStateGame(id, available){
    console.log(id, available);

    if (available) {
        fetch("/ban?uid="+id).then(() => {loadPlayers()})
    } else {
        fetch("/unban?uid="+id).then(() => {loadPlayers()})
    }
}
