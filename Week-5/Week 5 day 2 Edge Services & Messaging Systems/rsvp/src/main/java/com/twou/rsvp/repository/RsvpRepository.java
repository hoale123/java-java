package com.twou.rsvp.repository;

import com.twou.rsvp.model.Rsvp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RsvpRepository extends JpaRepository<Rsvp, Long> {
    Rsvp save(Rsvp rsvp);
    Optional<Rsvp> findById(Long id);
    List<Rsvp> findAll();
    //void update(Rsvp rsvp);
    void deleteById(Long id);
}
