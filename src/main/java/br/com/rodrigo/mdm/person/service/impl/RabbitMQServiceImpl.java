package br.com.rodrigo.mdm.person.service.impl;

import br.com.rodrigo.mdm.person.config.*;
import br.com.rodrigo.mdm.person.service.*;
import lombok.extern.slf4j.*;
import org.springframework.amqp.rabbit.core.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
@Slf4j
public class RabbitMQServiceImpl implements RabbitMQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, message);
        log.info("Mensagem enviada: {}", message);
    }
}
