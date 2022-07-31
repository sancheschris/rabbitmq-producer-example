package com.example.rabbitmqproducerexample.controller;

import com.example.rabbitmqproducerexample.producer.RabbitMqSimpleSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class MessageController {

    @Autowired
    private RabbitMqSimpleSender rabbitMqSimpleSender;

    @GetMapping("/publish")
    public ResponseEntity<String> publishUserDetails(@RequestParam("message") String msg) {
        rabbitMqSimpleSender.send(msg);
        return ResponseEntity.ok("Message sent to RabbitMQ ...");
    }
}
