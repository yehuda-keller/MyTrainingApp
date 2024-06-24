package hac.myworkoutapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/* default scope of this Bean is "singleton" */
public interface WorkoutRepository extends JpaRepository<Workout, Long> {


    List<Workout> findByUserName(String userName);
    List<Workout> findUserByUserName(String userName);
    List<Workout> findByEmail(String email);
    List<Workout> findByUserNameAndEmail(String userName, String email);
    List<Workout> findFirst10ByOrderByUserNameDesc(); // find first 10 users ordered by userName desc

}