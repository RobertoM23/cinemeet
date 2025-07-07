package it.epicode.cinemeet.controller;

import it.epicode.cinemeet.model.Message;
import it.epicode.cinemeet.repository.MessageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private final MessageRepository messageRepo;

    public MessageController(MessageRepository messageRepo) {
        this.messageRepo = messageRepo;
    }

    @PostMapping
    public Message sendMessage(@RequestBody Message message) {
        return messageRepo.save(message);
    }

    @GetMapping("/event/{eventId}")
    public List<Message> getMessages(@PathVariable Long eventId) {
        return messageRepo.findByEventId(eventId);
    }
}
