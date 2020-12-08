package com.avatar.services;

import com.avatar.models.dto.PreviewDto;
import com.avatar.models.entities.Event;
import com.avatar.models.entities.Preview;
import com.avatar.models.mappers.PreviewMapper;
import com.avatar.repositories.EventRepo;
import com.avatar.repositories.PreviewRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PreviewService {
    private final EventRepo eventRepo;
    private final PreviewRepo previewRepo;

    public PreviewDto getPreview(UUID eventId) {
        Event event = eventRepo.findById(eventId).orElseThrow(NullPointerException::new);
        return PreviewMapper.INSTANCE.PreviewToPreviewDto(event.getPreview());
    }

    public void changePreview(UUID eventId, PreviewDto previewDto) {
        Event event = eventRepo.findById(eventId).orElseThrow(NullPointerException::new);
        Preview dbPreview = Optional.ofNullable(event.getPreview()).orElse(new Preview(event));
        event.setSite(previewDto.getSite());
        Preview inputPreview = PreviewMapper.INSTANCE.PreviewDtoToPreview(previewDto, event);
        BeanUtils.copyProperties(inputPreview, dbPreview, "eventId", "event", "participants", "organisers", "contactPerson");
        event.setPreview(dbPreview);
        eventRepo.save(event);
    }
}
