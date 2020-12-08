package com.avatar.repositories;

import com.avatar.models.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParticipantRepo extends JpaRepository<Participant, UUID> {
}
