
function loadGames(){
    //fetch to get past games
    
    fetch("/getGames")

    for (let i in data){
        document.getElementById("games-list").innerHTML+=`
            <div class="gamelist-item">
                <div class="game">
                    `+data[i]+`
                </div>
            </div>
        `;
    }
}