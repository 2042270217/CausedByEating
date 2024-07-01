package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userId;
    @JsonIgnore
    private String password;
    private String userName;
    private int userSex;
    private String userImage;
    private int delTag;

}
