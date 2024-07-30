package org.example.model;

import lombok.*;

@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel{
    private String fullName;
    private String username;
    private String password;
}
