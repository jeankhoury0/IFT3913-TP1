/**  un bénévole est un utilisateur qui possède des informations mais
qui n'interagit pas directement avec le système. C'est pourquoi il n'a 
pas de méthodes.
*/

public class Benevole extends Utilisateur {

    /**
    * 
    * @param nom
    * @param prenom
    */
    public Benevole(String nom, String prenom) {
        setNom(nom);
        setPrenom(prenom);
    }

    /**
     * 
     * @param nom
     * @param prenom
     * @param date
     */
    public Benevole(String nom, String prenom, String date) {
        setNom(nom);
        setPrenom(prenom);
        setCourriel(date);
    }

    /**
     * 
     * @param benevole
     */
    public boolean equals(Benevole benevole) {
        if (this.getNom().equals(benevole.getNom()) && this.getPrenom().equals(benevole.getPrenom())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

}