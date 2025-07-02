package it.epicode.cinemeet.controller;

import it.epicode.cinemeet.model.User;
import it.epicode.cinemeet.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepo;

    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
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
}
