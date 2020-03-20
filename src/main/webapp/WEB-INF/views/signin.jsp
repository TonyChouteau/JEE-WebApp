<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Strict//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd'>
<html xml:lang="fr" lang="fr">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab&display=swap" rel="stylesheet">
    <title>Fluffy Gaming Center</title>
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
        
        #logo {
            position: absolute;
            width: 7vh;
            height: 7vh;
        }
        
        #login-page {
            margin: 0;
            padding: 0;
            background: transparent;
            width: 100vw;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        
        #login-panel {
            margin: 0;
            padding: 0;
            background: white;
            border-radius: 10px;
            width: 60vh;
            min-width: 442px;
            min-height: 290px;
            display: flex;
            flex-direction: column;
            text-align: center;
            justify-content: center;
        }
        
        #centered-text {
            margin: 0;
            padding: 0;
        }
        
        #title-login {
            margin: 0;
            padding: 10px;
        }
        
        .login-input {
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
        
        .login-button {
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
        
        .login-button:hover {
            background: rgb(233, 233, 233);
        }
        
        .login-button:active {
            background: rgb(235, 66, 223);
            color: white;
        }
    </style>
</head>

<body>
    <div>
        <img id="logo" src="/ressources/img/logo.png">
    </div>
    <div id="login-page">
        <div id="login-panel">
            <form method="POST" action=".">
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
                <span>Not registered ?</span> <a href="./signup.html" style="color:rgb(235, 66, 223);">Sign up</a>
            </h4>
        </div>
    </div>
</body>

</html>