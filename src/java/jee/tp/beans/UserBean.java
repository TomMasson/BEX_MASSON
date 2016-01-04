/*
Cette classe permets de :
*/
package jee.tp.beans;


public class UserBean {
    private String pseudo;
    private String mdp;

    public UserBean(String pseudo, String mdp) {
        this.pseudo = pseudo;
        this.mdp = mdp;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getMdp() {
        return mdp;
    }
    
    
}
