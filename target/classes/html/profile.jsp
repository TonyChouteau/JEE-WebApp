<%@ page language="java"%>
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
            
            #logo {
                position: absolute;
                width: 7vh;
                height: 7vh;
            }
            
            #page {
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
                width: 1500px;
                height: 50px;
                display: flex;
                flex-direction: column;
                text-align: start;
                justify-content: center;
            }
            
            #content-panel {
                margin: 20px 0 0 0;
                padding: 0;
                background: white;
                border-radius: 5px;
                width: 1500px;
                display: flex;
                flex-direction: column;
                text-align: start;
                justify-content: start;
            }
            
            #centered-text {
                margin: 0;
                padding: 0;
            }
            
            #title-login {
                margin: 0;
                padding: 10px;
            }
            
            #profile-top {
                width: 100%;
                height: 400px;
            }
        </style>
    </head>

    <body>
        <!--<div>
        <img id="logo" src="../ressources/logo.png">
    </div>-->
        <div id="page">
            <div id="menu-panel">
                <h1 id="title">
                    Connexion
                </h1>
            </div>
            <div id="content-panel">
                <div id="profile-top">

                </div>
            </div>
        </div>
    </body>

    </html>