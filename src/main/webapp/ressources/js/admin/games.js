
function loadGames(){
    //fetch to get past games
    
    let content = `
        <h3 class="game-list-title">
            Available Games 
        </h3>
    `;

    fetch('/getGames').then(response => {
        return response.json()
    }).then(data => {
        let adding = ""
        for (let i in data){
            adding+=`
                <div class="gamelist-item">
                    <div class="game game-id">
                        `+data[i].gid+`
                    </div>
                    <div class="verticalSeparator"></div>
                    <div class="game game-name">
                        `+data[i].name+`
                    </div>
                    <div class="verticalSeparator"></div>
                    <button     onclick="changeStateGame(`+ data[i].gid +`, `+ data[i].available +`)" class="game game-availability" style="background-color:`+(data[i].available?"green":"red")+`;">
                        `+(data[i].available?"available":"disable")+`
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
        fetch("/removeGame?gid="+id).then(() => {loadGames()})
    } else {
        fetch("/addGame?gid="+id).then(() => {loadGames()})
    }
}
