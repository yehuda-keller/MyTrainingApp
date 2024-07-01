package hac.myworkoutapp.repo;

import jakarta.persistence.*;
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

    private String description;

    @NotEmpty(message = "User name is mandatory")
    @Size(min = 3, max = 50, message = "User name must be between 3 and 50 characters")
    private String userName;

    @PastOrPresent(message = "Date cannot be in the future")
    private LocalDate date;

    @Lob
    @Column(name = "photo",
            columnDefinition = "LONGBLOB")
    private byte[] photo;

    @Transient
    private String base64Photo;

    public Post() {}

    public Post(String titleOfPost, String userName,String description, LocalDate date, byte[] photo) {
        this.titleOfPost = titleOfPost;
        this.description = description;
        this.userName = userName;
        this.date = date;
        this.photo = photo;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getBase64Photo() {
        return base64Photo;
    }

    public void setBase64Photo(String base64Photo) {
        this.base64Photo = base64Photo;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", titleOfPost='" + titleOfPost + '\'' +
                ", description='" + description + '\'' +
                ", userName='" + userName + '\'' +
                ", date='" + date + '\'' +
                ", photo=" + java.util.Arrays.toString(photo) +
                '}';
    }
}
