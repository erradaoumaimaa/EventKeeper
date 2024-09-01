import model.Event;
import service.EventService;
import java.util.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventService eventService = new EventService();

        // Ajout de plusieurs événements
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

            // Créer un nouvel événement avec un ID temporaire (0 dans ce cas)
            Event event = new Event(0, title, description, location, type, date);

            // Ajouter l'événement via EventService
            eventService.addEvent(event);
            System.out.println("Événement ajouté !\n");
        }

        // Afficher tous les événements
        System.out.println("Liste des événements ajoutés :");
        for (Event event : eventService.getEvents()) {
            System.out.println(event);
        }

        // Mise à jour d'un événement
        System.out.println("Modification d'un événement :");

        // Saisir l'ID de l'événement à mettre à jour
        System.out.print("ID de l'événement à modifier : ");
        int idToUpdate = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        // Saisir les nouvelles informations pour l'événement
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

        // Créer un événement avec les nouvelles informations
        Event updatedEvent = new Event(idToUpdate, newTitle, newDescription, newLocation, newType, newDate);

        // Mettre à jour l'événement via EventService
        Event updatedResult = eventService.updateEvent(updatedEvent);

        // Afficher le résultat de la mise à jour
        if (updatedResult != null) {
            System.out.println("Événement mis à jour avec succès !");
        } else {
            System.out.println("Aucun événement trouvé avec l'ID spécifié.");
        }

        // Afficher tous les événements après la mise à jour
        System.out.println("Liste des événements après mise à jour :");
        for (Event event : eventService.getEvents()) {
            System.out.println(event);
        }

        // Supprimer un événement
        System.out.println("Supprimer un événement :");

        // Saisir l'ID de l'événement à supprimer
        System.out.print("ID de l'événement à supprimer : ");
        int idToDelete = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        // Créer un événement avec l'ID à supprimer
        Event deleteEvent = new Event(idToDelete);

        // Supprimer l'événement via EventService
        Event deleteResult = eventService.deleteEvent(deleteEvent);

        // Afficher le résultat de la suppression
        if (deleteResult != null) {
            System.out.println("Événement supprimé avec succès !");
        } else {
            System.out.println("Aucun événement trouvé avec l'ID spécifié.");
        }

        // Afficher tous les événements après la suppression
        System.out.println("Liste des événements après suppression :");
        for (Event event : eventService.getEvents()) {
            System.out.println(event);
        }
        // Recherche par date
        System.out.println("Recherche d'événements par date :");
        System.out.print("Entrez la date (format YYYY-MM-DD) : ");
        LocalDate searchDate = LocalDate.parse(scanner.nextLine());
        List<Event> eventsByDate = eventService.searchEventsByDate(searchDate);
        System.out.println("Événements trouvés :");
        for (Event event : eventsByDate) {
            System.out.println(event);
        }

        // Recherche par lieu
        System.out.println("Recherche d'événements par lieu :");
        System.out.print("Entrez le lieu : ");
        String searchLocation = scanner.nextLine();
        List<Event> eventsByLocation = eventService.searchEventsByLocation(searchLocation);
        System.out.println("Événements trouvés :");
        for (Event event : eventsByLocation) {
            System.out.println(event);
        }

        // Recherche par type
        System.out.println("Recherche d'événements par type :");
        System.out.print("Entrez le type : ");
        String searchType = scanner.nextLine();
        List<Event> eventsByType = eventService.searchEventsByType(searchType);
        System.out.println("Événements trouvés :");
        for (Event event : eventsByType) {
            System.out.println(event);
        }
    }

}
