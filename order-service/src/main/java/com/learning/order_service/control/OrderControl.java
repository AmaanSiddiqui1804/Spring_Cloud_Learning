package com.learning.order_service.control;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderControl {
    private final RestTemplate restTemplate;

    public OrderControl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<String> getOrder(@PathVariable String orderId) {
        String userId = "123";  // test user
        String userServiceUrl = "http://user-service/users/" + userId;

        String userDetails = restTemplate.getForObject(userServiceUrl, String.class);
        return ResponseEntity.ok("Order Id: " + orderId + " | " + userDetails);
    }

//    @GetMapping("/{orderId}")
//    public ResponseEntity<String> getOrder(@PathVariable String orderId) {
//        return ResponseEntity.ok("Order ID: " + orderId);
//    }
}