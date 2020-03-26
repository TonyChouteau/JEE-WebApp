<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Strict//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd'>
<html xml:lang="fr" lang="fr">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="https://fonts.googleapis.com/css?family=Josefin+Slab&display=swap" rel="stylesheet">
	<title>Fluffy Gaming Center</title>
	<link rel="shortcut icon" href="/ressources/img/logo.png">
	<link rel="stylesheet" href="/ressources/css/style.css" />
	<script type="text/javascript" src="/ressources/js/signup.js">
	</script>
</head>

<body>
	<div>
		<a href="/home"><img id="logo" src="/ressources/img/logo.png"></a>
	</div>
	<div id="login-page">
		<div id="login-panel">
			<form method="POST" action="/signup">
				<h1 id="title-login" class="centered-text">
					Create an account
				</h1>
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

				<h3 class="centered-text">
					Password :
				</h3>
				<input class="register-input" type="password" id="fpassword1" name="password" placeholder="">

				<h3 class="centered-text">
					Confirm password :
				</h3>
				<input class="register-input" type="password" id="fpassword2" onchange="verifySecondPassword()"
					name="password" placeholder="">
				<h1></h1>
				<input class="register-button" type="submit" value="Register" />
			</form>
			<h4>
				<span>Already registered ?</span> <a href="./signin" style="color:rgb(235, 66, 223);">Sign in</a>
			</h4>
		</div>
	</div>
</body>

</html>