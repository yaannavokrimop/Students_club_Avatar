package com.avatar.services.claims;

import com.avatar.models.entities.Address;
import com.avatar.models.entities.Event;
import com.avatar.models.entities.claims.Transport;
import com.avatar.repositories.ClaimTransportRepo;
import com.avatar.repositories.EventRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class TransportService {
    private final EventRepo eventRepo;
    private final ClaimTransportRepo transportRepo;

    public UUID addTransportClaim(Transport transportClaim, UUID eventId) {
        Event event = eventRepo.findById(eventId).orElseThrow(NullPointerException::new);
        return transportRepo.save(transportClaim).getId();
    }
}
