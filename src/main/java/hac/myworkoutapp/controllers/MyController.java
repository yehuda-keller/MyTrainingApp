package hac.myworkoutapp.controllers;

import hac.myworkoutapp.repo.WorkoutRepository;
import hac.myworkoutapp.repo.Workout;
import hac.myworkoutapp.repo.Post;
import hac.myworkoutapp.repo.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.time.LocalDate;
import java.util.List;

@Controller
public class MyController {

    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/admin/admin-page")
    public String adminPage(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "admin/admin-page";
    }

    @RequestMapping("/shared/protein-count")
    public String userProteinCount() {
        return "shared/protein-count";
    }

    @PostMapping("/shared/protein-count")
    public String calculateProtein(
            @RequestParam("product") String product,
            @RequestParam("weight") double weight,
            Model model) {
        // Protein calculation logic here
        return "shared/protein-count";
    }

    @RequestMapping("/shared/recipes")
    public String userRecipes() {
        return "shared/recipes";
    }

    @GetMapping("/shared/my-workouts")
    public String userMyWorkouts(Model model) {
        model.addAttribute("workouts", workoutRepository.findAll());
        return "shared/my-workouts";
    }

    @GetMapping("/shared/add-workout")
    public String userAddWorkout(Model model) {
        model.addAttribute("workout", new Workout());
        return "shared/add-workout";
    }

    @PostMapping("/shared/add-workout")
    public String addWorkout(@Valid @ModelAttribute("workout") Workout workout, Model model) {
        workoutRepository.save(workout);
        return "redirect:/shared/my-workouts";
    }

    @PostMapping("/shared/delete-workout/{id}")
    public String deleteWorkout(@PathVariable Long id) {
        workoutRepository.deleteById(id);
        return "redirect:/shared/my-workouts";
    }

    @GetMapping("/sharing-the-process")
    public String userSharingTheProcess(Model model) {
        List<Post> posts = postRepository.findAll();
        posts.forEach(post -> {
            if (post.getPhoto() != null) {
                String base64Image = Base64.getEncoder().encodeToString(post.getPhoto());
                post.setBase64Photo(base64Image);
            }
        });
        model.addAttribute("posts", posts);
        return "sharing-the-process";
    }

    @GetMapping("/shared/add-post")
    public String userAddPost(Model model) {
        Post post = new Post();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        post.setUserName(auth.getName());
        post.setDate(LocalDate.now());
        model.addAttribute("post", post);
        return "shared/add-post";
    }

    @PostMapping("/shared/add-post")
    public String addPost(@Valid @ModelAttribute("post") Post post,
                          BindingResult result,
                          @RequestParam("file") MultipartFile file,
                          Model model) {
        if (result.hasErrors()) {
            return "shared/add-post";
        }
        if (!file.isEmpty()) {
            if (!file.getContentType().startsWith("image/")) {
                model.addAttribute("fileError", "Only image files are allowed.");
                return "shared/add-post";
            }
            try {
                post.setPhoto(file.getBytes());
            } catch (IOException e) {
                logger.error("Error uploading file", e);
            }
        }
        postRepository.save(post);
        return "redirect:/sharing-the-process";
    }


    @GetMapping("/shared/edit-post/{id}")
    public String editPost(@PathVariable Long id, Model model) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        model.addAttribute("post", post);
        return "shared/edit-post";
    }

    @PostMapping("/shared/delete-post/{id}")
    public String deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return "redirect:/sharing-the-process";
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
