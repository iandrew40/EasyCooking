package iandrew40.easycooking.service.models.post;


import java.time.LocalDate;

public class PostCreateServiceModel {

    private String name;
    private String content;
    private String user;
    private LocalDate dateAdded;

    public PostCreateServiceModel() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDate getDateAdded() {
        return this.dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }
}
