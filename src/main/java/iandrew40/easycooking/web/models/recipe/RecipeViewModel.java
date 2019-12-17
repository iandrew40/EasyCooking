package iandrew40.easycooking.web.models.recipe;

import iandrew40.easycooking.data.models.Ingredient;
import iandrew40.easycooking.web.models.BaseViewModel;

import java.time.LocalDate;
import java.util.List;

public class RecipeViewModel extends BaseViewModel {

    private String name;
    private Integer views;
    private Double rating;
    private LocalDate dateAdded;
    private List<Ingredient> ingredients;
    private String howToPrepare;

    public RecipeViewModel() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDate getDateAdded() {
        return this.dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
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
}
