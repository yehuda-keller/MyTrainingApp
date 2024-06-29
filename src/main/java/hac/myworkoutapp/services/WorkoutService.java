package hac.myworkoutapp.services;

import hac.myworkoutapp.repo.Workout;
import hac.myworkoutapp.repo.WorkoutRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public List<Workout> findWorkoutsByTypeOfTraining(String typeOfTraining) {
        return workoutRepository.findByTypeOfTraining(typeOfTraining);
    }

    public List<Workout> findWorkoutsByExerciseName(String exerciseName) {
        return workoutRepository.findByExerciseName(exerciseName);
    }

    public List<Workout> findWorkoutsByWorkingWeights(double workingWeights) {
        return workoutRepository.findByWorkingWeights(workingWeights);
    }

    public List<Workout> findWorkoutsByTypeOfTrainingAndExerciseName(String typeOfTraining, String exerciseName) {
        return workoutRepository.findByTypeOfTrainingAndExerciseName(typeOfTraining, exerciseName);
    }

    public List<Workout> findFirst10WorkoutsByTypeOfTrainingDesc() {
        return workoutRepository.findFirst10ByOrderByTypeOfTrainingDesc();
    }

    public void deleteWorkout(Long id) {
        workoutRepository.deleteById(id);
    }
}
