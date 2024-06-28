package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAddress {
    private int daId;
    private String contactName;
    private int contactSex;
    private String contactTel;
    private String address;
    private String userId;
}
