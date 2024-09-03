import model.Event;
import model.Participant;
import service.Menu;
import service.EventService;
import service.ParticipantService;
import service.RegistrationService;

import java.util.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        EventService eventService = new EventService();
        ParticipantService participantService = new ParticipantService();
        RegistrationService registrationService = new RegistrationService();

        Menu menu = new Menu(eventService , participantService , registrationService );
        menu.displayMenu();
        }
    }
