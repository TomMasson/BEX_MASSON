<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TP n°5</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>
            <h1>Veuillez entrer vos informations</h1>
            <form action="../TP3Servlet" method="post">
                <p>Pseudo : </p><input type="text" name="pseudo">
                <p>Mot de passe : </p><input type="password" name="password">
                <p></p><input type="submit">
            </form>
        </div>
        <a href='../index.html'>Page d'accueil</a>
    </body>
</html>
