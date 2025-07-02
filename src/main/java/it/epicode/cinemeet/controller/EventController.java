package it.epicode.cinemeet.controller;

import it.epicode.cinemeet.model.Event;
import it.epicode.cinemeet.repository.EventRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventRepository eventRepo;

    public EventController(EventRepository eventRepo) {
        this.eventRepo = eventRepo;
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventRepo.save(event);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }
}
