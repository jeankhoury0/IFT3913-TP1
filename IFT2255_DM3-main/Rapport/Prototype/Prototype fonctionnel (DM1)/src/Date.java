/**
 * un composant de type pour la classe rendez-vous
 */

public class Date {

    private int annee, mois, jours;

    Date(String date) {
        String[] uneDate = date.split("-");
        setAnnee(Integer.parseInt(uneDate[0]));
        setMois(Integer.parseInt(uneDate[1]));
        setJours(Integer.parseInt(uneDate[2]));
    }

    Date(String annee, String mois, String jour) {
        setAnnee(Integer.parseInt(annee));
        setMois(Integer.parseInt(mois));
        setJours(Integer.parseInt(jour));
    }

    Date(int annee, int mois, int jours) {
        setAnnee(annee);
        setMois(mois);
        setJours(jours);
    }

    public int getAnnee() {
        return this.annee;
    }

    public int getMois() {
        return this.mois;
    }

    public int getJours() {
        return this.jours;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public void setJours(int jours) {
        this.jours = jours;
    }

    public boolean equals(Date date) {
        if (this.getAnnee() == date.getAnnee() && this.getMois() == date.getMois()
                && this.getJours() == date.getJours()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "La date est le " + this.annee + "-" + this.mois + "-" + this.jours;
    }

}
