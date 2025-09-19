package dev.java.ecommerce.carrinhodecompras.controllers;


import dev.java.ecommerce.carrinhodecompras.response.PlatziProductResponse;
import dev.java.ecommerce.carrinhodecompras.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<PlatziProductResponse>> listarProdutos() {
        List<PlatziProductResponse> produtos =  productService.listarProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatziProductResponse> listarProdutosPorId(@PathVariable Long id) {

        return ResponseEntity.ok(productService.listarProdutosPorId(id));
    }

}
