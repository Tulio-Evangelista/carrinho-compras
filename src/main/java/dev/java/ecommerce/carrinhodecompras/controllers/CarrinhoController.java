package dev.java.ecommerce.carrinhodecompras.controllers;


import dev.java.ecommerce.carrinhodecompras.entity.Carrinho;
import dev.java.ecommerce.carrinhodecompras.request.CarrinhoRequest;
import dev.java.ecommerce.carrinhodecompras.service.CarrinhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carrinho")
@RequiredArgsConstructor
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    @GetMapping("/{id}")
    public ResponseEntity<Carrinho> ListarCarrinhosPorId(@PathVariable String id){
        return ResponseEntity.ok(carrinhoService.listarCarrinhosPorId(id));

    }

    @PostMapping("/criar")
    public ResponseEntity<Carrinho> criarCarrinho(@RequestBody CarrinhoRequest carrinhoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(carrinhoService.createdCarrinho(carrinhoRequest));
    }

}
