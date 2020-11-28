package com.avatar.services;

import com.avatar.models.dto.PreviewDto;
import com.avatar.models.entities.Event;
import com.avatar.models.entities.Preview;
import com.avatar.models.mappers.PreviewMapper;
import com.avatar.repositories.EventRepo;
import com.avatar.repositories.PreviewRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class PreviewService {
    private final EventRepo eventRepo;
    private final PreviewRepo previewRepo;

    public PreviewDto getPreview (UUID eventId) {
        Event event = eventRepo.findById(eventId).orElseThrow(NullPointerException::new);
        Preview preview = previewRepo.findById(event).orElse(new Preview(event));
        return PreviewMapper.INSTANCE.PreviewToPreviewDto(preview);
    }
}
