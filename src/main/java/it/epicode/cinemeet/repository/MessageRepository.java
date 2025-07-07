package it.epicode.cinemeet.repository;

import it.epicode.cinemeet.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByEventId(Long eventId);
}
