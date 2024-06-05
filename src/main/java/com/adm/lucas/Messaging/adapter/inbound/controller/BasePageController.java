package com.adm.lucas.Messaging.adapter.inbound.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@CrossOrigin
public class BasePageController {
    @RequestMapping("/")
    public RedirectView redirect() {
        return new RedirectView("https://api-srs-posts.onrender.com/swagger-ui.html");
    }
}