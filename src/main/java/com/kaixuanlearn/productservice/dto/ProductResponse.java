package com.kaixuanlearn.productservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;

}
/** It is a good practice to seperate the Product Model and also the dto,
 * because we dont want all the field exposed to the outside world**/
