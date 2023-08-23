package com.synechron.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordCounter {
	
	@Autowired
	public Translator translator;
	
    private Map<String, Integer> wordCounts;

    public WordCounter() {
        wordCounts = new HashMap<>();
    }

    public void addWords(String... words) {
        for (String word : words) {
            if (isValidWord(word)) {
                String englishWord = translator.translate(word);
               // System.out.println("englishWord "+englishWord);
                wordCounts.put(englishWord, wordCounts.getOrDefault(englishWord, 0) + 1);
            }
        }
    }

    public int getCount(String word) {
        String englishWord = translator.translate(word);
        return wordCounts.getOrDefault(englishWord, 0);
    }

    private boolean isValidWord(String word) {
        return word.matches("[a-zA-Z]+");
    }
}
