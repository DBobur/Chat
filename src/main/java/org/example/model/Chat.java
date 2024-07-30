package org.example.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Chat extends BaseModel{
    private UUID fromUserId;
    private UUID toUserId;
}
