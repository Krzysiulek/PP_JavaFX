package sample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoffeTO {
    private String cof_name;
    private int sup_id;
    private BigDecimal price;
    private int sales;
    private int total;
}
