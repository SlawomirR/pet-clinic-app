package com.example.petclinicspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnerController {

    @GetMapping({"/owners", "/owners/index", "/owners/index.html"})
    public String listOwners() {
        return "owners/index";
    }
}
