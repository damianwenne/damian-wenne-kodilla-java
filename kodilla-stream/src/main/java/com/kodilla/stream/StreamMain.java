package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.stream.Collectors;


public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();
        LocalDate today = LocalDate.now();

        String theForumUsers = forum.getUserList().stream()
                .filter(user -> user.getGender() == 'M')
                .filter(user -> user.getDateOfBirth().getYear() < today.minusYears(20).getYear())
                .filter(user -> user.getPostsQty() >= 1)
                .map(ForumUser::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theForumUsers);

    }
}
