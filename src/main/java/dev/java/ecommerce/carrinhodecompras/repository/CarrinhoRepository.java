package dev.java.ecommerce.carrinhodecompras.repository;

import dev.java.ecommerce.carrinhodecompras.entity.Carrinho;
import dev.java.ecommerce.carrinhodecompras.enums.Status;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface CarrinhoRepository extends MongoRepository<Carrinho, String> {


    Optional<Carrinho> findByClientAndStatus(Long client, Status status);
}
