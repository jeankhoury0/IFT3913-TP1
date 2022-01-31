// Un id est consturit lorsqu'un appointment ou un visiteur est créé.
// Il gènre automatiquement un numero d'identification.

package utils;

public class Id {
    private final String id;

    public Id() {
        this.id = createNewId();
    }

    public String createNewId() {
        return "NEWID";
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }

    /**
    * le seul moyen de comparer des id entre eux est par la chaine de
    * caractères qu'ils contiennent.
    * @param other un objet à comparer avec l'id courant.
    */
    @Override
    public boolean equals(Object other) {
        return this.toString().equals(other.toString());
    }

}
