import java.time.LocalDate;

public class Registration {

    // Les attributs
    private int id;
    private LocalDate date;
    private int eventID;
    private int participantID;

    // Constructeur
    public Registration(int id, LocalDate date, int eventID, int participantID) {
        this.id = id;
        this.date = date;
        this.eventID = eventID;
        this.participantID = participantID;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getParticipantID() {
        return participantID;
    }

    public void setParticipantID(int participantID) {
        this.participantID = participantID;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", Date='" + date + '\'' +
                ", EventName='" + eventID + '\'' +
                ", ParticipantName='" + participantID + '\'' +
                '}';
    }
}
