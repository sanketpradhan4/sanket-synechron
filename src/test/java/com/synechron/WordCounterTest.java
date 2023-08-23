package com.synechron;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.synechron.service.Translator;
import com.synechron.service.WordCounter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WordCounterTest {

    @MockBean
    private Translator translator;
    @Autowired
    private WordCounter wordCounter;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(translator.translate(any())).thenAnswer(invocation -> invocation.getArguments()[0]);
        //when
    }

    @Test
    public void testAddWordsAndCount() {
        //wordCounter.addWords("flower", "flor", "blume");
          wordCounter.addWords("flower", "flower", "flower");
        assertEquals(3, wordCounter.getCount("flower"));
    }

    @Test
    public void testAddInvalidWords() {
        wordCounter.addWords("flow", "123", "word_");
        assertEquals(1, wordCounter.getCount("flow"));
        assertEquals(0,wordCounter.getCount("123"));
    }
}
