package org.example.pojo;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userId;
    @JsonIgnore
    private String password;
    @NotEmpty
    private String userName;
    @Range(min = 0, max = 1,message = "数值越界[0,1]")
    private int userSex;
    private String userImage;
    @Range(min = 0, max = 1,message = "数值越界[0,1]")
    private int delTag;

}
