package org.ift3913.tp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Un analyseur de commentaires pour un seul fichier de code.
 *
 * @author Pierre Janier Dubry et Rui Jie Liu
 */
public class AnalyseurCommentaires {

    //region ================================ CHAMPS ================================

    /**
     * Le chemin fourni en entrée par l'utilisateur, pointant vers un fichier valide.
     * <br>
     * Note : ce chemin ne garantit pas un fichier .java existe en destination.
     */
    private final File fichier;

    // TODO: utiliser ce BufferedReader pour lire le fichier à analyser
    private BufferedReader fileStream;

    //endregion CHAMPS

    //region ================================ CONSTRUCTEUR ================================

    public AnalyseurCommentaires(File fichier) throws FileNotFoundException {
        if (!fichier.exists()) throw new FileNotFoundException("Le chemin fourni ne correspond pas à un fichier valide!");
        this.fichier = fichier;
    }

    //endregion CONSTRUCTEUR

    //region ================================ MÉTHODES ================================

    public ResultatAnalyseFichier Analyser() throws FileNotFoundException {
        if (fileStream == null) fileStream = new BufferedReader(new FileReader(fichier));

        try {
            fileStream = new BufferedReader(new FileReader(fichier));
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Le fichier à analyser n'existe plus sur le disque!");
        }

        // TODO: utiliser cette méthode comme point de départ, analyser tout le contenu du fichier donné utilisant l'automate fini
        // L'écriture d'autres méthodes internes peut s'avérer nécessaire
    }

    //endregion MÉTHODES
}
