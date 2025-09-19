package dev.java.ecommerce.carrinhodecompras.client;


import dev.java.ecommerce.carrinhodecompras.response.PlatziProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "platzi-store", url = "${carrinho-compras.client.platzi}")
public interface PlatziStoreClient {


    @GetMapping("/products")
    List<PlatziProductResponse> listarProducts();

    @GetMapping("/products/{id}")
    PlatziProductResponse listarProductsPorId(@PathVariable Long id);
}
