package org.ift3913.tp1.automates;

/**
 * Représente un automate pour l'analyse des mots-clés <b>{@code switch}</b> à l'intérieur du code Java.
 * Un mot-clé ainsi trouvé n'est valide que lorsqu'il respecte la case de chaque lettre et
 * est un identifiant indépendant, c'est-à-dire qu'il n'est pas entouré par des chiffres et des
 * "lettres Java" (un caractère Unicode accepté par la fonction {@link Character#isJavaIdentifierPart(char)}).
 * <br><br>
 * L'automate fonctionne en analysant caractère-par-caractère l'entièreté du code.
 * Un {@link java.io.BufferedReader} est recommandé pour la lecture.
 * <br><br>
 * Note que cet automate ne prend pas en compte de la validité du mot-clé trouvé comme étant
 * une déclaration du début d'une structure de contrôle. Pour assurer la validité, il faut
 * combiner le résultat des automates d'analyse de commentaires et de litéraux de strings.
 *
 * @author Pierre Janier Dubry et Rui Jie Liu
 */
public enum AutomateSwitch implements AutomateJava {
    /**
     * Valeur: tout caractère
     * <br>
     * État initial, aucun mot-clé.
     */
    Initial {
        public boolean valide() {
            return false;
        }

        @Override
        public AutomateSwitch prochainEtat(char prochainChar) {
            return null;
        }
    }
    // TODO: construire l'automate switch
}
