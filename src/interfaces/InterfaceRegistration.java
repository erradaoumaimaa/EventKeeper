package interfaces;

import model.Event;
import model.Participant;
import model.Registration;

import java.util.List;

public interface InterfaceRegistration {
        Registration addRegistration(Event event, Participant participant);
        boolean removeRegistration(int registrationId);
        List<Registration> getRegistrationsByEvent(Event event);
        List<Event> getEventsByParticipant(Participant participant);
}
