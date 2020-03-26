
<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Strict//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd'>
<html xml:lang="fr" lang="fr">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab&display=swap" rel="stylesheet">
    <link href="/ressources/css/style.css" rel="stylesheet">
    <title>Fluffy Gaming Center</title>
    <link rel="shortcut icon" href="/ressources/img/logo.png">
    <img id="logo" src="/ressources/img/logo.png">
    <script type="text/javascript" src="/ressources/js/profile.js"></script>
	<script>
		let logged = <%= session.getAttribute("uid") != null %>
		let admin = <%= session.getAttribute("isAdmin")%>
	</script>
	<script type="text/javascript" src="/ressources/js/menu.js"></script>
</head>

<body onload="loadData()">
    <%
        String username = session.getAttribute("username").toString();
    %>
    <div id="page">
		<div id="menu-panel">
			<%
				if (session.getAttribute("username") != null) {
			%>
			<%= session.getAttribute("username") %>
			<%
				} else {
			%>
			<a href="/signin">Sign in</a> / <a href="/signup">Sign up</a>
			<%
				}
			%>
		</div>
        <div id="content-panel">
            <div id="profile-top">
                <div id="picture">
                    <img id="profile-picture" src="/ressources/img/profile.bmp"/>
                </div>
                <div id="edit-profile">
                    <form id="form-profile" method="POST" action="/player">
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
                        Current Game (not done)
                    </h3>
                    <div class="gamelist-item">
                        <div id="current-game">
                            None
                        </div>
                    </div>
                </div>
                <div id="past-games" class="games-title">
                    <h3 class="game-list-title">
                        Past Games (not done)
                    </h3>
                </div>
            </div>
        </div>
    </div>
</body>

</html>