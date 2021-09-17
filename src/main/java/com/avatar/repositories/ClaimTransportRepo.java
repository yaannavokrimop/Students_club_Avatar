package com.avatar.repositories;

import com.avatar.models.entities.claims.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClaimTransportRepo extends JpaRepository<Transport, UUID> {
}
