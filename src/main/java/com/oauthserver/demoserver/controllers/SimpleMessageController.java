package com.oauthserver.demoserver.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SimpleMessageController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public ResponseEntity<Object> greeting(@RequestBody Map<String, String> params) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new ResponseEntity<>("Hello, " + params.get("name").toString() + "!", HttpStatus.OK);
    }
}
