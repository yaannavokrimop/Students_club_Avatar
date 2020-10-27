package com.avatar.repositories;


import com.avatar.models.entities.Event;
import com.avatar.models.enums.EventStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface EventRepo extends JpaRepository<Event, UUID> {

    @Query("select distinct event from Event event " +
            "where (event.organiserId = :organiserId or :organiserId is null) " +
            "and (event.dateTimeStart >= :dateStart) " +
            "and (event.eventStatus in (:statusList) or :statusList is null)")
    Page<Event> findAllByParams(@Param(value="statusList") List<EventStatus> statusList,
                                @Param(value = "dateStart") Date dateStart,
                                @Param(value = "organiserId") Integer organiserId,
                                Pageable page);

    @Query("select distinct event from Event event " +
            "where (event.organiserId = :organiserId or :organiserId is null) " +
            "and (event.dateTimeStart >= :dateStart) " +
            "and (event.dateTimeFinish <= :dateFinish) " +
            "and (event.eventStatus in (:statusList) or :statusList is null)")
    Page<Event> findAllByParamsAndDateTimeFinish(@Param(value="statusList") List<EventStatus> statusList,
                                @Param(value = "dateStart") Date dateStart,
                                @Param(value = "dateFinish") Date dateFinish,
                                @Param(value = "organiserId") Integer organiserId,
                                Pageable page);
}

