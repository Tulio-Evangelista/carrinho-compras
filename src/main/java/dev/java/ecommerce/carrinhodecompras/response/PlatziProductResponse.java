package dev.java.ecommerce.carrinhodecompras.response;

import java.math.BigDecimal;

public record PlatziProductResponse(Long id, String title, BigDecimal price) {
}
