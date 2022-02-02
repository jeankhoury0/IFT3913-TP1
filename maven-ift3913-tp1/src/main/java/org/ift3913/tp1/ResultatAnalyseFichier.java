package org.ift3913.tp1;

/**
 * Données obtenues après une analyse de commentaires auprès d'un fichier de code.
 *
 * @author Pierre Janier Dubry et Rui Jie Liu
 */
public record ResultatAnalyseFichier(int lignesDeCode, int lignesCommentaires) {
    public double DensiteCommentaires() {
        return (double) lignesCommentaires / (double) lignesDeCode;
    }
}
