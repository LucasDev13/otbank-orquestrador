package br.com.otbank.orquestrador.integracao;

import br.com.otbank.orquestrador.request.TransacaoRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "conta-digital", url = "${conta-digital.host}")
public interface ClientContaDigital {

    @PutMapping("${conta-digital.cadastraTransacao}")
    void cadastraTransacoes(@RequestBody TransacaoRequest transacaoRequest);
}
