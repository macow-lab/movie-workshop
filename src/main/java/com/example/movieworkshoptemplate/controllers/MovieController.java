package com.example.movieworkshoptemplate.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    //Controller methods
    @GetMapping("/")
    public String index(){
        return "Hello World welcome to my application";
    }



//@Mapping ("/getFirst")
   // public class first () {

}


//@Mapping ("/getRandom")
       // public void random () {

