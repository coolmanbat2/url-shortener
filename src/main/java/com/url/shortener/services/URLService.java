package com.url.shortener.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.url.shortener.exceptions.CannotCreateLinkException;
import com.url.shortener.models.URL;
import com.url.shortener.repositories.URLRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashSet;
import java.util.Random;


@Service
public class URLService {

    URLRepo urlRepo;

    @Autowired
    public URLService(URLRepo urlRepo) {
       this.urlRepo = urlRepo;
    }

    /*
        Generates a unique five character short code that can be used
        for the original link that was provided by the user.
     */
    private String genUnqCode() {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        HashSet<String> rawCode = new HashSet<>();
        Random random = new Random();


        // for each character in the five letters, one of it will be taken from alphabet randomly.
        // Add each letter that is generated into rawCode.
        // Keep going until the short code has reached five letters.
        while (rawCode.size() != 5) {
            rawCode.add(String.valueOf(alphabet.charAt(random.nextInt(52))));
        }

        // Convert rawCode into a String.
        String result = String.join("", rawCode);

        // Check to see if this short code has been used already.
        boolean codeExists = urlRepo.existsByShortURLCode(result);
        if (codeExists) {
            return genUnqCode();
        } else {
            return result;
        }
    }

    public String addURL(@ModelAttribute URL url) throws CannotCreateLinkException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String unq = genUnqCode();

        // add the unique code to the database.
        url.setShortURLCode(unq);

        return objectMapper.writeValueAsString(urlRepo.saveAndFlush(url));
    }

    public URL getURL(@ModelAttribute URL url) {
        return urlRepo.findByShortURLCode(url.getShortURLCode());
    }
}
