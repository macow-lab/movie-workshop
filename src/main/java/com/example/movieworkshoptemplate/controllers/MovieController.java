package com.example.movieworkshoptemplate.controllers;

import com.example.movieworkshoptemplate.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    MovieService service = new MovieService();


    //Controller methods
    @GetMapping("/")
    public String index() {
        return "Hello World welcome to my application";
    }


    @GetMapping("/getfirst")
    public String first () {
        return service.getfirst();
    }


    @GetMapping("/getRandom")
    public String random() {
        return service.getRandom();
    }
}


