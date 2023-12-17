package Calcul;

/**
 * Classe implémentant l'opération de soustraction.
 * Hérite des règles de base définies dans OperationRules.
 * Implémente l'interface OperationInterface pour définir le comportement de l'opération.
 */
public class Soustraction extends Regles implements calcul {
    /*@Override
    public boolean ContainsNonDigitNumbers() {
        return super.ContainsNonDigitNumbers();
    }*/
    @Override
    public boolean isAllowed() {
        return true;
    }

    @Override
    public double operation(double operant1, double operant2) {
        return operant1 - operant2;
    }


    // Implémentation spécifique de la soustraction

}
