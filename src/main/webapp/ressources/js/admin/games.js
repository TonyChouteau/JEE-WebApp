
function changeStateGame(id, available){
    console.log(id, available);

    if (available) {
        fetch("/removeGame?gid="+id)
    } else {
        fetch("/addGame?gid="+id)
    }
}

function loadGames(){
    //fetch to get past games
    

    fetch('/getGames').then(response => {
        return response.json()
    }).then(data => {
        console.log(data)
        for (let i in data){
            document.getElementById("games-list").innerHTML+=`
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
    })
    
    
}