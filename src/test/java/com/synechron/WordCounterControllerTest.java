package com.synechron;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.synechron.controller.WordCounterController;
import com.synechron.service.Translator;
import com.synechron.service.WordCounter;

@RunWith(SpringRunner.class)
@WebMvcTest(WordCounterController.class)
public class WordCounterControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private Translator translator;
    @MockBean
    private WordCounter wordCounter;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(translator.translate(any())).thenAnswer(invocation -> invocation.getArguments()[0]);
    }

    @Test
    public void testAddWords() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/addWords")
                .param("words", "flower", "flor", "blume"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetCount() throws Exception {
        when(wordCounter.getCount("flower")).thenReturn(3);

        mockMvc.perform(MockMvcRequestBuilders.get("/getCount/{word}", "flower"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("3"));
    }
}
