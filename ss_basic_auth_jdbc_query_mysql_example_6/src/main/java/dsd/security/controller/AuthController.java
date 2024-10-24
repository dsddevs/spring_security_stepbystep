package dsd.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping
    public ResponseEntity<String> connectServer(){
        try {
            return ResponseEntity.ok("Server connected!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR: " + e.getMessage());
        }

    }

    @GetMapping("/data")
    public ResponseEntity<String> getData(){
       try {
           return ResponseEntity.ok("SUCCESS: Data accepted!");
       }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR: " + e.getMessage());
       }
    }

}
