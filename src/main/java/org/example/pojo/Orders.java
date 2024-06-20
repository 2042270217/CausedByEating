package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private int orderId;
    private String userId;
    private int businessId;
    private String orderDate;
    private int orderTotal;
    private int daId;
    private int orderState;
}
