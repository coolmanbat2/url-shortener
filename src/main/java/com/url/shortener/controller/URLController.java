package com.url.shortener.controller;

import com.url.shortener.exceptions.CannotCreateLinkException;
import com.url.shortener.models.URL;
import com.url.shortener.services.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class URLController {
    URLService urlService;
    @Autowired
    URLController(URLService urlService) {
       this.urlService = urlService;
    }

    @PostMapping("/add-url")
    public ResponseEntity<String> add(@ModelAttribute URL url) {
        try {
            String result = urlService.addURL(url);

            return new ResponseEntity<>(result, HttpStatus.OK);

        } catch (Exception | CannotCreateLinkException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-url")
    public ResponseEntity<String> get(@ModelAttribute URL url) {
        URL result = urlService.getURL(url);
        return new ResponseEntity<>(result.getOriginalLink(), HttpStatus.OK);
    }
}
