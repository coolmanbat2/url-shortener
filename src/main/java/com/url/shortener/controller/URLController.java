package com.url.shortener.controller;

import com.url.shortener.exceptions.CannotCreateLinkException;
import com.url.shortener.models.URL;
import com.url.shortener.services.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class URLController {
    URLService urlService;
    //TODO: Please change this server link when pushing to prod, as the server will fail if server name is not changed.
    final String serverLink = "http://localhost:3000";
    @Autowired
    URLController(URLService urlService) {
       this.urlService = urlService;
    }

    @CrossOrigin(origins = serverLink)
    @PostMapping("/add-url")
    public ResponseEntity<String> add(@ModelAttribute URL url) {
        try {
            URL exists = urlService.getURL(url);
            if (exists != null) {
                String result = urlService.addURL(url);
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
               return new ResponseEntity<>("Already exists in the system.", HttpStatus.CONFLICT);
            }

        } catch (Exception | CannotCreateLinkException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = serverLink)
    @GetMapping("/get-url")
    public ResponseEntity<String> get(@ModelAttribute URL url) {
        try {
            URL result = urlService.getURL(url);
            return new ResponseEntity<>(result.getOriginalLink(), HttpStatus.OK);

        } catch (NullPointerException exception) {
           return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
