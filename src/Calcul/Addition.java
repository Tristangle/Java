package Calcul;

/**
 * Classe implémentant l'opération d'addition.
 * Hérite des règles de base définies dans Calcul.Regles.
 * Implémente l'interface OperationInterface pour définir le comportement de l'opération.
 */
public class Addition extends Regles implements calcul {
    @Override
    public boolean isAllowed() {
        return true;
    }

    @Override
    public double operation(double operant1, double operant2) {
        return operant1 + operant2;
    }


    // Implémentation spécifique de l'addition

    // Redéfinition des méthodes de l'interface et des règles communes

    // ...

}
