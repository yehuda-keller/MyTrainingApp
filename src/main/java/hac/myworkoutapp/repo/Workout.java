package hac.myworkoutapp.repo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.*;
import java.io.Serializable;

@Entity
public class Workout  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Name is mandatory")
    private String userName;

    @NotEmpty(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @PositiveOrZero(message = "Visits must be positive or zero")
    @NotNull
    private int visits = 0;

    @Positive(message = "Age must be positive")
    private int age;

    @Positive(message = "Current weight must be positive")
    private double currentWeight;

    public Workout() {}

    public Workout(String userName, String email, int age, double currentWeight) {
        this.userName = userName;
        this.email = email;
        this.age = age;
        this.currentWeight = currentWeight;
    }

    public int getVisits() {
        return visits;
    }
    public void setVisits(int visits) {
        this.visits = visits;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        if (userName.length() > 32)
            throw new IllegalArgumentException("Name cannot exceed 32 characters");
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }
    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", visits=" + visits +
                ", age=" + age +
                ", currentWeight=" + currentWeight +
                '}';
    }
}
