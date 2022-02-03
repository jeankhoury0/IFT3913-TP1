package org.ift3913.tp1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Programme d'analyse statistique pour mesurer la complexité de la sous-documentation d'un projet Java.
 *
 * @author Pierre Janier Dubry et Rui Jie Liu
 */
public class TP1 {

    //region ================================ MAIN ================================

    public static void main(String[] args) {
        // Point d'entrée du programme

        // Analyse des arguments en entrée
        File cheminBase = null;
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

        if (cheminBase.isDirectory()) {
            // Analyse paquet
            ResultatAnalysePaquet resultat = AnalyserPaquet(cheminBase);
            ImprimerStatistiquesPaquet(resultat);
        }
        else {
            // Analyse fichier simple
            ResultatAnalyseFichier resultat = AnalyserFichier(cheminBase);
            ImprimerStatistiquesFichier(resultat);
        }
    }

    //endregion MAIN

    //region ================================ CHAMPS ================================

    /**
     * Ensemble de tous les extensions ce programme supporterait l'analyse de commentaires sur.
     * Veuillez écrire les extensions à supporter en minuscules.
     */
    static final String[] EXTENSIONS_FICHIERS = {"java"};

    //endregion CHAMPS

    //region ================================ FONCTIONS ================================

    /**
     * Obtenir l'extension d'un fichier, en minuscules, à partir de son chemin.
     * Cette fonction retourne la chaîne de caractère après et excluant le point final (délimiteur d'extension).
     * <br>
     * Si le fichier ne possède pas d'extension valide, cette fonction retourne {@code null}.
     * @param cheminFichier le chemin du fichier
     * @return l'extension du fichier, en minuscules, sans le point (délimiteur d'extension). {@code null} si n'existe pas.
     */
    public static String ObtenirExtensionFichier(Path cheminFichier) {
        String nomFichier = cheminFichier.getFileName().toString();
        int indexPointExtension = nomFichier.lastIndexOf(".");
        if (indexPointExtension > 0 && nomFichier.length() > indexPointExtension) {
            return nomFichier.substring(indexPointExtension + 1).toLowerCase(Locale.ROOT);
        } else {
            return null;
        }
    }

    /**
     * Obtenir le nom complet du paquet d'un fichier ou dossier à partir de son chemin relatif au chemin du dossier/paquet de base.
     * @param paquetBase le chemin du paquet de base
     * @param paquet le chemin du fichier/dossier spécifié
     * @return le nom complet du paquet, basé sur le chemin relatif
     */
    public static String ObtenirNomPaquet(Path paquetBase, Path paquet) {
        if (!Files.isDirectory(paquetBase)) {
            return Files.isDirectory(paquet) ? paquet.getFileName().toString() : "";
        }
        else if (paquetBase.equals(paquet)) {
            return paquetBase.getFileName().toString();
        }

        String cheminRelatif = paquetBase.toUri().relativize(paquet.toUri()).toString();

        if (Objects.equals(cheminRelatif, paquet.toString())) {
            // paquetBase ne fait pas partie de paquet
            return Files.isDirectory(paquet) ? paquet.getFileName().toString() : "";
        }

        // Scénario normal: paquet = paquetBase + cheminRelatif
        cheminRelatif = cheminRelatif.replaceAll(File.pathSeparator, ".");
        return paquetBase.getFileName().toString() + "." + cheminRelatif;
    }

    static ResultatAnalyseFichier AnalyserFichier(File fichier) {
        // TODO: analyse d'un fichier (peu importe l'extension) utilisant une instance d'AnalyseurCommentaires
    }

    static ResultatAnalysePaquet AnalyserPaquet(File dossierPaquet) {
        /* Conversion des extensions supportées en un ensemble permet de dédupliquer les éléments,
         * convertir tout en minuscule, et faire appel à la méthode contains() */
        Set<String> ExtensionsSupportees = new HashSet<>(Arrays.stream(EXTENSIONS_FICHIERS).map(String::toLowerCase).toList());

        // Cette collection contiendrra tous les résultats des analyses de commentaires sur les fichiers individuels
        Collection<ResultatAnalyseFichier> resultats = new LinkedList<>();

        // populer la collection resultats en analysant chaque fichier de code
        try {
            // Utiliser la méthode du stream Java pour traverser tous les fichiers .java à partir du dossier racine
            Files.walk(dossierPaquet.toPath())
                    .filter( cheminFichier -> ExtensionsSupportees.contains(ObtenirExtensionFichier(cheminFichier)) )
                    .forEach( cheminFichier -> resultats.add(AnalyserFichier(cheminFichier.toFile())) );
        } catch (IOException e) {
            System.err.println("Une erreur s'est produite lors de la traverse des dossiers à la recherche des fichiers Java: " + e.getMessage());
            e.printStackTrace();
        }

        return new ResultatAnalysePaquet(resultats);
    }

    static void ImprimerStatistiquesFichier(ResultatAnalyseFichier resultat) {
        // TODO: imprimer les statistiques de l'analyse fichier

    }

    static void ImprimerStatistiquesPaquet(ResultatAnalysePaquet resultat) {
        // TODO: analyser le nom des paquets & imprimer les statistiques de l'analyse paquet

    }

    //endregion FONCTIONS

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
}
