package dev.java.ecommerce.carrinhodecompras.service;


import dev.java.ecommerce.carrinhodecompras.client.PlatziStoreClient;
import dev.java.ecommerce.carrinhodecompras.model.ProductModel;
import dev.java.ecommerce.carrinhodecompras.response.PlatziProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final PlatziStoreClient platziStoreClient;

    public List<PlatziProductResponse> listarProdutos() {
        return platziStoreClient.listarProducts();
    }

    public PlatziProductResponse listarProdutosPorId(Long id) {
        return platziStoreClient.listarProductsPorId(id);
    }
}
