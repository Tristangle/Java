package Calcul;

public class Division extends Regles implements calcul {
    @Override
    public boolean isAllowed() {
        boolean isAllowed = true;
        for (int i = 0; i < partition.length - 1; i++) {
            if (partition[i] == '/' && partition[i + 1] == '0') {
                // Calcul.Division par zéro détectée
                isAllowed = false;
                return isAllowed;
            }
        }
        return isAllowed;
    }
    @Override
    public double operation(double operant1, double operant2) {
        if(isAllowed()){
            return operant1 / operant2;
        }
        throw new IllegalArgumentException("Division par 0");
    }
}
