package model;

import java.time.LocalDate;

public class Event {

    // Insertion des variables
    private int id;
    private String title;
    private String description;
    private String location;
    private String type;
    private LocalDate date;

    // Constructeur
    public Event(int id, String title, String description, String location, String type ,LocalDate date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type= type;
        this.date = date;
    }
    public Event(int id) {
        this.id = id;
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
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
