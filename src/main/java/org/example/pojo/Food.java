package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Select;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    private int foodId;
    private String foodName;
    private String foodExplain;
    private String foodImg;
    private int foodPrice;
    private int businessId;
    private String remarks;
}
