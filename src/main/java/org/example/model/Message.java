package org.example.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Message extends BaseModel{
    private UUID userId;
    private UUID chatId;
    private String message;
}
