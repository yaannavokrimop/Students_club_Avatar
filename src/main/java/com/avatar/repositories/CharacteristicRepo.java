package com.avatar.repositories;

import com.avatar.models.entities.Characteristic;
import com.avatar.models.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CharacteristicRepo extends JpaRepository<Characteristic, Event> {
}
