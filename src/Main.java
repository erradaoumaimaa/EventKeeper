import model.Event;
import model.Participant;
import service.Menu;
import service.EventService;
import service.ParticipantService;
import java.util.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        EventService eventService = new EventService();
        ParticipantService participantService = new ParticipantService();
        Menu menu = new Menu(eventService , participantService );
        menu.displayMenu();
        }
    }
