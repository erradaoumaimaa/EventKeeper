
package interfaces;
import model.Event;

import java.time.LocalDate;
import java.util.List;


public interface InterfaceEvent {


   Event addEvent(Event event);

   List<Event> getEvents();

   Event updateEvent(Event event);

   Event deleteEvent(Event event);

   List<Event> searchEventsByDate(LocalDate date);

   List<Event> searchEventsByLocation(String location);

   List<Event> searchEventsByType(String type);
}
