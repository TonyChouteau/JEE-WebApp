
function loadGames(){
    //fetch to get past games
    

    fetch('/getGames').then(response => {
        return response.json()
    }).then(data => {
        console.log(data)
        for (let i in data){
            document.getElementById("games-list").innerHTML+=`
                <a href=/play?gid=`+ data[i].gid +`>
                <div class="gamelist-item">
                    <div class="game">
                        `+data[i].gid+`
                    </div>
                    <div class="game">
                        `+data[i].name+`
                    </div>
                </div>
                </a>
            `;
        }
    })
    
    
}