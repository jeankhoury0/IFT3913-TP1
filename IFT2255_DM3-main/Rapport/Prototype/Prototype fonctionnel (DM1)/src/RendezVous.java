/**
 * Un rendez-vous est l'unité dont est composé le calendrier. à chaque rendez
 * vous est associé un visiteur dont le compte est confirmé ou non.
 */

public class RendezVous {

    private Visiteur visiteur;
    private Date date;

    public RendezVous(Visiteur visiteur, Date date) {
        setVisiteur(visiteur);
        setDate(date);
    }

    public Visiteur getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean equals(RendezVous rendezVous) {
        if (this.getVisiteur().equals(rendezVous.getVisiteur()) && this.getDate().equals(rendezVous.getDate())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("\nNom et prenom du visiteur : %s %s\nDate du rendez vous : %s",
                this.getVisiteur().getNom(), this.getVisiteur().getPrenom(), this.getDate().toString());
    }

}