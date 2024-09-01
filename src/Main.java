import model.Event;
import service.Menu;
import service.EventService;
import java.util.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        EventService eventService = new EventService();
        Menu menu = new Menu(eventService);
        menu.displayMenu();
        }
    }
