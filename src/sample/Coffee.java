package sample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {
	private String name;
	private int supplierId;
	private BigDecimal price;
	private int sales;
	private int total;
}
