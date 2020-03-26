
function loadGames(){
    //fetch to get past games
    
    let content = `
        <h3 class="game-list-title">
            Available Games 
        </h3>
    `
    let adding = ""

    fetch('/getGames').then(response => {
        return response.json()
    }).then(data => {
        fetch('/getNbPlayers').then(response => {
            return response.json()
        }).then(data2 => {
            for (let i in data){
                if (data[i].available === true) {
                    let online = data2[data[i].gid]==undefined?0:data2[data[i].gid];
                    adding+=`
                        <a href=/play?gid=`+ data[i].gid +`>
                        <div class="gamelist-item">
                            <div class="game game-id">
                                `+data[i].gid+`
                            </div>
                            <div class="verticalSeparator"></div>
                            <div class="game game-name">
                                `+data[i].name+`
                            </div>
                            <div class="verticalSeparator"></div>
                            <div class="game game-online">
                                `+online+` online
                            </div>
                        </div>
                        </a>
                    `;
                }
            }
            document.getElementById("games-list").innerHTML = content+adding;
        })
    })
    
    
}