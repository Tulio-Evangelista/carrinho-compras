package dev.java.ecommerce.carrinhodecompras.service;


import dev.java.ecommerce.carrinhodecompras.client.PlatziStoreClient;
import dev.java.ecommerce.carrinhodecompras.model.ProductModel;
import dev.java.ecommerce.carrinhodecompras.response.PlatziProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final PlatziStoreClient platziStoreClient;

    @Cacheable(value = "products")
    public List<PlatziProductResponse> listarProdutos() {
        log.info("Buscando todos os produtos");
        return platziStoreClient.listarProducts();
    }

    @Cacheable(value = "product", key = "#id")
    public PlatziProductResponse listarProdutosPorId(Long id) {
        log.info("Buscando produto : {}", id);
        return platziStoreClient.listarProductsPorId(id);
    }
}
