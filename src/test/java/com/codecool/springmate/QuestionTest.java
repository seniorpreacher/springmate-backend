package com.codecool.springmate;


import com.codecool.springmate.model.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionTest {

    @Test
    public void questionHasId() {
        Question q = new Question("title", "msg");

    }
}
