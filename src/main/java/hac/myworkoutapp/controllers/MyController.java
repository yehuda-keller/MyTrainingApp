package hac.myworkoutapp.controllers;

import hac.myworkoutapp.repo.Workout;
import hac.myworkoutapp.repo.WorkoutRepository;
import hac.myworkoutapp.services.WorkoutService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.util.HashMap;
import java.util.Map;


@Controller
public class MyController {

    private static Logger logger = LoggerFactory.getLogger(MyController.class);


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/user/protein-count")
    public String userProteinCount() {
        return "user/protein-count";
    }

    @RequestMapping("/user/recipes")
    public String userRecipes() {
        return "user/recipes";
    }

    @RequestMapping("/user/my-workouts")
    public String userMyWorkouts() {
        return "user/my-workouts";
    }

    @GetMapping("/sharing-the-process")
    public String userSharingTheProcess() {
        return "sharing-the-process";
    }


    @GetMapping("/user/add-workout")
    public String showAddWorkoutForm() {
        return "user/add-workout";
    }


    @RequestMapping("/403")
    public String forbidden() {
        return "403";
    }

    @RequestMapping("/simulateError")
    public void simulateError() {
        throw new RuntimeException("This is a simulated exception thrown by a controller");
    }

    @RequestMapping("/errorpage")
    public String error(Exception ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception ex, Model model) {
        String errorMessage = (ex != null ? ex.getMessage() : "Unknown error");
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }

}
