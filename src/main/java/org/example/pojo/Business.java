package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business {
    private int businessId;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private String businessImg;
    private int orderTypeId;
    private int starPrice;
    private int deliveryPrice;
    private String remarks;
}
