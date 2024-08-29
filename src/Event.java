import java.time.LocalDate;

public class Event {

    // Insertion des variables
    private int id;
    private String title;
    private String description;
    private String location;
    private LocalDate date;

    // Constructeur
    public Event(int id, String title, String description, String location, LocalDate date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.date = date;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", date=" + date +
                '}';
    }

}
