package org.example.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @JsonIgnore
    private String userId;
    @JsonIgnore
    private String password;
    @NotEmpty
    private String userName;
    @Range(min = 0, max = 1,message = "数值越界[0,1]")
    private int userSex;
    private String userImg;
    @JsonIgnore
    @Range(min = 0, max = 1,message = "数值越界[0,1]")
    private int delTag;

}
