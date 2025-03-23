package com.learning.user_service.control;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserControl {
    @GetMapping("/{userId}")
    public ResponseEntity<String> getUser(@PathVariable String userId){
        return ResponseEntity.ok(("User details for Id: " + userId));
    }
}
