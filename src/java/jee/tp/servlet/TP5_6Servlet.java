/*
Cette servlet sers pour les TPs 5 et 6. Ellefgkuhsd,hdfdhkj
*/
package jee.tp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TP5Servlet", urlPatterns = {"/TP5Servlet"})
public class TP5_6Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String[]> param=request.getParameterMap();                  //On recupere les paramètres dans un map
        List<Map<String, String[]>> data = new ArrayList<Map<String, String[]>>(); //On créer une liste de HashMap pour stockés les utilisateurs enregistrés
        Map<String, String[]> data1 = new HashMap<String, String[]>();
        Map<String, String[]> data2 = new HashMap<String, String[]>();
        Map<String, String[]> data3 = new HashMap<String, String[]>();
        Map<String, String[]> data4 = new HashMap<String, String[]>();
        //On remplis les utilisateurs
        data1.put("pseudo", new String[]{"Vycen"});
        data1.put("password", new String[]{"hello"});
        data1.put("pseudo", new String[]{"Pseudo2"});
        data1.put("password", new String[]{"mdp2"});
        data1.put("date", new String[]{"2015-12-03"});
        data1.put("sexe", new String[]{"h"});
        data1.put("pseudo", new String[]{"Pseudo3"});
        data1.put("password", new String[]{"mdp3"});
        data1.put("date", new String[]{"1996-04-25"});
        data1.put("sexe", new String[]{"f"});
        data1.put("pseudo", new String[]{"Pseudo4"});
        data1.put("password", new String[]{"mdp4"});
        data1.put("date", new String[]{"1995-04-24"});
        data1.put("sexe", new String[]{"f"});
        //on mets les utilisateurs dans la liste
        data.add(data1);
        data.add(data2);
        data.add(data3);
        data.add(data4);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Informations utilisateur</title>");            
            out.println("</head>");
            out.println("<body>");
            if(authentification(param,data)) { //Si l'utilisateur est bien enregistré, on affiche ses informations, sinon on affiche un message d'erreur
                out.println("<p>Bonjour " + param.get("pseudo")[0] + ", votre mot de passe est " + param.get("password")[0] + ", tu est née le " + param.get("date")[0] + " et tu es du sexe " + param.get("sexe")[0] + ".</p>");
            }
            else {
                out.println("<h1>MAUVAISE AUTHENTIFICATION</h1>");
            }
            
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    private boolean authentification(Map<String, String[]> param, List<Map<String, String[]>> data) { //methode permettant de verifier si les paramètres entrés correspondent bien à un utilisateur enregistré
        boolean b = false;
        Iterator<Map<String, String[]>> it = data.iterator();
        while(it.hasNext()){ //On parcours la liste d'utilisateur
            Map i = it.next();
            //On compare les Maps contenant les utilisateurs préenregistrés avec le Map contenant les paramètres qui ont été rentré grace à la fonction equals de la classe Array
            if (Arrays.equals((Object[]) i.get("pseudo"), param.get("pseudo")) && Arrays.equals((Object[]) i.get("password"), param.get("password")) && Arrays.equals((Object[]) i.get("date"), param.get("date")) && Arrays.equals((Object[]) i.get("sexe"), param.get("sexe"))) {
                b=true;
                break;
            }
        }
        return b;
    }
}
