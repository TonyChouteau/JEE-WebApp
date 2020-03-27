function getDuration(a, b) {
    let t = (new Date(b)-new Date(a))/1000/60/60;
    let h = Math.floor(t);
    let m = Math.floor((t*60)%60)
    let s = (t*60*60)%60
    return (h!=0?(h+"h "):"")+(m!=0?(m+"m "):"")+s+"s" 
}


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
                    <div class="verticalSeparator"></div>
                    <div class="game past-duration">
                        `+getDuration(data[i].dateDebut, data[i].dateFin)+`
                    </div>
                </div>
            `;
        }
        document.getElementById("games-list").innerHTML = content+adding;
    })
}