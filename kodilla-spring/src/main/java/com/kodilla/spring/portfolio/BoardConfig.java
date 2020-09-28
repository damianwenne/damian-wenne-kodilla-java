package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Bean
    public TaskList toDoList() {
        return new TaskList();
    }

    @Bean
    public TaskList inProgresList() {
        return new TaskList();
    }

    @Bean
    public TaskList doneList() {
        return new TaskList();
    }

    @Bean
    public Board board(@Qualifier ("toDoList") TaskList toDoList,
                       @Qualifier ("inProgresList") TaskList inProgresList,
                       @Qualifier ("doneList") TaskList doneList) {
        return new Board(toDoList, inProgresList, doneList);
    }
}
