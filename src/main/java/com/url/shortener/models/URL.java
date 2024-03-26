package com.url.shortener.models;

import jakarta.persistence.*;

@Entity
public class URL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long urlId;

    public Long getUrlId() {
        return urlId;
    }

    public void setUrlId(Long urlId) {
        this.urlId = urlId;
    }

    public String getOriginalLink() {
        return originalLink;
    }

    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }

    public String getShortURLCode() {
        return shortURLCode;
    }

    public void setShortURLCode(String shortURLCode) {
        this.shortURLCode = shortURLCode;
    }

    private String originalLink;
    private String shortURLCode;


}
