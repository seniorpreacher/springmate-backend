package com.codecool.askmate.controller;

import com.codecool.askmate.model.Question;
import com.codecool.askmate.model.Rating;
import com.codecool.askmate.repository.QuestionRepository;
import com.codecool.askmate.repository.RatingRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONAs;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class QuestionControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private RatingRepository ratingRepository;

    private Question question;

    @Before
    public void before() {
        question = questionRepository.save(new Question("hello", "bello"));
        ratingRepository.save(new Rating(100, question));
        ratingRepository.save(new Rating(-50, question));
    }


    @Test
    public void getByIdReturnsTheRequestedQuestion() throws Exception {
        String questionId = question.getId().toString();
        mvc.perform(get("/question/" + questionId))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        sameJSONAs("{\"id\":\"" + questionId + "\"}")
                                .allowingExtraUnexpectedFields()
                        )
                );
    }

    @Test
    public void getByIdReturnsTheCorrectTitle() throws Exception {
        mvc.perform(get("/question/" + question.getId().toString()))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        sameJSONAs("{\"title\":\"hello\"}")
                                .allowingExtraUnexpectedFields()
                        )
                );
    }

    @Test
    public void getByIdReturnsTheCorrectMessage() throws Exception {
        mvc.perform(get("/question/" + question.getId().toString()))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        sameJSONAs("{\"message\":\"bello\"}")
                                .allowingExtraUnexpectedFields()
                        )
                );
    }

    @Test
    public void getByIdReturnsNullAsImagePathWhenItsEmpty() throws Exception {
        mvc.perform(get("/question/" + question.getId().toString()))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        sameJSONAs("{\"imagePath\":null}")
                                .allowingExtraUnexpectedFields()
                        )
                );
    }

    @Test
    public void getByIdReturnsTheCorrectRating() throws Exception {
        mvc.perform(get("/question/" + question.getId().toString()))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        sameJSONAs("{\"rating\":50}")
                                .allowingExtraUnexpectedFields()
                        )
                );
    }
}
