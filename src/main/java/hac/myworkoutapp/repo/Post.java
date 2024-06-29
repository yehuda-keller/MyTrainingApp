package hac.myworkoutapp.repo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;
@Entity
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Title of Post is mandatory")
    private String titleOfPost;


    public Post() {}

    public Post(String titleOfPost) {
        this.titleOfPost = titleOfPost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitleOfPost() {
        return titleOfPost;
    }

    public void setTitleOfPost(String titleOfPost) {
        this.titleOfPost = titleOfPost;
    }



    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", titleOfPost='" + titleOfPost + '\'' +
                '}';
    }

}