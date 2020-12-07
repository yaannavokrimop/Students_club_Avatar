package com.avatar.services;

import com.avatar.models.dto.PreviewDto;
import com.avatar.models.entities.Event;
import com.avatar.models.entities.Preview;
import com.avatar.models.mappers.PreviewMapper;
import com.avatar.repositories.EventRepo;
import com.avatar.repositories.PreviewRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PreviewService {
    private final EventRepo eventRepo;
    private final PreviewRepo previewRepo;

    public PreviewDto getPreview (UUID eventId) {
        Event event = eventRepo.findById(eventId).orElseThrow(NullPointerException::new);
        return PreviewMapper.INSTANCE.PreviewToPreviewDto(event.getPreview());
    }

    public void changePreview (UUID eventId, PreviewDto previewDto) {
        Event event = eventRepo.findById(eventId).orElseThrow(NullPointerException::new);
        Preview inputPreview = PreviewMapper.INSTANCE.PreviewDtoToPreview(previewDto, event);
        Preview dbPreview = event.getPreview();
        event.setPreview(inputPreview);
//        Preview dbPreview = Optional.ofNullable(event.getPreview()).orElse(new Preview());
        Event event1 = eventRepo.save(event);
//        BeanUtils.copyProperties(inputPreview, dbPreview, "eventId", "participants", "organisers", "contactPerson");
    }
}
