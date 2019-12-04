package iandrew40.easycooking.web.models.recipe;

public class RecipeCreateModel {

    private String name;
    private String category;

    public RecipeCreateModel() {
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
}
