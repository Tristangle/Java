import Calcul.Addition;
import Calcul.Division;
import Calcul.Multiplication;
import Calcul.Soustraction;
public class OperationFactory {

    // Redirige vers la bonne opération
    public Object redirigerOperation(char operation) {
        switch (operation) {
            case '+':
                return new Addition();
            case '-':
                return new Soustraction();
            case '*':
                return new Multiplication();
            case '/':
                return new Division();
            default:
                throw new IllegalArgumentException("Opérateur non supporté : " + operation);
        }

    }

}
