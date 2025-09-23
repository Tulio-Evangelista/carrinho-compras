package dev.java.ecommerce.carrinhodecompras.response;

import lombok.Builder;

import java.io.Serializable;
import java.math.BigDecimal;



@Builder
public record PlatziProductResponse(Long id, String title, BigDecimal price) implements Serializable {
}
