package model;

public class Registration {
    private int id;
    private Event event;
    private Participant participant;


    // Constructeur
    public Registration(Event event, Participant participant) {
        this.event = event;
        this.participant = participant;
    }

    public Registration(int id){
        this.id =id;
    }

    public Registration() {

    }

    public int getId(){
        return id;
    }

    public void setId(){
        this.id = id;
    }
    // Getter pour Event
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }



    // Getter pour Participant
    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
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
