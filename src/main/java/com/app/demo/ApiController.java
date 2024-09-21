package com.app.demo;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


@RestController
@RequestMapping("/api")
public class ApiController {          

    @GetMapping("/name")
    public String getName() {
        return "Eugenio";
    }
    
    @GetMapping("/random")
    public int getRandom() throws IOException {
    	Random random = new Random(); 
    	
    	int randomInt = random.nextInt();
    	return randomInt;
    }
    
    @GetMapping("/add")
    public int getAdd() {
    	int answer = 2 + 2; 
    	return answer; 
    }
}
