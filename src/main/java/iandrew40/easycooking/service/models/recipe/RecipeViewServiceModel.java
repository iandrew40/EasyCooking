package iandrew40.easycooking.service.models.recipe;

import iandrew40.easycooking.data.models.Ingredient;
import iandrew40.easycooking.service.models.BaseServiceModel;

import java.time.LocalDate;
import java.util.List;

public class RecipeViewServiceModel extends BaseServiceModel {

    private String name;
    private String category;
    private List<Ingredient> ingredients;
    private String howToPrepare;
    private LocalDate dateAdded;
    private String user;
    private Integer views;
    private Double rating;

    public RecipeViewServiceModel() {
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

    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getHowToPrepare() {
        return this.howToPrepare;
    }

    public void setHowToPrepare(String howToPrepare) {
        this.howToPrepare = howToPrepare;
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

    public Integer getViews() {
        return this.views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Double getRating() {
        return this.rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
