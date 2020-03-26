
function loadPast(){
    //fetch to get past games
    
    let content = `
        <h3 class="game-list-title">
            Past Games
        </h3>
    `;

    fetch('/getPastGames').then(response => {
        return response.json()
    }).then(data => {
        let adding = ""
        for (let i in data){
            console.log(i)
            adding+=`
                <div class="gamelist-item">
                    <div class="game current-id">
                        `+data[i].pid+`
                    </div>
                    <div class="verticalSeparator"></div>
                    <div class="game past-info">
                        `+data[i].nameUser+`
                    </div>
                    <div class="verticalSeparator"></div>
                    <div class="game past-info">
                        `+data[i].nameGame+`
                    </div>
                    <div class="verticalSeparator"></div>
                    <div class="game past-info">
                        `+data[i].dateDebut+`
                    </div>
                    <div class="verticalSeparator"></div>
                    <div class="game past-info">
                        `+data[i].dateFin+`
                    </div>
                </div>
            `;
        }
        document.getElementById("games-list").innerHTML = content+adding;
    })
}