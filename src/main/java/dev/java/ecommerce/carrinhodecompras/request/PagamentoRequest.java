package dev.java.ecommerce.carrinhodecompras.request;


import dev.java.ecommerce.carrinhodecompras.enums.FormaPagamento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoRequest {


    private FormaPagamento pagamento;
}
