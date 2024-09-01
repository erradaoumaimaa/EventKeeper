package service;

import model.Event;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private EventService eventService;

    public Menu(EventService eventService) {
        this.eventService = eventService;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisir votre rôle:");
        System.out.println("1 - Admin");
        System.out.println("2 - Utilisateur");
        System.out.print("Votre choix : ");
        int roleChoice = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        if (roleChoice == 1) {
            displayAdminMenu();
        } else if (roleChoice == 2) {
            displayUserMenu();
        } else {
            System.out.println("Choix invalide. Veuillez réessayer.");
            displayMenu();
        }
    }

    private void displayAdminMenu() {
        Scanner scanner = new Scanner(System.in);

        boolean continueManaging = true;

        while (continueManaging) {
            System.out.println("\nMenu:");
            System.out.println("************* GESTION Événements (Admin) ***************");
            System.out.println("1. Ajouter un événement ");
            System.out.println("2. Modifier un événement");
            System.out.println("3. Supprimer un événement");
            System.out.println("************* AFFICHAGE Événements ***************");
            System.out.println("4. Afficher les événements disponibles");
            System.out.println("5. Rechercher un événement par date");
            System.out.println("6. Rechercher un événement par type");
            System.out.println("************* GESTION Participants ***************");
            System.out.println("7. Afficher tous les participants");
            System.out.println("8. Ajouter un participant");
            System.out.println("9. Modifier un participant");
            System.out.println("10. Supprimer un participant");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            int adminChoice = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            switch (adminChoice) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    updateEvent();
                    break;
                case 3:
                    deleteEvent();
                    break;
                case 4:
                    displayAllEvents();
                    break;
                case 5:
                    searchEventsByDate();
                    break;
                case 6:
                    searchEventsByType();
                    break;
                case 7:
                    // Afficher tous les participants
                    break;
                case 8:
                    // Ajouter un participant
                    break;
                case 9:
                    // Modifier un participant
                    break;
                case 10:
                    // Supprimer un participant
                    break;
                case 0:
                    continueManaging = false; // Quitter le menu admin
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }
        }

        System.out.println("Retour au menu principal.");
        displayMenu();
    }

    private void addEvent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Combien d'événements souhaitez-vous ajouter ? ");
        int numberOfEvents = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfEvents; i++) {
            System.out.println("Veuillez saisir les informations pour l'événement " + (i + 1) + ":");

            System.out.print("Titre : ");
            String title = scanner.nextLine();

            System.out.print("Description : ");
            String description = scanner.nextLine();

            System.out.print("Lieu : ");
            String location = scanner.nextLine();

            System.out.print("Type : ");
            String type = scanner.nextLine();

            System.out.print("Date (format YYYY-MM-DD) : ");
            LocalDate date = LocalDate.parse(scanner.nextLine());

            Event event = new Event(0, title, description, location, type, date);

            eventService.addEvent(event);
            System.out.println("Événement ajouté !\n");
        }

        displayAllEvents();
    }

    private void updateEvent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Modification d'un événement :");
        System.out.print("ID de l'événement à modifier : ");
        int idToUpdate = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        System.out.print("Nouveau titre : ");
        String newTitle = scanner.nextLine();

        System.out.print("Nouvelle description : ");
        String newDescription = scanner.nextLine();

        System.out.print("Nouveau lieu : ");
        String newLocation = scanner.nextLine();

        System.out.print("Nouveau type : ");
        String newType = scanner.nextLine();

        System.out.print("Nouvelle date (format YYYY-MM-DD) : ");
        LocalDate newDate = LocalDate.parse(scanner.nextLine());

        Event updatedEvent = new Event(idToUpdate, newTitle, newDescription, newLocation, newType, newDate);
        Event updatedResult = eventService.updateEvent(updatedEvent);

        if (updatedResult != null) {
            System.out.println("Événement mis à jour avec succès !");
        } else {
            System.out.println("Aucun événement trouvé avec l'ID spécifié.");
        }

        displayAllEvents();
    }

    private void deleteEvent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Suppression d'un événement :");
        System.out.print("ID de l'événement à supprimer : ");
        int idToDelete = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        Event deleteEvent = new Event(idToDelete);
        Event deleteResult = eventService.deleteEvent(deleteEvent);

        if (deleteResult != null) {
            System.out.println("Événement supprimé avec succès !");
        } else {
            System.out.println("Aucun événement trouvé avec l'ID spécifié.");
        }

        displayAllEvents();
    }

    private void displayAllEvents() {
        System.out.println("Liste des événements :");
        for (Event event : eventService.getEvents()) {
            System.out.println(event);
        }
    }

    private void searchEventsByDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez la date (format YYYY-MM-DD) : ");
        LocalDate searchDate = LocalDate.parse(scanner.nextLine());

        List<Event> eventsByDate = eventService.searchEventsByDate(searchDate);
        System.out.println("Événements trouvés :");
        for (Event event : eventsByDate) {
            System.out.println(event);
        }
    }

    private void searchEventsByType() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le type : ");
        String searchType = scanner.nextLine();

        List<Event> eventsByType = eventService.searchEventsByType(searchType);
        System.out.println("Événements trouvés :");
        for (Event event : eventsByType) {
            System.out.println(event);
        }
    }

    private void displayUserMenu() {
    }
}
