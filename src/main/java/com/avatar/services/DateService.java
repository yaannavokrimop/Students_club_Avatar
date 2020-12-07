package com.avatar.services;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;

@Service
public class DateService {
//    private final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    public void checkDate(Date dateFrom, Date dateTo) {
        if (dateTo.compareTo(dateFrom) < 0) throw new DateTimeException("Дата окончания указана неверно.");
    }
}
