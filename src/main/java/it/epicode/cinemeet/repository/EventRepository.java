package it.epicode.cinemeet.repository;

import it.epicode.cinemeet.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}