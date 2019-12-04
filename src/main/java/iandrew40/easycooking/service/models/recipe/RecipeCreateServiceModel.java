package iandrew40.easycooking.service.models.recipe;

import java.time.LocalDate;

public class RecipeCreateServiceModel {

    private String name;
    private String category;
    private LocalDate dateAdded;
    private String user;

    public RecipeCreateServiceModel() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDateAdded() {
        return this.dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
