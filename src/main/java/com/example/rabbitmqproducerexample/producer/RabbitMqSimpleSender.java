package com.example.rabbitmqproducerexample.producer;

import com.example.rabbitmqproducerexample.domain.User;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSimpleSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.simpleRoutingkey}")
    private String simpleRoutingkey;

    public void send(String msg){
        rabbitTemplate.convertAndSend(exchange, simpleRoutingkey, msg);
    }
}
