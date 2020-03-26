<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Strict//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd'>
<html xml:lang="fr" lang="fr">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab&display=swap" rel="stylesheet">
    <title>Fluffy Gaming Center</title>
    <link rel="shortcut icon" href="/ressources/img/logo.png">
    <link rel="stylesheet" href="/ressources/css/style.css" />
	<script type="text/javascript" src="/ressources/js/menu.js"></script>
</head>

<body>
    <div>
        <img id="logo" src="/ressources/img/logo.png">
    </div>
    <div id="login-page">
        <div id="login-panel">
            <form method="POST" action="/signin">
                <h1 id="title-login" class="centered-text">
                    Connexion
                </h1>
                <h3 class="centered-text">
                    Username :
                </h3>
                <input class="login-input" type="text" id="fusername" name="username" placeholder="">

                <h3 class="centered-text">
                    Password :
                </h3>
                <input class="login-input" type="password" id="fpassword" name="password" placeholder="">
                <h1></h1>
                <input class="login-button" type="submit" value="Login" />
            </form>
            <h4>
                <span>Not registered ?</span> <a href="./signup" style="color:rgb(235, 66, 223);">Sign up</a>
            </h4>
        </div>
    </div>
</body>

</html>