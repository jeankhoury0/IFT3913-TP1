package org.ift3913.tp1;

/**
 * Représente un automate pour l'analyse des commentaires dans du code.
 * <br>
 * L'automate fonctionne en analysant caractère-par-caractère l'entièreté du code.
 * Un {@link java.io.BufferedReader} est recommandé pour la lecture.
 *
 * @author Pierre Janier Dubry et Rui Jie Liu
 */
public interface AutomateCommentaires {
    /**
     * Retourner si l'état actuel de l'automate est un commentaire ou non.
     * @return si l'état actuel représente un commentaire.
     */
    boolean estCommentaire();

    /**
     * Obtenir le prochain état de l'automate en soumettant le caractère suivant.
     * @param prochainChar le caractère suivant le curseur actuel.
     * @return l'état suivant de l'automate.
     */
    AutomateCommentairesJava prochainEtat(char prochainChar);
}
