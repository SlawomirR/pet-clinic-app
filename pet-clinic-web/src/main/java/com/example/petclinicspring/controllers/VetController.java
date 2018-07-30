package com.example.petclinicspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(method = RequestMethod.GET, path = "/vets")
public class VetController {

    @GetMapping({"", "/index", "/index.html"})
    public String listVets() {

        return "vets/index";
    }
}
