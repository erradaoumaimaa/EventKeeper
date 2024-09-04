import model.Event;
import model.Participant;
import service.Menu;
import service.EventService;
import service.ParticipantService;
import service.RegistrationService;

public class Main {
    public static void main(String[] args) {

        // Créer une instance de RegistrationService
        RegistrationService registrationService = new RegistrationService();

        // Passer registrationService lors de la création d'EventService
        EventService eventService = new EventService(registrationService);

        // Créer une instance de ParticipantService
        ParticipantService participantService = new ParticipantService();

        // Créer l'objet Menu en passant les services nécessaires
        Menu menu = new Menu(eventService, participantService, registrationService);

        // Afficher le menu
        menu.displayMenu();
    }
}
