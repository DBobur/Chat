package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@ToString
public abstract class BaseModel {
    {
        id = UUID.randomUUID();
        createDate = Calendar.getInstance().getTime();
    }

    private UUID id;
    private Date createDate;
}
