package br.com.otbank.orquestrador.controller;

import br.com.otbank.orquestrador.config.TopicProducer;
import br.com.otbank.orquestrador.integracao.ClientContaDigital;
import br.com.otbank.orquestrador.request.TransacaoRequest;
import feign.FeignException;
import org.apache.kafka.common.internals.Topic;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orquestrador/conta-digital")
public class OrquestradorController {

    private ClientContaDigital clientContaDigital;
    private TopicProducer topicProducer;

    public OrquestradorController(ClientContaDigital clientContaDigital,
                                  TopicProducer topicProducer) {
        this.clientContaDigital = clientContaDigital;
        this.topicProducer = topicProducer;
    }

    @PutMapping("/transacoes")
    public ResponseEntity<?> orquestrador(@RequestBody TransacaoRequest transacaoRequest){
        try {
            clientContaDigital.cadastraTransacoes(transacaoRequest);
            var novaTransacao = transacaoRequest.toExtratoRequest();
            topicProducer.send(novaTransacao);
            return ResponseEntity.ok().build();
        }catch (FeignException.NotFound e){
            return ResponseEntity.notFound().build();
        }catch (FeignException.UnprocessableEntity e){
            return ResponseEntity.unprocessableEntity().build();
        }catch (FeignException e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
