package iandrew40.easycooking.data.models;

import iandrew40.easycooking.data.models.base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

    @ManyToOne
   // @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne
    //@JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private Recipe recipe;

    @ManyToOne
   // @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;

    @Column(name = "date_added", nullable = false)
    private LocalDate dateAdded;

    public Comment() {
    }


    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Recipe getRecipe() {
        return this.recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }


    public Post getPost() {
        return this.post;
    }

    public void setPost(Post post) {
        this.post = post;
    }


    public LocalDate getDateAdded() {
        return this.dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }
}
