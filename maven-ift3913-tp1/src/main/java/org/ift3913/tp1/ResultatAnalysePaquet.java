package org.ift3913.tp1;

import java.util.Collection;

/**
 * Données obtenues après une analyse de commentaires auprès d'un paquet (dossier)
 * contenant possiblement plusieurs fichiers de code.
 *
 * @author Pierre Janier Dubry et Rui Jie Liu
 */
public record ResultatAnalysePaquet(Collection<ResultatAnalyseFichier> resultatsFichiers) {

    public int LigneCodesTotal() {
        return resultatsFichiers.stream().mapToInt(ResultatAnalyseFichier::lignesDeCode).sum();
    }

    public int LignesCommentairesTotal() {
        return resultatsFichiers.stream().mapToInt(ResultatAnalyseFichier::lignesCommentaires).sum();
    }

    public double DensiteCommentaires() {
        return (double) LignesCommentairesTotal() / (double) LigneCodesTotal();
    }
}
