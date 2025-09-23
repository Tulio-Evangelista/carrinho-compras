package dev.java.ecommerce.carrinhodecompras.entity;


import dev.java.ecommerce.carrinhodecompras.enums.Status;
import dev.java.ecommerce.carrinhodecompras.model.ProductModel;
import dev.java.ecommerce.carrinhodecompras.service.ProductService;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "carrinho")
public class Carrinho {


    private String id;

    private Long client;

    private BigDecimal total;

    private List<ProductModel> produtos;

    private Status status;

    public void calcularTotal(ProductService productService){
        this.total = produtos.stream().map(p -> productService.listarProdutosPorId(p.getId())
                .price().multiply(BigDecimal.valueOf(p.getQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
