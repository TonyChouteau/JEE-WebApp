
function loadCurrent(){
    //fetch to get past games
    
    let content = `
        <h3 class="game-list-title">
            Current Games
        </h3>
    `;

    fetch('/getCurrentGames').then(response => {
        return response.json()
    }).then(data => {
        let adding = ""
        for (let i in data){
            console.log(i)
            adding+=`
                <div class="gamelist-item">
                    <div class="game current-id">
                        `+parseInt(i+1)+`
                    </div>
                    <div class="verticalSeparator"></div>
                    <div class="game current-user">
                        `+data[i].username+`
                    </div>
                    <div class="verticalSeparator"></div>
                    <div class="game current-game">
                        `+data[i].gamename+`
                    </div>
                    <div class="verticalSeparator"></div>
                    <button onclick="cancelGame(`+ data[i].idUser +`)" class="game current-cancel">
                        Cancel
                    </button>
                </div>
            `;
        }
        document.getElementById("games-list").innerHTML = content+adding;
    })
}

function cancelGame(id){

    fetch("/endGame?uid="+id).then(() => {loadCurrent()})
}
