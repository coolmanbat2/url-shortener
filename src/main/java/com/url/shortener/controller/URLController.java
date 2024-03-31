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
    final String serverLink = "http://localhost:3000";

    private void updateUrlWithHttps(URL url) {

        if (!url.getOriginalLink().contains("http")) {
            StringBuilder sb = new StringBuilder(url.getOriginalLink());
            sb.insert(0, "https://");
            url.setOriginalLink(sb.toString());
        }
    }

    @Autowired
    URLController(URLService urlService) {
       this.urlService = urlService;
    }

    @CrossOrigin(origins = serverLink)
    @PostMapping("/add-url")
    public ResponseEntity<String> add(@ModelAttribute URL url) {
        try {
            updateUrlWithHttps(url);
            String result = urlService.addURL(url);
            return new ResponseEntity<>(result, HttpStatus.OK);

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
