package com.ceiba.pabloparking.infraestructura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@RequestMapping("/")
    public String app() {
        return "registro-parqueo";
    }
}
