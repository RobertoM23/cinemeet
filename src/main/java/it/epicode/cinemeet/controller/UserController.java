package it.epicode.cinemeet.controller;

import it.epicode.cinemeet.model.Event;
import it.epicode.cinemeet.model.User;
import it.epicode.cinemeet.repository.EventRepository;
import it.epicode.cinemeet.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepo;
    private final EventRepository eventRepo;

    public UserController(UserRepository userRepo, EventRepository eventRepo) {
        this.userRepo = userRepo;
        this.eventRepo = eventRepo;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User loginData) {
        User user = userRepo.findByEmail(loginData.getEmail());
        if (user != null && user.getPassword().equals(loginData.getPassword())) {
            return user;
        }
        throw new RuntimeException("Invalid credentials");
    }

    @GetMapping("/{userId}/events")
    public List<Event> getUserEvents(@PathVariable Long userId) {
        return eventRepo.findByCreatorId(userId);
    }
}
