package dsd.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

    @GetMapping
    public String connectServer(){
        return "SUCCESS: Server connected";
    }

    @GetMapping("/data")
    public String getData(){
        return "SUCCESS: Data accepted";
    }

}
