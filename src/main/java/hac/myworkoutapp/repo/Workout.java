package hac.myworkoutapp.repo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

@Entity
public class Workout implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Type of training is mandatory")
    private String typeOfTraining;

    @NotEmpty(message = "Name of the exercise is mandatory")
    private String exerciseName;

    @Min(value = 0, message = "Working weights must be 0 or more")
    private double workingWeights;

    @Min(value = 1, message = "Level of satisfaction with performance must be at least 1")
    @Max(value = 5, message = "Level of satisfaction with performance must be at most 5")
    private int satisfactionWithPerformance;

    @Min(value = 1, message = "Level of satisfaction with exercise must be at least 1")
    @Max(value = 5, message = "Level of satisfaction with exercise must be at most 5")
    private int satisfactionWithExercise;



    public Workout() {}

    public Workout(String typeOfTraining, String exerciseName, double workingWeights, int satisfactionWithPerformance, int satisfactionWithExercise) {
        this.typeOfTraining = typeOfTraining;
        this.exerciseName = exerciseName;
        this.workingWeights = workingWeights;
        this.satisfactionWithPerformance = satisfactionWithPerformance;
        this.satisfactionWithExercise = satisfactionWithExercise;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTypeOfTraining() {
        return typeOfTraining;
    }

    public void setTypeOfTraining(String typeOfTraining) {
        this.typeOfTraining = typeOfTraining;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public double getWorkingWeights() {
        return workingWeights;
    }

    public void setWorkingWeights(double workingWeights) {
        this.workingWeights = workingWeights;
    }

    public int getSatisfactionWithPerformance() {
        return satisfactionWithPerformance;
    }

    public void setSatisfactionWithPerformance(int satisfactionWithPerformance) {
        this.satisfactionWithPerformance = satisfactionWithPerformance;
    }

    public int getSatisfactionWithExercise() {
        return satisfactionWithExercise;
    }

    public void setSatisfactionWithExercise(int satisfactionWithExercise) {
        this.satisfactionWithExercise = satisfactionWithExercise;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", typeOfTraining='" + typeOfTraining + '\'' +
                ", exerciseName='" + exerciseName + '\'' +
                ", workingWeights=" + workingWeights +
                ", satisfactionWithPerformance=" + satisfactionWithPerformance +
                ", satisfactionWithExercise=" + satisfactionWithExercise +
                '}';
    }
}
