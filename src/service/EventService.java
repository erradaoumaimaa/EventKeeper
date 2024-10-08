package service;

import model.Event;
import interfaces.InterfaceEvent;


import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;



public class EventService implements InterfaceEvent{

    private List<Event> events = new LinkedList<>();
    private RegistrationService registrationService;

    private int nextId = 1;

    // Constructeur avec RegistrationService injecté
    public EventService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    //Methode pour l'ajout des evenement :
    @Override
    public Event addEvent(Event event) {
        event.setId(nextId++);
       events.add(event);
       return event;
    }



    //Methode pour Affichage des evenement :
    public List<Event> getEvents() {
        return events;
    }
    public Event getEventById(int id) {
        for (Event event : events) {
            if (event.getId() == id) {
                return event;
            }
        }
        return null;
    }
    @Override
    public Event updateEvent(Event newEvent) {

        for (int i=0 ;i< events.size();i++){

            if(events.get(i).getId()== newEvent.getId()){
                Event ev = events.get(i);
                ev.setTitle(newEvent.getTitle());
                ev.setDescription(newEvent.getDescription());
                ev.setLocation(newEvent.getLocation());
                ev.setType(newEvent.getType());
                ev.setDate(newEvent.getDate());

                return ev;
            }
        }
        return null;
    }

    @Override
    public Event deleteEvent(Event e) {
        for (int i =0 ; i<events.size();i++){
            if(events.get(i).getId()== e.getId()){
                Event removedEvent = events.remove(i);
                return removedEvent;
            }
        }
        return null;
    }

    @Override
    public List<Event> searchEventsByDate(LocalDate date) {
        return events.stream().filter(event -> event.getDate().equals(date)).collect(Collectors.toList());
    }


    @Override
    public List<Event> searchEventsByLocation(String location) {
        return events.stream().filter(event -> event.getLocation().equals(location)).collect(Collectors.toList()) ;
    }

    @Override
    public List<Event> searchEventsByType(String type) {
        return events.stream().filter(event -> event.getType().equals(type)).collect(Collectors.toList());
    }

    // affichage chaque event avec le nombre de participant dans l'évement :
    public String generateEventReport() {
        StringBuilder report = new StringBuilder();
        report.append("Rapport des événements:\n");

        for (Event event : events) { // events est la liste de tous les événements
            long count = registrationService.getRegistrationsByEvent(event).size();
            report.append("Événement: ").append(event.getTitle())
                    .append(", Nombre de participants: ").append(count)
                    .append("\n");
        }

        return report.toString();
    }




}
