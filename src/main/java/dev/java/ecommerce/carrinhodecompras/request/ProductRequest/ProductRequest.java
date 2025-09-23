package dev.java.ecommerce.carrinhodecompras.request.ProductRequest;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductRequest(Long id, Integer quantity, String title, BigDecimal price) {
}
