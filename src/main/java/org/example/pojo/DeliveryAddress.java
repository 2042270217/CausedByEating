package org.example.pojo;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAddress {
    private int daId;
    @NotEmpty
    private String contactName;
    private int contactSex;
    @NotEmpty
    private String contactTel;
    @NotEmpty
    private String address;
    private String userId;
}
