
<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Strict//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd'>
<html xml:lang="fr" lang="fr">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab&display=swap" rel="stylesheet">
    <title>Fluffy Gaming Center
    </title>
    <link rel="shortcut icon" href="/ressources/img/logo.png">
    <style>
        html,
        body {
            margin: 0;
            padding: 0;
            background: rgb(171, 28, 161);
            background: linear-gradient(45deg, rgb(192, 80, 186) 0%, rgba(184, 0, 255, 1) 100%);
            min-height: 100vh;
            width: 100vw;
            color: black;
            /*rgb(223, 25, 209);*/
            font-family: 'Josefin Slab', serif;
        }

        #page {
            z-index: 1;
            margin: 0;
            padding: 0;
            background: transparent;
            width: 100vw;
            height: 100vh;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: start;
        }
        
        #menu-panel {
            margin: 0;
            padding: 0;
            background: white;
            border-radius: 0 0 5px 5px;
            width: 1200px;
            height: 50px;
            display: flex;
			flex-direction : row;
            text-align: center;
            justify-content: center;
        }
        
        #content-panel {
            margin: 20px 0 0 0;
            padding: 0;
            background: white;
            border-radius: 5px;
            width: 1200px;
            display: flex;
            flex-direction: column;
            text-align: start;
            justify-content: start;
        }
        
        #centered-text {
            margin: 0;
            padding: 0;
        }
        
        #menu {
            margin:  0;
            padding: 0;
            width: 80%;
            height: 100%;
			font-size: 20px;
            display: flex;
			flex-direction : row;
            text-align: center;
            justify-content: center;
        }
        .menu-item{
            margin-left: 10%;
            margin-right: 10%;
            display: flex;
			flex-direction : column;
            text-align: center;
            justify-content: center;
        }
        #title {
            width: 20%;
            height: 100%;
			font-size: 20px;
        }
        #game-title{
            text-align: center;
        }
        #game {
            border-radius: 5px;
            width: calc(100%-20px);
            height:  500px;
            margin : 0 10px 0 10px;
            background-color: black;
            display: flex;
			flex-direction : column;
            text-align: center;
            justify-content: center;
        }
        #score{
            color: white;
        }
        #buttons{
            margin: 20px 0 20px 0;
            display: flex;
			flex-direction : row;
            text-align: center;
            justify-content: center;
        }
        .button {
            font-family: 'Josefin Slab', serif;
            font-size: larger;
            margin: 0;
            padding: 0;
            background: rgb(228, 228, 228);
            height: 50px;
            width: 10vh;
            min-width: 295px;
            margin: 0 auto;
            border: 0;
            text-align: center;
            border-radius: 5px;
            color: rgb(235, 66, 223);
        }
        .button:hover {
            background: rgb(233, 233, 233);
        }
        
        .button:active {
            background: rgb(235, 66, 223);
            color: white;
        }
    </style>
    <script type="text/javascript">
        function loadGame(){
            //Nothing for now
        }
        let playing = false;
        let score = 0;
        function playingButton() {
            playing = !playing;
        }
        setInterval(() => {
            play()
        }, 1000)
        function play(){
            if (playing){
                score ++;
                document.getElementById("score").innerHTML = score;
                console.log(score);
            }
        }
    </script>
</head>

<body onload="loadGame()">
    <div id="page">
        <div id="menu-panel">
            <h1 id="menu">
                <div class="menu-item">
                    <div>
                        Games
                    </div>
                </div>
                <div class="menu-item">
                    <div>
                        Players
                    </div>
                </div>
                <div class="menu-item">
                    <div>
                        Games
                    </div>
                </div>
            </h1>
            <div class="verticalSeparator"></div>
            <h1 id="title">
                <div>
                    <%=username%>
                </div>
            </h1>
        </div>
        <div id="content-panel">
            <h3 id="game-title">
                <%=gameName>
            </h3>
            <div id="game" onclick="play()">
                <h2 id="score">
                    0
                </h2>
            </div>
            <div id="buttons">
                    <button class="button" onclick="playingButton()">
                        Play
                    </button>
            </div>
        </div>
    </div>
</body>

</html>
