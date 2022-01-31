package org.ift3913.tp1;

import java.io.File;

/**
 * Programme d'analyse statistique pour mesurer la complexité de la sous-documentation d'un projet Java.
 *
 * @author Pierre Janier Dubry et Rui Jie Liu
 */
public class Analyseur {

    //region ================================ CHAMPS ================================

    /**
     * Le chemin fourni en entrée par l'utilisateur, pointant vers un fichier ou un dossier valide.
     * Note : ce chemin ne garantit pas un fichier .java existe en destination.
     */
    static File cheminBase = null;

    //endregion CHAMPS

    //region ================================ MAIN ================================

    public static void main(String[] args) {
        // Point d'entrée du programme

        // Analyse des arguments en entrée
        for (String arg : args) {
            // Vérification de la validité du chemin donné. Aucune analyse du type de fichier ici.
            File potentialPath = new File(arg);
            if (potentialPath.exists()) {
                cheminBase = potentialPath;
            }
        }

        if (cheminBase == null) {
            System.out.println("Veuillez fournir un chemin valide à un paquet ou fichier Java!");
            System.exit(3);     // Cohérent avec code erreur Win32: 3=ERROR_PATH_NOT_FOUND
        }

        // Faire appel à une méthode d'analyse avec le chemin de base
    }

    //endregion MAIN

    //region ================================ MÉTHODES ================================

    /*
    TODO - codage partie 1
    1) Lecture de fichiers .java (avec un buffered stream?)
        1.1) Si cheminBase est un dossier (paquet Java), lire tous les fichiers .java contenus
    2) Analyse des commentaires (possiblement avec une machine à états finis?)
        2.1) Établir une implémentation lisible, avec les variables donnés dans l'énoncé
     */

    /*
    Statistiques à mesurer:
    • classe_LOC : nombre de lignes de code d’une classe
    • paquet_LOC : nombre de lignes de code d’un paquet (java package) -- la somme des LOC de ses classes
    • classe_CLOC : nombre de lignes de code d’une classe qui contiennent des commentaires
    • paquet_CLOC : nombre de lignes de code d’un paquet qui contiennent des commentaires
    • paquet_DC : densité de commentaires pour une classe : classe_DC = classe_CLOC / classe_LOC
•    paquet_DC : densité de commentaires pour un paquet : paquet_DC = paquet_CLOC / paquet_LOC
     */

    //endregion MÉTHODES
}
