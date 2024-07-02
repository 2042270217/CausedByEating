package org.example.pojo;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAddress {
    private int daId;
    @NotEmpty
    private String contactName;
    @Range(min = 0, max = 1,message = "数值越界[0,1]")
    private int contactSex;
    @NotEmpty
    private String contactTel;
    @NotEmpty
    private String address;
    private String userId;
}
