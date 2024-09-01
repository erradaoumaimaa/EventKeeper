package model;

public class Registration {
    private Event event;
    private Participant participant;

    // Constructeur
    public Registration(Event event, Participant participant) {
        this.event = event;
        this.participant = participant;
    }

    // Getter pour Event
    public Event getEvent() {
        return event;
    }

    // Getter pour Participant
    public Participant getParticipant() {
        return participant;
    }

    // Méthode toString pour afficher les détails de l'inscription
    @Override
    public String toString() {
        return "Registration{" +
                "Event='" + event.getTitle() + '\'' +
                ", Participant='" + participant.getName() + '\'' +
                '}';
    }

}
