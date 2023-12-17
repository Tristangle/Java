package Calcul;

public class Division extends Regles implements calcul {
    /*@Override
    public boolean ContainsNonDigitNumbers() {
        return super.ContainsNonDigitNumbers();
    }*/
    @Override
    public boolean isAllowed() {
        boolean isAllowed = true;
        //for (int i = 0; i < operandes.length - 1; i++) {
          //  if (operandes[i] == '/' && operandes[i + 1] == '0') {
                // Calcul.Division par zéro détectée
            //    isAllowed = false;
              //  return isAllowed;
            //}
        //}
        return isAllowed;
    }
    @Override
    public double operation(double operant1, double operant2) {
        return operant1 / operant2;
    }
}
