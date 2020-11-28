package com.avatar.repositories;

import com.avatar.models.entities.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CharacteristicRepo extends JpaRepository<Characteristic, UUID> {
}
