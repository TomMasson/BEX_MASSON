/*
Cette classe permets de représenter l'objet Utilisateur.
Elle permets d'instancier une liste d'utilisateurs prédéfinie,
de sélectionner un utilisateur au hasard dans cette liste,
et de retourner grâce à toString les valeurs de l'utilisatuer sous forme d'une phrase
*/
package jee.tp.beans;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur {
    private String nom;
    private String prenom;
    private int age;
    private String mdp;
    
    public Utilisateur(String nom, String prenom, int age, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.mdp = mdp;
    }

    //methode statique qui instancie des utilisateurs, les stocke dans une ArrayList et retourne cette liste
    public static ArrayList getUtilisateurs() {
        Utilisateur u1 = new Utilisateur("Masson","Tom",18, "bonjour");
        Utilisateur u2 = new Utilisateur("Bex","Emile",19, "salut");
        Utilisateur u3 = new Utilisateur("Rouquette","Loic",23, "yo");
        Utilisateur u4 = new Utilisateur("Derollepot","Louis",20, "coucou");
        List<Utilisateur> u = new ArrayList<Utilisateur>();
        u.add(u1);
        u.add(u2);
        u.add(u3);
        u.add(u4);
        return (ArrayList) u;
    }
    
    //methode qui instancie une liste d'Utilisateur prédéfinie grace à la methode getUtilisateurs(), et va aléatoirement choisir un index entre 0 et 3, et retourner l'utilisateur de la liste correspondant à l'index
    public static Utilisateur randomUtilisateur() {
        int i;
        List<Utilisateur> u = getUtilisateurs();
        i=(int)(Math.random()*u.size());
        return u.get(i);
    }
    
    //surcharge de la methode toString, pour retourner un texte qui affiche tous les attributs de l'Utilisateur
    @Override
    public String toString() {
        return nom + " " +  prenom + " a " + age + " ans et son mot de passe est \"" + mdp + "\"";
    }
}
