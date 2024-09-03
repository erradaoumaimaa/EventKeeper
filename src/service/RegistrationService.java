package service;

import interfaces.InterfaceRegistration;
import model.Event;
import model.Participant;
import model.Registration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RegistrationService implements InterfaceRegistration {
    private List<Registration> registrations = new ArrayList<>();

    @Override
    public Registration addRegistration(Event event, Participant participant) {
        Registration registration = new Registration(event, participant);
        registrations.add(registration);
        return registration;
    }

    @Override
    public boolean removeRegistration(int registrationId) {
        return registrations.removeIf(registration -> registration.getId() == registrationId);
    }

    @Override
    public List<Registration> getRegistrationsByEvent(Event event) {
        return registrations.stream()
                .filter(registration -> registration.getEvent().equals(event))
                .collect(Collectors.toList());
    }



    @Override
    public List<Event> getEventsByParticipant(Participant participant) {
        return registrations.stream()
                .filter(registration -> registration.getParticipant().equals(participant))
                .map(Registration::getEvent)
                .collect(Collectors.toList());
    }


    public List<Event> getEvents(Participant participant) {
        return registrations.stream()
                .filter(reg -> reg.getParticipant().equals(participant))
                .map(Registration::getEvent)
                .collect(Collectors.toList());
    }
}
