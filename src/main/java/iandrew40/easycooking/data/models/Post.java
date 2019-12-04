package iandrew40.easycooking.data.models;

import iandrew40.easycooking.data.models.base.BaseEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "content", nullable = false)
    @Type(type = "text")
    private String content;

    @ManyToOne
    //@JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    private User user;

    @JoinTable(
            name = "posts_comments",
            joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id", referencedColumnName = "id")
    )
    @OneToMany  //(targetEntity = Comment.class, mappedBy = "post", fetch=FetchType.EAGER)
    private List<Comment> comments;

     @Column(name = "date_added", nullable = false)
    private LocalDate dateAdded;

    public Post() {
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


    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public List<Comment> getComments() {
        return this.comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


    public LocalDate getDateAdded() {
        return this.dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }
}
