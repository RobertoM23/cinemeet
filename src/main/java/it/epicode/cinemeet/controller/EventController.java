package it.epicode.cinemeet.controller;

import it.epicode.cinemeet.model.Event;
import it.epicode.cinemeet.model.User;
import it.epicode.cinemeet.repository.EventRepository;
import it.epicode.cinemeet.repository.UserRepository;
import it.epicode.cinemeet.service.EmailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventRepository eventRepo;
    private final UserRepository userRepo;
    private final EmailService emailService;

    public EventController(EventRepository eventRepo, UserRepository userRepo, EmailService emailService) {
        this.eventRepo = eventRepo;
        this.userRepo = userRepo;
        this.emailService = emailService;
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventRepo.save(event);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    @PostMapping("/{eventId}/join")
    public String joinEvent(@PathVariable Long eventId, @RequestParam Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("Utente non trovato"));
        Event event = eventRepo.findById(eventId).orElseThrow(() -> new RuntimeException("Evento non trovato"));

        emailService.sendEmail(
                user.getEmail(),
                "Conferma iscrizione evento",
                "Ciao " + user.getName() + ", sei iscritto all'evento: " + event.getMovieTitle());

        return "Utente iscritto ed email inviata";
    }
    }