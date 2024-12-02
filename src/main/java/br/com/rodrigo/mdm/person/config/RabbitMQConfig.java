package br.com.rodrigo.mdm.person.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.*;

@Configuration
public class RabbitMQConfig {

    // Nome da fila
    public static final String QUEUE_NAME = "REP_IN_OUT";

    // Nome da exchange
    public static final String EXCHANGE_NAME = "exchange";

    // Routing key
    public static final String ROUTING_KEY = "REP_IN_OUT";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
}