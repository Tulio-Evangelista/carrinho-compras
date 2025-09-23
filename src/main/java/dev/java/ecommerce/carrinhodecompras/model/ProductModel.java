package dev.java.ecommerce.carrinhodecompras.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@Builder
public class ProductModel {


    private Long id;

    private String title;

    private BigDecimal price;

    private Integer quantity;

}
