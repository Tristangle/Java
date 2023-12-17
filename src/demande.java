import java.util.LinkedList;
import java.util.Scanner;
import Calcul.*;

public class demande {
    private LinkedList<Character> demandeList = new LinkedList<>();
    private char operation;

    public void demandeList() {
        Scanner demandeUtilisateur = new Scanner(System.in);

        System.out.println("Veuillez entrer l'opération désirée :");
        String demande = demandeUtilisateur.nextLine();

        convertirOperation(demande);
        OperationFactory operationFactory = new OperationFactory();
    }

    public void convertirOperation(String demande) {
        demande = demande.replace("x", "*");
        for (char c : demande.toCharArray()) {
            demandeList.add(c);
        }
        System.out.println(demandeList);
        analyserOperation();
    }

    public LinkedList<Double> analyserOperation() {
            LinkedList<Double> partition = new LinkedList<>();

            for (int i = 0; i < demandeList.size(); i++) {
                char currentChar = demandeList.get(i);

                if (Character.isDigit(currentChar)) {
                    // Si le caractère est un chiffre, ajoutez-le à la partition
                    partition.add((double) Character.getNumericValue(currentChar));
                } else {
                    // Si le caractère est un opérateur, redirigez l'opération avec deux opérandes
                    OperationFactory operationFactory = new OperationFactory();
                    calcul operation = (calcul) operationFactory.redirigerOperation(currentChar);

                    // Assurez-vous qu'il y a au moins deux opérandes dans la partition
                    if (partition.size() < 2) {
                        throw new IllegalStateException("Pas assez d'opérandes dans la partition.");
                    }

                    // Récupérez les deux derniers éléments de la partition pour les utiliser comme opérandes
                    double operand2 = partition.removeLast();
                    double operand1 = partition.removeLast();

                    // Appliquez l'opération et ajoutez le résultat à la partition
                    double result = operation.operation(operand1, operand2);
                    partition.add(result);
                }
            }

            // Vérifiez que la partition contient au moins un élément après le traitement
            if (partition.isEmpty()) {
                throw new IllegalStateException("Pas assez d'opérandes dans la partition.");
            }

            return partition;
        }
}
