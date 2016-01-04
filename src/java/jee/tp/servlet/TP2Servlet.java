/*
Cette servlet nous permets de tester la récupération de paramètres situées dans l'URL,
et d'afficher les informations du navigateur web.
*/
package jee.tp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TP2Servlet", urlPatterns = {"/TP2Servlet"})
public class TP2Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TP2Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Liste des paramètres :</h1>");
            Map<String, String[]> param = request.getParameterMap();
            Set<String> clef = param.keySet();
            out.println("<p>Afin de parcourir toute la Map dans laquelle sont stocké les paramètres de l'URL, on récupère la collection de clefs sous forme de Set grâce à la méthode keySet du Map. On parcours ensuite cette collection et à chaque boucle, on récupère le paramètre correspondant à la clé. Afin de récuperer les éventuelles multiple valeurs pour un paramètre, on boucle egalement au sein de chaque tableau de String correspondant à la valeur du Map.</p>");
            out.println("<ul>");
            for (String key : clef) {
                out.println("<li>");
                out.println(key + " ");
                String[] value = param.get(key);
                out.println("{");
                for (String s : value) {
                    out.println(s);
                }
                out.println("}</li>");
            }
            out.println("</ul>");
            out.println("<p>Afin de mettre deux valeurs pour un seul paramètre, il suffit d'assigner deux fois une valeur au paramètre dans l'URL</p>");
            out.println("<h1>Information du navigateur web :</h1>");
            out.println("<ul><li>Remote addr : " + request.getRemoteAddr() +" L'adresse IPV6 du client </li><li>Protocol : " + request.getProtocol() + " Le protocole de la requete et sa version</li><li>Local port : " + request.getLocalPort() +" Le port utilisé par le serveur</li><li>Context path : " + request.getContextPath() +" Le chemin dans lequel se trouve le Servlet</li><li>Request url : "+ request.getRequestURL()+ " L'url complète de la page généré</li></ul>");
            out.println("<a href='index.html'>Page d'accueil</a>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}