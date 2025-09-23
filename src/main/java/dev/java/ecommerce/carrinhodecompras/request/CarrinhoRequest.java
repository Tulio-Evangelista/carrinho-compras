package dev.java.ecommerce.carrinhodecompras.request;

import dev.java.ecommerce.carrinhodecompras.model.ProductModel;
import dev.java.ecommerce.carrinhodecompras.request.ProductRequest.ProductRequest;
import lombok.Builder;

import java.util.List;

@Builder
public record CarrinhoRequest(Long client, List<ProductModel> products ) {

}
