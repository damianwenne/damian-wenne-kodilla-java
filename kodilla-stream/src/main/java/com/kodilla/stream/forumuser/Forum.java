package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> forumUsersList = new ArrayList<>();

    public Forum() {
        forumUsersList.add(new ForumUser(001, "Che Guevara", 'M', LocalDate.of(1928, Month.JUNE, 14), 2));
        forumUsersList.add(new ForumUser(002, "Cenciak", 'M', LocalDate.of(1991, Month.MAY, 04), 0));
        forumUsersList.add(new ForumUser(003, "Endzi", 'F', LocalDate.of(1989, Month.APRIL, 01), 4));
        forumUsersList.add(new ForumUser(004, "Pokus", 'M', LocalDate.of(2002, Month.JANUARY, 14), 2));
        forumUsersList.add(new ForumUser(005, "Rambo", 'M', LocalDate.of(1946, Month.JULY, 06), 10));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(forumUsersList);
    }
}
