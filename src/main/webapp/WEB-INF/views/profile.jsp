
<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Strict//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd'>
<html xml:lang="fr" lang="fr">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab&display=swap" rel="stylesheet">
    <title>Fluffy Gaming Center
    </title>
    <link rel="shortcut icon" href="/ressources/img/logo.png">
    <img id="logo" src="/ressources/img/logo.png">
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