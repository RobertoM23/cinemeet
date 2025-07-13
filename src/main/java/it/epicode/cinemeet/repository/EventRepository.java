package it.epicode.cinemeet.repository;

import it.epicode.cinemeet.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByCreatorId(Long creatorId);
    List<Event> findByCreatorIdNot(Long creatorId);
}