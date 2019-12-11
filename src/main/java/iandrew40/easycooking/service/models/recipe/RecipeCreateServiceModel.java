package iandrew40.easycooking.service.models.recipe;

import iandrew40.easycooking.data.models.Ingredient;

import java.time.LocalDate;
import java.util.List;

public class RecipeCreateServiceModel {

    private String name;
    private String category;
    private List<String> ingredients;
    private LocalDate dateAdded;
    private String howToPrepare;
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

    public List<String> getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public LocalDate getDateAdded() {
        return this.dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getHowToPrepare() {
        return this.howToPrepare;
    }

    public void setHowToPrepare(String howToPrepare) {
        this.howToPrepare = howToPrepare;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
