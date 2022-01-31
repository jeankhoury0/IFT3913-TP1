
/**
 * IFT2255 - DM 1 : VaxToDo
 * Fais le 06 octobre 2021 
 *
 * C'est le reponsePrincipal principal du système avec lequel interagit l'employé
 */

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VaxToDo {

    private List<Benevole> benevoleList;
    private List<Visiteur> visiteurList;
    private Calendrier calendrier;
    private String identifiant;
    private String motDePasse;
    private boolean acces;

    public VaxToDo() {
        setAcces(false);
        this.calendrier = new Calendrier();
        this.visiteurList = new ArrayList<>();
        this.benevoleList = new ArrayList<>();
    }

    public void setAcces(boolean acces) {
        this.acces = acces;
    }

    public boolean getAcces() {
        return this.acces;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean verifierConnection() {
        if (getIdentifiant().equals("employe") && getMotDePasse().equals("1234"))
            return true;
        else
            return false;
    }

    // visiteur 
    private void ajouterVisiteur(Visiteur visiteur) {
        this.visiteurList.add(visiteur);
        System.out.println("Le visiteur a bien ete ajoute.");
    }

    private boolean rechercherVisiteur(Visiteur visiteur) {
        boolean trouve = false;
        for (Visiteur unVisiteur : this.visiteurList) {
            if (unVisiteur.equals(visiteur)) {
                System.out.println("Le visiteur est trouve");
                trouve = true;
            }
        }
        System.out.println("Le visiteur est introuvable");
        return trouve;
    }

    private Visiteur rechercherVisiteur(String nom, String prenom) {

        for (Visiteur unVisiteur : this.visiteurList) {
            if (unVisiteur.getNom().equals(nom) && unVisiteur.getPrenom().equals(prenom)) {
                System.out.println("le visiteur est trouve");
                return unVisiteur;
            }
        }
        System.out.println("le visiteur est introuvable");
        return null;
    }

    private void supprimerVisiteur(Visiteur visiteur) {
        this.visiteurList.remove(visiteur);
        System.out.println("Le visiteur a bien ete supprime.");

    }

    // benevole 
    private void ajouterBenevole(Benevole benevole) {
        this.benevoleList.add(benevole);
        System.out.println("Le benevole a bien ete ajoute.");
    }

    private boolean rechercherBenevole(Benevole benevole) {
        boolean trouve = false;
        for (Benevole unBenevole : this.benevoleList) {
            if (unBenevole.equals(benevole)) {
                System.out.println("Le benevole a ete trouve");
                trouve = true;
            }
        }
        System.out.println("Le benevole est introuvable");
        return trouve;
    }

    private Benevole rechercherBenevole(String nom, String prenom) {

        for (Benevole unBenevole : benevoleList) {
            if (unBenevole.getNom().equals(nom) && unBenevole.getPrenom().equals(prenom)) {
                System.out.println("le benevole est trouve");
                return unBenevole;
            }
        }
        System.out.println("le benevole est introuvable");
        return null;
    }

    private void supprimerBenevole(Benevole benevole) {
        this.benevoleList.remove(benevole);
        System.out.println("Le benevole a bien ete supprime.");
    }

    // calendrier 
    private void ajouterRendezVous(Visiteur visiteur, Date date) {
        this.visiteurList.add(visiteur);
        this.calendrier.ajouterRendezVous(new RendezVous(visiteur, date));
        System.out.println("Le rendez-vous a bien ete ajoute.");
    }

    private RendezVous rechercherRendezVous(RendezVous rendezvous) {

        for (RendezVous unRendezVous : this.calendrier.getRendezVousList()) {
            if (unRendezVous.equals(rendezvous)) {
                System.out.println("Le rendez vous est trouve");
                return unRendezVous;
            }
        }
        System.out.println("Le rendez vous est introuvable");
        return null;
    }

    private void supprimerRendezVous(RendezVous rendezvous) {
        this.calendrier.supprimerRendezVous(rechercherRendezVous(rendezvous));
        System.out.println("Le rendez vous a bien ete supprime.");
    }

    private String afficherCalendrier() {
        return this.calendrier.toString();
    }

    // fonctiond d'affichage de menu 

    private void afficherMenuPrincipal() {
        String affiche = "------------------\nMenu principal : \n1: Gestion des visiteurs \n2: Gestion des benevoles \n3: Gestion du calendrier \n4: Deconnection\n------------------\n";
        System.out.println(affiche);
    }

    private void afficherMenuVisiteur() {
        String affiche = "------------------\nMenu Visiteur : \n1: Ajouter un visiteur \n2: Supprimer un visiteur \n3: Rechercher un visiteur \n4: Retour en arriere\n------------------\n";
        System.out.println(affiche);
    }

    private void afficherMenuBenevole() {
        String affiche = "------------------\nMenu Benevole : \n1: Ajouter un benevole \n2: Supprimer un benevole \n3: Rechercher un benevole \n4: Retour en arriere\n------------------\n";
        System.out.println(affiche);
    }

    private void afficherMenuCalendrier() {
        String affiche = "------------------\nMenu Calendrier : \n1: Ajouter un rendez-vous \n2: Supprimer un rendez-vous \n3: Rechercher un rendez-vous \n4: Afficher le calendrier \n5: Retour en arriere\n------------------\n";
        System.out.println(affiche);
    }

    public static void main(String[] args) throws IOException {

        VaxToDo vax = new VaxToDo();

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Bienvenue dans le systeme VaxToDo:re!\nMenu d'authentification : \n");
        System.out.println("Quel est votre identifiant ?");
        vax.setIdentifiant(console.readLine());
        System.out.println("Quel est votre mot de passe ?");
        vax.setMotDePasse(console.readLine());

        if (!vax.verifierConnection()) {
            throw new Error("Les credits de connection sont incorrects");
        } else {
            System.out.println("Connection reussie.\n");
            vax.setAcces(true);
        }

        if (vax.getAcces()) {
            boolean connecter = true;

            while (connecter) {

                boolean menuPrincipal = false;
                int reponsePrincipal = 0;

                while (!menuPrincipal) {
                    vax.afficherMenuPrincipal();
                    System.out.println("Dans quel menu souhaitez vous vous rendre ?\n");
                    reponsePrincipal = Integer.parseInt(console.readLine());
                    switch (reponsePrincipal) {
                        case 1, 2, 3: // Gestion des visiteurs
                            menuPrincipal = true;
                            break;
                        case 4: // Déconnection
                            connecter = false;
                            menuPrincipal = true;
                            break;
                        default:
                            System.out
                                    .println("Le systeme n'a pas compris votre reponse. Veuillez taper 1, 2, 3 ou 4.");
                    }

                    if (reponsePrincipal == 1) { // Gestion des visiteurs
                        vax.afficherMenuVisiteur();
                        boolean menuVisiteur = false;
                        int reponseVisiteur = 0;
                        while (!menuVisiteur) {
                            reponseVisiteur = Integer.parseInt(console.readLine());

                            switch (reponseVisiteur) {
                                case 1: // Ajouter un visiteur
                                    System.out.println("Quel est le nom du visiteur que vous souhaitez ajouter ?");
                                    String nomAjouterVisiteur = console.readLine();
                                    System.out.println("Quel est le prenom du visiteur que vous souhaitez ajouter ?");
                                    String prenomAjouterVisiteur = console.readLine();
                                    Visiteur visiteurAAJouter = new Visiteur(nomAjouterVisiteur, prenomAjouterVisiteur);
                                    vax.ajouterVisiteur(visiteurAAJouter);
                                    menuVisiteur = true;
                                    break;
                                case 2: // Supprimer un visiteur
                                    System.out.println("Quel est le nom du visiteur que vous souhaitez supprimer ?");
                                    String nomSupprimerVisiteur = console.readLine();
                                    System.out.println("Quel est le prenom du visiteur que vous souhaitez supprimer ?");
                                    String prenomSupprimerVisiteur = console.readLine();
                                    vax.supprimerVisiteur(
                                            vax.rechercherVisiteur(nomSupprimerVisiteur, prenomSupprimerVisiteur));
                                    menuVisiteur = true;
                                    break;
                                case 3: // Rechercher un visiteur
                                    System.out.println("Quel est le nom du visiteur que vous souhaitez rechercher ?");
                                    String nomrechercherVisiteur = console.readLine();
                                    System.out
                                            .println("Quel est le prenom du visiteur que vous souhaitez rechercher ?");
                                    String prenomrechercherVisiteur = console.readLine();
                                    vax.rechercherVisiteur(
                                            new Visiteur(nomrechercherVisiteur, prenomrechercherVisiteur));
                                    menuVisiteur = true;
                                    break;
                                case 4: // Retour en arrière
                                    menuVisiteur = true;
                                    menuPrincipal = false;
                                    break;
                                default:
                                    System.out.println(
                                            "Le systeme n'a pas compris votre reponse. Veuillez taper 1, 2, 3 ou 4.");
                            }
                        }
                    }

                    if (reponsePrincipal == 2) { // Gestion des bénévoles
                        vax.afficherMenuBenevole();
                        boolean menuBenevole = false;
                        int reponseBenevole = 0;
                        while (!menuBenevole) {
                            reponseBenevole = Integer.parseInt(console.readLine());

                            switch (reponseBenevole) {
                                case 1: // Ajouter un benevole
                                    System.out.println("Quel est le nom du benevole que vous souhaitez ajouter ?");
                                    String nomAjouterBenevole = console.readLine();
                                    System.out.println("Quel est le prenom du benevole que vous souhaitez ajouter ?");
                                    String prenomAjouterBenevole = console.readLine();
                                    Benevole benevoleAAJouter = new Benevole(nomAjouterBenevole, prenomAjouterBenevole);
                                    vax.ajouterBenevole(benevoleAAJouter);
                                    menuBenevole = true;
                                    break;
                                case 2: // Supprimer un benevole
                                    System.out.println("Quel est le nom du benevole que vous souhaitez supprimer ?");
                                    String nomSupprimerBenevole = console.readLine();
                                    System.out.println("Quel est le prenom du benevole que vous souhaitez supprimer ?");
                                    String prenomSupprimerBenevole = console.readLine();
                                    vax.supprimerBenevole(
                                            vax.rechercherBenevole(nomSupprimerBenevole, prenomSupprimerBenevole));
                                    // consoleSupprimerBenevole.close();
                                    menuBenevole = true;
                                    break;
                                case 3: // Rechercher un benevole
                                    System.out.println("Quel est le nom du benevole que vous souhaitez rechercher ?");
                                    String nomrechercherBenevole = console.readLine();
                                    System.out
                                            .println("Quel est le prenom du benevole que vous souhaitez rechercher ?");
                                    String prenomrechercherBenevole = console.readLine();
                                    vax.rechercherBenevole(
                                            new Benevole(nomrechercherBenevole, prenomrechercherBenevole));
                                    // consoleRechercherBenevole.close();
                                    menuBenevole = true;
                                    break;
                                case 4: // Retour en arrière
                                    menuBenevole = true;
                                    menuPrincipal = false;
                                    break;
                                default:
                                    System.out.println(
                                            "Le systeme n'a pas compris votre reponse. Veuillez taper 1, 2, 3 ou 4.");
                            }

                        }

                    }

                    if (reponsePrincipal == 3) { // Gestion du calendrier
                        vax.afficherMenuCalendrier();
                        boolean menuCalendrier = false;
                        int reponseCalendrier = 0;
                        while (!menuCalendrier) {
                            reponseCalendrier = Integer.parseInt(console.readLine());
                            switch (reponseCalendrier) {
                                case 1: // Ajouter un rendez-vous
                                    System.out.println(
                                            "Quel est le nom du visiteur qui souhaite prendre un rendez-vous ?");
                                    String nomAjouterVisiteur = console.readLine();
                                    System.out.println(
                                            "Quel est le prenom du visiteur qui souhaite prendre un rendez-vous ?");
                                    String prenomAjouterVisiteur = console.readLine();
                                    System.out.println("Quelle est la date du rendez-vous ? YYYY-MM-JJ");
                                    String dateRendezVous = console.readLine();
                                    vax.ajouterRendezVous(new Visiteur(nomAjouterVisiteur, prenomAjouterVisiteur),
                                            new Date(dateRendezVous));

                                    menuCalendrier = true;
                                    break;
                                case 2: // Supprimer un rendez-vous
                                    System.out.println(
                                            "Quel est le nom du visiteur associe au rendez vous que vous souhaitez supprimer ?");
                                    String nomSupprimerRendezVous = console.readLine();
                                    System.out.println(
                                            "Quel est le prenom du visiteur associe au rendez vous que vous souhaitez supprimer ?");
                                    String prenomSupprimerRendezVous = console.readLine();
                                    System.out.println(
                                            "Quelle est la date associee au rendez vous que vous souhaitez supprimer ?");
                                    String dateSupprimerRendezVous = console.readLine();
                                    vax.supprimerRendezVous(vax.rechercherRendezVous(new RendezVous(
                                            new Visiteur(nomSupprimerRendezVous, prenomSupprimerRendezVous),
                                            new Date(dateSupprimerRendezVous))));
                                    menuCalendrier = true;
                                    break;
                                case 3: // Rechercher un rendez-vous

                                    System.out.println(
                                            "Quel est le nom du visiteur associe au rendez vous que vous souhaitez supprimer ?");
                                    String nomRechercherRendezVous = console.readLine();
                                    System.out.println(
                                            "Quel est le prenom du visiteur associe au rendez vous que vous souhaitez supprimer ?");
                                    String prenomRechercherRendezVous = console.readLine();
                                    System.out.println(
                                            "Quelle est la date associee au rendez vous que vous souhaitez supprimer ?");
                                    String dateRechercherRendezVous = console.readLine();
                                    vax.rechercherRendezVous(new RendezVous(
                                            new Visiteur(nomRechercherRendezVous, prenomRechercherRendezVous),
                                            new Date(dateRechercherRendezVous)));
                                    menuCalendrier = true;
                                    break;
                                case 4: // Afficher le calendrier
                                    System.out.println(vax.afficherCalendrier());
                                    menuCalendrier = true;
                                    break;
                                case 5: // Retour en arrière
                                    menuCalendrier = true;
                                    menuPrincipal = false;
                                    break;
                                default:
                                    System.out.println(
                                            "Le systeme n'a pas compris votre reponse. Veuillez taper 1, 2, 3 ou 4.");
                            }

                        }
                    }
                }
            }
        }

        System.out.println("Deconnection");

    }

}