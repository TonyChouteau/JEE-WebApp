
<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Strict//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd'>
<html xml:lang="fr" lang="fr">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab&display=swap" rel="stylesheet">
    <title>Fluffy Gaming Center
    </title>
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

        .verticalSeparator{
            height: 100%;
            width : 1px;
            background-color: black;
        }
        .horizontal-separator{
            width: 100%;
            height : 1px;
            background-color: lightgray;
        }

        #profile-top {
            width: 100%;
            height: 320px;
            display: flex;
            flex-direction: row;
        }
        #picture{
            border-radius: 5px;
            margin : 10px;
            height: 300px;
            width: 300px;
        }
        #edit-profile{
            border-radius: 0 5px 0 0;
            margin-right: 10px;
            height: 300px;
            width: 900px;
        }
        #profile-picture{
            width: 100%;
            height: 100%;
        }
        .centered-text {
            text-align: center;
            justify-content: center;
        }
        .register-input {
            margin: 0;
            padding: 0;
            background: rgb(228, 228, 228);
            height: 40px;
            width: 40vh;
            min-width: 295px;
            margin: 0 auto;
            border: 0;
            text-align: center;
            border-radius: 5px;
        }
        
        .register-button {
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
        
        .register-button:hover {
            background: rgb(233, 233, 233);
        }
        
        .register-button:active {
            background: rgb(235, 66, 223);
            color: white;
        }

        #form-profile{
            display: flex;
            flex-direction: row;
        }
        .column{
            width: 50%;
            height: 100%;
            margin: 10px;
            display: flex;
            flex-direction: column;
        }
        
        #profile-bottom {
            width: calc(100% - 20px);
            margin: 0 10px 0 10px;
            display: flex;
			flex-direction : column;
            text-align: center;
            justify-content: center;
        }
        #game-list-title{
            margin: 10px 0 20px 0;
        }
        #games-title {
            width: 80%;
        }
        .gamelist-item {
            border: solid 1px black;
            border-radius: 5px;
            width: 100%;
            height: 70px;
            margin-bottom: 10px;
            background-color: rgb(228, 228, 228);
            display: flex;
			flex-direction : column;
            text-align: center;
            justify-content: center;
        }
    </style>
    <script type="text/javascript">
        function verifySecondPassword() {
            if (document.getElementById("fpassword1").value != document.getElementById("fpassword2").value) {
                document.getElementById("fpassword2").style["border"] = "1px solid red";
            } else {
                document.getElementById("fpassword2").style["border"] = "0px #00000000";
            }
        }

        function loadData() {
            loadProfileInfo();
            loadCurrentGame();
            loadPastGames();
        }
        function loadProfileInfo() {
            //fetch to get players personal information
        }
        function loadCurrentGame() {
            data = "Game 1";
            document.getElementById("current-game").innerHTML = data;
        }
        function loadPastGames(){
            //fetch to get past games
            data = [
                "Game1",
                "Game2",
                "Game3",
            ]
            for (let i in data){
                document.getElementById("past-games").innerHTML+=`
                    <div class="gamelist-item">
                        <div class="game">
                            `+data[i]+`
                        </div>
                    </div>
                `;
            }
        }
    </script>
</head>

<body onload="loadData()">
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
            <div id="profile-top">
                <div id="picture">
                    <img id="profile-picture" src="ressource/img/profile.bmp"/>
                </div>
                <div id="edit-profile">
                    <form id="form-profile" method="POST" action="/signup">
                        <div class="column">
                            <h3 class="centered-text">
                                E-mail :
                            </h3>
                            <input class="register-input" type="email" id="femail" name="email" placeholder="">
            
                            <h3 class="centered-text">
                                Username :
                            </h3>
                            <input class="register-input" type="text" id="fusername" name="username" placeholder="">
            
                            <h3 class="centered-text">
                                Birthday :
                            </h3>
                            <input class="register-input" type="date" id="fbirthday" name="birthday" placeholder="">
                        </div>
                        <div class="column">
                            <h3 class="centered-text">
                                Password :
                            </h3>
                            <input class="register-input" type="password" id="fpassword1" name="password" placeholder="">
            
                            <h3 class="centered-text">
                                Confirm password :
                            </h3>
                            <input class="register-input" type="password" id="fpassword2" onchange="verifySecondPassword()" name="password" placeholder="">
                            <h1></h1>
                            <input class="register-button" type="submit" value="Save" />
                        </div>
                    </form>
                </div>
            </div>
            <div class="horizontal-separator"></div>
            <div id="profile-bottom">
                <div class="games-title">
                    <h3 class="game-list-title">
                        Curent Game
                    </h3>
                    <div class="gamelist-item">
                        <div id="current-game">
                            None
                        </div>
                    </div>
                </div>
                <div id="past-games" class="games-title">
                    <h3 class="game-list-title">
                        Past Games
                    </h3>
                </div>
            </div>
        </div>
    </div>
</body>

</html>