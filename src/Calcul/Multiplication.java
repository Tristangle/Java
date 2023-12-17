package Calcul;
public class Multiplication extends Regles implements calcul {
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
        return operant1 * operant2;
    }
}
