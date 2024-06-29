package hac.myworkoutapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    List<Workout> findByTypeOfTraining(String typeOfTraining);
    List<Workout> findByExerciseName(String exerciseName);
    List<Workout> findByWorkingWeights(double workingWeights);
    List<Workout> findByTypeOfTrainingAndExerciseName(String typeOfTraining, String exerciseName);
    List<Workout> findFirst10ByOrderByTypeOfTrainingDesc(); // find first 10 workouts ordered by typeOfTraining desc

}
