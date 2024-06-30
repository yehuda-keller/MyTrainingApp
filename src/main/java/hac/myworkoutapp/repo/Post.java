package hac.myworkoutapp.repo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Title of Post is mandatory")
    private String titleOfPost;

    @NotEmpty(message = "User name is mandatory")
    @Size(min = 3, max = 50, message = "User name must be between 3 and 50 characters")
    private String userName;

    @PastOrPresent(message = "Date cannot be in the future")
    private LocalDate date;

    public Post() {}

    public Post(String titleOfPost, String userName, LocalDate date) {
        this.titleOfPost = titleOfPost;
        this.userName = userName;
        this.date = date;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", titleOfPost='" + titleOfPost + '\'' +
                ", userName='" + userName + '\'' +
                ", date=" + date +
                '}';
    }
}
