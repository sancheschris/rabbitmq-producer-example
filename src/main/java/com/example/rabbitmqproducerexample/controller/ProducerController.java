package com.example.rabbitmqproducerexample.controller;

import com.example.rabbitmqproducerexample.domain.User;
import com.example.rabbitmqproducerexample.producer.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/")
public class ProducerController {

    @Autowired
    private RabbitMqSender rabbitMqSender;

    @Value("${app.message}")
    private String message;

    @PostMapping(value = "user")
    public String publishUserDetails(@RequestBody User user) {
        rabbitMqSender.send(user);
        return message;
    }
}
