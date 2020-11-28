package com.avatar.repositories;

import com.avatar.models.entities.Event;
import com.avatar.models.entities.Preview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreviewRepo extends JpaRepository<Preview, Event> {
}
