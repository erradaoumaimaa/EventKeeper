package service;

import model.Event;
import model.Participant;
import model.Registration;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private EventService eventService;
    private ParticipantService participantService;
    private RegistrationService registrationService;
    private InputValidator inputValidator;

    private Scanner scanner;

    public Menu(EventService eventService ,ParticipantService participantService ,RegistrationService registrationService) {
        this.eventService = eventService;
        this.participantService=participantService;
        this.registrationService=registrationService;
        this.scanner = new Scanner(System.in);
        this.eventService = new EventService(registrationService);
        this.inputValidator = new InputValidator();
    }
    private Menu(){}
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
            System.out.println("************* Statistique d'un evenement ***************");
            System.out.println("11. Afficher les statistiques");
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
                    getAllParticipant();
                    break;
                case 8:
                    addParticipant();
                    break;
                case 9:
                    updateParticipant();
                    break;
                case 10:
                    deleteParticipant();
                    break;
                case 11:
                    generateReport();
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
        int numberOfEvents = inputValidator.getIntInput("Combien d'événements souhaitez-vous ajouter ? ");

        for (int i = 0; i < numberOfEvents; i++) {
            System.out.println("Veuillez saisir les informations pour l'événement " + (i + 1) + ":");

            String title = inputValidator.getStringInput("Titre : ");
            String description = inputValidator.getStringInput("Description : ");
            String location = inputValidator.getStringInput("Lieu : ");
            String type = inputValidator.getStringInput("Type : ");
            LocalDate date = inputValidator.getDateInput("Date (format YYYY-MM-DD) : ");

            Event event = new Event(0, title, description, location, type, date);
            eventService.addEvent(event);
            System.out.println("Événement ajouté !\n");
        }

        displayAllEvents();
    }

    private void updateEvent() {
        int idToUpdate = inputValidator.getIntInput("ID de l'événement à modifier : ");
        String newTitle = inputValidator.getStringInput("Nouveau titre : ");
        String newDescription = inputValidator.getStringInput("Nouvelle description : ");
        String newLocation = inputValidator.getStringInput("Nouveau lieu : ");
        String newType = inputValidator.getStringInput("Nouveau type : ");
        LocalDate newDate = inputValidator.getDateInput("Nouvelle date (format YYYY-MM-DD) : ");

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

    private void addParticipant() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Combien de participants souhaitez-vous ajouter ? ");
        int numberOfParticipants = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfParticipants; i++) {
            System.out.println("Veuillez saisir les informations pour le participant " + (i + 1) + ":");

            System.out.print("Nom : ");
            String name = scanner.nextLine();

            System.out.print("Numéro de téléphone : ");
            String phone = scanner.nextLine();

            // Création d'un nouvel objet Participant avec un ID temporaire
            Participant participant = new Participant(0, name, phone);

            // Ajout du participant via ParticipantService
            participantService.addParticipant(participant);
            System.out.println("Participant ajouté !\n");
        }

        // Affichage de tous les participants après ajout
        getAllParticipant();
    }

    private void getAllParticipant() {
        List<Participant> participants = participantService.getAllParticipant();

        if (participants.isEmpty()) {
            System.out.println("Aucun participant enregistré.");
        } else {
            System.out.println("Liste des participants :");
            for (Participant participant : participants) {
                System.out.println(participant);
            }
        }
    }


    private void updateParticipant() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez l'ID du participant à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        // Saisie des nouvelles informations pour le participant
        System.out.print("Nouveau nom : ");
        String newName = scanner.nextLine();

        System.out.print("Nouveau numéro de téléphone : ");
        String newPhone = scanner.nextLine();

        // Création d'un objet Participant avec les nouvelles informations
        Participant updatedParticipant = new Participant(id, newName, newPhone);

        // Mise à jour du participant via ParticipantService
        Participant result = participantService.updateParticipant(updatedParticipant);

        if (result != null) {
            System.out.println("Participant mis à jour avec succès !");
        } else {
            System.out.println("Aucun participant trouvé avec l'ID spécifié.");
        }
        getAllParticipant();
    }


    private void deleteParticipant() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez l'ID du participant à supprimer : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        // Création d'un objet Participant avec l'ID à supprimer
        Participant participantToDelete = new Participant(id);
        // Suppression du participant via ParticipantService
        Participant result = participantService.deleteParticipant(participantToDelete);
        if (result != null) {
            System.out.println("Participant supprimé avec succès !");
        } else {
            System.out.println("Aucun participant trouvé avec l'ID spécifié.");
        }
        getAllParticipant();
    }

    private void generateReport() {
        String report = eventService.generateEventReport();
        System.out.println(report);
    }

    public void displayUserMenu() {
        int choix;
        do {
            System.out.println("\n--- Menu Utilisateur ---");
            System.out.println("1. S'inscrire à un événement");
            System.out.println("2. Se désinscrire d'un événement");
            System.out.println("3. Voir mes inscriptions");
            System.out.println("4. Afficher les inscriptions d'un événement");
            System.out.println("5. Quitter");
            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    registerForEvent();
                    break;
                case 2:
                    unregisterFromEvent();
                    break;
                case 3:
                    viewMyRegistrations();
                    break;
                case 4:
                    viewMyEventRegistrations();
                    break;
                case 5:
                    System.out.println("Fermeture du menu...");
                    displayMenu();
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 5);
    }
    private void registerForEvent() {
        System.out.print("Enter your Participant ID: ");
        int participantId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Participant participant = participantService.getParticipantById(participantId);
        if (participant == null) {
            System.out.println("Participant not found.");
            return;
        }

        System.out.print("Enter Event ID to register: ");
        int eventId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Event event = eventService.getEventById(eventId);
        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        Registration registration = registrationService.addRegistration(event, participant);
        System.out.println("Registration successful: " + registration);
    }

    private void unregisterFromEvent() {
        System.out.print("Enter your Participant ID: ");
        int participantId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Participant participant = participantService.getParticipantById(participantId);
        if (participant == null) {
            System.out.println("Participant not found.");
            return;
        }

        System.out.print("Enter Event ID to unregister: ");
        int eventId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Event event = eventService.getEventById(eventId);
        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        List<Registration> registrations = registrationService.getRegistrationsByEvent(event);
        Registration toRemove = registrations.stream()
                .filter(reg -> reg.getParticipant().getId() == participantId)
                .findFirst()
                .orElse(null);

        if (toRemove != null) {
            registrationService.removeRegistration(toRemove.getId());
            System.out.println("Unregistered successfully.");
        } else {
            System.out.println("You are not registered for this event.");
        }
    }

    private void viewMyRegistrations() {
        System.out.print("Enter your Participant ID: ");
        int participantId = scanner.nextInt();
        scanner.nextLine();

        Participant participant = participantService.getParticipantById(participantId);
        if (participant == null) {
            System.out.println("Participant not found.");
            return;
        }

        List<Event> events = registrationService.getEventsByParticipant(participant);
        if (events.isEmpty()) {
            System.out.println("You have no event registrations.");
        } else {
            System.out.println("You are registered for the following events:");
            events.forEach(event -> System.out.println("- " + event.getTitle()));
        }
    }


    private void viewMyEventRegistrations() {
        System.out.print("Entrez l'ID de l'événement pour afficher les inscriptions : ");
        int eventId = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne

        Event event = eventService.getEventById(eventId);

        if (event != null) {
            List<Registration> registrations = registrationService.getRegistrationsByEvent(event);
            if (registrations.isEmpty()) {
                System.out.println("Aucune inscription trouvée pour cet événement.");
            } else {
                System.out.println("Inscriptions pour l'événement : " + event.getTitle());
                for (Registration registration : registrations) {
                    System.out.println("Participant : " + registration.getParticipant().getName());
                }
            }
        } else {
            System.out.println("Événement non trouvé.");
        }
    }


}