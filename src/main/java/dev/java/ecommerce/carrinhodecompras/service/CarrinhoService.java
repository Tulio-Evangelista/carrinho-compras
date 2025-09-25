package dev.java.ecommerce.carrinhodecompras.service;


import dev.java.ecommerce.carrinhodecompras.entity.Carrinho;
import dev.java.ecommerce.carrinhodecompras.enums.Status;
import dev.java.ecommerce.carrinhodecompras.model.ProductModel;
import dev.java.ecommerce.carrinhodecompras.repository.CarrinhoRepository;
import dev.java.ecommerce.carrinhodecompras.request.CarrinhoRequest;
import dev.java.ecommerce.carrinhodecompras.response.PlatziProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;
    private final ProductService productService;



    public Carrinho listarCarrinhosPorId(String id){
        return carrinhoRepository.findById(id).orElseThrow(() -> new RuntimeException("Carrinho nao encontrado"));
    }


    List<ProductModel> produtcs = new ArrayList<>();
    public Carrinho createdCarrinho(CarrinhoRequest carrinhoRequest){
        carrinhoRepository.findByClientAndStatus(carrinhoRequest.client(), Status.Open)
                .ifPresent(carrinho -> {
                    throw new RuntimeException("Carrinho ja existe para esse cliente");
                });


        carrinhoRequest.products().forEach(productRequest -> {
            PlatziProductResponse platziProductResponse = productService.listarProdutosPorId(productRequest.getId());

            produtcs.add(ProductModel.builder()
                    .id(platziProductResponse.id())
                    .title(platziProductResponse.title())
                    .price(platziProductResponse.price())
                    .quantity(productRequest.getQuantity())
                    .build());

        });





        Carrinho carrinho = Carrinho
                .builder()
                .client(carrinhoRequest.client())
                .status(Status.Open)
                .produtos(carrinhoRequest.products())
                .build();


        carrinho.calcularTotal(productService);
        return carrinhoRepository.save(carrinho);
    }



    public Carrinho atualizarCarrinhoPorId(String id, CarrinhoRequest carrinhoRequest){
        Carrinho carrinho = listarCarrinhosPorId(id);

        if(carrinho.getStatus() == Status.Closed){
            throw new RuntimeException("Carrinho ja finalizado");
        }

        List<ProductModel> produtosAtualizados = new ArrayList<>();

        carrinhoRequest.products().forEach(productRequest -> {
            PlatziProductResponse platziProductResponse = productService.listarProdutosPorId(productRequest.getId());

            produtosAtualizados.add(ProductModel.builder()
                    .id(platziProductResponse.id())
                    .title(platziProductResponse.title())
                    .price(platziProductResponse.price())
                    .quantity(productRequest.getQuantity())
                    .build());

        });

        carrinho.setProdutos(produtosAtualizados);
        carrinho.calcularTotal(productService);

        return carrinhoRepository.save(carrinho);
    }


}
