/** Un visiteur dérive la classe utilisateur. Il s'agit de la classe qui 
 * correspond aux personnes à vacciner par VaxToDo. C'est pourquoi ils peuvent
 * être associé à des rendez vous dans le système.  
*/

public class Visiteur extends Utilisateur {

    // private boolean compteConfirme;
    // private String vaccin;
    // private boolean dose1;
    // private boolean dose2;
    // private Date premierRendezVous;
    // private Date secondRendezVous;

    /**
     * 
     * @param nom
     * @param prenom
     * @param courriel
     */
    public Visiteur(String nom, String prenom, String date) {
        setNom(nom);
        setPrenom(prenom);
        setDate(date);
    }

    public Visiteur(String nom, String prenom) {
        setNom(nom);
        setPrenom(prenom);
    }

    /**
     * 
     * @param vaccin
     */
    // public void setVaccin(String vaccin) {
    //     this.vaccin = vaccin;
    // }

    /**
     * 
     * @param nom
     * @param prenom
     */
    public boolean equals(Visiteur visiteur) {
        if (this.getNom().equals(visiteur.getNom()) && this.getPrenom().equals(visiteur.getPrenom())) {
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