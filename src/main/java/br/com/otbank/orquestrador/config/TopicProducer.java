package br.com.otbank.orquestrador.config;

import br.com.otbank.orquestrador.request.NovaTransacaoExtratoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TopicProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

//    public TopicProducer(KafkaTemplate<String, Object> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }

    public void send(NovaTransacaoExtratoRequest message){
        kafkaTemplate.send(topicName, message);
    }

}
