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
	<script type="text/javascript" src='/ressources/js/games/1.js'></script>
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
			</h1>
		</div>
		<div id="content-panel">
			<h3 id="game-title">
			</h3>
			<div id="game" onclick="play()">
				<h2 id="score">
					0
				</h2>
			</div>
			<div id="buttons">
				<button id="play-button" class="button" onclick="playingButton()">
					Play
				</button>
				<button class="button" onclick="submitScore()">
					Submit
				</button>
			</div>
		</div>
	</div>
</body>

</html>