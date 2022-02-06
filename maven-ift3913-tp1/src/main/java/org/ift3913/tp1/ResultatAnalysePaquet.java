package org.ift3913.tp1;

import java.util.Collection;
import java.util.Dictionary;

/**
 * Données obtenues après une analyse de commentaires auprès d'un paquet (dossier)
 * contenant possiblement plusieurs fichiers de code.
 * Les résultats d'analyse de chaque fichier sont stockés à l'intérieur d'un dictionnaire:
 * nom du paquet (String) : liste de toutes les classes dans ce paquet Collection<ResultatAnalyseFichier>
 *
 * @author Pierre Janier Dubry et Rui Jie Liu
 */
public record ResultatAnalysePaquet(Dictionary<String, Collection<ResultatAnalyseFichier>> resultatsFichiers) {

    public int ligneCodesTotal() {
        int total = 0;
        resultatsFichiers.elements().asIterator().forEachRemaining(x -> total += x.stream().mapToInt(ResultatAnalyseFichier::lignesDeCode).sum());
        return total;
    }

    public int lignesCommentairesTotal() {
        return resultatsFichiers.stream().mapToInt(ResultatAnalyseFichier::lignesCommentaires).sum();
    }

    public double DensiteCommentaires() {
        return (double) lignesCommentairesTotal() / (double) ligneCodesTotal();
    }
}
