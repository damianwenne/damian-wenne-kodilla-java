package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {

    @Autowired
    private Board board;

    @Test
    public void testTaskAdd() {
        //Given & When
        board.getDoneList().getTasks().add("Done");
        board.getInProgressList().getTasks().add("In Progres");
        board.getToDoList().getTasks().add("To Do");
        //Then
        Assert.assertTrue(board.getDoneList().getTasks().contains("Done"));
        Assert.assertTrue(board.getInProgressList().getTasks().contains("In Progres"));
        Assert.assertTrue(board.getToDoList().getTasks().contains("To Do"));
    }
}
