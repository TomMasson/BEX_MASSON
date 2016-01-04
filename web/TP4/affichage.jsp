<%--Tous les imports qui seront utile au fonctionnement du programme--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jee.tp.beans.Utilisateur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%--Entre la balise <h1> sera appelé la méthode toString() sur un Utilisateur renvoyé par la methode statique randomUtilisateur() de la classe Utilisateur.
        La chaine de caractère renvoyé sera écrite dans le style de <h1>--%>
        <h1><%=Utilisateur.randomUtilisateur().toString()%></h1>
        <ul>
        <%--Au sein d'une liste non ordonnée, on instancie la liste d'utilisateur grace à la méthode statique getUtilisateurs() de la classe Utilisateur. On parcours ensuite cette liste grace à un for optimisé.
        Chaque Utilisateur de la liste sera mis sous forme de chaine de caractère (methode toString()) et sera mis comme élément de la liste non ordonnée sur la page.--%>
        <%
            List<Utilisateur> u = Utilisateur.getUtilisateurs();
            for (Utilisateur ut : u) {
        %>
        <li><%=ut.toString()%></li>
        <%
            }
        %>
        </ul>
        <a href='../index.html'>Page d'accueil</a>
    </body>
</html>
