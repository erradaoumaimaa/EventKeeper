package service;

import java.time.LocalDate;
import java.util.Scanner;

public class InputValidator {

    private Scanner scanner;

    public InputValidator() {
        this.scanner = new Scanner(System.in);
    }

    public int getIntInput(String prompt) {
        int input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                scanner.nextLine(); // Consommer la nouvelle ligne
                break;
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
                scanner.next(); // Consommer l'entrée incorrecte
            }
        }
        return input;
    }

    public String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public LocalDate getDateInput(String prompt) {
        LocalDate date;
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                date = LocalDate.parse(input);
                break;
            } catch (Exception e) {
                System.out.println("Format de date invalide. Veuillez utiliser le format YYYY-MM-DD.");
            }
        }
        return date;
    }
}
