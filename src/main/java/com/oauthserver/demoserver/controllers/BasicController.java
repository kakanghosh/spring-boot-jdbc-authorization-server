package com.oauthserver.demoserver.controllers;

import com.oauthserver.demoserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BasicController {

    UserRepository userRepository;

    public BasicController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/basic")
    public ResponseEntity<Object> getUserBasicInfo(HttpServletRequest httpServletRequest){
        Principal principal = httpServletRequest.getUserPrincipal();
        return new ResponseEntity<Object>(userRepository.findByUsername(principal.getName()), HttpStatus.OK);
    }

    @GetMapping(value = "/user")
    public ResponseEntity<Object> getUserInfo(HttpServletRequest httpServletRequest){
        Principal principal = httpServletRequest.getUserPrincipal();
        return new ResponseEntity<Object>(userRepository.findByUsername(principal.getName()), HttpStatus.CREATED);
    }

    @GetMapping(value = "/test-url")
    public ResponseEntity<Object> testURL(HttpServletRequest httpServletRequest){
        Map response = new HashMap();
        response.putIfAbsent("name", "ghosh");
        return ResponseEntity.ok(response);
    }
}
