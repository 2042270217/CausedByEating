package org.example.pojo;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private int cartId;
    private int foodId;
    private int businessId;
    private String userId;
    @Min(value = 0,message = "数量不得小于0")
    private int quantity;
}
