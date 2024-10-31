package dsd.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ServerController {

    @GetMapping
    public ResponseEntity<String> connectServer(){
        return ResponseEntity.ok("SUCCESS: Server connected!");
    }

    @GetMapping("/data")
    public ResponseEntity<Map<String, String>> getData(){
        try {
            Map<String, String> data = new HashMap<>();
            data.put("1", "Apple");
            data.put("2", "Banana");
            data.put("3", "Pineapple");
            return ResponseEntity.ok(data);
        }catch (Exception e){
            Map<String, String> response = new HashMap<>();
            response.put("ERROR", "Data not found!");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

}
