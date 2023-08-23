package com.synechron.service;

import org.springframework.stereotype.Service;

@Service
public class Translator {
    public String translate(String word) {
        // call to translation API or service
        return word.toLowerCase(); // assuming translations are done to lowercase
    }
}

