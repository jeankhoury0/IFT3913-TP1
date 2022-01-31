/** La classe utilisateur est une classe dont hérite les utilisateurs et les
 * visiteurs. Elle contient les propriétés fondamentales que tout utilisateurs
 * doivent hérité telle que le nom et l'adresse courriel. 
 */

public class Utilisateur {

    private String nom;
    private String prenom;
    private String courriel;
    private String date;

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCourriel() {
        return this.courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;

    }

    @Override
    public String toString() {
        return String.format("Le nom est : %s\nLe prenom est : %s\n", this.nom, this.prenom);
    }
}