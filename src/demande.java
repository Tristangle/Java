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
        double nombreCourant = 0;
        boolean isNombreEnCours = false;
        int signe = 1; // Pour gérer les signes + et - du nombre courant

        for (int i = 0; i < demandeList.size(); i++) {
            char currentChar = demandeList.get(i);

            if (Character.isDigit(currentChar) || currentChar == '.') {
                // Si le caractère est un chiffre ou un point, ajoutez-le au nombre courant
                isNombreEnCours = true;
            }  else if (currentChar == '*' || currentChar == '/') {
                // Si le caractère est un opérateur, ajoutez le nombre courant à la partition
                if (isNombreEnCours) {
                    partition.add(signe * nombreCourant);
                    isNombreEnCours = false;
                    nombreCourant = 0;
                }
                // Ajoutez l'opérateur à la partition
                partition.add((double) currentChar);
            } else {
                throw new IllegalArgumentException("Caractère non supporté : " + currentChar);
            }
        }

        // Ajoutez le dernier nombre à la partition s'il y en a un
        if (isNombreEnCours) {
            partition.add(signe * nombreCourant);
        }

        return partition;
    }

}
