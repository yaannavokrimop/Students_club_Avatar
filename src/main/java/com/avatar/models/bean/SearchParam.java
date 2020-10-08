package com.avatar.models.bean;

import com.avatar.models.enums.EventStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SearchParam {
    List<EventStatus> statusList;
    Date dateStart;
    Date dateFinish;
    Boolean onlyPersonal;
}
