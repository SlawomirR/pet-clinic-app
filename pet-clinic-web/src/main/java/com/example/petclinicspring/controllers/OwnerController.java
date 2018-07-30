package com.example.petclinicspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(method = RequestMethod.GET, path = "/owners")
public class OwnerController {

    @GetMapping({"", "/index", "/index.html"})
    public String listOwners() {
        return "owners/index";
    }
}
