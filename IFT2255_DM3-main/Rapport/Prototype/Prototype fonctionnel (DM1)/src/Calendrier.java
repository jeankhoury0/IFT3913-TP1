
/**
 * Cette classe est la classe qui organise le système. Elle utilise les rendez 
 * vous pour determiner la place qu'il reste dans le système.
 */
import java.util.*;

public class Calendrier {

    private List<RendezVous> rendezVousList;

    public Calendrier() {
        this.rendezVousList = new ArrayList<>();
    }

    public void ajouterRendezVous(RendezVous rendezvous) {
        this.rendezVousList.add(rendezvous);
    }
    public void supprimerRendezVous(RendezVous rendezvous) {
        this.rendezVousList.remove(rendezvous);
    }

    

    public List<RendezVous> getRendezVousList() {
        return this.rendezVousList;
    }


    @Override
    public String toString() {
        String afficher = "";
        int compteur = 1;
        for (RendezVous rendezVous : this.rendezVousList) {
            afficher += "-------------\n" + compteur + ")" + rendezVous.toString() +"\n";
            compteur++;
        }
        return afficher;
    }
}