<%@ page import="data.DB,data.Jeu" %>
<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Strict//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd'>
<html xml:lang="fr" lang="fr">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="https://fonts.googleapis.com/css?family=Josefin+Slab&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="/ressources/css/style.css" />
	<title>Fluffy Gaming Center</title>
	<link rel="shortcut icon" href="/ressources/img/logo.png">
	<img id="logo" src="/ressources/img/logo.png">
	<script>
		let logged = <%= session.getAttribute("uid") != null %>
		let admin = <%= session.getAttribute("isAdmin")%>
	</script>
	<script type="text/javascript" src="/ressources/js/menu.js"></script>
	<script type="text/javascript" src="/ressources/js/games.js"></script>
</head>

<body onload="loadGames()">
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
			<div id="profile-bottom">
                <div id="games-list" class="games-title">
                    <h3 class="game-list-title">
						Available Games 
                    </h3>
				</div>
            </div>
		</div>
	</div>
</body>

</html>