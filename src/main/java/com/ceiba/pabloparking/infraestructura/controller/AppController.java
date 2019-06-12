package com.ceiba.pabloparking.infraestructura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping(value = "/")
    public String app() {
        return "registro-parqueo";
    }
}
