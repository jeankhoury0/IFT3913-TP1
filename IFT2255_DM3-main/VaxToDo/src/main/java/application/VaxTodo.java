// c'est la classe à exécuter qui va initialiser les contrôleurs,
// les modèles et la vue du programme VaxToDo.

package application;

import controller.SystemController;

import java.io.IOException;

public class VaxTodo {

    // initialisation du programme
    public static void main(String[] args) throws IOException {
        SystemController sc = SystemController.GetInstance();
    }

}


