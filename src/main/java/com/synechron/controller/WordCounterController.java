package com.synechron.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synechron.service.WordCounter;

@RestController
public class WordCounterController {

    @Autowired
    private WordCounter wordCounter;
    
    @GetMapping("/test")
    public String test(){
    	return "test";
    }

    @GetMapping("/addWords")
    public void addWords(@RequestParam String[] words) {
    	Arrays.asList(words).forEach(x->System.out.println(x));
        wordCounter.addWords(words);
    }

    @GetMapping("/getCount/{word}")
    public int getCount(@PathVariable String word) {
    	System.out.println(word);
        return wordCounter.getCount(word);
    }
}

